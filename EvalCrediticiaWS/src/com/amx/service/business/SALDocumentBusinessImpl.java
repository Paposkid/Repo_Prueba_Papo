package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.SALDocumentTO;
import com.amx.service.dao.SALDocumentDAO;


@Service
public class SALDocumentBusinessImpl implements SALDocumentBusiness {

	private static Logger logger = Logger
			.getLogger(SALDocumentBusinessImpl.class);

	@Autowired
	private SALDocumentDAO salDocumentDAO;

	@Override
	public void insertarSALDocument(SALDocumentTO sALDocumentTO)
			throws Exception {
		try {
			salDocumentDAO.insertarSALDocument(sALDocumentTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SALDocumentTO> buscarSALDocument(String codigo)
			throws Exception {

		List<SALDocumentTO> lstSALDocument = null;
		Map<String, Object> mapSALDocument = new HashMap<String, Object>();

		try {
			mapSALDocument.put("codigoDocument", codigo);
			salDocumentDAO.listarSALDocumentById(mapSALDocument);
			lstSALDocument = (List<SALDocumentTO>) mapSALDocument
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstSALDocument;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SALDocumentTO> buscarSALDocumentByNombre(String nombre) {
		List<SALDocumentTO> lstSALDocument = null;
		Map<String, Object> mapSALDocument = new HashMap<String, Object>();

		try {
			mapSALDocument.put("nombre", nombre);
			salDocumentDAO.listarSALDocumentById(mapSALDocument);
			lstSALDocument = (List<SALDocumentTO>) mapSALDocument
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstSALDocument;
	}

}
