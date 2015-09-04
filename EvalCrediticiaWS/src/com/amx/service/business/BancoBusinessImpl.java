package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.BancoTO;
import com.amx.service.dao.BancoDAO;


@Service
public class BancoBusinessImpl implements BancoBusiness {

	private static Logger logger = Logger.getLogger(BancoBusinessImpl.class);

	@Autowired
	private BancoDAO bancoDAO;

	@Override
	public void insertarBanco(BancoTO bancoTO) throws Exception {
		try {
			bancoDAO.insertarBanco(bancoTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BancoTO> buscarBanco(long codigoE) throws Exception {
		List<BancoTO> lstBanco = null;
		Map<String, Object> mapBanco = new HashMap<String, Object>();

		try {
			mapBanco.put("serialVersion", codigoE);
			bancoDAO.listarBanco(mapBanco);
			lstBanco = (List<BancoTO>) mapBanco.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstBanco;
	}

}
