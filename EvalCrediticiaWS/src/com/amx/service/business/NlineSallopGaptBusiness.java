package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.NlineSallopGaptTO;



public interface NlineSallopGaptBusiness {
	public void insertarNlineSallopGapt(NlineSallopGaptTO nlineSallopGaptTO) throws Exception;
	public List<NlineSallopGaptTO> buscarNlineSallopGapt (Long corrSallce )throws Exception;
}
