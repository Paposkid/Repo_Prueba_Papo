package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.NegFceTO;
import com.amx.service.dao.NegFceDAO;


@Service
public class NegFceBusinessImpl implements NegFceBusiness {

	private static Logger logger = Logger.getLogger(NegFceBusinessImpl.class);

	@Autowired
	private NegFceDAO negFceDAO;

	@Override
	public void insertarNegFce(NegFceTO negFceTO) throws Exception {

		try {
			negFceDAO.insertarNegFce(negFceTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public NegFceTO listNegFce(Integer codFce, Integer codLce) throws Exception {
		NegFceTO objNegFCE = null;
		List<NegFceTO> listNegFce= null;
		Map<String, Object> mapNegFceBean = new HashMap<String, Object>();

		try {
			mapNegFceBean.put("codFce", codFce);
			mapNegFceBean.put("codLce", codLce);
			negFceDAO.listNegFce(mapNegFceBean);
			listNegFce= (List<NegFceTO>) mapNegFceBean.get("resultados");
			objNegFCE= listNegFce.get(0);
		} catch (Exception e) {
				e.printStackTrace();

		}

		return objNegFCE;
	} 

	@Override
	public void actualizarEstadoNegFce(NegFceTO negFceBean) throws Exception {
		try {
			negFceDAO.actualizarEstadoNegFce(negFceBean);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NegFceTO> listNegFCEByCodLCE(Integer codLce) throws Exception {
		List<NegFceTO> listNegFceByLCE = null;
		Map<String, Object> mapNegFceBean = new HashMap<String, Object>();

		try {
			mapNegFceBean.put("codLce", codLce);
			negFceDAO.listNegFCEByCodLCE(mapNegFceBean);
			listNegFceByLCE = (List<NegFceTO>) mapNegFceBean.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listNegFceByLCE;
	}

}
