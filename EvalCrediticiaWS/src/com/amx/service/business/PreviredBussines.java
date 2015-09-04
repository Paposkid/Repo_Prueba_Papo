package com.amx.service.business;

import com.amx.service.bean.PreviredTO;


public interface PreviredBussines {

	public void insertarPrevired(PreviredTO previredTO)throws Exception ;
	
	public PreviredTO consultarPreviredByCodigo(PreviredTO previredTO)throws Exception ;
	
	public PreviredTO consultarPreviredByRut(PreviredTO previredTO)throws Exception ;

	PreviredTO consultarPrevired(String rutCLiente) throws Exception;
	
}
