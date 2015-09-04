package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.SubSistema00TO;



public interface SubSistema0DAO {
	
	public void insetarSubSistema0 (SubSistema00TO subSistemaOBean)throws Exception ;
	public void listSubSys0 (Map<String, Object> subSistemaOBean)throws Exception ;
	public void listSubSys0ByRut (Map<String, Object> subSistemaOBean)throws Exception ;

}
