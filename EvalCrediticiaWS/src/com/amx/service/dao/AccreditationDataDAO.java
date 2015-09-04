package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.AccreditationDataTO;




public interface AccreditationDataDAO {

	public void ingresarAccrData(AccreditationDataTO accrdata) throws Exception ;
	
	public void buscarAccrData(Map<String, Object> accrdata)throws Exception ;
}
