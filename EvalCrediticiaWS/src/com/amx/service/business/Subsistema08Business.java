package com.amx.service.business;

import com.amx.service.bean.SubSistema08TO;

public interface Subsistema08Business {
	
	public void insertarSubSys8 (SubSistema08TO subSistemaBean8)throws Exception;
	public SubSistema08TO searchListSys8(Long serialVersion8) throws Exception;

}
