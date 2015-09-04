package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.SalFceTO;


public interface SalFceBusiness {

	public void insertarFCE(SalFceTO SalFceTO)throws Exception;
	public SalFceTO buscarFCE(long codigo) throws Exception;
	public List<SalFceTO>buscarFCEAproIdOut(String aprobacionCred) throws Exception;
	public void actualizarSalFCEOnlyLineas(SalFceTO salFceTO) throws Exception;
}
