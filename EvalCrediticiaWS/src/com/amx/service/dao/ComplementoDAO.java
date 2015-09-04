package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ComplementoTO;



public interface ComplementoDAO {

	public void listarComplemento(Map<String, Object> complementoTO);

	public void insertarComplemento(ComplementoTO complementoTO);

	public void actualizarComplemento(ComplementoTO complementoTO);
}
