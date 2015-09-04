package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DocumentFCETO;


public interface DocumentFCEBusiness {
	
	public void insertarDocumentFCE(DocumentFCETO documentFCETO)throws Exception;
	public List<DocumentFCETO>buscarDocumentFCE(String codigo) throws Exception;
}
