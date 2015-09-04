package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.NegExcepcionTO;
import com.amx.service.dao.NegExcepcionDAO;


@Service
public class NegExcepcionBusinessImpl implements NegExcepcionBusiness {

	private static Logger logger = Logger
			.getLogger(NegExcepcionBusinessImpl.class);

	@Autowired
	private NegExcepcionDAO negExcepcionDAO;

	@Override
	public void insertarNegExcepcion(NegExcepcionTO negExcepcionTO)
			throws Exception {

		try {
			negExcepcionDAO.insertarNegExcepcion(negExcepcionTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NegExcepcionTO> listNegExcepcion(Integer codExcepcion)
			throws Exception {

		List<NegExcepcionTO> listNegExcepcion = null;
		Map<String, Object> mapNegExcepcionBean = new HashMap<String, Object>();

		try {

			mapNegExcepcionBean.put("codExcepcion", codExcepcion);
			negExcepcionDAO.listNegExcepcion(mapNegExcepcionBean);
			listNegExcepcion = (List<NegExcepcionTO>) mapNegExcepcionBean
					.get("resultados");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listNegExcepcion;
	}

	@Override
	public void actualizarEstadoNegExcepcion(NegExcepcionTO negExcepcionTO)
			throws Exception {
		try {
			negExcepcionDAO.actualizarEstadoNegExcepcion(negExcepcionTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public NegExcepcionTO buscarNegExcepcionPorCodExcepcion(Integer codExcepcion)
			throws Exception {
		NegExcepcionTO miNegExcepcion = null;
		List<NegExcepcionTO> listNegExcepcion = null;
		Map<String, Object> mapNegExcepcionBean = new HashMap<String, Object>();

		try {

			mapNegExcepcionBean.put("codExcepcion", codExcepcion);
			
			negExcepcionDAO.listNegExcepcion(mapNegExcepcionBean);
			listNegExcepcion = (List<NegExcepcionTO>) mapNegExcepcionBean
					.get("resultados");
			if (!listNegExcepcion.isEmpty()) {
				miNegExcepcion = listNegExcepcion.get(0);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return miNegExcepcion;
	}

}
