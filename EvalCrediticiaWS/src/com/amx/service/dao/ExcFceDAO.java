package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.ExcFceTO;



public interface ExcFceDAO {

	public void insertarExcFce(ExcFceTO excFceTO)throws Exception ;
	public void listExcFce(Map<String, Object> excFceBean) throws Exception ;
}
