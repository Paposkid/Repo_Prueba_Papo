package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.BiomTO;
import com.amx.service.dao.BiomDAO;


@Service
public class BiomBusinessImpl implements BiomBusiness {

	private static Logger logger = Logger.getLogger(BiomBusinessImpl.class);

	@Autowired
	private BiomDAO bioDAO;

	@Override
	public void insertarBiometric(BiomTO biom) throws Exception {
		try {
			bioDAO.ingresarBiom(biom);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BiomTO> searchListBio(Long corrBiom) throws Exception {
		List<BiomTO> listBiom = null;
		Map<String, Object> mapBiomBean = new HashMap<String, Object>();
		try {
			mapBiomBean.put("corrBiom", corrBiom);
			bioDAO.buscarBiom(mapBiomBean);
			listBiom = (List<BiomTO>) mapBiomBean.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listBiom;

	}

}
