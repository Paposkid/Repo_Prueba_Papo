package com.amx.service.bean;

import java.util.ArrayList;


public class CustomerEntityListSalidaTO {

	private String customerId;
	private ArrayList<AccountBaIdsInfoSalidaTO> accountBaIdsList;
	
	public CustomerEntityListSalidaTO() {
		
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the accountBaIdsList
	 */
	public ArrayList<AccountBaIdsInfoSalidaTO> getAccountBaIdsList() {
		if (accountBaIdsList == null) {
            accountBaIdsList = new ArrayList<AccountBaIdsInfoSalidaTO>();
        }
		return accountBaIdsList;
	}

	/**
	 * @param accountBaIdsList the accountBaIdsList to set
	 */
	public void setAccountBaIdsList(ArrayList<AccountBaIdsInfoSalidaTO> accountBaIdsList) {
		this.accountBaIdsList = accountBaIdsList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerEntityListSalidaTO [customerId=" + customerId
				+ ", accountBaIdsList=" + accountBaIdsList + "]";
	}

	
	
	
}
