package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.OrderactionTO;


public interface OrderactionDAO {

	public void ingresarOrder(OrderactionTO orderTo)throws Exception ;
	
	public void buscarOrder(Map<String, Object> lista)throws Exception ;
}
