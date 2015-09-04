package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DetSubsistema09TO;



public interface DetSubsistema09Business {
	public void insertarDetSubsistema09(DetSubsistema09TO detSubsistema09TO) throws Exception;
	public List<DetSubsistema09TO> buscarDetSubsistema09(long codigoDetSubsistema09) throws Exception;

}
