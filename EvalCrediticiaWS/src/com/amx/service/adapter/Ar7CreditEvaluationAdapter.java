package com.amx.service.adapter;

import org.apache.log4j.Logger;


import com.amx.schema.creditevaluation.ar7creditevaluation.Ar7CreditEvaluationRequest;
import com.amx.schema.creditevaluation.ar7creditevaluation.Ar7CreditEvaluationResponse;
import com.amx.service.bean.Ar7CreditEvaluationSalidaTO;
import com.amx.service.bean.Ar7CreditEvaluationTO;


public class Ar7CreditEvaluationAdapter {
	
	private static Logger logger = Logger.getLogger(Ar7CreditEvaluationAdapter.class);
	
	public static Ar7CreditEvaluationRequest  beanToRequest (Ar7CreditEvaluationTO creditEvaluation) throws Exception{
		
		Ar7CreditEvaluationRequest ar7CreditEvaluationRequest = new Ar7CreditEvaluationRequest();
		
		try {
			
			ar7CreditEvaluationRequest.setCustomerNo(creditEvaluation.getCustomerNo());
			for (int i = 0; i < creditEvaluation.getL7MSISDN().size(); i++) {
			ar7CreditEvaluationRequest.getL7MSISDN().add(creditEvaluation.getL7MSISDN().get(i));
			
			}
			
									
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
				
		return ar7CreditEvaluationRequest;
	}
	
	public static Ar7CreditEvaluationSalidaTO responseToBean (Ar7CreditEvaluationResponse creditEvaluation) throws Exception{
				
		Ar7CreditEvaluationSalidaTO ar7CreditEvaluationSalidaTO = new Ar7CreditEvaluationSalidaTO();
		try {
			
			ar7CreditEvaluationSalidaTO.setAccountBalance(creditEvaluation.getAccountBalance());
			ar7CreditEvaluationSalidaTO.setAmountDue(creditEvaluation.getAmountDue());
			ar7CreditEvaluationSalidaTO.setAr7CustPymBeh(creditEvaluation.getL7PaymentBehavior());
			ar7CreditEvaluationSalidaTO.setBucketNumber(creditEvaluation.getBucketNumber());
			ar7CreditEvaluationSalidaTO.setL7AccountId(creditEvaluation.getL7AccountId());
			ar7CreditEvaluationSalidaTO.setL7DebtAge(creditEvaluation.getL7DebtAge());
			ar7CreditEvaluationSalidaTO.setL7Msisdn(creditEvaluation.getAr7CustPymBeh());
			ar7CreditEvaluationSalidaTO.setL7Nunca(creditEvaluation.getL7Nunca());
			ar7CreditEvaluationSalidaTO.setL7PaymentBehavior(creditEvaluation.getL7PaymentBehavior());
			ar7CreditEvaluationSalidaTO.setL7SubSeniority(creditEvaluation.getL7SubSeniority());
			ar7CreditEvaluationSalidaTO.setL7VIP(creditEvaluation.getL7VIP());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
			}	
		
		return ar7CreditEvaluationSalidaTO;
	}

}
