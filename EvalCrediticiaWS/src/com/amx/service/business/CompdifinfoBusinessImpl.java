package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AttrdifinfoTO;
import com.amx.service.bean.ChargesinfoTO;
import com.amx.service.bean.CompdifinfoTO;
import com.amx.service.dao.CompdifinfoDAO;


@Service
public class CompdifinfoBusinessImpl implements CompdifinfoBusiness {

	private static Logger logger = Logger
			.getLogger(CompdifinfoBusinessImpl.class);

	@Autowired
	private CompdifinfoDAO compdifinfoDAO;

	@Autowired
	private AttrdifinfoBusiness attrdifinfoBusinessImpl;

	@Autowired
	private ChargesinfoBusiness ChargesinfoBusinessImpl;

	@Override
	public void insertarCompdifinfo(CompdifinfoTO compdifinfoTO)
			throws Exception {
		try {
			compdifinfoDAO.insertarCompdifinfo(compdifinfoTO);
			for (CompdifinfoTO ds : compdifinfoTO.getListsubComponente()) {
				ds.setSubComponente(ds.getCodigoCompdifinfo());
				insertarCompdifinfo(ds);
			}
			for (AttrdifinfoTO ds : compdifinfoTO.getListAttrdifinfo()) {
				ds.setCodigoCompdifinfo(ds.getCodigoCompdifinfo());
				attrdifinfoBusinessImpl.insertarAttrdifinfo(ds);
			}
			for (ChargesinfoTO ds : compdifinfoTO.getListChargesinfo()) {
				ds.setCodigoCompdifinfo(ds.getCodigoCompdifinfo());
				ChargesinfoBusinessImpl.insertarChargesinfo(ds);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public CompdifinfoTO listarCompdifinfo(String codigoCompdifinfo) {
		CompdifinfoTO compdifinfoTO = null;
		List<CompdifinfoTO> lstCompdifinfo = null;
		List<AttrdifinfoTO> lstAttrdifinfo = null;
		List<ChargesinfoTO> lstChargesinfo = null;
		List<CompdifinfoTO> lstCompdifinfoSub = new ArrayList<CompdifinfoTO>();

		Map<String, Object> mapCompdifinfoTO = new HashMap<String, Object>();

		try {
			mapCompdifinfoTO.put("codigoCompdifinfo", codigoCompdifinfo);
			compdifinfoDAO.listarCompdifinfo(mapCompdifinfoTO);
			lstCompdifinfo = (List<CompdifinfoTO>) mapCompdifinfoTO
					.get("resultados");
			if (!lstCompdifinfo.isEmpty()) {
				compdifinfoTO = lstCompdifinfo.get(0);

				lstAttrdifinfo = attrdifinfoBusinessImpl
						.listarAttrdifinfo(compdifinfoTO.getCodigoCompdifinfo()
								.toString());
				compdifinfoTO.getListAttrdifinfo().addAll(lstAttrdifinfo);

				lstChargesinfo = ChargesinfoBusinessImpl
						.listarChargesinfo(compdifinfoTO.getCodigoCompdifinfo()
								.toString());
				compdifinfoTO.getListChargesinfo().addAll(lstChargesinfo);

				lstCompdifinfoSub = listarCompdifinfoBySubComponente(compdifinfoTO
						.getSubComponente().toString());
				compdifinfoTO.getListsubComponente().addAll(lstCompdifinfoSub);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return compdifinfoTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompdifinfoTO> listarCompdifinfoBySubComponente(
			String SubComponente) throws Exception {
		List<CompdifinfoTO> lstCompdifinfo = null;
		List<CompdifinfoTO> lstCompdifinfoSub = new ArrayList<CompdifinfoTO>();
		Map<String, Object> mapSubCompdifinfoTO = new HashMap<String, Object>();

		try {
			mapSubCompdifinfoTO.put("codigosSub", SubComponente);
			compdifinfoDAO
					.listarCompdifinfoBySubComponente(mapSubCompdifinfoTO);
			lstCompdifinfo = (List<CompdifinfoTO>) mapSubCompdifinfoTO
					.get("resultados");
			if (!lstCompdifinfo.isEmpty()) {
				for (CompdifinfoTO ds : lstCompdifinfo) {
					lstCompdifinfoSub.add(listarCompdifinfo(ds
							.getCodigoCompdifinfo().toString()));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstCompdifinfoSub;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompdifinfoTO> listarCompdifinfoByProducto(String Producto)
			throws Exception {
		List<CompdifinfoTO> lstCompdifinfo = null;
		List<CompdifinfoTO> lstCompdifinfoPrd = new ArrayList<CompdifinfoTO>();
		Map<String, Object> mapPrdCompdifinfoTO = new HashMap<String, Object>();

		try {
			mapPrdCompdifinfoTO.put("codigoPro", Producto);
			compdifinfoDAO.listarCompdifinfoByProducto(mapPrdCompdifinfoTO);
			lstCompdifinfo = (List<CompdifinfoTO>) mapPrdCompdifinfoTO
					.get("resultados");
			if (!lstCompdifinfo.isEmpty()) {
				for (CompdifinfoTO ds : lstCompdifinfo) {
					lstCompdifinfoPrd.add(listarCompdifinfo(ds
							.getCodigoCompdifinfo().toString()));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstCompdifinfoPrd;

	}

}
