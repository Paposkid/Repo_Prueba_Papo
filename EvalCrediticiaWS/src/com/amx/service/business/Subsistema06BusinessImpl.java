package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.BancoTO;
import com.amx.service.bean.SubSistema06TO;
import com.amx.service.dao.Subsistema06DAO;


@Service
public class Subsistema06BusinessImpl implements Subsistema06Business {

	private static Logger logger = Logger
			.getLogger(Subsistema06BusinessImpl.class);

	@Autowired
	private Subsistema06DAO Subsistema06Dao;

	@Autowired
	private BancoBusiness bancoBL;

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema06TO buscarSubsistema06(long codigoE) throws Exception {
		SubSistema06TO miSubSistema06TO = null;
		List<SubSistema06TO> lstSubSistema06 = null;
		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {

			mapEquifax.put("serialVersion", codigoE);
			Subsistema06Dao.listarSubsistema06(mapEquifax);
			lstSubSistema06 = (List<SubSistema06TO>) mapEquifax
					.get("resultados");
			if (!lstSubSistema06.isEmpty()) {
				miSubSistema06TO = lstSubSistema06.get(0);
				List<BancoTO> lstBanco = null;
				lstBanco = bancoBL.buscarBanco(codigoE);
				if (!lstBanco.isEmpty()) {
					miSubSistema06TO.getListBanco().addAll(lstBanco);
				}
				;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return miSubSistema06TO;
	}

	@Override
	public void insertarSubsistema06(SubSistema06TO subSisTO) throws Exception {
		try {
			Subsistema06Dao.insertarSubsistema06(subSisTO);

			for (BancoTO banco : subSisTO.getListBanco()) {
				banco.setSerialVersion(subSisTO.getSerialVersion());
				bancoBL.insertarBanco(banco);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
