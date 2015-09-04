package com.amx.service.business;
import java.util.List;

import com.amx.service.bean.ConditionFCETO;



public interface ConditionFCEBusiness {
	public void insertarConditionFCE(ConditionFCETO conditionFCETO)throws Exception;
	public List<ConditionFCETO>buscarConditionFCE(long codigo) throws Exception;
}
