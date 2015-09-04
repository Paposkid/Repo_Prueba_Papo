package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ExcLceTO;
import com.amx.service.dao.ExcLceDAO;


@Service
public class ExcLceBusinessImpl implements ExcLceBusiness {

	private static Logger logger = Logger.getLogger(ExcLceBusinessImpl.class);

	@Autowired
	private ExcLceDAO excLceDAO;

	@Override
	public void insertarExcLce(ExcLceTO excLceTO) throws Exception {

		try {
			excLceDAO.insertarExcLce(excLceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExcLceTO> listExcLce(Long codExcLce, Long codLce)
			throws Exception {

		List<ExcLceTO> listExcLce = null;
		Map<String, Object> mapExcLceBean = new HashMap<String, Object>();

		try {

			mapExcLceBean.put("codExcLce", codExcLce);
			mapExcLceBean.put("codLce", codLce);
			excLceDAO.listExcLce(mapExcLceBean);
			listExcLce = (List<ExcLceTO>) mapExcLceBean.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listExcLce;
	}

}
