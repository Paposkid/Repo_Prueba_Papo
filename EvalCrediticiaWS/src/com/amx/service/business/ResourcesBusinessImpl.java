package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ResourcesTO;
import com.amx.service.dao.ResourcesDAO;


@Service
public class ResourcesBusinessImpl implements ResourcesBusiness {

	@Autowired
	ResourcesDAO resourcesDAO;

	@Override
	@SuppressWarnings("unchecked")
	public List<ResourcesTO> searchResources() throws Exception {

		List<ResourcesTO> lstResource = null;
		Map<String, Object> mapResource = new HashMap<String, Object>();

		try {
			resourcesDAO.listarResources(mapResource);
			lstResource = (List<ResourcesTO>) mapResource.get("resultados");

		} catch (Exception ex) {

			throw ex;
		}

		return lstResource;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResourcesTO searchResourcesByName(ResourcesTO resourcesBean) throws Exception {

		List<ResourcesTO> lstResource = null;
		Map<String, Object> mapResource = new HashMap<String, Object>();
		ResourcesTO lResourcesBean = new ResourcesTO();

		try {
			mapResource.put("resourceName", resourcesBean.getResourceName());
			resourcesDAO.resourcesPorNombre(mapResource);
			lstResource = (List<ResourcesTO>) mapResource.get("resultados");

			if (!lstResource.isEmpty()) {

				lResourcesBean = lstResource.get(0);
			}

		} catch (Exception ex) {

			throw ex;

		}

		return lResourcesBean;
	}
}
