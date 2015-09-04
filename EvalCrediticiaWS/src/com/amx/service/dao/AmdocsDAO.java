package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.AmdocsTO;




public interface AmdocsDAO {

	public void insertarAmdocs(AmdocsTO amdocsTO)throws Exception ;
	public void listAmdocs(Map<String, Object> amdocsBean) throws Exception ;
	
}
