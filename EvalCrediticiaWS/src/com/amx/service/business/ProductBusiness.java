package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ProductTO;


public interface ProductBusiness {
	public void insertarProduct(ProductTO productTO) throws Exception;
	public ProductTO buscarProduct (long codProduct )throws Exception;
	public List<ProductTO> buscarProductByEFCE (long codProductEFCE )throws Exception;
}
