package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.ExcLceTO;




public interface ExcLceDAO {

	public void insertarExcLce(ExcLceTO excLceTO)throws Exception ;
	public void listExcLce(Map<String, Object> excLceBean) throws Exception ;
}
