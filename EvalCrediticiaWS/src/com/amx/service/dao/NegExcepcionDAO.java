package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.NegExcepcionTO;


public interface NegExcepcionDAO {

	public void insertarNegExcepcion (NegExcepcionTO negExcepcionTO)throws Exception ;
	public void listNegExcepcion (Map<String, Object> negExcepcionTO) throws Exception ;
	public void actualizarEstadoNegExcepcion (NegExcepcionTO negExcepcionTO)throws Exception ;
}
