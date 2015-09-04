package com.amx.service.bean;

import java.util.ArrayList;


import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.OrgEntityList;

public class CustomerEntitiesByIdentifierSalidaTO {
	
	private ArrayList<ContactListSalidaTO> contactList;
	private boolean hasMoreEntities;
	private ArrayList<OrgEntityList> organizationList;
	
	public CustomerEntitiesByIdentifierSalidaTO() {
		
	}
	
	public ArrayList<ContactListSalidaTO> getContactList() {
		if (contactList == null) {
            contactList = new ArrayList<ContactListSalidaTO>();
        }
		return contactList;
	}
	
	public void setContactList(ArrayList<ContactListSalidaTO> contactList) {
		this.contactList = contactList;
	}
	
	public boolean isHasMoreEntities() {
		return hasMoreEntities;
	}
	
	public void setHasMoreEntities(boolean hasMoreEntities) {
		this.hasMoreEntities = hasMoreEntities;
	}
	
	public ArrayList<OrgEntityList> getOrganizationList() {
		if (organizationList == null) {
            organizationList = new ArrayList<OrgEntityList>();
        }
		return organizationList;
	}
	
	public void setOrganizationList(ArrayList<OrgEntityList> organizationList) {
		this.organizationList = organizationList;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerEntitiesByIdentifierSalidaTO [contactList="
				+ contactList + ", hasMoreEntities=" + hasMoreEntities
				+ ", organizationList=" + organizationList + "]";
	}
	

	
	

}
