package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ContactInfoTO;


public interface ContactInfoDao {
	public void insertarContactInfo (ContactInfoTO contactInfoTO) throws Exception ;
	public void buscarContactInfo (Map<String, Object> mapContactInfoTO) throws Exception ;
}
