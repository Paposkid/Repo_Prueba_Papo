package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema03TO;
import com.amx.service.bean.SubSistema03TO;
import com.amx.service.dao.DetSubsistema03DAO;
import com.amx.service.dao.Subsistema03DAO;


@Service
public class Subsistema03BusinessImpl implements Subsistema03Business {

	private static Logger logger = Logger
			.getLogger(Subsistema03BusinessImpl.class);

	@Autowired
	private Subsistema03DAO subSistema03DAO;

	@Autowired
	private DetSubsistema03DAO detSubsistema03DAO;

	@Autowired
	private DetSubsistema03Business DetSubsistema03BL;

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema03TO buscarSubsistema03(long codigoE) throws Exception {

		List<SubSistema03TO> lstSubSistema03 = null;
		SubSistema03TO subSistema03TO = null;
		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {
			mapEquifax.put("serialVersion", codigoE);
			subSistema03DAO.listarSubsistema03(mapEquifax);
			lstSubSistema03 = (List<SubSistema03TO>) mapEquifax
					.get("resultados");
			if (!lstSubSistema03.isEmpty()) {
				subSistema03TO = lstSubSistema03.get(0);
				List<DetSubsistema03TO> lstDetSubsistema03 = null;
				lstDetSubsistema03 = DetSubsistema03BL
						.buscarDetSubsistema03(subSistema03TO
								.getSerialVersion());
				subSistema03TO.getListDetSubSistema03().addAll(lstDetSubsistema03);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSistema03TO;
	}

	@Override
	public void insertarSubsistema03(SubSistema03TO subSistema03TO)
			throws Exception {
		try {
			subSistema03DAO.insertarSubsistema03(subSistema03TO);

			for (DetSubsistema03TO ds : subSistema03TO.getListDetSubSistema03()) {
				ds.setSerialVersion(subSistema03TO.getSerialVersion());
				detSubsistema03DAO.insertarDetSubsistema03(ds);
			}
			;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
