package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema07TO;
import com.amx.service.dao.DetSubsistema07DAO;


@Service
public class DetSubsistema07BusinessImpl implements DetSubsistema07Business {

	private static Logger logger = Logger
			.getLogger(DetSubsistema07BusinessImpl.class);

	@Autowired
	private DetSubsistema07DAO detSubSistema07DAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<DetSubsistema07TO> buscarDetSubsistema07(String codigoE)
			throws Exception {

		List<DetSubsistema07TO> lstDetSubsistema07 = null;
		Map<String, Object> mapDetSubsistema07 = new HashMap<String, Object>();

		try {
			mapDetSubsistema07.put("serialVersion", codigoE);
			detSubSistema07DAO.listarDetSubsistema07(mapDetSubsistema07);

			lstDetSubsistema07 = (List<DetSubsistema07TO>) mapDetSubsistema07
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstDetSubsistema07;
	}

	@Override
	public void insertarDetSubsistema07(DetSubsistema07TO detSubsistema07TO)
			throws Exception {
		try {
			detSubSistema07DAO.insertarDetSubsistema07(detSubsistema07TO);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
