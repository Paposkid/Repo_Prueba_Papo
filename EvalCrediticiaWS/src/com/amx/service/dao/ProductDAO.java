package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ProductTO;


public interface ProductDAO {

	public void ingresarProduct(ProductTO productTO) throws Exception ;
	public void buscarProduct(Map<String, Object> lista)throws Exception ;
	public void buscarProductByEFCE(Map<String, Object> lista)throws Exception ;
}
