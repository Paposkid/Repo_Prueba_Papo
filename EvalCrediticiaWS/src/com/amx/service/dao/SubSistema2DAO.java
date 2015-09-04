package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.SubSistema02TO;




public interface SubSistema2DAO {
	
	public void insetarSubSistema2 (SubSistema02TO subSistema02TO)throws Exception ;
	public void listSubSys2 (Map<String, Object> subSistema2Bean)throws Exception ;

}
