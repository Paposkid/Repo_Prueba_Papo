package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.AccrinfoTO;



public interface AccrinfoDAO {

	public void ingresarAccrinfo(AccrinfoTO accrinfoTo)throws Exception ;
	
	public void buscarAccrinfo(Map<String, Object> lista)throws Exception ;
	
}
