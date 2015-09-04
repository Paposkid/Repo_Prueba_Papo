package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.NlineSallopGaptTO;
import com.amx.service.dao.NlineSallopGaptDao;


@Service
public class NlineSallopGaptBusinessImpl implements NlineSallopGaptBusiness {

	private static Logger logger = Logger
			.getLogger(NlineSallopGaptBusinessImpl.class);

	@Autowired
	NlineSallopGaptDao nlineSallopGaptDao;

	@Override
	public void insertarNlineSallopGapt(NlineSallopGaptTO nlineSallopGaptTO)
			throws Exception {
		try {
			nlineSallopGaptDao.insertarNlineSallopGapt(nlineSallopGaptTO);
		}

		catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NlineSallopGaptTO> buscarNlineSallopGapt(Long CorrSallce)
			throws Exception {
		List<NlineSallopGaptTO> listaNlineSallopGapt = null;
		Map<String, Object> mapNlineSallopGapt = new HashMap<String, Object>();
		try {

			mapNlineSallopGapt.put("CorrSallce", CorrSallce);
			nlineSallopGaptDao.listarNlineSallopGapt(mapNlineSallopGapt);
			listaNlineSallopGapt = (List<NlineSallopGaptTO>) mapNlineSallopGapt
					.get("resultados");

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return listaNlineSallopGapt;
	}

}
