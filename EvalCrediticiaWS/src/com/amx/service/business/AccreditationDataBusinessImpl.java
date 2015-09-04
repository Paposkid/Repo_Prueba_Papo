package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AccreditationDataTO;
import com.amx.service.dao.AccreditationDataDAO;


@Service
public class AccreditationDataBusinessImpl implements AccreditationDataBusiness {

	private static Logger logger = Logger.getLogger(AccreditationDataBusinessImpl.class);

	@Autowired
	private AccreditationDataDAO accreditationDataDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<AccreditationDataTO> buscarAccrdata(Long corrAccrdata) throws Exception {
		List<AccreditationDataTO> listAccrdata = null;
		Map<String, Object> mapAccrdataTO = new HashMap<String, Object>();
		try {
			mapAccrdataTO.put("corrAccrData", corrAccrdata);
			accreditationDataDAO.buscarAccrData(mapAccrdataTO);
			listAccrdata = (List<AccreditationDataTO>) mapAccrdataTO.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listAccrdata;
	}

	@Override
	public void insertarAccrdata(AccreditationDataTO accrdata) throws Exception {
		// TODO Auto-generated method stub
		try {
			accreditationDataDAO.ingresarAccrData(accrdata);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
