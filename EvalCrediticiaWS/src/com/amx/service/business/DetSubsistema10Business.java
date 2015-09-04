package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DetSubsistema10TO;



public interface DetSubsistema10Business {
	public void insertarDetSubsistema10(DetSubsistema10TO detSubsistema10) throws Exception;
	public List<DetSubsistema10TO> buscarDetSubsistema10(long codigoDetSubsistema10) throws Exception;


}
