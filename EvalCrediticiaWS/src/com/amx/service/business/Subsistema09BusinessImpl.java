package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema09TO;
import com.amx.service.bean.SubSistema09TO;
import com.amx.service.dao.Subsistema09DAO;


@Service
public class Subsistema09BusinessImpl implements Subsistema09Business {

	private static Logger logger = Logger
			.getLogger(Subsistema09BusinessImpl.class);

	@Autowired
	private Subsistema09DAO subSistema09DAO;

	@Autowired
	private DetSubsistema09Business DetSubsistema09BL;

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema09TO buscarSubsistema09(long codigoE) throws Exception {
		List<SubSistema09TO> lstSubSistema09TO = null;
		List<DetSubsistema09TO> lstDetSubsistema09TO = null;
		SubSistema09TO subSistema09TO = null;
		Map<String, Object> mapSubSistema09 = new HashMap<String, Object>();

		try {
			mapSubSistema09.put("serialVersion", codigoE);
			subSistema09DAO.listarSubsistema09(mapSubSistema09);
			lstSubSistema09TO = (List<SubSistema09TO>) mapSubSistema09
					.get("resultados");
			if (!lstSubSistema09TO.isEmpty()) {
				subSistema09TO = lstSubSistema09TO.get(0);
				lstDetSubsistema09TO = DetSubsistema09BL
						.buscarDetSubsistema09(subSistema09TO
								.getSerialVersion());
				subSistema09TO.getListDetSubSistema09().addAll(
						lstDetSubsistema09TO);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSistema09TO;
	}

	@Override
	public void insertarSubsistema09(SubSistema09TO subSistema09TO)
			throws Exception {

		try {
			subSistema09DAO.insertarSubsistema09(subSistema09TO);

			for (DetSubsistema09TO ds : subSistema09TO.getListDetSubSistema09()) {
				ds.setSerialVersion(subSistema09TO.getSerialVersion());
				DetSubsistema09BL.insertarDetSubsistema09(ds);
			}
			;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
