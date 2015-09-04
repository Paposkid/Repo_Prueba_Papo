package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.ConditionFCETO;

public interface ConditionFCEDAO {
	public void listarConditionFCEById(Map<String, Object>conditionFCETO)throws Exception ;
	public void insertarConditionFCE(ConditionFCETO conditionFCETO) throws Exception ;
}
