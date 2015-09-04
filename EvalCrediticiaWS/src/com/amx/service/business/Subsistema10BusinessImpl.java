package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetSubsistema10TO;
import com.amx.service.bean.SubSistema10TO;
import com.amx.service.dao.DetSubsistema10DAO;
import com.amx.service.dao.Subsistema10DAO;


@Service
public class Subsistema10BusinessImpl implements Subsistema10Business {

	private static Logger logger = Logger
			.getLogger(Subsistema10BusinessImpl.class);

	@Autowired
	private Subsistema10DAO subsistema10DAO;

	@Autowired
	private DetSubsistema10DAO detSubsistema10DAO;

	@Autowired
	private DetSubsistema10Business detSubsistema10BL;

	@SuppressWarnings("unchecked")
	@Override
	public SubSistema10TO buscarSubsistema10(long codigoE) throws Exception {

		List<SubSistema10TO> lstSubSistema10 = null;
		SubSistema10TO subSistema10TO = null;
		Map<String, Object> mpSubSistema10 = new HashMap<String, Object>();

		try {
			mpSubSistema10.put("serialVersion", codigoE);
			subsistema10DAO.listarSubsistema10(mpSubSistema10);
			lstSubSistema10 = (List<SubSistema10TO>) mpSubSistema10
					.get("resultados");
			if (!lstSubSistema10.isEmpty()) {
				subSistema10TO = lstSubSistema10.get(0);
				List<DetSubsistema10TO> listDetSubsistema10 = null;
				listDetSubsistema10 = detSubsistema10BL
						.buscarDetSubsistema10(subSistema10TO
								.getSerialVersion());
				subSistema10TO.getListDetSubSistema10().addAll(
						listDetSubsistema10);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return subSistema10TO;
	}

	@Override
	public void insertarSubsistema10(SubSistema10TO subSistema10TO)
			throws Exception {

		try {
			subsistema10DAO.insertarSubsistema10(subSistema10TO);
			for (DetSubsistema10TO ds : subSistema10TO.getListDetSubSistema10()) {
				ds.setSerialVersion(subSistema10TO.getSerialVersion());
				detSubsistema10DAO.insertarDetSubsistema10(ds);
			}
			;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
