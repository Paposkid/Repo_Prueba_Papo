package com.amx.service.business;

import com.amx.service.bean.ADDRInfoDetTO;

public interface ADDRInfoDetailsBusiness {
	
	public void insertarADDRInfoDetails(ADDRInfoDetTO aDDRInfoDetailsTO)throws Exception ;
	public ADDRInfoDetTO consultarADDRInfoDetailsByCodigo(ADDRInfoDetTO aDDRInfoDetailsTO)throws Exception ;
}
