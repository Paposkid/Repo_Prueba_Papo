package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.CondicionTO;



public interface CondicionDAO {

	public void listarCondicion(Map<String, Object> condicionTO);

	public void insertarCondicion(CondicionTO condicionTO);

	public void actualizarCondicion(CondicionTO condicionTO);

}
