package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ADDRInfoDetTO;

import cl.clarochile.aplicaciones.evalcrediticia.dao.ADDRInfoDetailsDAO;

@Service
public class ADDRInfoDetailsBusinessImpl implements ADDRInfoDetailsBusiness {

	private static Logger logger = Logger
			.getLogger(ADDRInfoDetailsBusinessImpl.class);

	@Autowired
	private ADDRInfoDetailsDAO aDDRInfoDetailsDAO;

	@Override
	public void insertarADDRInfoDetails(ADDRInfoDetTO aDDRInfoDetailsTO)
			throws Exception {
		try {
			aDDRInfoDetailsDAO.insertarADDRInfoDetails(aDDRInfoDetailsTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public ADDRInfoDetTO consultarADDRInfoDetailsByCodigo(
			ADDRInfoDetTO aDDRInfoDetailsTO) throws Exception {

		ADDRInfoDetTO credScoreInfo = new ADDRInfoDetTO();
		List<ADDRInfoDetTO> listcredScoreInfo = new ArrayList<ADDRInfoDetTO>();
		Map<String, Object> mapADDRInfoDetTO = new HashMap<String, Object>();

		try {

			mapADDRInfoDetTO.put("codigoCredScoreInfo",
					aDDRInfoDetailsTO.getCodigoCredScoreInfo());
			aDDRInfoDetailsDAO
					.consultarADDRInfoDetailsByCodigo(mapADDRInfoDetTO);
			listcredScoreInfo = (ArrayList<ADDRInfoDetTO>) mapADDRInfoDetTO
					.get("resultados");

			if (!listcredScoreInfo.isEmpty()) {
				credScoreInfo = listcredScoreInfo.get(0);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return credScoreInfo;
	}

}
