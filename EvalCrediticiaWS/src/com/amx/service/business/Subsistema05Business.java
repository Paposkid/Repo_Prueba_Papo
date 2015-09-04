package com.amx.service.business;

import com.amx.service.bean.SubSistema05TO;

public interface Subsistema05Business {
	
	public void insertarSubSys5(SubSistema05TO subSistemaBean5)throws Exception;
	public SubSistema05TO searchListSys5(Long serialVersion5) throws Exception;

}
