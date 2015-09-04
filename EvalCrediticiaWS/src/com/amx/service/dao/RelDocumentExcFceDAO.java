package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.RelDocumentExcFceTO;



public interface RelDocumentExcFceDAO {

	public void insertarRelDocumentExcFce(RelDocumentExcFceTO relDocumentExcFceTO)throws Exception ;
	public void listRelDocumentExcFce(Map<String, Object> relDocumentExcFceBean) throws Exception ;
}
