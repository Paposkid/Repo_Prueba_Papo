package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.dao.CredScoreInfoDAO;


@Service
public class CredScoreInfoBusinessImpl implements CredScoreInfoBusiness {

	private static Logger logger = Logger
			.getLogger(CredScoreInfoBusinessImpl.class);

	@Autowired
	private CredScoreInfoDAO credScoreInfoDAO;
	@Autowired
	private ADDRInfoDetailsBusiness AddressInfoDetailBL;

	@Override
	public void insertarCredScoreInfo(CredScoreInfoTO credScoreInfoTO)
			throws Exception {
		try {
			credScoreInfoDAO.insertarCredScoreInfo(credScoreInfoTO);
			credScoreInfoTO.getDireccionInfo().setCodigoCredScoreInfo(
					credScoreInfoTO.getCodigoCredScoreInfo());
			AddressInfoDetailBL.insertarADDRInfoDetails(credScoreInfoTO
					.getDireccionInfo());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CredScoreInfoTO> consultarCredScoreInfoByCodigo(
			CredScoreInfoTO credScoreInfoTO) throws Exception {

		List<CredScoreInfoTO> listcredScoreInfo = new ArrayList<CredScoreInfoTO>();
		Map<String, Object> mapCredScoreInfoTO = new HashMap<String, Object>();

		try {

			mapCredScoreInfoTO.put("CodigoCredScoreInfo",
					credScoreInfoTO.getCodigoCredScoreInfo());
			credScoreInfoDAO.consultarCredScoreInfoByCodigo(mapCredScoreInfoTO);
			listcredScoreInfo = (ArrayList<CredScoreInfoTO>) mapCredScoreInfoTO
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listcredScoreInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CredScoreInfoTO consultarCredScoreInfoByOrder(String orderID)
			throws Exception {
		List<CredScoreInfoTO> listcredScoreInfoOrder = new ArrayList<CredScoreInfoTO>();
		Map<String, Object> mapCredScoreInfoTO = new HashMap<String, Object>();

		try {

			mapCredScoreInfoTO.put("orderID", orderID);
			credScoreInfoDAO.consultarCredScoreInfoByOrder(mapCredScoreInfoTO);
			listcredScoreInfoOrder = (ArrayList<CredScoreInfoTO>) mapCredScoreInfoTO
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listcredScoreInfoOrder.get(0);
	}

}
