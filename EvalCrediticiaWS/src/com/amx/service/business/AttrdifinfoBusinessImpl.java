package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AttrdifinfoTO;
import com.amx.service.dao.AttrdifinfoDAO;


@Service
public class AttrdifinfoBusinessImpl implements AttrdifinfoBusiness {

	private static Logger logger = Logger
			.getLogger(AttrdifinfoBusinessImpl.class);

	@Autowired
	private AttrdifinfoDAO attrdifinfoDAO;

	@Override
	public void insertarAttrdifinfo(AttrdifinfoTO AttrdifinfoTO)
			throws Exception {
		try {
			attrdifinfoDAO.insertarAttrdifinfo(AttrdifinfoTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttrdifinfoTO> listarAttrdifinfo(String codigoAttrdifinfo)
			throws Exception {
		List<AttrdifinfoTO> lstAttrdifinfo = null;
		Map<String, Object> mapAttrdifinfo = new HashMap<String, Object>();

		try {
			mapAttrdifinfo.put("codigoAttrdifinfo", codigoAttrdifinfo);
			attrdifinfoDAO.listarAttrdifinfo(mapAttrdifinfo);
			lstAttrdifinfo = (List<AttrdifinfoTO>) mapAttrdifinfo
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstAttrdifinfo;
	}

}
