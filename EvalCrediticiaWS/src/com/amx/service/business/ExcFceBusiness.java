package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ExcFceTO;



public interface ExcFceBusiness {

	public void insertarExcFce (ExcFceTO excFceTO) throws Exception;
	public List<ExcFceTO> listExcFce (Long codExcFce, Long codFce) throws Exception;
}
