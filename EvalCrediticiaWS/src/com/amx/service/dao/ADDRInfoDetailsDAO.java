package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ADDRInfoDetTO;



public interface ADDRInfoDetailsDAO {
	
	public void insertarADDRInfoDetails(ADDRInfoDetTO aDDRInfoDetailsTO)throws Exception ;
	public void consultarADDRInfoDetailsByCodigo(Map<String, Object> aDDRInfoDetailsTO)throws Exception ;
}
