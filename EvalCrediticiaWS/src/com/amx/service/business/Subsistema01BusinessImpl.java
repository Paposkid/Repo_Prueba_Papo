package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.SubSistema01TO;
import com.amx.service.dao.SubSistema1DAO;


@Service
public class Subsistema01BusinessImpl implements Subsistema01Business {

	private static Logger logger = Logger
			.getLogger(Subsistema01BusinessImpl.class);

	@Autowired
	private SubSistema1DAO subSisytema1DAO;

	@Override
	public void insertarSubSys1(SubSistema01TO subSistemaBean1)
			throws Exception {
		try {
			subSisytema1DAO.insetarSubSistema1(subSistemaBean1);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema01TO searchListSys1(Long serialVersion1) throws Exception {
		SubSistema01TO subSistema01TO = null;
		List<SubSistema01TO> listSys1 = null;
		try {
			Map<String, Object> mapSubSistema1Bean = new HashMap<String, Object>();
			mapSubSistema1Bean.put("serialVersion", serialVersion1);
			subSisytema1DAO.listSubSys1(mapSubSistema1Bean);
			listSys1 = (List<SubSistema01TO>) mapSubSistema1Bean
					.get("resultados");
			if (!listSys1.isEmpty()) {
				subSistema01TO = listSys1.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSistema01TO;
	}

}
