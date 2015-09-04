package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.SubSistema00TO;


public interface Subsistema00Business {
	public void insertarSubSys0 (SubSistema00TO subSistemaBean0)throws Exception;
	public SubSistema00TO searchListSys0(Long serialVersion) throws Exception;
	public List<SubSistema00TO> listSubSys0ByRut(String rutEval) throws Exception;
	

}
