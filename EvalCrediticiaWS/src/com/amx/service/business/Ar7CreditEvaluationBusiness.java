package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.Ar7CreditEvaluationSalidaTO;
import com.amx.service.bean.CustomerEntityListSalidaTO;


public interface Ar7CreditEvaluationBusiness {

	public Ar7CreditEvaluationSalidaTO consultaAr7 (List<CustomerEntityListSalidaTO> listCBP) throws Exception;
		
}
