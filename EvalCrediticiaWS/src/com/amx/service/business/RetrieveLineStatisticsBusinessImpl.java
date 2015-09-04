package com.amx.service.business;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceClient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.ApplicationContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.ComAmdocsCihServicesOmsInterfacesRetrieveLineStatistics;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.GamaStatistics;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.MaskInfo;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.OrderingContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatistics;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatisticsInput;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatisticsResponse;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatistics_Type;
import com.amx.service.adapter.RetrieveLineStatisticsAdapter;
import com.amx.service.bean.CustomerEntityListSalidaTO;
import com.amx.service.bean.GamaStatisticsSalidaTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.bean.RetrieveLineStatisticsSalidaTO;
import com.amx.service.bean.RetrieveLineStatisticsTypeTO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;


@Service
public class RetrieveLineStatisticsBusinessImpl implements RetrieveLineStatisticsBusiness{

	private static Logger logger = Logger.getLogger(RetrieveLineStatisticsBusinessImpl.class);
	@Autowired
	private ResourcesBusiness resourcesBusiness;
	@Override
	public Integer consultarEstadisticasDeLineas(List<CustomerEntityListSalidaTO> listCBP)throws Exception {
		
		RetrieveLineStatisticsSalidaTO  miRetrieveLineStatisticsSalidaTO = null;
		RetrieveLineStatisticsTypeTO miRetrieveLineStatisticsTypeTO = null;
		ResourcesTO resourcesTORetrieve = new ResourcesTO();
		RetrieveLineStatistics_Type requestRetrieve = new RetrieveLineStatistics_Type();
		RetrieveLineStatisticsResponse responseRetrieve = new RetrieveLineStatisticsResponse();
		Integer sumaLineas = 0;
		GamaStatisticsSalidaTO gamaStatisticsSalidaTO = null;
		ApplicationContext applicationContext = null;
		OrderingContext orderingContext = null;
		RetrieveLineStatisticsInput retrieveLineStatisticsInput = null;
		MaskInfo maskInfo = null;
		
		
		try {
			resourcesTORetrieve.setResourceName(Constantes.ENDPOINT_RETRIEVE_LINE_EVALUATION);
			resourcesTORetrieve = resourcesBusiness.searchResourcesByName(resourcesTORetrieve);
			LoggerFacade.registerLog(Constantes.INFO_LLAMADO + "AMDOCS RETRIEVE LINE EVALUATION");
			
			WebServiceClient clienteWSRLS = ComAmdocsCihServicesOmsInterfacesRetrieveLineStatistics.class.getAnnotation(WebServiceClient.class);
			URL endPointRLS = new URL (resourcesTORetrieve.getValor());
			QName serviNameRLS  = new QName(clienteWSRLS.targetNamespace(),clienteWSRLS.name());
			ComAmdocsCihServicesOmsInterfacesRetrieveLineStatistics webServiceRLS = new ComAmdocsCihServicesOmsInterfacesRetrieveLineStatistics(endPointRLS, serviNameRLS);
			RetrieveLineStatistics portRLS = webServiceRLS.getRetrieveLineStatistics();
			
			for (CustomerEntityListSalidaTO customerEntityListSalidaTO : listCBP) {
				
			miRetrieveLineStatisticsTypeTO  = new RetrieveLineStatisticsTypeTO();
			miRetrieveLineStatisticsSalidaTO = new RetrieveLineStatisticsSalidaTO();
			applicationContext = new ApplicationContext();
			orderingContext = new OrderingContext();
			retrieveLineStatisticsInput = new RetrieveLineStatisticsInput();
			retrieveLineStatisticsInput.setCustomerIdX11(customerEntityListSalidaTO.getCustomerId());
			maskInfo = new MaskInfo();
					
			requestRetrieve= RetrieveLineStatisticsAdapter.beanToRequest(miRetrieveLineStatisticsTypeTO);
			responseRetrieve.setRetrieveLineStatisticsOutput(portRLS.retrieveLineStatistics(applicationContext, orderingContext, retrieveLineStatisticsInput, maskInfo));
			
			miRetrieveLineStatisticsSalidaTO = RetrieveLineStatisticsAdapter.responseToBean(responseRetrieve);
				
			for (GamaStatisticsSalidaTO gamaStatisticsSalida : miRetrieveLineStatisticsSalidaTO.getRetrieveLineStatisticsOutput().getCustomerLineStatisticsX11().getGamaStatisticsX11()) {
				
				sumaLineas = (Integer.parseInt(gamaStatisticsSalida.getTotalAssignedLinesX11())) + sumaLineas;
			}
						
			}
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
			throw e;
		}
		
		return sumaLineas;
	}

}
