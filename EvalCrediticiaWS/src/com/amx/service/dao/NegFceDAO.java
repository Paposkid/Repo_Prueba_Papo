package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.NegFceTO;


public interface NegFceDAO {

	public void insertarNegFce(NegFceTO negFceTO)throws Exception ;
	public void listNegFce(Map<String, Object> negFceBean) throws Exception ;
	public void actualizarEstadoNegFce(NegFceTO negFceBean)throws Exception ;
	public void listNegFCEByCodLCE(Map<String, Object> negFceBean) throws Exception ;
}
