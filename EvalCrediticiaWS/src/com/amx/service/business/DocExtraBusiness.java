package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DocExtraTO;


public interface DocExtraBusiness {
	public void insertarDocExtra(DocExtraTO docExtraTO)throws Exception;
	public List<DocExtraTO>buscarDocExtra(String codigo) throws Exception;
	public List<DocExtraTO>buscarDocExtraByNombre(String nombre) throws Exception;
}
