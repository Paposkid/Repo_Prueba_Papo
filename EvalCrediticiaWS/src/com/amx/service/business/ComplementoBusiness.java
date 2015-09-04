package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ComplementoTO;




public interface ComplementoBusiness {

	public void insertarComplemento(ComplementoTO complementoTO) throws Exception;

	public List<ComplementoTO> buscarComplemento(ComplementoTO complementoTO) throws Exception;

	public void actualizarComplemento(ComplementoTO complementoTO) throws Exception;
}
