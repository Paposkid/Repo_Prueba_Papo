package com.amx.service.business;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceClient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.charge.getdocumentcharges.GetDocumentCharges;
import com.amx.charge.getdocumentcharges.GetDocumentChargesService;
import com.amx.schema.charge.getdocumentcharges.GetDocumentChargesRequest;
import com.amx.schema.charge.getdocumentcharges.GetDocumentChargesResponse;
import com.amx.service.adapter.DocumentChargesAdapter;
import com.amx.service.bean.DocumentChargesSalidaTO;
import com.amx.service.bean.DocumentChargesTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;


@Service
public class DocumentChargesBusinessImpl implements DocumentChargesBusiness {

	private static Logger logger = Logger.getLogger(DocumentChargesBusinessImpl.class);
	@Autowired
	private ResourcesBusiness resourcesBusiness;

	@Override
	public DocumentChargesSalidaTO consultarAporteDeIVA (String  id) throws Exception {

		DocumentChargesTO miDocumentChargesTO = null;
		DocumentChargesSalidaTO miDocumentChargesSalidaTO = null;
		ResourcesTO resourcesTODCharges = new ResourcesTO();
		GetDocumentChargesRequest requestDCharges = new GetDocumentChargesRequest();
		GetDocumentChargesResponse responseDCharges = new GetDocumentChargesResponse();
		

		try {
			resourcesTODCharges.setResourceName(Constantes.ENDPOINT_DOCUMNETS_CHARGES);
			resourcesTODCharges = resourcesBusiness.searchResourcesByName(resourcesTODCharges);
			LoggerFacade.registerLog(Constantes.INFO_LLAMADO + "AMDOCS DOCUMNETS CHARGES");

			WebServiceClient clienteWSCharge = GetDocumentChargesService.class.getAnnotation(WebServiceClient.class);
			URL endPointCharges = new URL(resourcesTODCharges.getValor());
			QName serviceNameCharges = new QName(clienteWSCharge.targetNamespace(), clienteWSCharge.name());
			GetDocumentChargesService webServiceCharge = new GetDocumentChargesService(endPointCharges, serviceNameCharges);
			GetDocumentCharges portCharge = webServiceCharge.getGetDocumentChargesPort();
			
			miDocumentChargesTO = new DocumentChargesTO();
			miDocumentChargesSalidaTO = new DocumentChargesSalidaTO();
			miDocumentChargesTO.getDocIdInfo().setDocumentId(Long.parseLong(id));
			miDocumentChargesTO.getChargeSelectionInfo().setRevenueCode("RC");
			miDocumentChargesTO.getPaginationInfo().setNumberOfRows(1000);
			miDocumentChargesTO.getPaginationInfo().setPageNumber(1);
			miDocumentChargesTO.getPaginationInfo().setPageSize(1000);
			requestDCharges = DocumentChargesAdapter.beanToRequest(miDocumentChargesTO);
			responseDCharges = portCharge.getDocumentCharges(requestDCharges);
			miDocumentChargesSalidaTO = DocumentChargesAdapter.responseToBean(responseDCharges);

			
				

		} catch (Exception e) {

			logger.error(e.getMessage());
			throw e;
		}

		return miDocumentChargesSalidaTO;
	}

}
