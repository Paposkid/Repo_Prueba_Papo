package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ExcCondicionFceTO;
import com.amx.service.dao.ExcCondicionFceDAO;


@Service
public class ExcCondicionFceBusinessImpl implements ExcCondicionFceBusiness {

	private static Logger logger = Logger
			.getLogger(ExcCondicionFceBusinessImpl.class);

	@Autowired
	private ExcCondicionFceDAO excCondicionFceDAO;

	@Override
	public void insertarExcCondicionFce(ExcCondicionFceTO excCondicionFceTO)
			throws Exception {
		try {
			excCondicionFceDAO.insertarExcCondicionFce(excCondicionFceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExcCondicionFceTO> listExcCondicionFce(Integer codCondicionFce)
			throws Exception {
		List<ExcCondicionFceTO> listExcCondicionFce = null;
		Map<String, Object> mapExcCondicionFceBean = new HashMap<String, Object>();

		try {
			mapExcCondicionFceBean.put("codCondicionFce", codCondicionFce);
			excCondicionFceDAO.listExcCondicionFce(mapExcCondicionFceBean);
			listExcCondicionFce = (List<ExcCondicionFceTO>) mapExcCondicionFceBean
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listExcCondicionFce;
	}

}
