package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.AccrinfoTO;



public interface AccrinfoBusiness {

	public void insertarAccrinfo(AccrinfoTO accrinfo)throws Exception;
	public List <AccrinfoTO>  buscarAccrinfo( Long corrAccrinfo)throws Exception;
}
