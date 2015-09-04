package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ChargesinfoTO;




public interface ChargesinfoBusiness {
	public void insertarChargesinfo(ChargesinfoTO chargesinfoTO) throws Exception;
	public List<ChargesinfoTO> listarChargesinfo(String codigoChargesinfo) throws Exception;
}
