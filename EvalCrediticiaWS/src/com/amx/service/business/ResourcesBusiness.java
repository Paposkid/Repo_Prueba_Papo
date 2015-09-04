package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ResourcesTO;



public interface ResourcesBusiness {
	
	
	public List<ResourcesTO> searchResources() throws Exception;
	
	public ResourcesTO searchResourcesByName(ResourcesTO resourcesBean) throws Exception;
	
}
