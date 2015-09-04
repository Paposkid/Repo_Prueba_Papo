package com.amx.service.business;

import com.amx.service.bean.AmdocsResTO;

public interface AmdocsResBusiness {
	
	public void insertarAmdocsRes(AmdocsResTO amdocsResTO) throws Exception;	
	public AmdocsResTO searchListAmdocsRes(String rut)throws Exception;

}
