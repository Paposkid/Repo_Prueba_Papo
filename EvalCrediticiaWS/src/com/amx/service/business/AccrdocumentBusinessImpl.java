package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AccrdocumentTO;
import com.amx.service.dao.AccrdocumentDAO;


@Service
public class AccrdocumentBusinessImpl implements AccrdocumentBusiness {

	private static Logger logger = Logger.getLogger(AccreditationDataBusinessImpl.class);

	@Autowired
	private AccrdocumentDAO accrdataDAO;

	@Override
	public void insertarAccrdocument(AccrdocumentTO accrdocumentTO)
			throws Exception {

		try {
			accrdataDAO.ingresarDocument(accrdocumentTO);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccrdocumentTO> buscarAccrdocument(Long corrAccrdocument)
			throws Exception {
		// TODO Auto-generated method stub
		List<AccrdocumentTO> listAccr = null;
		Map<String, Object> mapAccrdataTO = new HashMap<String, Object>();
		try {
			mapAccrdataTO.put("corrAccrdocument", corrAccrdocument);
			accrdataDAO.buscarDocument(mapAccrdataTO);
			listAccr = (List<AccrdocumentTO>) mapAccrdataTO.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listAccr;

	}

}
