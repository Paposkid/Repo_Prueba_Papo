package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.SubSistema01TO;



public interface SubSistema1DAO {

	public void insetarSubSistema1 (SubSistema01TO subSistema01TO)throws Exception ;
	public void listSubSys1 (Map<String, Object> subSistema1Bean)throws Exception ;
}
