package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema09TO;
import com.amx.service.dao.DetSubsistema09DAO;


@Service
public class DetSubsistema09BusinessImpl implements DetSubsistema09Business {

	private static Logger logger = Logger
			.getLogger(DetSubsistema09BusinessImpl.class);

	@Autowired
	private DetSubsistema09DAO detSubSistema09DAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<DetSubsistema09TO> buscarDetSubsistema09(long codigoE)
			throws Exception {

		List<DetSubsistema09TO> lstDetSubsistema09 = null;
		Map<String, Object> mapDetSubsistema09 = new HashMap<String, Object>();

		try {
			mapDetSubsistema09.put("serialVersion", codigoE);
			detSubSistema09DAO.listarDetSubsistema09(mapDetSubsistema09);
			lstDetSubsistema09 = (List<DetSubsistema09TO>) mapDetSubsistema09
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstDetSubsistema09;
	}

	@Override
	public void insertarDetSubsistema09(DetSubsistema09TO detSubsistema09TO)
			throws Exception {
		try {
			detSubSistema09DAO.insertarDetSubsistema09(detSubsistema09TO);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
