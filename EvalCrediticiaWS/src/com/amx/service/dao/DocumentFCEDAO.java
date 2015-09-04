package com.amx.service.dao;

import java.util.List;
import java.util.Map;

import com.amx.service.bean.DocumentFCETO;



public interface DocumentFCEDAO {
	
	
public List<DocumentFCETO> listarDocumentFCEById(Map<String, Object> documentFCETO)	throws Exception ;
public void insertarDocumentFCE(DocumentFCETO documentFCETO) throws Exception ;
	
}
