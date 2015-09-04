package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.EquifaxDetalleTO;


public interface EquifaxDetalleDAO {
	public void insertarDetalleEquifax(EquifaxDetalleTO equifaxDetalleTO)throws Exception ;	
	public void listarDetalleEquifax(Map<String, Object> equifaxDetalleTO)throws Exception ;
	public void listarDetalleEquifaxByRut(Map<String, Object> equifaxDetalleTO)throws Exception ;

}
