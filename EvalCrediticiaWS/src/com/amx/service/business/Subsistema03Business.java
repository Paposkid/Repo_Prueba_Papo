package com.amx.service.business;

import com.amx.service.bean.SubSistema03TO;


public interface Subsistema03Business {
	
	public void insertarSubsistema03(SubSistema03TO subSistema03) throws Exception;
	public SubSistema03TO buscarSubsistema03(long codigoSubsistema03) throws Exception;

}
