package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.RelDocumentExcFceTO;
import com.amx.service.dao.RelDocumentExcFceDAO;


@Service
public class RelDocumentExcFceBusinessImpl implements RelDocumentExcFceBusiness {

	private static Logger logger = Logger
			.getLogger(RelDocumentExcFceBusinessImpl.class);

	@Autowired
	private RelDocumentExcFceDAO relDocumentExcFceDAO;

	@Override
	public void insertarRelDocumentExcFce(
			RelDocumentExcFceTO relDocumentExcFceTO) throws Exception {
		try {
			relDocumentExcFceDAO.insertarRelDocumentExcFce(relDocumentExcFceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelDocumentExcFceTO> listRelDocumentExcFce(
			Integer codFceDocument) throws Exception {
		List<RelDocumentExcFceTO> listRelDocumentExcFce = null;
		Map<String, Object> mapRelDocumentExcFceBean = new HashMap<String, Object>();

		try {
			mapRelDocumentExcFceBean.put("codFceDocument", codFceDocument);
			relDocumentExcFceDAO
					.listRelDocumentExcFce(mapRelDocumentExcFceBean);
			listRelDocumentExcFce = (List<RelDocumentExcFceTO>) mapRelDocumentExcFceBean
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listRelDocumentExcFce;
	}

}
