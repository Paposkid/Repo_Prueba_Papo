package com.amx.service.dao;



import java.util.Map;

import com.amx.service.bean.AmdocsResTO;



public interface AmdocsResDAO {
	
	public void insertarAmdocsRes (AmdocsResTO amdocsResTO)throws Exception ;
	public void listAmdocsRes (Map<String, Object> amdocsResTO) throws Exception ;

}
