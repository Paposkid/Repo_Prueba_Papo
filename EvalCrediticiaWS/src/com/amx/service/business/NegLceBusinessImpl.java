package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.NegLceTO;
import com.amx.service.dao.NegLceDAO;


@Service
public class NegLceBusinessImpl implements NegLceBusiness {

	private static Logger logger = Logger.getLogger(NegLceBusinessImpl.class);

	@Autowired
	private NegLceDAO negLceDAO;

	@Override
	public void insertarNegLce(NegLceTO negLceTO) throws Exception {

		try {
			negLceDAO.insertarNegLce(negLceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NegLceTO> listNegLce(Integer codLce) throws Exception {

		List<NegLceTO> listNegLce = null;
		Map<String, Object> mapNegLceBean = new HashMap<String, Object>();

		try {

			mapNegLceBean.put("codLce", codLce);
			negLceDAO.listNegLce(mapNegLceBean);
			listNegLce = (List<NegLceTO>) mapNegLceBean.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listNegLce;
	}

	@Override
	public void actualizarNegLce(NegLceTO negLceTO) throws Exception {

		try {
			negLceDAO.actualizarNegLce(negLceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public NegLceTO listNegLceOrder(Integer nroOrden) throws Exception {
		List<NegLceTO> listNegLceOrder = null;
		NegLceTO negLceTO = new NegLceTO();
		Map<String, Object> mapNegLceBean = new HashMap<String, Object>();

		try {

			mapNegLceBean.put("nroOrden", nroOrden);
			negLceDAO.listNegLceOrder(mapNegLceBean);
			listNegLceOrder = (List<NegLceTO>) mapNegLceBean.get("resultados");
			if (!listNegLceOrder.isEmpty()) {
				negLceTO = listNegLceOrder.get(0);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return negLceTO;
	}

	@Override
	public void actualizarEstadoNegLce(NegLceTO negLceBean) throws Exception {
		try {
			negLceDAO.actualizarEstadoNegLce(negLceBean);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
