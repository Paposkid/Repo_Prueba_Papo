package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.RelExcFceDocExtraTO;



public interface RelExcFceDocExtraDAO {

	public void insertarRelExcFceDocExtra(RelExcFceDocExtraTO relExcFceDocExtraTO)throws Exception ;
	public void listRelExcFceDocExtra (Map<String, Object> relExcFceDocExtraBean) throws Exception ;
}
