package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.CreditScoreTO;


public interface CreditScoreDao {
	public void insertarCreditScore (CreditScoreTO creditScoreTO)throws Exception ;
	public void buscarCreditScore (Map<String, Object> mapCreditScoreTO)throws Exception ;
}
