package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ReglalceTO;
import com.amx.service.dao.ReglalceDAO;


@Service
public class ReglalceBusinessImpl implements ReglalceBusiness {

	private static Logger logger = Logger.getLogger(ReglalceBusinessImpl.class);

	@Autowired
	private ReglalceDAO reglalceDAO;

	@Override
	public void insertarReglalce(ReglalceTO reglalceTO) throws Exception {
		try {
			reglalceDAO.insertarReglalce(reglalceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReglalceTO> listarReglalce(String codigoReglalce)
			throws Exception {
		List<ReglalceTO> lstReglalce = null;
		Map<String, Object> mapReglalce = new HashMap<String, Object>();

		try {
			mapReglalce.put("codigoReglalce", codigoReglalce);
			reglalceDAO.listarReglalceTO(mapReglalce);
			lstReglalce = (List<ReglalceTO>) mapReglalce.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstReglalce;

	}
}
