package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AmdocsResTO;
import com.amx.service.bean.AmdocsTO;
import com.amx.service.bean.Ar7CreditEvaluationSalidaTO;
import com.amx.service.bean.CustomerEntityListSalidaTO;
import com.amx.service.bean.DocInfoTO;
import com.amx.service.bean.DocumentChargesSalidaTO;
import com.amx.service.bean.DocumentChargesTO;
import com.amx.service.bean.DocumentListTO;
import com.amx.service.bean.ParametroTO;
import com.amx.service.bean.RetrieveLineStatisticsSalidaTO;
import com.amx.service.bean.RetrieveLineStatisticsTypeTO;
import com.amx.service.dao.AmdocsDAO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;



@Service
public class AmdocsBusinessImpl implements AmdocsBusiness {

	private static Logger logger = Logger.getLogger(AmdocsBusinessImpl.class);

	@Autowired
	private AmdocsDAO amdocsDAO;

	@Autowired
	private ParametroBusiness parametroBusinessImpl;

	@Autowired
	private AmdocsResBusiness amdocsResImpl;

	@Autowired
	private ResourcesBusiness resourcesBusiness;

	@Autowired
	private Ar7CreditEvaluationBusiness ar7CreditEvaluationBusinessWS;

	@Autowired
	private CustomerEntitiesByIdentifierClientBusiness customerEntitiesByIdentifierClientBusinessWS;

	@Autowired
	private DocumentListBusiness documentListBusinessWS;

	@Autowired
	private DocumentChargesBusiness documentChargesBusinessWS;

	@Autowired
	private RetrieveLineStatisticsBusiness retrieveLineStatisticsBusinessWS;

	@SuppressWarnings("unchecked")
	public List<AmdocsTO> searchListAmdocs(Long codAmdocs) throws Exception {
		List<AmdocsTO> listAmdocs = null;
		Map<String, Object> mapAmdocsBean = new HashMap<String, Object>();

		try {
			mapAmdocsBean.put("codAmdocs", codAmdocs);
			amdocsDAO.listAmdocs(mapAmdocsBean);
			listAmdocs = (List<AmdocsTO>) mapAmdocsBean.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listAmdocs;
	}

	@Override
	public AmdocsTO consultarApiAmdocs(String rut, String idType) throws Exception {
		AmdocsTO miAmdocs = new AmdocsTO();
		List<ParametroTO> orden = parametroBusinessImpl.buscarParametroPorNomb("odse_nota_comportamiento_");
		try {
			miAmdocs = ejecutarPaso(rut, orden.get(0).getNombreParametro(),idType);
		} catch (Exception e) {
			try {
				miAmdocs = ejecutarPaso(rut, orden.get(1).getNombreParametro(),idType);

			} catch (Exception j) {
				try {
					miAmdocs = ejecutarPaso(rut, orden.get(2).getNombreParametro(),idType);

				} catch (Exception k) {

					logger.error("No se pudo acceder a los datos a través de ninguno de los medios");
					throw new Exception(k);
				}

			}

		}
		return miAmdocs;
	}

	@Override
	public void insertarAmdocs(AmdocsTO amdocsTO) throws Exception {
		try {
			amdocsDAO.insertarAmdocs(amdocsTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	public AmdocsTO ejecutarPaso(String rut, String tipo, String idType) throws Exception {

		AmdocsTO miAmdocs = null;
		ParametroTO miParametroTO = null;
		AmdocsResTO miAmdocsRes = null;

		

		if (tipo.equals("odse_nota_comportamiento_ws")) {
			// Consumo Web Service Amdocs
			List<CustomerEntityListSalidaTO> lstCustomerEntityListSalidaTO = null;
			Ar7CreditEvaluationSalidaTO ar7CreditEvaluationSalidaTO = null;
			List<DocInfoTO> lstDocumentListSalidaTO = null;
			DocumentListTO documentListTO = null;
			DocumentChargesTO documentChargesTO = null;
			RetrieveLineStatisticsTypeTO retrieveLineStatisticsTypeTO = null;
			RetrieveLineStatisticsSalidaTO retrieveLineStatisticsSalidaTO = null;
			DocumentChargesSalidaTO documentChargesSalidaTO = null;
			Double sumaAmountIncludeTax = 0d;
			Integer retrieveLineStatistics=null;
			
			
			try {
				
				miAmdocs = new AmdocsTO();
				miAmdocs.setClienteAntiguo("N");
				miAmdocs.setNotaComportamiento("0");
				miAmdocs.setOrigen("Servicio");
				
				LoggerFacade.registerLog(Constantes.INFO_LLAMADO + "AMDOCS");
				lstCustomerEntityListSalidaTO = customerEntitiesByIdentifierClientBusinessWS.listaCBP(rut,idType);
				
				if ((lstCustomerEntityListSalidaTO == null || lstCustomerEntityListSalidaTO.isEmpty())
						|| ((lstCustomerEntityListSalidaTO.size() == 1) && ((lstCustomerEntityListSalidaTO.get(0).getAccountBaIdsList() == null || lstCustomerEntityListSalidaTO.get(0)
								.getAccountBaIdsList().isEmpty())))) {
					miAmdocs.setClienteAntiguo("N");
					} else {
						miAmdocs.setClienteAntiguo("S");
						//Llamar Ar7 //ar7CreditEvaluationSalidaTO = ar7CreditEvaluationBusinessWS.consultaAr7(lstCustomerEntityListSalidaTO);//nota de comportamiento, monto de deuda, antiguedad del cliente
					}
						if (miAmdocs.getClienteAntiguo().equals("S")) {
		//					if (ar7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("0") && !ar7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1")) {
		//						 miAmdocs.setClienteAntiguo("N");
		//
		//					}
							//retrieveLineStatistics = retrieveLineStatisticsBusinessWS.consultarEstadisticasDeLineas(lstCustomerEntityListSalidaTO);//Cantidad de lineas
							for (CustomerEntityListSalidaTO CBP : lstCustomerEntityListSalidaTO) {
								lstDocumentListSalidaTO = documentListBusinessWS.listaDocumentFacturados(CBP.getCustomerId());
								for (DocInfoTO doc : lstDocumentListSalidaTO) {
									documentChargesSalidaTO = documentChargesBusinessWS.consultarAporteDeIVA(doc.getDocumentId().toString());
									if (documentChargesSalidaTO.getChargeAllDetailsInfo().getTaxRelation().toString().equals("0")
											|| (documentChargesSalidaTO.getChargeAllDetailsInfo().getTaxRelation().toString().equals("1"))) {
										sumaAmountIncludeTax = sumaAmountIncludeTax + documentChargesSalidaTO.getChargeAllDetailsInfo().getAmountIncludeTax();
									}
									documentChargesSalidaTO.getChargeAllDetailsInfo().setAmountIncludeTax(sumaAmountIncludeTax);
								}
							}
						
							//miAmdocs.setAntiguedaLineasAct((int) ar7CreditEvaluationSalidaTO.getL7SubSeniority());
						    //miAmdocs.setDeudaVencida((int) ar7CreditEvaluationSalidaTO.getAmountDue());
						    //miAmdocs.setNotaComportamiento(ar7CreditEvaluationSalidaTO.getL7PaymentBehavior());
						    miAmdocs.setPagoRecurrenteAct((Integer) documentChargesSalidaTO.getChargeAllDetailsInfo().getTotalTaxAmount().intValue());
						   // miAmdocs.setCantLineasAct(retrieveLineStatistics);
						
												
					}

			} catch (Exception w) {
				logger.error(w.getMessage());
				throw new Exception("El web service no esta disponible");
			}

		} else if (tipo.equals("odse_nota_comportamiento_tr")) {
			miAmdocsRes = amdocsResImpl.searchListAmdocsRes(rut);
			miAmdocs = new AmdocsTO();
			miAmdocs.setAntiguedaLineasAct(miAmdocsRes.getAntgLineasAct());
			miAmdocs.setCantLineasAct(miAmdocsRes.getCantLineasAct());
			miAmdocs.setClienteAntiguo(miAmdocsRes.getClienteAntiguo());
			miAmdocs.setDeudaVencida(miAmdocsRes.getDeudaVencida());
			miAmdocs.setNotaComportamiento(miAmdocsRes.getNotaComportamineto());
			miAmdocs.setOrigen("Respaldo Amdocs");
			miAmdocs.setPagoRecurrenteAct(miAmdocsRes.getPagoRecurrenteAct());

			if (miAmdocs == null || miAmdocs.getCodAmdocs() == null) {
				throw new Exception("No hay datos en la base de datos");
			}

		} else if (tipo.equals("odse_nota_comportamiento_vd")) {
			miParametroTO = parametroBusinessImpl.buscarParametroPorNombre("prm_LCE_NC_CLIENTE_ANTIGUO");
			miAmdocs = new AmdocsTO();
			miAmdocs.setClienteAntiguo(miParametroTO.getValorParametro());
			miParametroTO = parametroBusinessImpl.buscarParametroPorNombre("prm_LCE_NC_ANTIGUEDAD_ACTIVAS_CLIENTE");
			miAmdocs.setAntiguedaLineasAct(Integer.parseInt(miParametroTO.getValorParametro()));
			miParametroTO = parametroBusinessImpl.buscarParametroPorNombre("prm_LCE_NC_DEUDA_VENCIDA_CLIENTE");
			miAmdocs.setDeudaVencida(Integer.parseInt(miParametroTO.getValorParametro()));
			miParametroTO = parametroBusinessImpl.buscarParametroPorNombre("prm_LCE_NC_NOTA_COMPORTAMIENTO");
			miAmdocs.setNotaComportamiento(miParametroTO.getValorParametro());
			miParametroTO = parametroBusinessImpl.buscarParametroPorNombre("prm_LCE_NC_CANTIDAD_LINEAS_ACTUALES");
			miAmdocs.setCantLineasAct(Integer.parseInt(miParametroTO.getValorParametro()));
			miParametroTO = parametroBusinessImpl.buscarParametroPorNombre("prm_LCE_NC_PAGO_RECURRENTE_ACTUAL");
			miAmdocs.setPagoRecurrenteAct(Integer.parseInt(miParametroTO.getValorParametro()));
			miAmdocs.setOrigen("Valores por Defecto");
		} else if (tipo.equals("odse_nota_comportamiento_dh")) {
			if (miAmdocs == null || miAmdocs.getCodAmdocs() == null) {
				throw new Exception("No hay datos en la base de datos");
			}
		}

		return miAmdocs;

	}

}
