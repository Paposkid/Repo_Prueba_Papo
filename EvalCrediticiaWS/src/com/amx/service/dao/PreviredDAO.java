package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.PreviredTO;


public interface PreviredDAO {
	
	public void insertarPrevired(PreviredTO previredTO)throws Exception ;
	public void consultarPreviredByCodigo(Map<String, Object> previredTO)throws Exception ;
	public void consultarPreviredByRut(Map<String, Object> previredTO)throws Exception ;
	

	
}
