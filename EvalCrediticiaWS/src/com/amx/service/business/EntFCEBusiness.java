package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.EntFceTO;


public interface EntFCEBusiness {

	public void insertarEntFCE (EntFceTO entFceTO )throws Exception;
	public List<EntFceTO> searchListEntFCE (Long corrFCE) throws Exception;
	public List<EntFceTO> searchListEntFCEAproId (String credApproValidInput) throws Exception;
}
