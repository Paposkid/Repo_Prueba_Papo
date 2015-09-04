package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.NlineSallopGaptTO;


public interface NlineSallopGaptDao {
	public void insertarNlineSallopGapt (NlineSallopGaptTO nlineSallopGaptTO)throws Exception ;
	public void listarNlineSallopGapt(Map<String, Object> nlineSallopGaptTO)throws Exception ;
}
