package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.BancoTO;



public interface BancoBusiness {
	public void insertarBanco(BancoTO bancoTO) throws Exception;
	public List<BancoTO> buscarBanco(long codigoE) throws Exception;

}
