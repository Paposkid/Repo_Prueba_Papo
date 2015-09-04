package com.amx.service.business;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amx.service.bean.AmdocsTO;
import com.amx.service.bean.BiomTO;
import com.amx.service.bean.CategoriaTO;
import com.amx.service.bean.ConstanteTO;
import com.amx.service.bean.DominioTO;
import com.amx.service.bean.EntLceTO;
import com.amx.service.bean.EquifaxTO;
import com.amx.service.bean.EquivalenteEntradaTO;
import com.amx.service.bean.NegLceTO;
import com.amx.service.bean.ParametroTO;
import com.amx.service.bean.PlusGoldTO;
import com.amx.service.bean.PreviredTO;
import com.amx.service.bean.ReadListaTypeTO;
import com.amx.service.bean.ReglaTO;
import com.amx.service.bean.SalLceTO;
import com.amx.service.dao.EquivalenteEntradaDAO;
import com.amx.service.util.Reflexion;

import cl.clarochile.aplicaciones.evalcrediticia.exception.BusinessException;

@Component
public class GetCreditScoreByCustomerBusinessImpl implements GetCreditScoreByCustomerBusiness {

	private static Logger logger = Logger.getLogger(GetCreditScoreByCustomerBusinessImpl.class);

	@Autowired
	ReglaBusiness miReglaBusiness;
	@Autowired
	EquivalenteEntradaDAO miEquivalenteEntradaDAO;
	@Autowired
	ConstanteBusiness miConstanteBusiness;
	@Autowired
	DominioBusiness miDominioBusiness;
	@Autowired
	CategoriaBusiness miCategoriaBusinessImpl;
	@Autowired
	private EntLceBusiness miEntLceBL;
	@Autowired
	private SalLceBusiness miSalLceBL;
	@Autowired
	private AmdocsBusiness apiAmdocsBL;
	@Autowired
	private NegLceBusiness negLceBL;
	@Autowired
	private PlusGoldBusiness plusGoldBL;
	@Autowired
	private PreviredBussines PreviredBL;
	@Autowired
	private EquifaxBusiness equifaxBL;

	@Autowired
	private ListasEspecialesBusiness listasEspecialesBL;
	@Autowired
	private ParametroBusiness parametroBL;

	@SuppressWarnings("unused")
	@Override
	public SalLceTO getCreditScoreByCustomer(EntLceTO requestTO) throws Exception {
		String reglas = "";
		AmdocsTO apiAmdocsTO = null;
		SalLceTO miSalLceTO = null;
		Date fechaActual = null;
		NegLceTO negLce = null;
		List<ReadListaTypeTO> listaEspecialTO = null;
		PlusGoldTO plusGoldTO = null;
		PreviredTO miPreviredTO = null;
		EquifaxTO miEquifaxTO = null;
		ParametroTO miParametroTO = null;
		String tipoAcreditacion = "";
		String rutCliente = "";
		String identifierType ="";//jamj
		Boolean ventaMasDeDiezLineas = false;
		Boolean consultarPrevired = false;
		Boolean tieneDicom = false;
		Boolean tienePrevired = false;
		Boolean existeError = false;
		Boolean pre = false;
		Boolean eva = false;
		Boolean pos = false;
		Integer usuario = 0;

		try {
			usuario = Integer.parseInt(requestTO.getCredScoreInfo().getDealerId());
			negLce = new NegLceTO();
			negLce.setCodUsuarioAlta(usuario);
			negLce.setEstado("I");
			negLce.setNroOrden(Integer.parseInt(requestTO.getCredScoreInfo().getOrderID()));
			negLceBL.insertarNegLce(negLce);
			requestTO.setCorrLce(negLce.getCodLce());
			requestTO.setUsuario(usuario);
			miEntLceBL.insertarLce(requestTO);
			tipoAcreditacion = requestTO.getAccrInfo().getAccrType();

			fechaActual = new Date();

			if (tipoAcreditacion.equals("Cliente Claro")) {

				miSalLceTO = miSalLceBL.buscarSalLceOrderId(requestTO.getCredScoreInfo().getOrderID());

			} else if (tipoAcreditacion.equals("Continuacion Empresa")) {
				miSalLceTO = miSalLceBL.buscarSalLceCredAproId(requestTO.getCredApprovalid()); // OK
																								// CC
				if (miSalLceTO != null && miSalLceTO.getCredScoreResInfo().getScoreExpiryDate().compareTo(fechaActual) >= 0) {
					ventaMasDeDiezLineas = true;

				} else
					miSalLceTO = null;
			}

			if (!ventaMasDeDiezLineas) {
				rutCliente = requestTO.getCredScoreInfo().getUserId();
				identifierType = requestTO.getCredScoreInfo().getIdenType();//jamj
				apiAmdocsTO = apiAmdocsBL.consultarApiAmdocs(rutCliente,identifierType);//jamj
				if (apiAmdocsTO != null) {

					apiAmdocsTO.setCodUsuarioAlta(usuario);
					apiAmdocsBL.insertarAmdocs(apiAmdocsTO);
					negLce.setCodAmdocs(apiAmdocsTO.getCodAmdocs().intValue());
					negLceBL.actualizarNegLce(negLce);
					if (Integer.parseInt(apiAmdocsTO.getNotaComportamiento()) != 0 || !requestTO.getAccrInfo().getAccrType().equals("Cliente Claro")) {

						listaEspecialTO = listasEspecialesBL.obtenerRespuestaListasEspeciales(requestTO.getCredScoreInfo());

						plusGoldTO = plusGoldBL.buscarPlusGoldbByRut(rutCliente);
						if (plusGoldTO != null) {

							plusGoldTO.setUsuario(usuario);
							if (plusGoldTO.getOrigen() == "Datos por defecto") {
								miParametroTO = parametroBL.buscarParametroPorNombre("prm_LCE_DICOM_TIPO_DEUDA_ULT_IMPAGO");
								if (miParametroTO.getValorParametro().equals("S")) {
									tieneDicom = true;
								}

							} else {
								tieneDicom = true;
							}
							plusGoldTO.setEstado("C");
							plusGoldBL.insertarPlusGold(plusGoldTO);
							negLce.setPlusGold(plusGoldTO.getSerialVersion().intValue());
							negLceBL.actualizarNegLce(negLce);

							for (BiomTO biometricValidation : requestTO.getListBiom()) {
								if (biometricValidation.getIsPrevire().equals("S")) {
									consultarPrevired = true;
								}
							}
							if (consultarPrevired) {

								miPreviredTO = new PreviredTO();
								miPreviredTO.setRutCliente(rutCliente);
								miPreviredTO = PreviredBL.consultarPreviredByCodigo(miPreviredTO);

								if (miPreviredTO != null) {

									miPreviredTO.setCodUsuarioAlta(usuario);

									if (miPreviredTO.getOrigen().equals("Datos por defecto")) {
										miParametroTO = parametroBL.buscarParametroPorNombre("prm_LCE_CONSULTO_PREVIRED");
										if (miParametroTO.getValorParametro().equals("S")) {
											tienePrevired = true;
										}

									} else {
										tienePrevired = true;
									}
								} else {
									existeError = true;
								}

								PreviredBL.insertarPrevired(miPreviredTO);
								negLce.setPrevired(miPreviredTO.getCodPrevired().intValue());
								negLceBL.actualizarNegLce(negLce);

							}
						} else {
							existeError = true;
						}
						if (tipoAcreditacion.equals("Cuenta Corriente - Cheque")) {
							miEquifaxTO = equifaxBL.ConsultarEquifax(rutCliente);
							if (miEquifaxTO != null) {

								miEquifaxTO.setUsuario(usuario);
								miEquifaxTO.setEstado("A");
								equifaxBL.insertarEquifax(miEquifaxTO);
								negLce.setEquiFax(miEquifaxTO.getCodigoEquifax().intValue());
								negLceBL.actualizarNegLce(negLce);
							} else
								existeError = true;
						}
						if (!existeError) {
							miSalLceTO = new SalLceTO();
							if (miEquifaxTO == null)
								miEquifaxTO = new EquifaxTO();
							if (miPreviredTO == null)
								miPreviredTO = new PreviredTO();

							Map<String, Object> mapReglas = new HashMap<String, Object>();
							mapReglas.put("EntLceTO", requestTO);
							mapReglas.put("AmdocsTO", apiAmdocsTO);
							mapReglas.put("PreviredTO", miPreviredTO);
							mapReglas.put("PlusGoldTO", plusGoldTO);
							mapReglas.put("EquifaxTO", miEquifaxTO);
							mapReglas.put("NegLceTO", negLce);
							mapReglas.put("SalLceTO", miSalLceTO);
							mapReglas.put("Reglas", reglas);
							pre = realizarPreEvaluacion(mapReglas);
							if (!pre) {
								if (!realizarEvaluacion(mapReglas)) {
									existeError = true;
								} else {
									realizarPostEvaluacion(mapReglas);
								}
							}
							if (!existeError) {
								miSalLceTO.setCorrLce(negLce.getCodLce());
								miSalLceTO.setCorrUsuarioAlta(usuario);
								miSalLceTO.setReglas(String.valueOf(mapReglas.get("Reglas")));
								miSalLceBL.insertarLce(miSalLceTO);

							}
						}
					}
				} else {
					existeError = true;
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (negLce != null) {
				negLce.setEstado("A");
				negLceBL.actualizarEstadoNegLce(negLce);
			}
		}
		if (existeError) {
			if (negLce != null) {
				negLce.setEstado("A");
				negLceBL.actualizarEstadoNegLce(negLce);
			}
			throw new BusinessException();
		}
		return miSalLceTO;
	}

	public boolean realizarEvaluacion(Map<String, Object> mapReglas) {
		ScriptEngineManager mgr;
		String nombreRegla = "";
		String reglas;
		ScriptEngine engine;
		Boolean o;
		int cumplidas = 0;
		boolean cumplio = false;
		String condicion;
		List<ReglaTO> misReglas = new ArrayList<ReglaTO>();
		List<String> instrucciones = null;

		Map<String, Object> mapResults = new HashMap<String, Object>();
		ReglaTO miReglaTO = new ReglaTO();
		reglas = (String) mapReglas.get("Reglas");
		miReglaTO.setTipoEvaluacion("E");
		miReglaTO.setEstado("A");
		miReglaTO.setTipoRegla("L");
		miReglaTO.setSubtipoRegla("G");
		try {
			misReglas = miReglaBusiness.buscarReglaAEvaluar(miReglaTO);
			for (ReglaTO reglaTO : misReglas) {
				condicion = getCondicion(reglaTO.getValor(), mapReglas, mapResults);

				try {
					mgr = new ScriptEngineManager();
					engine = mgr.getEngineByName("JavaScript");
					o = (Boolean) engine.eval(condicion);
					if (o) {
						if (cumplidas <= (Integer) mapResults.get("numeroCondiciones")) {
							nombreRegla = reglaTO.getNombre();
							cumplidas = (Integer) mapResults.get("numeroCondiciones");
							instrucciones = ((List<String>) mapResults.get("instrucciones"));
							cumplio = true;
						}
					}
				} catch (ScriptException ex) {
					throw ex;
				}
			}
			mapReglas.put("Reglas", reglas);
			if (cumplio) {
				reglas = reglas.concat(nombreRegla + ",");
				ejecutarInstrucciones(instrucciones, mapReglas);
			}

		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return cumplio;

	}

	public boolean realizarPostEvaluacion(Map<String, Object> mapReglas) {
		String reglas;
		ScriptEngineManager mgr;
		ScriptEngine engine;
		Boolean o;
		boolean cumplio = false;
		String condicion;
		List<ReglaTO> misReglas = new ArrayList<ReglaTO>();
		List<String> instrucciones;
		Map<String, Object> mapResults = new HashMap<String, Object>();
		ReglaTO miReglaTO = new ReglaTO();
		miReglaTO.setTipoEvaluacion("O");
		miReglaTO.setSubtipoRegla("G");
		miReglaTO.setEstado("A");
		miReglaTO.setTipoRegla("L");
		reglas = (String) mapReglas.get("Reglas");
		try {
			misReglas = miReglaBusiness.buscarReglaAEvaluar(miReglaTO);
			for (ReglaTO reglaTO : misReglas) {
				condicion = getCondicion(reglaTO.getValor(), mapReglas, mapResults);

				try {
					mgr = new ScriptEngineManager();
					engine = mgr.getEngineByName("JavaScript");
					o = (Boolean) engine.eval(condicion);
					if (o) {
						reglas = reglas.concat(reglaTO.getNombre() + ",");
						instrucciones = ((List<String>) mapResults.get("instrucciones"));
						ejecutarInstrucciones(instrucciones, mapReglas);
						cumplio = true;
					}
				} catch (ScriptException ex) {
					throw ex;
				}
			}
			mapReglas.put("Reglas", reglas);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
		return cumplio;
	}

	public boolean realizarPreEvaluacion(Map<String, Object> mapReglas) {
		String reglas;
		ScriptEngineManager mgr;
		ScriptEngine engine;
		Boolean o;
		boolean cumplio = false;
		String condicion;
		List<ReglaTO> misReglas = new ArrayList<ReglaTO>();
		List<String> instrucciones;
		Map<String, Object> mapResults = new HashMap<String, Object>();
		ReglaTO miReglaTO = new ReglaTO();
		miReglaTO.setTipoEvaluacion("P");
		miReglaTO.setSubtipoRegla("G");
		miReglaTO.setEstado("A");
		miReglaTO.setTipoRegla("L");
		reglas = (String) mapReglas.get("Reglas");
		try {
			misReglas = miReglaBusiness.buscarReglaAEvaluar(miReglaTO);
			for (ReglaTO reglaTO : misReglas) {
				condicion = getCondicion(reglaTO.getValor(), mapReglas, mapResults);
				try {
					mgr = new ScriptEngineManager();
					engine = mgr.getEngineByName("JavaScript");
					o = (Boolean) engine.eval(condicion);
					if (o) {
						reglas = reglas.concat(reglaTO.getNombre() + ",");
						instrucciones = ((List<String>) mapResults.get("instrucciones"));
						ejecutarInstrucciones(instrucciones, mapReglas);
						cumplio = true;
					}
				} catch (ScriptException ex) {
					throw ex;
				}
			}
			mapReglas.put("Reglas", reglas);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return cumplio;
	}

	public void ejecutarInstrucciones(List<String> instrucciones, Map<String, Object> mapReglas) {
		String[] seccion;
		ScriptEngineManager mgr;
		ScriptEngine engine;
		Object o;
		Map<String, Object> equi;
		EquivalenteEntradaTO miEquivalenteEntradaTO;
		for (String instruccion : instrucciones) {
			seccion = instruccion.split("=");
			equi = new HashMap<String, Object>();
			equi.put("campo", seccion[0]);
			try {
				miEquivalenteEntradaDAO.buscarEquivalente(equi);
				miEquivalenteEntradaTO = ((List<EquivalenteEntradaTO>) equi.get("resultados")).get(0);
				String atributo = miEquivalenteEntradaTO.getAtributo();
				String clazz = miEquivalenteEntradaTO.getObjeto();
				Object obj = mapReglas.get(clazz);
				Field field = Reflexion.getField(obj, atributo);

				if (field.getType().equals(String.class)) {
					String val = seccion[1];
					Reflexion.setValue(obj, atributo, new Object[] { val });
				} else {
					mgr = new ScriptEngineManager();
					engine = mgr.getEngineByName("JavaScript");
					o = engine.eval(seccion[1]);
					if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
						Double val = (Double) o;

						Reflexion.setValue(obj, atributo, new Object[] { val });

					} else if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {

						Integer val = ((Double) o).intValue();

						Reflexion.setValue(obj, atributo, new Object[] { val });

					} else if ((field.getType().equals(Long.class))) {
						Long val = ((Double) o).longValue();

						Reflexion.setValue(obj, atributo, new Object[] { val });

					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage(), e);
			}

		}

	}

	public String getCondicion(String linea, Map<String, Object> mapReglas, Map<String, Object> mapResults) {
		int limiteI = 0;
		int limiteD = 0;
		int limiteDe = 0;
		int limiteIz = 0;
		int numeroCondiciones = 1;
		List<String> instrucciones = new ArrayList<String>();
		CategoriaTO miCategoriaTO;
		CategoriaTO resultCategoriaTO;
		EquivalenteEntradaTO miEquivalenteEntradaTO;
		Map<String, Object> equi;
		ConstanteTO miConstanteTO;
		ConstanteTO resulConstanteTO;
		DominioTO resulDominioTO;
		DominioTO miDominioTO;
		CategoriaTO resuCategoriaTO;
		List<DominioTO> listDominioTO;
		List<ConstanteTO> listConstanteTO;
		List<CategoriaTO> listCategoriaTO;
		String valorX;
		String valorY = "";
		boolean condi = false;
		boolean instruccion = false;
		String[] result;
		String[] operacion;
		String desde;
		String hasta;
		String linea2 = " ";
		List<String> operadores = new ArrayList<String>();
		List<String> comparadores = new ArrayList<String>();
		List<String> otros = new ArrayList<String>();
		List<String> categoria;
		operadores.add("+");
		operadores.add("-");
		operadores.add("*");
		operadores.add("/");
		comparadores.add("=");
		comparadores.add("==");
		comparadores.add("<");
		comparadores.add(">");
		comparadores.add("IN");
		comparadores.add("NOT");
		comparadores.add("BETWEEN");
		comparadores.add("NULL");
		comparadores.add("LIKE");
		otros.add(";");
		otros.add(")");
		otros.add("(");
		otros.add("{");
		otros.add("}");
		otros.add("IF");
		otros.add("AND");
		otros.add("OR");
		result = linea.split(" ");
		try {
			for (int i = 0; i < result.length; i++) {
				if ((!comparadores.contains(result[i])) && (!otros.contains(result[i]))) {
					if (result[i].contains(".")) {
						operacion = result[i].split("\\.");
						result[i] = "";
						for (int k = 0; k < operacion.length; k++) {
							if (!operacion[k].equals("+") && !operacion[k].equals("-") && !operacion[k].equals("*") && !operacion[k].equals("/")) {
								if (operacion[k].subSequence(0, 1).equals("D")) {
									miDominioTO = new DominioTO();
									resulDominioTO = new DominioTO();
									miDominioTO.setNombre(operacion[k].substring(1, operacion[k].length()));
									resulDominioTO = miDominioBusiness.obtenerDominioPorNombre(miDominioTO);
									result[i] = result[i].concat(resulDominioTO.getValor());// buscar
								} else {
									miConstanteTO = new ConstanteTO();
									miConstanteTO.setNombre(operacion[k].substring(1, operacion[k].length()));
									resulConstanteTO = miConstanteBusiness.obtenerConstantePorNombre(miConstanteTO);
									result[i] = result[i].concat(resulConstanteTO.getValor());
								}
							} else {
								result[i] = result[i].concat(operacion[k]);
							}
						}
					} else if (comparadores.contains(result[i - 1])) {
						if (result[i - 1].equals("BETWEEN")) {
							miCategoriaTO = new CategoriaTO();
							miCategoriaTO.setNombreCategoria(result[i]);
							listCategoriaTO = new ArrayList<CategoriaTO>();
							resuCategoriaTO = miCategoriaBusinessImpl.obtenerCategoriaPorNombre(miCategoriaTO);
							desde = resuCategoriaTO.getRangoDesde();
							hasta = resuCategoriaTO.getRangoHasta();
							linea2 = "(";
							linea2 = linea2.concat(result[i - 2] + ">" + desde + "&&" + result[i - 2] + "<" + hasta);
							linea2 = linea2.concat(")");
							if (condi || instruccion) {
								result[i] = linea2;
								result[i - 1] = "";
								result[i - 2] = "";
							}
						} else if (result[i - 1].equals("IN")) {
							miCategoriaTO = new CategoriaTO();
							miCategoriaTO.setNombreCategoria(result[i]);
							resuCategoriaTO = miCategoriaBusinessImpl.obtenerCategoriaPorNombre(miCategoriaTO);
							String corrCat = resuCategoriaTO.getCodigoCategoria();
							categoria = new ArrayList<String>();
							miCategoriaTO.setCodigoCategoria(corrCat);
							listDominioTO = miCategoriaBusinessImpl.listarDominiosByCategoria(miCategoriaTO);
							for (DominioTO dom : listDominioTO) {
								categoria.add(dom.getValor());
							}
							linea2 = "(";
							for (String s : categoria) {
								linea2 = linea2.concat(result[i - 2] + "==" + s + "||");
							}
							linea2 = linea2.substring(0, linea2.length() - 2);
							linea2 = linea2.concat(")");
							if (condi || instruccion) {
								result[i] = linea2;
								result[i - 1] = "";
								result[i - 2] = "";
							}
						} else {
							miConstanteTO = new ConstanteTO();
							miConstanteTO.setNombre(result[i]);
							valorX = miConstanteBusiness.obtenerConstantePorNombre(miConstanteTO).getValor();
							if (valorX.equals("")) {
								miCategoriaTO = new CategoriaTO();
								miCategoriaTO.setNombreCategoria(result[i]);
								valorX = miCategoriaBusinessImpl.listarDominiosByCategoria(miCategoriaTO).get(0).getValor();
							}
							if (condi || instruccion) {
								result[i] = valorX;
								valorX = "";
							}

						}
					} else {
						if (condi) {
							equi = new HashMap<String, Object>();
							equi.put("campo", result[i]);
							miEquivalenteEntradaDAO.buscarEquivalente(equi);
							miEquivalenteEntradaTO = ((List<EquivalenteEntradaTO>) equi.get("resultados")).get(0);
							String atributo = miEquivalenteEntradaTO.getAtributo();
							String clazz = miEquivalenteEntradaTO.getObjeto();
							Object obj = mapReglas.get(clazz);
							valorY = String.valueOf(Reflexion.getValue(obj, atributo));
							result[i] = valorY;
						} else {
							result[i] = result[i];
						}
					}
				} else {
					if (result[i].equals(">")) {
						if (result[i - 1].equals("<")) {
							result[i] = "=";
							result[i - 1] = "!";
						}
					} else if (result[i].equals("NOT")) {
						if (condi || instruccion) {
							result[i] = "!";
						}

					} else if (result[i].equals("=")) {
						if (condi || !instruccion) {
							result[i] = "==";

						}
					} else if (result[i].equals("AND")) {
						if (condi || instruccion) {
							result[i] = "&&";
							numeroCondiciones += 1;
						}

					} else if (result[i].equals("OR")) {
						if (condi || instruccion) {
							result[i] = "||";
							numeroCondiciones += 1;
						}
					} else if (result[i].equals("(")) {
						if (!condi && !instruccion) {
							limiteI = i;
						}
						if (!instruccion) {
							condi = true;
						}
					} else if (result[i].equals("{")) {
						limiteD = i;
						limiteIz = i + 1;
						instruccion = true;
						condi = false;
					} else if (result[i].equals(";")) {
						limiteDe = i;
						linea2 = "";
						for (int j = limiteIz; j < limiteDe; j++) {
							linea2 = linea2.concat(result[j]);
						}
						instrucciones.add(linea2);
						limiteIz = i + 1;
						condi = false;
					}
				}
			}
			linea2 = "";
			for (int i = limiteI; i < limiteD; i++) {
				linea2 = linea2.concat(result[i]);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		mapResults.put("instrucciones", instrucciones);
		mapResults.put("numeroCondiciones", numeroCondiciones);
		return linea2;
	}
}
