package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CondicionTO;



public interface CondicionBusiness {

	public void insertarCondiciones(CondicionTO condicionTO) throws Exception;

	public List<CondicionTO> buscarCondiciones(CondicionTO condicionTO) throws Exception;

	public void actualizarCondiciones(CondicionTO condicionTO) throws Exception;
}
