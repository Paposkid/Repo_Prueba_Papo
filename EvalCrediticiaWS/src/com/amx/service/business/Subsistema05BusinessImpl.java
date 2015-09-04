package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.SubSistema05TO;
import com.amx.service.dao.SubSistema5DAO;


@Service
public class Subsistema05BusinessImpl implements Subsistema05Business {

	private static Logger logger = Logger
			.getLogger(Subsistema05BusinessImpl.class);

	@Autowired
	private SubSistema5DAO subSisytema5DAO;

	@Override
	public void insertarSubSys5(SubSistema05TO subSistemaBean5)
			throws Exception {

		subSisytema5DAO.insetarSubSistema5(subSistemaBean5);

	}

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema05TO searchListSys5(Long serialVersion5) throws Exception {

		List<SubSistema05TO> listSys5 = null;
		SubSistema05TO subSistema05 = null;
		try {
			Map<String, Object> mapSubSistema5Bean = new HashMap<String, Object>();
			mapSubSistema5Bean.put("serialVersion", serialVersion5);
			subSisytema5DAO.listSubSys5(mapSubSistema5Bean);
			listSys5 = (List<SubSistema05TO>) mapSubSistema5Bean
					.get("resultados");
			if (!listSys5.isEmpty()) {
				subSistema05 = listSys5.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSistema05;
	}

}
