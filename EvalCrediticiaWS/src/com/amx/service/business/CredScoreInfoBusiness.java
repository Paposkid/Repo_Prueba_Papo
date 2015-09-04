package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CredScoreInfoTO;


public interface CredScoreInfoBusiness {
	
	public void insertarCredScoreInfo(CredScoreInfoTO credScoreInfoTO)throws Exception ;
	public List<CredScoreInfoTO> consultarCredScoreInfoByCodigo(CredScoreInfoTO credScoreInfoTO)throws Exception ;
	public CredScoreInfoTO consultarCredScoreInfoByOrder(String orderID)throws Exception ;
}
