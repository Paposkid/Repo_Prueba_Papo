package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema07TO;
import com.amx.service.bean.SubSistema07TO;
import com.amx.service.dao.Subsistema07DAO;


@Service
public class Subsistema07BusinessImpl implements Subsistema07Business {

	private static Logger logger = Logger
			.getLogger(Subsistema07BusinessImpl.class);

	@Autowired
	private Subsistema07DAO subsistema07DAO;

	@Autowired
	DetSubsistema07Business detSubsistema07BL;

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema07TO buscarSubsistema07(long codigoE) throws Exception {

		List<SubSistema07TO> lstSubSistema07 = null;
		SubSistema07TO subSistema07TO = null;
		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {
			mapEquifax.put("serialVersion", codigoE);
			subsistema07DAO.listarSubsistema07(mapEquifax);
			lstSubSistema07 = (List<SubSistema07TO>) mapEquifax
					.get("resultados");
			if (!lstSubSistema07.isEmpty()) {
				subSistema07TO = lstSubSistema07.get(0);
				List<DetSubsistema07TO> lstDetSub07 = new ArrayList<DetSubsistema07TO>();
				lstDetSub07 = detSubsistema07BL
						.buscarDetSubsistema07(subSistema07TO
								.getSerialVersion().toString());
				subSistema07TO.getListDetSubsistema07().addAll(lstDetSub07);
			}
			;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSistema07TO;
	}

	@Override
	public void insertarSubsistema07(SubSistema07TO subSistema07TO)
			throws Exception {

		try {
			subsistema07DAO.insertarSubsistema07(subSistema07TO);
			for (DetSubsistema07TO ds : subSistema07TO.getListDetSubsistema07()) {
				ds.setSerialVersion(subSistema07TO.getSerialVersion());
				detSubsistema07BL.insertarDetSubsistema07(ds);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
}
