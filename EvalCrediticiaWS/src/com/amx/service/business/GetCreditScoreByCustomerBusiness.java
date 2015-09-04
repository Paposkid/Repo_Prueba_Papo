package com.amx.service.business;

import com.amx.service.bean.EntLceTO;
import com.amx.service.bean.SalLceTO;

public interface GetCreditScoreByCustomerBusiness {

	SalLceTO getCreditScoreByCustomer(EntLceTO requestTo) throws Exception;

}
