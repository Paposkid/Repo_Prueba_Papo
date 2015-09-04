package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DocExtraTO;
import com.amx.service.dao.DocExtraDAO;


@Service
public class DocExtraBusinessImpl implements DocExtraBusiness {

	private static Logger logger = Logger.getLogger(DocExtraBusinessImpl.class);

	@Autowired
	private DocExtraDAO docExtraDAO;

	@Override
	public void insertarDocExtra(DocExtraTO docExtraTO) throws Exception {
		try {
			docExtraDAO.insertarDocExtra(docExtraTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocExtraTO> buscarDocExtra(String codigo) throws Exception {

		List<DocExtraTO> lstDocExtra = null;
		Map<String, Object> mapDocExtra = new HashMap<String, Object>();

		try {
			mapDocExtra.put("codDocExtra", codigo);
			docExtraDAO.listarDocExtraById(mapDocExtra);
			lstDocExtra = (List<DocExtraTO>) mapDocExtra.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstDocExtra;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocExtraTO> buscarDocExtraByNombre(String nombre) {
		List<DocExtraTO> lstDocExtra = null;
		Map<String, Object> mapDocExtra = new HashMap<String, Object>();

		try {
			mapDocExtra.put("nombre", nombre);
			docExtraDAO.listarDocExtraById(mapDocExtra);
			lstDocExtra = (List<DocExtraTO>) mapDocExtra.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstDocExtra;

	}

}
