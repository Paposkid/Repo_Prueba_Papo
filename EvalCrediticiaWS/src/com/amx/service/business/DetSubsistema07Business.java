package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DetSubsistema07TO;



public interface DetSubsistema07Business {
	public void insertarDetSubsistema07(DetSubsistema07TO detSubsistema07TO) throws Exception;
	public List<DetSubsistema07TO> buscarDetSubsistema07(String codigoDetSubsistema07) throws Exception;

}
