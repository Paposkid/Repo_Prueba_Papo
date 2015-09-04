package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.BiomTO;





public interface BiomDAO {

	public void ingresarBiom(BiomTO biomTo)throws Exception  ;
	
	public void buscarBiom(Map<String, Object> lista)throws Exception  ;
	
}
