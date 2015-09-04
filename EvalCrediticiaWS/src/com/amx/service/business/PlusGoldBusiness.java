package com.amx.service.business;

import com.amx.service.bean.PlusGoldTO;




public interface PlusGoldBusiness {
	
	public void insertarPlusGold(PlusGoldTO plusGoldTO) throws Exception;
	public PlusGoldTO buscarPlusGold(String codigoPlusGold) throws Exception;
	public  PlusGoldTO  buscarPlusGoldbByRut(String rut) throws Exception;

}
