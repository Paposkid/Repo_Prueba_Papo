package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.FCEDocExtraTO;


public interface FCEDocExtraDAO {

	public void listarFCEDocExtraById(Map<String, Object> fCEDocExtraTO)throws Exception ;
	public void insertarFCEDocExtra(FCEDocExtraTO fCEDocExtraTO) throws Exception ;
	
}
