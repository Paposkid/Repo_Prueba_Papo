package com.amx.service.business;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceClient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.billinginquiry.getdocumentlist.GetDocumentList;
import com.amx.billinginquiry.getdocumentlist.GetDocumentListService;
import com.amx.charge.getdocumentcharges.GetDocumentCharges;
import com.amx.charge.getdocumentcharges.GetDocumentChargesService;
import com.amx.schema.billinginquiry.getdocumentlist.GetDocumentListRequest;
import com.amx.schema.billinginquiry.getdocumentlist.GetDocumentListResponse;
import com.amx.schema.charge.getdocumentcharges.GetDocumentChargesRequest;
import com.amx.schema.charge.getdocumentcharges.GetDocumentChargesResponse;
import com.amx.service.adapter.DocumentListAdapter;
import com.amx.service.bean.CustomerEntityListSalidaTO;
import com.amx.service.bean.DocInfoTO;
import com.amx.service.bean.DocumentChargesSalidaTO;
import com.amx.service.bean.DocumentChargesTO;
import com.amx.service.bean.DocumentListSalidaTO;
import com.amx.service.bean.DocumentListTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;
import com.amx.service.util.Util;


@Service
public class DocumentListBusinessImpl implements DocumentListBusiness {

	@Autowired
	private ResourcesBusiness resourcesBusiness;
	private static Logger logger = Logger.getLogger(DocumentListBusinessImpl.class);

	@Override
	public List<DocInfoTO> listaDocumentFacturados(String id) throws Exception {

		GetDocumentListRequest requestDList = new GetDocumentListRequest();
		GetDocumentListResponse responseDList = new GetDocumentListResponse();
		ResourcesTO resourcesTODList = new ResourcesTO();
		DocumentListSalidaTO miDocumentListSalidaTO = null;
		DocumentListTO miDocumentListTO = null;
		List<DocInfoTO> listDocumentosFacturados = new ArrayList<DocInfoTO>();
		

		try {

			resourcesTODList.setResourceName(Constantes.ENDPOINT_DOCUMENT_LIST);
			resourcesTODList = resourcesBusiness.searchResourcesByName(resourcesTODList);
			LoggerFacade.registerLog(Constantes.INFO_LLAMADO + "AMDOCS DOCUMENT LIST");

				WebServiceClient clienteWSDocuments = GetDocumentListService.class.getAnnotation(WebServiceClient.class);
				URL endPointDocuments = new URL(resourcesTODList.getValor());
				QName serviceNameList = new QName(clienteWSDocuments.targetNamespace(), clienteWSDocuments.name());
				GetDocumentListService webServiceList = new GetDocumentListService(endPointDocuments, serviceNameList);
				GetDocumentList portList = webServiceList.getGetDocumentListPort();
	
					miDocumentListTO = new DocumentListTO();
					miDocumentListTO.getBaIdInfo().setBaId(Long.parseLong(id));
					miDocumentListTO.getDateLimitInfo().setFromDate(Util.getPrimerDiaDelMes());
					miDocumentListTO.getDateLimitInfo().setToDate(Util.getUltimoDiaDelMes());
					miDocumentListTO.getPaginationInfo().setNumberOfRows(1000);
					miDocumentListTO.getPaginationInfo().setPageNumber(1);
					miDocumentListTO.getPaginationInfo().setPageSize(1000);
					requestDList = DocumentListAdapter.beanToRequest(miDocumentListTO);
					responseDList = portList.getDocumentList(requestDList);
					miDocumentListSalidaTO = DocumentListAdapter.responseToBean(responseDList);
		
					listDocumentosFacturados.addAll(miDocumentListSalidaTO.getDocInfo());

		} catch (Exception e) {

			logger.error(e.getMessage());
			throw e;
		}

		return listDocumentosFacturados;
	}

}
