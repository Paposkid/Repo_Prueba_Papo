package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.RelDocumentExcFceTO;


public interface RelDocumentExcFceBusiness {

	public void insertarRelDocumentExcFce (RelDocumentExcFceTO relDocumentExcFceTO)throws Exception;
	public List<RelDocumentExcFceTO> listRelDocumentExcFce (Integer codFceDocument) throws Exception;
}
