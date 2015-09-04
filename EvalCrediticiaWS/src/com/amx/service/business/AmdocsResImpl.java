package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AmdocsResTO;
import com.amx.service.dao.AmdocsResDAO;


@Service
public class AmdocsResImpl implements AmdocsResBusiness {

	private static Logger logger = Logger.getLogger(AmdocsResImpl.class);

	@Autowired
	private AmdocsResDAO amdocsResDAO;

	@Override
	public void insertarAmdocsRes(AmdocsResTO amdocsResTO) throws Exception {
		try {
			amdocsResDAO.insertarAmdocsRes(amdocsResTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public AmdocsResTO searchListAmdocsRes(String rut) throws Exception {

		List<AmdocsResTO> listAmdocsRes = null;
		AmdocsResTO miAmdocsResTO = null;
		try {
			Map<String, Object> mapAmdocsResTO = new HashMap<String, Object>();
			mapAmdocsResTO.put("rut", rut);
			amdocsResDAO.listAmdocsRes(mapAmdocsResTO);
			listAmdocsRes = (List<AmdocsResTO>) mapAmdocsResTO
					.get("resultados");
			if (!listAmdocsRes.isEmpty())
				miAmdocsResTO = listAmdocsRes.get(0);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return miAmdocsResTO;
	}

}
