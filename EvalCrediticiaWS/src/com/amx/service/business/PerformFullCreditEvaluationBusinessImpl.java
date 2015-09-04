package com.amx.service.business;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AttrdifinfoTO;
import com.amx.service.bean.CategoriaTO;
import com.amx.service.bean.CompdifinfoTO;
import com.amx.service.bean.ConditionFCETO;
import com.amx.service.bean.ConstanteTO;
import com.amx.service.bean.DominioTO;
import com.amx.service.bean.EntFceTO;
import com.amx.service.bean.EquivalenteEntradaTO;
import com.amx.service.bean.ExcCondicionFceTO;
import com.amx.service.bean.ExcFceTO;
import com.amx.service.bean.NegExcepcionTO;
import com.amx.service.bean.NegFceTO;
import com.amx.service.bean.NegLceTO;
import com.amx.service.bean.ProductTO;
import com.amx.service.bean.ReadListaTypeTO;
import com.amx.service.bean.ReglaTO;
import com.amx.service.bean.SalFceTO;
import com.amx.service.bean.SalLceTO;
import com.amx.service.dao.EquivalenteEntradaDAO;
import com.amx.service.exception.BusinessException;
import com.amx.service.util.Reflexion;
import com.amx.service.util.Util;
import com.amx.service.util.XReflection;


@Service
public class PerformFullCreditEvaluationBusinessImpl implements PerformFullCreditEvaluationBusiness {

	private static Logger logger = Logger.getLogger(PerformFullCreditEvaluationBusinessImpl.class);

	@Autowired
	private EntFCEBusiness entFCEBusiness;
	@Autowired
	private SalFceBusiness salFceBusiness;
	@Autowired
	private SalLceBusiness salLceBusiness;
	@Autowired
	private NegFceBusiness negFceBusiness;
	@Autowired
	private NegLceBusiness negLceBusiness;
	@Autowired
	private ExcFceBusiness excFceBusiness;
	@Autowired
	private ConditionFCEBusiness condicionFceBusiness;
	@Autowired
	private ListasEspecialesBusiness listasEspecialesBL;
	@Autowired
	private NegExcepcionBusiness negExcepcionesBusiness;
	@Autowired
	private ExcCondicionFceBusiness excCondicionFceBusiness;
	@Autowired
	private DominioBusiness miDominioBusiness;
	@Autowired
	private ConstanteBusiness miConstanteBusiness;
	@Autowired
	private CategoriaBusiness miCategoriaBusinessImpl;
	@Autowired
	private ReglaBusiness miReglaBusiness;
	@Autowired
	EquivalenteEntradaDAO miEquivalenteEntradaDAO;

	@Override
	public SalFceTO performFullCreditEvaluation(EntFceTO requestTO) throws Exception {
		String reglas="";
		NegFceTO negFCE = null;
		NegFceTO miNegFCE = null;
		NegLceTO negLCE = null;
		SalFceTO salFce = null;
		List<ReadListaTypeTO> listaEspecialTO = null;
		SalLceTO salLCE = null;
		SalFceTO resultadoSalFce = null;
		SalFceTO miSalFCE = null;
		NegExcepcionTO miNegExcepcion = null;
		NegExcepcionTO negExcepcion = null;
		ExcFceTO miExcFce = null;
		ConditionFCETO condicionFCE = null;
		List<SalFceTO> miListSalFCE = null;
		List<ExcFceTO> miListaExcepcionFce = null;
		List<NegFceTO> fceAsociada = null;
		List<ExcCondicionFceTO> excCondicion = null;
		Integer usuario = 0;
		Boolean ventaMultiple = false;
		Boolean existeFCE = false;
		Boolean primerMensaje = true;
		Boolean pre = false;
		Boolean existeError = false;
		Integer totalLinasSolicitadas = 0;
		Integer sumaLineas = 0;
		Integer edadCliente = 0;
		Integer cantLineas = 0;
		Integer lineasDisponibles = 0;
		Date fechaActual = new Date();
		Date fechaCercana = new Date(19700808);
		try {

			usuario = Integer.parseInt(requestTO.getCredScoreInfo().getDealerId());
			negFCE = new NegFceTO();
			negFCE.setCodUsuarioAlta(usuario);
			negFCE.setEstado("I");
			negLCE = negLceBusiness.listNegLceOrder(Integer.parseInt(requestTO.getCredScoreInfo().getOrderID()));
			if (negLCE != null && !negLCE.getEstado().equals("I")) {
				salLCE = salLceBusiness.buscarSalLce(negLCE.getCodLce().intValue());
				if (salLCE != null) {
					if (salLCE.getCredScoreResInfo().getScoreExpiryDate().compareTo(fechaActual) <= 0) {
						negFCE.setCodLce(negLCE.getCodLce());
						negFceBusiness.insertarNegFce(negFCE);
						requestTO.setUsuario(usuario);
						requestTO.setCorrFCE(negFCE.getCodFce());
						entFCEBusiness.insertarEntFCE(requestTO);
						for (ProductTO record : requestTO.getProducto()) {

							for (CompdifinfoTO componente : record.getComponent()) {

								if (componente.getCid().equals("199853") && !ventaMultiple) {
									for (AttrdifinfoTO attrdifinfo : componente.getListAttrdifinfo()) {
										if (attrdifinfo.getNombre().equals("Requested_Quantity") && attrdifinfo.getValor() != null) {
											ventaMultiple = true;
										}
									}
								}
							}
						}
						for (ProductTO record : requestTO.getProducto()) {
							if (ventaMultiple) {
								if ((record.getOrderAction().getOrderActiontype().equals("PR") || record.getOrderAction().getOrderActiontype().equals("PI")
										|| record.getOrderAction().getOrderActiontype().equals("CW") || record.getOrderAction().getOrderActiontype().equals("ES"))) {

									for (CompdifinfoTO componente : record.getComponent()) {

										if (componente.getCid().equals("199853")) {
											for (AttrdifinfoTO attrdifinfo : componente.getListAttrdifinfo()) {
												if (attrdifinfo.getNombre().equals("Requested_Quantity")) {
													sumaLineas = Integer.parseInt(attrdifinfo.getValor());
													totalLinasSolicitadas = totalLinasSolicitadas + sumaLineas;

												}
											}
										}
									}
								} else {
									for (CompdifinfoTO componente : record.getComponent()) {

										if (componente.getCid().equals("199853")) {
											for (AttrdifinfoTO attrdifinfo : componente.getListAttrdifinfo()) {
												sumaLineas = Integer.parseInt(attrdifinfo.getValor());
												totalLinasSolicitadas = totalLinasSolicitadas - sumaLineas;
											}
										}
									}
								}
							} else {
								if ((record.getOrderAction().getOrderActiontype().equals("PR") || record.getOrderAction().getOrderActiontype().equals("PI")
										|| record.getOrderAction().getOrderActiontype().equals("CW") || record.getOrderAction().getOrderActiontype().equals("ES"))) {

									totalLinasSolicitadas++;

								} else {
									totalLinasSolicitadas--;
								}
							}
							cantLineas++;
						}

						if (requestTO.getCredApproValidInput() != null && !requestTO.getCredApproValidInput().isEmpty()) { 
							miListSalFCE = salFceBusiness.buscarFCEAproIdOut(requestTO.getCredApproValidInput());
							if (miListSalFCE != null && !miListSalFCE.isEmpty()) {
								for (SalFceTO encontrarSalFce : miListSalFCE) {
									if (encontrarSalFce.getCreditApprovalIDOutput() != null && !encontrarSalFce.getCreditApprovalIDOutput().isEmpty()) {
										miNegFCE = negFceBusiness.listNegFce(encontrarSalFce.getCodFCE().intValue(), negLCE.getCodLce().intValue());
										if (miNegFCE.getFechaAlta().compareTo(fechaCercana) >= 0) {
											fechaCercana = miNegFCE.getFechaAlta();
											miSalFCE = encontrarSalFce;
											if (encontrarSalFce.getConditions().isEmpty())
												miSalFCE.getConditions().addAll(condicionFceBusiness.buscarConditionFCE(encontrarSalFce.getCodFCE()));
										}
									}
								}
							}
							lineasDisponibles = miSalFCE.getLineasDisponibles();
							if (lineasDisponibles < cantLineas) {
								existeError = true;
							} else {
								miSalFCE.setLineasDisponibles(lineasDisponibles - cantLineas);
								salFceBusiness.actualizarSalFCEOnlyLineas(miSalFCE);
								miSalFCE.setCodFCE(negFCE.getCodFce());
								miSalFCE.setAprobacionCred(null);
								salFceBusiness.insertarFCE(miSalFCE);
							}
							primerMensaje = false;
						}
						if (!existeError) {
							if (primerMensaje) {

								edadCliente = Util.calcularEdad(requestTO.getCredScoreInfo().getDateBirth(), new Date());
								fceAsociada = negFceBusiness.listNegFCEByCodLCE(salLCE.getCorrLce().intValue());
								if (fceAsociada != null && !fceAsociada.isEmpty()) {
									for (NegFceTO negFceActual : fceAsociada) {
										salFce = salFceBusiness.buscarFCE(negFceActual.getCodFce());
										if (salFce != null) {
											if (negFceActual.getFechaAlta().compareTo(fechaCercana) >= 0) {
												if (ventaMultiple) {
													if (salFce.getAprobacionCred() != null) {
														fechaCercana = negFceActual.getFechaAlta();
														miNegFCE = negFceActual;
														miSalFCE = salFce;
													}
												} else {
													fechaCercana = negFceActual.getFechaAlta();
													miNegFCE = negFceActual;
													miSalFCE = salFce;
												}
											}
										}
									}
									if (miSalFCE != null) {
										existeFCE = true;
										fechaCercana = new Date(19700808);
										miListaExcepcionFce = excFceBusiness.listExcFce(null, miSalFCE.getCodFCE());
										if (miListaExcepcionFce != null && !miListaExcepcionFce.isEmpty()) {
											for (ExcFceTO excepcionFCE : miListaExcepcionFce) {
												negExcepcion = negExcepcionesBusiness.buscarNegExcepcionPorCodExcepcion(excepcionFCE.getCodExcFce().intValue());
												if (negExcepcion.getFechaAlta().compareTo(fechaCercana) >= 0) {
													fechaCercana = negExcepcion.getFechaAlta();
													miNegExcepcion = negExcepcion;
													miExcFce = excepcionFCE;
												}
											}
										}
										if (miExcFce != null) {
											salFce = miSalFCE;
											miSalFCE = new SalFceTO();
											miSalFCE.setCodFCE(negFCE.getCodFce());
											excCondicion = excCondicionFceBusiness.listExcCondicionFce(miExcFce.getCodExcFce().intValue());
											miSalFCE.setHomeVisitRequired(salFce.getHomeVisitRequired());
											miSalFCE.setCreditApprovalIDOutput(salFce.getCreditApprovalIDOutput());
											miSalFCE.setCreditRefNumber(salFce.getCreditRefNumber());
											miSalFCE.setStatus(salFce.getStatus());
											miSalFCE.setDescription(salFce.getDescription());
											for (ExcCondicionFceTO excCondicionFceTO : excCondicion) {
												condicionFCE = new ConditionFCETO();
												// condicionFCE.setAmount()
												condicionFCE.setCantCuotas(excCondicionFceTO.getNumInstallment());
												condicionFCE.setCodeUsuario(usuario);
												condicionFCE.setCodOrdenActionInfo(excCondicionFceTO.getCodOrderactionInfo());
												condicionFCE.setDeposit(excCondicionFceTO.getDeposit());
												condicionFCE.setInstZero(excCondicionFceTO.getInstZero());
												condicionFCE.setMesesAdelanto(excCondicionFceTO.getNumRcInAvanced());
												miSalFCE.getConditions().add(condicionFCE);
											}
											miSalFCE.setCodeUsuario(usuario);
											miSalFCE.setCodFCE(negFCE.getCodFce());
											salFceBusiness.insertarFCE(miSalFCE);
										}

									}

								}
								if (!existeFCE) {
									listaEspecialTO = listasEspecialesBL.obtenerRespuestaListasEspeciales(requestTO.getCredScoreInfo());

									miSalFCE = new SalFceTO();
									Map<String, Object> mapReglas = new HashMap<String, Object>();
									mapReglas.put("EntFceTO", requestTO);
									mapReglas.put("NegLceTO", negLCE);
									mapReglas.put("SalLceTO", salLCE);
									mapReglas.put("NegFceTO", negFCE);
									mapReglas.put("SalFceTO", miSalFCE);
									mapReglas.put("Reglas", reglas);
									pre = realizarPreEvaluacion(mapReglas);
									if (!pre) {
										if (!realizarEvaluacion(mapReglas)) {
											existeError = true;
										} else {
											realizarEvaluacionEspecifica(mapReglas);
											realizarPostEvaluacion(mapReglas);
										}
									}
									if (!existeError) {
										miSalFCE.setReglas(String.valueOf(mapReglas.get("Reglas")));
										miSalFCE.setCodFCE(negFCE.getCodLce());
										miSalFCE.setCodeUsuario(usuario);
										salFceBusiness.insertarFCE(miSalFCE);
									}

								} else {
									existeError = true;

								}

							}

						}
					} else {
						existeError = true;
					}
				} else {
					existeError = true;
				}
			} else {
				existeError = true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			if (negFCE != null) {
				negFCE.setEstado("A");
				negFceBusiness.actualizarEstadoNegFce(negFCE);
			}
			throw e;
		}
		if (existeError) {
			if (negFCE != null) {
				negFCE.setEstado("A");
				negFceBusiness.actualizarEstadoNegFce(negFCE);
			}
			throw new BusinessException();
		}

		return miSalFCE;
	}

	public void realizarEvaluacionEspecifica(Map<String, Object> mapReglas) {
		ScriptEngineManager mgr;
		String reglas;
		String nombreRegla="";
		ScriptEngine engine;
		ConditionFCETO miConditionFCETO;
		EntFceTO miEntFceTO;
		SalFceTO miSalFceTO;
		Boolean o;
		List<ProductTO> listaProductos;
		int cumplidas = 0;
		boolean cumplio = false;
		String condicion;
		List<ReglaTO> misReglas = new ArrayList<ReglaTO>();
		List<String> instrucciones = null;
		Map<String, Object> mapResults = new HashMap<String, Object>();
		ReglaTO miReglaTO = new ReglaTO();
		miEntFceTO = (EntFceTO) mapReglas.get("EntFceTO");
		listaProductos = miEntFceTO.getProducto();
		miReglaTO.setTipoEvaluacion("E");
		miReglaTO.setEstado("A");
		miReglaTO.setTipoRegla("F");
		miReglaTO.setSubtipoRegla("E");
		reglas =(String)mapReglas.get("Reglas");
		try {
			misReglas = miReglaBusiness.buscarReglaAEvaluar(miReglaTO);
			for (ProductTO pro : listaProductos) {
				mapReglas.put("ProductTO", pro);

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

				if (cumplio) {
					reglas = reglas.concat(nombreRegla+",");
					miConditionFCETO = new ConditionFCETO();
					miConditionFCETO.setCodOrdenActionInfo(pro.getOrderAction().getCorrProduct());
					miConditionFCETO.setOrderActionId(pro.getOrderAction().getOrderActionid());
					mapReglas.put("ConditionFCETO", miConditionFCETO);
					ejecutarInstrucciones(instrucciones, mapReglas);
					miSalFceTO = (SalFceTO) mapReglas.get("SalFceTO");
					miSalFceTO.getConditions().add(miConditionFCETO);
					mapReglas.put("Reglas", reglas);
				}
				
			}
		} catch (Exception e) {

			logger.error(e.getMessage(),e);
		}

	}

	public boolean realizarEvaluacion(Map<String, Object> mapReglas) {
		ScriptEngineManager mgr;
		ScriptEngine engine;
		String reglas;
		String nombreRegla="";
		Boolean o;
		int cumplidas = 0;
		boolean cumplio = false;
		String condicion;
		List<ReglaTO> misReglas = new ArrayList<ReglaTO>();
		List<String> instrucciones = null;

		Map<String, Object> mapResults = new HashMap<String, Object>();
		ReglaTO miReglaTO = new ReglaTO();

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

			if (cumplio) {
				reglas = (String)mapReglas.get("Reglas");
				ejecutarInstrucciones(instrucciones, mapReglas);
				reglas = reglas.concat(nombreRegla);
				mapReglas.put("Reglas", reglas);
			}
		} catch (Exception e) {

			logger.error(e.getMessage(),e);
		}

		return cumplio;

	}

	public boolean realizarPostEvaluacion(Map<String, Object> mapReglas) {

		ScriptEngineManager mgr;
		ScriptEngine engine;
		Boolean o;
		String reglas;
		Boolean cumplio = false;
		String condicion;
		List<ReglaTO> misReglas = new ArrayList<ReglaTO>();
		List<String> instrucciones;
		Map<String, Object> mapResults = new HashMap<String, Object>();
		ReglaTO miReglaTO = new ReglaTO();
		miReglaTO.setTipoEvaluacion("O");
		miReglaTO.setEstado("A");
		miReglaTO.setTipoRegla("F");
		miReglaTO.setSubtipoRegla("G");
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
						reglas = reglas.concat(reglaTO.getNombre());
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

			logger.error(e.getMessage(),e);
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
		miReglaTO.setEstado("A");
		miReglaTO.setTipoRegla("F");
		miReglaTO.setSubtipoRegla("G");
		reglas= (String)mapReglas.get("Reglas");
		try {
			misReglas = miReglaBusiness.buscarReglaAEvaluar(miReglaTO);
			for (ReglaTO reglaTO : misReglas) {
				condicion = getCondicion(reglaTO.getValor(), mapReglas, mapResults);
				try {
					mgr = new ScriptEngineManager();
					engine = mgr.getEngineByName("JavaScript");
					o = (Boolean) engine.eval(condicion);
					if (o) {
						reglas = reglas.concat(reglaTO.getNombre());
						instrucciones = ((List<String>) mapResults.get("instrucciones"));
						ejecutarInstrucciones(instrucciones, mapReglas);
						cumplio = true;
					}
				} catch (ScriptException ex) {
					throw ex;
				}
			}
			mapReglas.put("Reglas",reglas);

		} catch (Exception e) {

			logger.error(e.getMessage(),e);
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
				logger.error(e.getMessage(),e);
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
									result[i] = result[i].concat(resulDominioTO.getValor());
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
			logger.error(e.getMessage(),e);
		}
		mapResults.put("instrucciones", instrucciones);
		mapResults.put("numeroCondiciones", numeroCondiciones);
		return linea2;
	}

}
