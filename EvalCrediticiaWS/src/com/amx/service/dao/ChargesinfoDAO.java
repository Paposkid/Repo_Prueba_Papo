package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.ChargesinfoTO;



public interface ChargesinfoDAO {
	public void insertarChargesinfo(ChargesinfoTO chargesinfoTO) throws Exception ;
	public void listarChargesinfo(Map<String, Object> chargesinfoTO) throws Exception ;

}
