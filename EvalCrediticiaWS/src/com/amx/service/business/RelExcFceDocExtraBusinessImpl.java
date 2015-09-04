package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.RelExcFceDocExtraTO;
import com.amx.service.dao.RelExcFceDocExtraDAO;


@Service
public class RelExcFceDocExtraBusinessImpl implements RelExcFceDocExtraBusiness {

	private static Logger logger = Logger
			.getLogger(RelExcFceDocExtraBusinessImpl.class);

	@Autowired
	private RelExcFceDocExtraDAO relExcFceDocExtraDAO;

	@Override
	public void insertarRelExcFceDocExtra(
			RelExcFceDocExtraTO relExcFceDocExtraTO) throws Exception {
		try {
			relExcFceDocExtraDAO.insertarRelExcFceDocExtra(relExcFceDocExtraTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelExcFceDocExtraTO> listRelExcFceDocExtra(
			Integer codExcFceDocExtra) throws Exception {

		List<RelExcFceDocExtraTO> listRelExcFceDocExtra = null;
		Map<String, Object> mapRelExcFceDocExtraBean = new HashMap<String, Object>();

		try {
			mapRelExcFceDocExtraBean
					.put("codExcFceDocExtra", codExcFceDocExtra);
			relExcFceDocExtraDAO
					.listRelExcFceDocExtra(mapRelExcFceDocExtraBean);
			listRelExcFceDocExtra = (List<RelExcFceDocExtraTO>) mapRelExcFceDocExtraBean
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listRelExcFceDocExtra;
	}

}
