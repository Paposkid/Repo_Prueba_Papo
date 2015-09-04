package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.CredScoreInfoTO;





public interface CredScoreInfoDAO {
	
	public void insertarCredScoreInfo(CredScoreInfoTO credScoreInfoTO)throws Exception ;
	public void consultarCredScoreInfoByCodigo(Map<String, Object> credScoreInfoTO)throws Exception ;
	public void consultarCredScoreInfoByOrder(Map<String, Object> credScoreInfoTO)throws Exception ;
}
