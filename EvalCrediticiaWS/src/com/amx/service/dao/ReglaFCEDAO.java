package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ReglaFCETO;



public interface ReglaFCEDAO {
	
	public void insertarReglaFCE(ReglaFCETO reglaFCETO)throws Exception ;
	public void consultarReglaFCEByCodigoRegla(Map<String, Object> reglaFCETO)throws Exception ;
	public void consultarReglaFCEByCodigoFCE(Map<String, Object> reglaFCETO)throws Exception ;
}
