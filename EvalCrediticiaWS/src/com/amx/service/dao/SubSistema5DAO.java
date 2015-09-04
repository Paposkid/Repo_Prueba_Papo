package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.SubSistema05TO;

public interface SubSistema5DAO {
	
	public void insetarSubSistema5 (SubSistema05TO subSistema05TO)throws Exception ;
	public void listSubSys5 (Map<String, Object> subSistema5Bean)throws Exception ;

}
