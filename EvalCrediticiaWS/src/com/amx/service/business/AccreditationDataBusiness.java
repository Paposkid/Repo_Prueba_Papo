package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.AccreditationDataTO;


public interface AccreditationDataBusiness{
public void insertarAccrdata(AccreditationDataTO accrdata)throws Exception;
public List <AccreditationDataTO>  buscarAccrdata( Long corrAccrdata)throws Exception;
}
