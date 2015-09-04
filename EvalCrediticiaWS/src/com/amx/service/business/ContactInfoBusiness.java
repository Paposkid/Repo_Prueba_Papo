package com.amx.service.business;

import com.amx.service.bean.ContactInfoTO;


public interface ContactInfoBusiness {
	public void insertarContactInfo(ContactInfoTO contactInfoTO) throws Exception;
	public ContactInfoTO buscarContactInfo (String codContactInfo )throws Exception;
}
