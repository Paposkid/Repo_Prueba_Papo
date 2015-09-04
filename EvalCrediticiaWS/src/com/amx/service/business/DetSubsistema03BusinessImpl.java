package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema03TO;
import com.amx.service.dao.DetSubsistema03DAO;


@Service
public class DetSubsistema03BusinessImpl implements DetSubsistema03Business {

	private static Logger logger = Logger
			.getLogger(DetSubsistema03BusinessImpl.class);

	@Autowired
	private DetSubsistema03DAO detSubSistema03DAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<DetSubsistema03TO> buscarDetSubsistema03(long codigoE)
			throws Exception {

		List<DetSubsistema03TO> lstDetSubsistema03 = null;
		Map<String, Object> mapDetSubsistema03 = new HashMap<String, Object>();

		try {
			mapDetSubsistema03.put("serialVersionUId", codigoE);
			detSubSistema03DAO.listarDetSubsistema03(mapDetSubsistema03);
			lstDetSubsistema03 = (List<DetSubsistema03TO>) mapDetSubsistema03
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstDetSubsistema03;
	}

	@Override
	public void insertarDetSubsistema03(DetSubsistema03TO equifaxTO)
			throws Exception {
		try {
			detSubSistema03DAO.insertarDetSubsistema03(equifaxTO);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
