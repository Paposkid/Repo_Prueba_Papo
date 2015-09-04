package com.amx.service.business;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceClient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.billinginquiry.getcustomerentitiesbyidentifier.GetCustomerEntitiesByIdentifier;
import com.amx.billinginquiry.getcustomerentitiesbyidentifier.GetCustomerEntitiesByIdentifierService;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.GetCustomerEntitiesByIdentifierRequest;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.GetCustomerEntitiesByIdentifierResponse;
import com.amx.service.adapter.CustomerEntitiesByIdentifierAdapter;
import com.amx.service.bean.AccountBaIdsInfoSalidaTO;
import com.amx.service.bean.ContactListSalidaTO;
import com.amx.service.bean.CustomerEntitiesByIdentifierSalidaTO;
import com.amx.service.bean.CustomerEntitiesByIdentifierTO;
import com.amx.service.bean.CustomerEntityListSalidaTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;

@Service
public class CustomerEntitiesByIdentifierClientBusinessImpl implements CustomerEntitiesByIdentifierClientBusiness{

	private static Logger logger = Logger.getLogger(CustomerEntitiesByIdentifierClientBusinessImpl.class);
	
	@Autowired
	private ResourcesBusiness resourcesBusiness;
	
	@Override
	public List<CustomerEntityListSalidaTO> listaCBP(String rut, String idType ) throws Exception {
		
		
		CustomerEntitiesByIdentifierTO miCustomerEntitiesByIdentifierTO = null;
		CustomerEntitiesByIdentifierSalidaTO miCustomerEntitiesByIdentifierSalidaTO = null;
		GetCustomerEntitiesByIdentifierRequest request = null;
		GetCustomerEntitiesByIdentifierResponse response = null;
		ResourcesTO resourcesTO = new ResourcesTO();
		List<CustomerEntityListSalidaTO> listCBP = new ArrayList<CustomerEntityListSalidaTO>();
		
		
		try {
			
				resourcesTO.setResourceName(Constantes.ENDPOINT_CUSTOMER_ENTITIES_BY_IDENTIFIER);
				resourcesTO = resourcesBusiness.searchResourcesByName(resourcesTO);
				LoggerFacade.registerLog(Constantes.INFO_LLAMADO + "AMDOCS SERVICIO CUSTOMER BY IDENTIFIER");
				
				WebServiceClient clienteWS = GetCustomerEntitiesByIdentifierService.class.getAnnotation(WebServiceClient.class);
				URL endPoint = new URL(resourcesTO.getValor());
				QName serviceName = new QName(clienteWS.targetNamespace(),clienteWS.name());
				
				GetCustomerEntitiesByIdentifierService webService = new GetCustomerEntitiesByIdentifierService(endPoint, serviceName);
				GetCustomerEntitiesByIdentifier port = webService.getGetCustomerEntitiesByIdentifierPort();
				
				miCustomerEntitiesByIdentifierTO= new CustomerEntitiesByIdentifierTO();
				miCustomerEntitiesByIdentifierTO.setIdentifierNumber(rut);
				miCustomerEntitiesByIdentifierTO.setIdentifierType(idType);
				request = CustomerEntitiesByIdentifierAdapter.beanToRequest(miCustomerEntitiesByIdentifierTO);
				response= port.getCustomerEntitiesByIdentifier(request);
				miCustomerEntitiesByIdentifierSalidaTO = CustomerEntitiesByIdentifierAdapter.responseToBean(response);
				
				for (ContactListSalidaTO contactListSalidaTO : miCustomerEntitiesByIdentifierSalidaTO.getContactList()) {
					
					listCBP.addAll(contactListSalidaTO.getCbpList());
					
				}
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		
		return listCBP;
	}

}
