package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ExcFceTO;
import com.amx.service.dao.ExcFceDAO;


@Service
public class ExcFceBusinessImpl implements ExcFceBusiness {

	private static Logger logger = Logger.getLogger(ExcFceBusinessImpl.class);

	@Autowired
	private ExcFceDAO excFCEDAO;

	@Override
	public void insertarExcFce(ExcFceTO excFceTO) throws Exception {
		try {
			excFCEDAO.insertarExcFce(excFceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExcFceTO> listExcFce(Long codExcFce, Long codFce)
			throws Exception {
		List<ExcFceTO> listExcFCE = null;
		Map<String, Object> mapExcFCEBean = new HashMap<String, Object>();
		try {
			mapExcFCEBean.put("codExcFce", codExcFce);
			mapExcFCEBean.put("codFce", codFce);
			excFCEDAO.listExcFce(mapExcFCEBean);
			listExcFCE = (List<ExcFceTO>) mapExcFCEBean.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listExcFCE;
	}

}
