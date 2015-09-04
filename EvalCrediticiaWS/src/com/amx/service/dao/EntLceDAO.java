package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.EntLceTO;


public interface EntLceDAO {

	public void ingresarLce(EntLceTO entlceTo) throws Exception ;

	public void buscarLce(Map<String, Object> lista) throws Exception ;

	public void buscarLceCredApprovalid(Map<String, Object> lista)throws Exception ;
}
