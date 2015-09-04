package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DocumentFCETO;
import com.amx.service.dao.DocumentFCEDAO;


@Service
public class DocumentFCEBusinessImpl implements DocumentFCEBusiness {

	private static Logger logger = Logger
			.getLogger(DocumentFCEBusinessImpl.class);

	@Autowired
	private DocumentFCEDAO documentFceDAO;

	@Override
	public void insertarDocumentFCE(DocumentFCETO documentFCETO)
			throws Exception {
		try {
			documentFceDAO.insertarDocumentFCE(documentFCETO);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentFCETO> buscarDocumentFCE(String codigo)
			throws Exception {
		List<DocumentFCETO> lstDocumentFCE = null;
		Map<String, Object> mapDocumentFCE = new HashMap<String, Object>();

		try {
			mapDocumentFCE.put("codDocumento", codigo);
			documentFceDAO.listarDocumentFCEById(mapDocumentFCE);
			lstDocumentFCE = (List<DocumentFCETO>) mapDocumentFCE
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstDocumentFCE;
	}

}
