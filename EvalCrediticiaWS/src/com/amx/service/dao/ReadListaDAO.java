package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ReadListaTypeTO;



public interface ReadListaDAO {
	
	public void insertarSpecialList(ReadListaTypeTO readListaTypeTO)throws Exception ;
	public void buscarListSpecial(Map<String, Object> readListaTypeTO)throws Exception ;
	
}
