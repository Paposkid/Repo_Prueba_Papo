package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ReglalceTO;



public interface ReglalceDAO {
	public void insertarReglalce(ReglalceTO reglalceTO)throws Exception ;	
	public void listarReglalceTO(Map<String, Object> reglalceTO)throws Exception ;

}
