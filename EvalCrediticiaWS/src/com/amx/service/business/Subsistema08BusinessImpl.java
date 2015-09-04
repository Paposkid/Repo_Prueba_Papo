package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.SubSistema08TO;
import com.amx.service.dao.SubSistema8DAO;


@Service
public class Subsistema08BusinessImpl implements Subsistema08Business {

	private static Logger logger = Logger
			.getLogger(Subsistema08BusinessImpl.class);

	@Autowired
	private SubSistema8DAO subSisytema8DAO;

	@Override
	public void insertarSubSys8(SubSistema08TO subSistemaBean8)
			throws Exception {
		subSisytema8DAO.insetarSubSistema8(subSistemaBean8);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema08TO searchListSys8(Long serialVersion8) throws Exception {
		SubSistema08TO subSistema08TO = null;
		try {
			List<SubSistema08TO> listSys8 = null;
			Map<String, Object> mapSubSistema8Bean = new HashMap<String, Object>();
			mapSubSistema8Bean.put("serialVersion", serialVersion8);
			subSisytema8DAO.listSubSys8(mapSubSistema8Bean);
			listSys8 = (List<SubSistema08TO>) mapSubSistema8Bean
					.get("resultados");
			if (!listSys8.isEmpty()) {
				subSistema08TO = listSys8.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return subSistema08TO;
	}
}
