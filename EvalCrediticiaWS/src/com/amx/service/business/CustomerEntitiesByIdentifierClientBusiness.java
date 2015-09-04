package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CustomerEntitiesByIdentifierTO;
import com.amx.service.bean.CustomerEntityListSalidaTO;

public interface CustomerEntitiesByIdentifierClientBusiness {
	
	public List<CustomerEntityListSalidaTO> listaCBP (String rut, String idType) throws Exception;

}
