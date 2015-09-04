package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.ExcCondicionFceTO;


public interface ExcCondicionFceDAO {

	public void insertarExcCondicionFce (ExcCondicionFceTO excCondicionFceTO)throws Exception ;
	public void listExcCondicionFce (Map<String, Object> excCondicionFceBean) throws Exception ;
}
