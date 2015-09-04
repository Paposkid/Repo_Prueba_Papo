package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.EquifaxDetalleTO;
import com.amx.service.dao.EquifaxDetalleDAO;


@Service
public class EquifaxDetalleBusinessImpl implements EquifaxDetalleBusiness {

	private static Logger logger = Logger
			.getLogger(EquifaxDetalleBusinessImpl.class);

	@Autowired
	private EquifaxDetalleDAO equifaxDetalleDAO;

	@Override
	public void insertarDetalleEquifax(EquifaxDetalleTO detalleEquifaxTO)
			throws Exception {
		try {
			equifaxDetalleDAO.insertarDetalleEquifax(detalleEquifaxTO);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquifaxDetalleTO> listarDetalleEquifax(String codigoEquifax)
			throws Exception {
		List<EquifaxDetalleTO> lstEquifaxDetalle = null;
		Map<String, Object> mapEquifaxDetalle = new HashMap<String, Object>();
		try {
			mapEquifaxDetalle.put("codigoDetalleEquifax", codigoEquifax);
			equifaxDetalleDAO.listarDetalleEquifax(mapEquifaxDetalle);
			lstEquifaxDetalle = (List<EquifaxDetalleTO>) mapEquifaxDetalle
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstEquifaxDetalle;

	}

	@Override
	public List<EquifaxDetalleTO> listarDetalleEquifaxByRut(String rut) throws Exception {
		List<EquifaxDetalleTO> lstEquifaxDetalle = null;
		Map<String, Object> mapEquifaxDetalle = new HashMap<String, Object>();
		try {
			mapEquifaxDetalle.put("rut", rut);
			equifaxDetalleDAO.listarDetalleEquifax(mapEquifaxDetalle);
			lstEquifaxDetalle = (List<EquifaxDetalleTO>) mapEquifaxDetalle.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstEquifaxDetalle;
	}

}
