package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.DetallePreviredTO;


public interface DetallePreviredDAO {
	
	public void insertarDetallePrevired(DetallePreviredTO detallePreviredTO)throws Exception ;
	public void consultarDetallePreviredByCodigo(Map<String, Object> detallePreviredTO)throws Exception ;

}
