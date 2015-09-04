package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ExcLceTO;




public interface ExcLceBusiness {

	public void insertarExcLce (ExcLceTO excLceTO) throws Exception;
	public List<ExcLceTO> listExcLce (Long codExcFce, Long codFce) throws Exception;
}
