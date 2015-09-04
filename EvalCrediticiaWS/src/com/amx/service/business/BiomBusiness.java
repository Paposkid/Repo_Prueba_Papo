package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.BiomTO;


public interface BiomBusiness {

	public void insertarBiometric (BiomTO biom)throws Exception;
	public List<BiomTO> searchListBio (Long corrBiom )throws Exception;
}
