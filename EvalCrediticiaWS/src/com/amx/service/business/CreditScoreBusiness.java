package com.amx.service.business;

import com.amx.service.bean.CreditScoreTO;

public interface CreditScoreBusiness {
	public void insertarCreditScore(CreditScoreTO creditScoreTO) throws Exception;
	public CreditScoreTO buscarCreditScore (String codCreditScore )throws Exception;

}
