package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.AccrdocumentTO;



public interface AccrdocumentDAO {

	public void ingresarDocument(AccrdocumentTO accrdocument)throws Exception ;
	
	public void buscarDocument(Map<String, Object> lista)throws Exception ;
	
}
