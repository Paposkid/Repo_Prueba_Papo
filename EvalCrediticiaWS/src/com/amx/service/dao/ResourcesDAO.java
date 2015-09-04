package com.amx.service.dao;

import java.util.List;
import java.util.Map;

import com.amx.service.bean.ResourcesTO;


public interface ResourcesDAO {

	public List<ResourcesTO> listarResources(Map<String, Object> resourcesBean);

	public ResourcesTO resourcesPorNombre(Map<String, Object> resourcesBean);

}
