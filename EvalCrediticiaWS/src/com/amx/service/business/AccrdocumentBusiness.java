package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.AccrdocumentTO;



public interface AccrdocumentBusiness {
	public void insertarAccrdocument(AccrdocumentTO accrdocumentTO)throws Exception;
	public List <AccrdocumentTO>  buscarAccrdocument(Long corrAccrdocument)throws Exception;
}
