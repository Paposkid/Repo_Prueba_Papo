package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.DocExtraTO;


public interface DocExtraDAO{

	public void listarDocExtraById(Map<String, Object> docExtra)throws Exception ;
	public void listarDocExtraByNombre(Map<String, Object> docExtraNombre)throws Exception ;
	public void insertarDocExtra(DocExtraTO docExtraTO) throws Exception ;

}
