package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CustomerEntityListSalidaTO;
import com.amx.service.bean.RetrieveLineStatisticsSalidaTO;



public interface RetrieveLineStatisticsBusiness {
	
	public Integer consultarEstadisticasDeLineas (List<CustomerEntityListSalidaTO> listCBP)throws Exception;

}
