package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.EntFceTO;


public interface EntFceDAO {

	void ingresarFce(EntFceTO fceTo) throws Exception  ;
	void buscarFce(Map<String, Object> listaFce) throws Exception  ;
	void buscarFceXAprovalId(Map<String, Object> listaFceXAprovalId) throws Exception  ;
}
