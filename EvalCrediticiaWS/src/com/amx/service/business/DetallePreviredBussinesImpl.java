package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetallePreviredTO;
import com.amx.service.dao.DetallePreviredDAO;


@Service
public class DetallePreviredBussinesImpl implements DetallePreviredBussines {

	private static Logger logger = Logger
			.getLogger(DetallePreviredBussinesImpl.class);

	@Autowired
	private DetallePreviredDAO detallePreviredDAO;

	@Override
	public void insertarDetallePrevired(DetallePreviredTO detallePreviredTO)
			throws Exception {
		try {
			detallePreviredDAO.insertarDetallePrevired(detallePreviredTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePreviredTO> consultarDetallePreviredByCodigo(
			DetallePreviredTO detallePreviredTO) throws Exception {
		List<DetallePreviredTO> listPrevired = new ArrayList<DetallePreviredTO>();
		Map<String, Object> mapDetallePreviredTO = new HashMap<String, Object>();
		try {
			mapDetallePreviredTO.put("codPrevired",
					detallePreviredTO.getCodPrevired());
			detallePreviredDAO
					.consultarDetallePreviredByCodigo(mapDetallePreviredTO);
			listPrevired = (ArrayList<DetallePreviredTO>) mapDetallePreviredTO
					.get("resultadosDos");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listPrevired;
	}

}
