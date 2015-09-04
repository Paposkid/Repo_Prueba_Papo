package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ChargesinfoTO;
import com.amx.service.dao.ChargesinfoDAO;


@Service
public class ChargesinfoBusinessImpl implements ChargesinfoBusiness {

	private static Logger logger = Logger
			.getLogger(ChargesinfoBusinessImpl.class);

	@Autowired
	private ChargesinfoDAO chargesinfoDAO;

	@Override
	public void insertarChargesinfo(ChargesinfoTO chargesinfoTO)
			throws Exception {

		try {
			chargesinfoDAO.insertarChargesinfo(chargesinfoTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargesinfoTO> listarChargesinfo(String codigoChargesinfo)
			throws Exception {
		List<ChargesinfoTO> lstChargesinfo = null;
		Map<String, Object> mapChargesinfoTO = new HashMap<String, Object>();

		try {
			mapChargesinfoTO.put("codigoChargesinfo", codigoChargesinfo);
			chargesinfoDAO.listarChargesinfo(mapChargesinfoTO);
			lstChargesinfo = (List<ChargesinfoTO>) mapChargesinfoTO
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstChargesinfo;
	}

}
