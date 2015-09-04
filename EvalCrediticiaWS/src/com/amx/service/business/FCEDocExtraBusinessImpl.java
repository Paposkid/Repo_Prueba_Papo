package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.FCEDocExtraTO;
import com.amx.service.dao.FCEDocExtraDAO;


@Service
public class FCEDocExtraBusinessImpl implements FCEDocExtraBusiness {

	private static Logger logger = Logger
			.getLogger(FCEDocExtraBusinessImpl.class);

	@Autowired
	private FCEDocExtraDAO fCEDocExtraDAO;

	@Override
	public void insertarFCEDocExtra(FCEDocExtraTO fCEDocExtraTO)
			throws Exception {
		try {
			fCEDocExtraDAO.insertarFCEDocExtra(fCEDocExtraTO);
		}

		catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FCEDocExtraTO> buscarFCEDocExtra(String codigo)
			throws Exception {
		List<FCEDocExtraTO> lstFCEDocExtra = null;
		Map<String, Object> mapFCEDocExtra = new HashMap<String, Object>();

		try {
			mapFCEDocExtra.put("codigoDocExtrasFCE", codigo);
			fCEDocExtraDAO.listarFCEDocExtraById(mapFCEDocExtra);
			lstFCEDocExtra = (List<FCEDocExtraTO>) mapFCEDocExtra
					.get("resultados");
		}

		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstFCEDocExtra;
	}

}
