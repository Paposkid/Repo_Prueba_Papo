package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.SubSistema02TO;
import com.amx.service.dao.SubSistema2DAO;


@Service
public class Subsistema02BusinessImpl implements Subsistema02Business {

	private static Logger logger = Logger
			.getLogger(Subsistema02BusinessImpl.class);

	@Autowired
	private SubSistema2DAO subSisytema2DAO;

	@Override
	public void insertarSubSys2(SubSistema02TO subSistemaBean2)
			throws Exception {
		try {
			subSisytema2DAO.insetarSubSistema2(subSistemaBean2);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema02TO searchListSys2(Long serialVersion2) throws Exception {
		List<SubSistema02TO> listSys2 = null;
		SubSistema02TO subSys2 = null;
		try {
			Map<String, Object> mapSubSistema2Bean = new HashMap<String, Object>();
			mapSubSistema2Bean.put("serialVersion", serialVersion2);
			subSisytema2DAO.listSubSys2(mapSubSistema2Bean);
			listSys2 = (List<SubSistema02TO>) mapSubSistema2Bean
					.get("resultados");
			if (!listSys2.isEmpty()) {
				subSys2 = listSys2.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSys2;
	}

}
