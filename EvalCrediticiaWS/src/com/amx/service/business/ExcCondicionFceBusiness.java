package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ExcCondicionFceTO;



public interface ExcCondicionFceBusiness {

	public void insertarExcCondicionFce (ExcCondicionFceTO excCondicionFceTO) throws Exception;
	public List<ExcCondicionFceTO> listExcCondicionFce (Integer codCondicionFce) throws Exception;
}
