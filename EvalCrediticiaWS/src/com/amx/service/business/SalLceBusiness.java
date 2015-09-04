package com.amx.service.business;

import com.amx.service.bean.SalLceTO;

public interface SalLceBusiness {
	public void insertarLce(SalLceTO salLceTO) throws Exception;
	public SalLceTO buscarSalLce (Integer codSalLce )throws Exception;
	public SalLceTO buscarSalLceCredAproId (String credAprovalId )throws Exception;
	public  SalLceTO buscarSalLceOrderId (String orderId) throws Exception;
	
}
