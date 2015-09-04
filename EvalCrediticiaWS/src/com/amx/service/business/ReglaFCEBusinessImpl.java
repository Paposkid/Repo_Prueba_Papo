package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ReglaFCETO;
import com.amx.service.dao.ReglaFCEDAO;


@Service
public class ReglaFCEBusinessImpl implements ReglaFCEBusiness {

	private static Logger logger = Logger.getLogger(ReglaFCEBusinessImpl.class);

	@Autowired
	private ReglaFCEDAO reglaFCEDAO;

	@Override
	public void insertarReglaFCE(ReglaFCETO reglaFCETO) throws Exception {
		try {
			reglaFCEDAO.insertarReglaFCE(reglaFCETO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public ReglaFCETO consultarReglaFCEByCodigoRegla(ReglaFCETO reglaFCETO)
			throws Exception {

		ReglaFCETO reglaFCE = new ReglaFCETO();
		List<ReglaFCETO> listReglaFCE = new ArrayList<ReglaFCETO>();
		Map<String, Object> mapReglaFCETO = new HashMap<String, Object>();

		try {

			mapReglaFCETO.put("codReglaFCE", reglaFCETO.getCodReglaFCE());
			reglaFCEDAO.consultarReglaFCEByCodigoRegla(mapReglaFCETO);
			listReglaFCE = (ArrayList<ReglaFCETO>) mapReglaFCETO
					.get("resultados");

			if (!listReglaFCE.isEmpty()) {
				reglaFCE = listReglaFCE.get(0);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return reglaFCE;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ReglaFCETO consultarReglaFCEByCodigoFCE(ReglaFCETO reglaFCETO)
			throws Exception {
		ReglaFCETO reglaFCE = new ReglaFCETO();
		List<ReglaFCETO> listReglaFCE = new ArrayList<ReglaFCETO>();
		Map<String, Object> mapReglaFCETO = new HashMap<String, Object>();

		try {

			mapReglaFCETO.put("codFCE", reglaFCETO.getCodFCE());
			reglaFCEDAO.consultarReglaFCEByCodigoFCE(mapReglaFCETO);
			listReglaFCE = (ArrayList<ReglaFCETO>) mapReglaFCETO
					.get("resultados");

			if (!listReglaFCE.isEmpty()) {
				reglaFCE = listReglaFCE.get(0);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return reglaFCE;
	}

}
