package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.FCEDocExtraTO;


public interface FCEDocExtraBusiness {

	public void insertarFCEDocExtra(FCEDocExtraTO fCEDocExtraTO)throws Exception;
	public List<FCEDocExtraTO>buscarFCEDocExtra(String codigo) throws Exception;
	
}
