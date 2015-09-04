package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.AffiinformationTO;



public interface AffiinformationDAO {

	public void ingresarAffiinformation(AffiinformationTO affiInformation)throws Exception  ;
	public void buscarAffiinformation(Map<String, Object> form)throws Exception  ;
	public void buscarAffiinformationAfiliate (Map<String, Object> form)throws Exception  ;
}
