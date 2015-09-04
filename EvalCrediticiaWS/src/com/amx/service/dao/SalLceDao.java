package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.SalLceTO;


public interface SalLceDao {
	public void insertarLce (SalLceTO salLceTO);
	public void buscarLce (Map<String, Object> mapLceTO);
	public void buscarLceCredApro (Map<String, Object> mapLceTO);
}
