package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.PlusGoldTO;


public interface PlusGoldDAO {
	
	public void insertarPlusGold(PlusGoldTO plusGoldTO)throws Exception ;	
	public void listarPlusGold(Map<String, Object> plusGoldTO)throws Exception ;

}
