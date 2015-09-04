package com.amx.service.adapter;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;

import org.apache.log4j.Logger;

import com.amx.schema.billinginquiry.getdocumentlist.BaIdInfo;
import com.amx.schema.billinginquiry.getdocumentlist.DateLimitInfo;
import com.amx.schema.billinginquiry.getdocumentlist.DocInfo;
import com.amx.schema.billinginquiry.getdocumentlist.GetDocumentListRequest;
import com.amx.schema.billinginquiry.getdocumentlist.GetDocumentListResponse;
import com.amx.schema.billinginquiry.getdocumentlist.PaginationInfo;
import com.amx.service.bean.DocInfoTO;
import com.amx.service.bean.DocumentListSalidaTO;
import com.amx.service.bean.DocumentListTO;
import com.amx.service.util.Util;


public class DocumentListAdapter {

	private static Logger logger = Logger.getLogger(DocumentListAdapter.class);

	public static GetDocumentListRequest beanToRequest(DocumentListTO documentList) throws Exception {

		GetDocumentListRequest documentListRequest = new GetDocumentListRequest();
		GregorianCalendar c = new GregorianCalendar();
		PaginationInfo pagi = new PaginationInfo();
		BaIdInfo baId = new BaIdInfo();
		
		if(documentListRequest.getDateLimitInfo() == null) {
			documentListRequest.setDateLimitInfo(new DateLimitInfo());
		}
		
		if(documentListRequest.getPaginationInfo() == null) {
			documentListRequest.setPaginationInfo(new PaginationInfo());
		}
		
		
		try {

			if (documentListRequest.getBaIdInfo()!=null) {
				documentListRequest.getBaIdInfo().setBaId(documentList.getBaIdInfo().getBaId());
			}else{
				documentListRequest.setBaIdInfo(baId);
				documentListRequest.getBaIdInfo().setBaId(documentList.getBaIdInfo().getBaId());
			}
			
			if (documentList.getDateLimitInfo().getFromDate() != null) {
				documentListRequest.getDateLimitInfo().setFromDate(Util.DateToXMLCalendar(documentList.getDateLimitInfo().getFromDate()));

			}
			else {
				documentList.getDateLimitInfo().setFromDate(Util.getPrimerDiaDelMes());
				c.setGregorianChange(documentList.getDateLimitInfo().getFromDate());
				documentListRequest.getDateLimitInfo().setFromDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
			}
			if (documentList.getDateLimitInfo().getToDate() != null) {
				documentListRequest.getDateLimitInfo().setToDate(Util.DateToXMLCalendar(documentList.getDateLimitInfo().getToDate()));
				
			}
			
			if (documentListRequest.getPaginationInfo()!=null) {
				documentListRequest.getPaginationInfo().setNumberOfRows(documentList.getPaginationInfo().getNumberOfRows());
				documentListRequest.getPaginationInfo().setPageNumber(documentList.getPaginationInfo().getPageNumber());
				documentListRequest.getPaginationInfo().setPageSize(documentList.getPaginationInfo().getPageSize());
			}else {
				documentListRequest.setPaginationInfo(pagi);
				documentListRequest.getPaginationInfo().setNumberOfRows(documentList.getPaginationInfo().getNumberOfRows());
				documentListRequest.getPaginationInfo().setPageNumber(documentList.getPaginationInfo().getPageNumber());
				documentListRequest.getPaginationInfo().setPageSize(documentList.getPaginationInfo().getPageSize());
			}
			

		} catch (Exception e) {

			logger.error(e.getMessage());
			throw e;
		}
		return documentListRequest;
	}

	public static DocumentListSalidaTO responseToBean(GetDocumentListResponse documentList) throws Exception {

		DocumentListSalidaTO documentListSalidaTO = new DocumentListSalidaTO();
		
		try {
			
					
			for (int i = 0; i < documentList.getDocInfo().size(); i++) {
				documentListSalidaTO.getDocInfo().add(responseToBean(documentList.getDocInfo().get(i)));

			}
			
			

		} catch (Exception e) {

			logger.error(e.getMessage());
			throw e;
		}

		return documentListSalidaTO;

	}

	public static DocInfoTO responseToBean (DocInfo docInfo) throws Exception {

		DocInfoTO miDocInfoTO = new DocInfoTO();

		try {

			miDocInfoTO.setBaNumber(docInfo.getBaNumber());
			miDocInfoTO.setAccountNumber(docInfo.getAccountNumber());
			miDocInfoTO.setDocumentId(docInfo.getDocumentId());
			
			
		} catch (Exception e) {

			logger.error(e.getMessage());
			throw e;
		}

		return miDocInfoTO;
	}

}
