package com.amx.service.business;


import com.amx.service.bean.EquifaxTO;


public interface EquifaxBusiness {
	
	public void insertarEquifax(EquifaxTO equifaxTO) throws Exception;
	public EquifaxTO buscarEquifax(String codigoEquifax) throws Exception;
	public EquifaxTO buscarEquifaxByRut(String rutCliente) throws Exception;
	EquifaxTO ConsultarEquifax(String rutCliente) throws Exception;

}
