package com.amx.service.bean;

import java.util.ArrayList;


public class Ar7CreditEvaluationTO {
	
	private int customerNo;
	private ArrayList<String> l7MSISDN;
	
	public Ar7CreditEvaluationTO() {
		
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public ArrayList<String> getL7MSISDN() {
		if (l7MSISDN == null) {
            l7MSISDN = new ArrayList<String>();
        }
		return l7MSISDN;
	}

	public void setL7MSISDN(ArrayList<String> l7msisdn) {
		l7MSISDN = l7msisdn;
	}

	@Override
	public String toString() {
		return "Ar7CreditEvaluationTO [customerNo=" + customerNo
				+ ", l7MSISDN=" + l7MSISDN + "]";
	}
	 
	

}
