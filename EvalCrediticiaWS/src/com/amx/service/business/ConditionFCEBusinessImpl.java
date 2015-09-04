package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ConditionFCETO;
import com.amx.service.dao.ConditionFCEDAO;


@Service
public class ConditionFCEBusinessImpl implements ConditionFCEBusiness {

	private static Logger logger = Logger
			.getLogger(ConditionFCEBusinessImpl.class);

	@Autowired
	private ConditionFCEDAO conditionFCEDAO;

	@Override
	public void insertarConditionFCE(ConditionFCETO conditionFCETO)
			throws Exception {
		try {
			conditionFCEDAO.insertarConditionFCE(conditionFCETO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConditionFCETO> buscarConditionFCE(long codigo)
			throws Exception {

		List<ConditionFCETO> lstConditionFCE = null;
		Map<String, Object> mapConditionFCE = new HashMap<String, Object>();

		try {
			mapConditionFCE.put("codCondicionFCE", codigo);
			conditionFCEDAO.listarConditionFCEById(mapConditionFCE);
			lstConditionFCE = (List<ConditionFCETO>) mapConditionFCE
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstConditionFCE;

	}

}
