package com.amx.service.business;

import com.amx.service.bean.EntFceTO;
import com.amx.service.bean.SalFceTO;

public interface PerformFullCreditEvaluationBusiness {
	
	public SalFceTO performFullCreditEvaluation (EntFceTO requestTO) throws Exception;
		
}
