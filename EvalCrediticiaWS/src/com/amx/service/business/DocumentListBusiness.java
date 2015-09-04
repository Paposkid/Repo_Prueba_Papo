package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DocInfoTO;




public interface DocumentListBusiness {

	public List<DocInfoTO> listaDocumentFacturados (String id) throws Exception;
}
