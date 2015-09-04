package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.EquifaxTO;


    public interface EquifaxDAO {
    
	public void insertarEquifax(EquifaxTO equifaxTO)throws Exception ;	
	public void listarEquifax(Map<String, Object> equifaxTO)throws Exception ;
	
}
