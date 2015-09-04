package com.amx.service.business;

import com.amx.service.bean.ReglaFCETO;


public interface ReglaFCEBusiness {
	
	public void insertarReglaFCE(ReglaFCETO reglaFCETO)throws Exception ;
	
	public ReglaFCETO consultarReglaFCEByCodigoRegla(ReglaFCETO reglaFCETO)throws Exception ;
	
	public ReglaFCETO consultarReglaFCEByCodigoFCE(ReglaFCETO reglaFCETO)throws Exception ;
}
