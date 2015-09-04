package com.amx.service.business;

import com.amx.service.bean.SubSistema06TO;


public interface Subsistema06Business {
	
	public void insertarSubsistema06(SubSistema06TO equifaxTO) throws Exception;
	public SubSistema06TO buscarSubsistema06(long codigoSubsistema06) throws Exception;

}
