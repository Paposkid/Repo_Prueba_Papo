package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ReglaTO;



public interface ReglaDAO {

	public void listarRegla(Map<String, Object> reglaTO);

	public void insertarRegla(ReglaTO reglaTO);

	public void actualizarRegla(ReglaTO reglaTO);
	
	public void listarReglaAEvaluar(Map<String, Object> reglaTO);
	
}
