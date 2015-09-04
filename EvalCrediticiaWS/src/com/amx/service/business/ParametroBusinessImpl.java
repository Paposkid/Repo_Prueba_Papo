package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ParametroTO;
import com.amx.service.dao.ParametroDAO;


/**
 * Clase donde implementa la interfaz ParametroBusiness y utiliza los métodos
 * para comunicarse con ParametroDao para la comunicacion de la base de datos.
 * 
 * @author Jorge Armado Montoya J. [jorge.montoyajaramillo@tcs.com]
 * @since 04/08/2013
 * @version 1.0
 */
@Service
public class ParametroBusinessImpl implements ParametroBusiness {

	private static Logger logger = Logger.getLogger(ParametroBusinessImpl.class);

	@Autowired
	ParametroDAO parametroDao;

	@SuppressWarnings("unchecked")
	@Override
	public ParametroTO buscarParametroPorNombre(String nombreParametro) throws Exception {
		ParametroTO parametro = null;
		List<ParametroTO> listParm = new ArrayList<ParametroTO>();
		Map<String, Object> mapParametroTO = new HashMap<String, Object>();
		try {
			mapParametroTO.put("nombreParametro", nombreParametro);
			parametroDao.buscarParametroPorNombre(mapParametroTO);
			listParm = (List<ParametroTO>) mapParametroTO.get("resultados");
			if (!listParm.isEmpty()) {
				parametro = listParm.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return parametro;
	}

	public List<ParametroTO> buscarParametroPorNomb(String nombreParametro) throws Exception {
		ParametroTO parametro = null;
		List<ParametroTO> listParm = new ArrayList<ParametroTO>();
		Map<String, Object> mapParametroTO = new HashMap<String, Object>();
		try {
			mapParametroTO.put("nombreParametro", nombreParametro);
			parametroDao.buscarParametroPorNomb(mapParametroTO);
			listParm = (List<ParametroTO>) mapParametroTO.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listParm;
	}

}
