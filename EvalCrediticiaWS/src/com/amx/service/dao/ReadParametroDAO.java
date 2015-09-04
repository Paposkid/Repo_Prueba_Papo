package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ReadParametroTypeTO;



public interface ReadParametroDAO {
	
	public void insertarParametro(ReadParametroTypeTO readParametroTypeTO)throws Exception ;
	public void buscarParametro(Map<String, Object> readParametroTypeTO)throws Exception ;
}
