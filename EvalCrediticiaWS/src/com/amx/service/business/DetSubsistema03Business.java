package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DetSubsistema03TO;





public interface DetSubsistema03Business {
	
	public void insertarDetSubsistema03(DetSubsistema03TO detSubsistema03) throws Exception;
	public List<DetSubsistema03TO> buscarDetSubsistema03(long codigoDetSubsistema03) throws Exception;

}
