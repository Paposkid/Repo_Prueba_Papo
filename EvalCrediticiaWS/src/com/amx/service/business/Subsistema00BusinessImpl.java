package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.SubSistema00TO;
import com.amx.service.dao.SubSistema0DAO;


@Service
public class Subsistema00BusinessImpl implements Subsistema00Business {

	private static Logger logger = Logger
			.getLogger(Subsistema00BusinessImpl.class);

	@Autowired
	private SubSistema0DAO subSistema0DAO;

	@Override
	public void insertarSubSys0(SubSistema00TO subSistemaBean0)
			throws Exception {
		try {
			subSistema0DAO.insetarSubSistema0(subSistemaBean0);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema00TO searchListSys0(Long serialVersion) throws Exception {

		List<SubSistema00TO> listSys0 = null;
		SubSistema00TO subSys0 = null;
		try {
			Map<String, Object> mapSubSistema0Bean = new HashMap<String, Object>();
			mapSubSistema0Bean.put("serialVersion", serialVersion);
			subSistema0DAO.listSubSys0(mapSubSistema0Bean);
			listSys0 = (List<SubSistema00TO>) mapSubSistema0Bean
					.get("resultados");
			if (!listSys0.isEmpty()) {
				subSys0 = listSys0.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSys0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubSistema00TO> listSubSys0ByRut(String rutEval)
			throws Exception {
		List<SubSistema00TO> consSubSistema00 = null;
		try {
			Map<String, Object> mapSubSistema0Bean = new HashMap<String, Object>();
			mapSubSistema0Bean.put("rutEval", rutEval);

			subSistema0DAO.listSubSys0ByRut(mapSubSistema0Bean);

			consSubSistema00 = (List<SubSistema00TO>) mapSubSistema0Bean
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return consSubSistema00;
	}

}
