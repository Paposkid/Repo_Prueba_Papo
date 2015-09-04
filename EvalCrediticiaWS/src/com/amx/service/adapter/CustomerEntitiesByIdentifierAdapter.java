package com.amx.service.adapter;

import java.util.ArrayList;


import org.apache.log4j.Logger;

import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.AccountBaIdsInfo;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.ContactList;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.CustomerEntityList;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.GetCustomerEntitiesByIdentifierRequest;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.GetCustomerEntitiesByIdentifierResponse;
import com.amx.schema.billinginquiry.getcustomerentitiesbyidentifier.OrgEntityList;
import com.amx.service.bean.AccountBaIdsInfoSalidaTO;
import com.amx.service.bean.ContactListSalidaTO;
import com.amx.service.bean.CustomerEntitiesByIdentifierSalidaTO;
import com.amx.service.bean.CustomerEntitiesByIdentifierTO;
import com.amx.service.bean.CustomerEntityListSalidaTO;


public class CustomerEntitiesByIdentifierAdapter {
	
	private static Logger logger = Logger.getLogger(CustomerEntitiesByIdentifierAdapter.class);
	
	public static GetCustomerEntitiesByIdentifierRequest  beanToRequest (CustomerEntitiesByIdentifierTO customerEntities) throws Exception{
		
		GetCustomerEntitiesByIdentifierRequest customerEntitiesByIdentifierRequest = new GetCustomerEntitiesByIdentifierRequest();
		
		
		try {
		
		
		customerEntitiesByIdentifierRequest.setIdentifierNumber(customerEntities.getIdentifierNumber());
		customerEntitiesByIdentifierRequest.setIdentifierType(customerEntities.getIdentifierType());
		
		
		} catch (Exception e) {
			
			logger.error(e.getMessage());
			throw e;
		}
		
		return customerEntitiesByIdentifierRequest;
		
	}
	
	public static CustomerEntitiesByIdentifierSalidaTO  responseToBean (GetCustomerEntitiesByIdentifierResponse customerEntities) throws Exception{
		
		CustomerEntitiesByIdentifierSalidaTO customerEntitiesByIdentifierSalidaTO = new CustomerEntitiesByIdentifierSalidaTO();
		
		ArrayList<ContactListSalidaTO> lstContactListSalidaTO = new ArrayList<ContactListSalidaTO>();
		ArrayList<CustomerEntityListSalidaTO> lstCustomerEntityListSalidaTO = null;
		ArrayList<AccountBaIdsInfoSalidaTO> lstAccountBaIdsInfoSalidaTO = null;
		

		ContactListSalidaTO lContactListSalidaTO = null;
		CustomerEntityListSalidaTO  lCustomerEntityListSalidaTO = null;
		AccountBaIdsInfoSalidaTO lAccountBaIdsInfoSalidaTO = null;
		
		
		
		try {
					customerEntitiesByIdentifierSalidaTO.getContactList();
					customerEntities.getContactList();
					
					for (ContactList contactList : customerEntities.getContactList()) {
							
								lstCustomerEntityListSalidaTO = new ArrayList<CustomerEntityListSalidaTO>(); 
								lContactListSalidaTO = new ContactListSalidaTO();
								lContactListSalidaTO.setContactId(contactList.getContactId());
	
								
								for (CustomerEntityList customerEntityList : contactList.getCBPList()) {
									
											lstAccountBaIdsInfoSalidaTO = new ArrayList<AccountBaIdsInfoSalidaTO>();
										    lCustomerEntityListSalidaTO = new CustomerEntityListSalidaTO();
										    lCustomerEntityListSalidaTO.setCustomerId(customerEntityList.getCustomerId());
											
											
											for (AccountBaIdsInfo accountBaIdInfo : customerEntityList.getAccountBaIdsList()) {
												
												 lAccountBaIdsInfoSalidaTO = new AccountBaIdsInfoSalidaTO();
												 lAccountBaIdsInfoSalidaTO.setFaBarId(accountBaIdInfo.getFaBarId());
												 lstAccountBaIdsInfoSalidaTO.add(lAccountBaIdsInfoSalidaTO);
												
											}
											
											
											lCustomerEntityListSalidaTO.setAccountBaIdsList(lstAccountBaIdsInfoSalidaTO);
											lstCustomerEntityListSalidaTO.add(lCustomerEntityListSalidaTO);
								  }
								
									lContactListSalidaTO.setCbpList(lstCustomerEntityListSalidaTO);
									lstContactListSalidaTO.add(lContactListSalidaTO);
						  }
					
					
					customerEntitiesByIdentifierSalidaTO.setContactList(lstContactListSalidaTO);
					customerEntitiesByIdentifierSalidaTO.setHasMoreEntities(customerEntities.isHasMoreEntities());
					customerEntitiesByIdentifierSalidaTO.setOrganizationList((ArrayList<OrgEntityList>) customerEntities.getOrganizationList());
					
	
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return customerEntitiesByIdentifierSalidaTO;
	}

}
