package com.amx.service.bean;

import java.util.ArrayList;


public class ContactListSalidaTO {
	
	private String contactId;
	private ArrayList<CustomerEntityListSalidaTO> cbpList;
	
	public ContactListSalidaTO() {
		
	}

	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the cbpList
	 */
	public ArrayList<CustomerEntityListSalidaTO> getCbpList() {
		if (cbpList == null) {
            cbpList = new ArrayList<CustomerEntityListSalidaTO>();
        }
		return cbpList;
	}

	/**
	 * @param cbpList the cbpList to set
	 */
	public void setCbpList(ArrayList<CustomerEntityListSalidaTO> cbpList) {
		this.cbpList = cbpList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactListSalidaTO [contactId=" + contactId + ", cbpList="
				+ cbpList + "]";
	}


	
	

}
