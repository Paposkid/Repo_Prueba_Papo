package com.amx.service.business;

import com.amx.service.bean.SubSistema02TO;

public interface Subsistema02Business {
	
	public void insertarSubSys2 (SubSistema02TO subSistemaBean2)throws Exception;
	public SubSistema02TO searchListSys2(Long serialVersion2) throws Exception;

}
