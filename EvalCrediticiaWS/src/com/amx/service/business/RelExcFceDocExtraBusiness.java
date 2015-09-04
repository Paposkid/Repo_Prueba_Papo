package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.RelExcFceDocExtraTO;


public interface RelExcFceDocExtraBusiness {

	public void insertarRelExcFceDocExtra(RelExcFceDocExtraTO relExcFceDocExtraTO)throws Exception;
	public List<RelExcFceDocExtraTO> listRelExcFceDocExtra (Integer codExcFceDocExtra) throws Exception;
}
