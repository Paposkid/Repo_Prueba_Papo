package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema10TO;
import com.amx.service.dao.DetSubsistema10DAO;


@Service
public class DetSubsistema10BusinessImpl implements DetSubsistema10Business {

	private static Logger logger = Logger
			.getLogger(DetSubsistema10BusinessImpl.class);

	@Autowired
	DetSubsistema10DAO detSubSistema10DAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<DetSubsistema10TO> buscarDetSubsistema10(long codigoE)
			throws Exception {

		List<DetSubsistema10TO> lstEquifax = null;

		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {
			mapEquifax.put("serialVersion", codigoE);
			detSubSistema10DAO.listarDetSubsistema10(mapEquifax);
			lstEquifax = (List<DetSubsistema10TO>) mapEquifax.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstEquifax;
	}

	@Override
	public void insertarDetSubsistema10(DetSubsistema10TO DetSubsistema10)
			throws Exception {
		try {
			detSubSistema10DAO.insertarDetSubsistema10(DetSubsistema10);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
