package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.CampoTO;
import com.amx.service.dao.CampoDAO;



/**
 * CampoBusinessImpl es una clase que permite la comunicación con el CampoDao y
 * su base de datos
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
@Service
public class CampoBusinessImpl implements CampoBusiness {

	@Autowired
	CampoDAO campoDAO;

	/**
	 * actualizarCampo es un método que permite actualizar campos por el DAO y
	 * almacenado en la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	@Override
	public void actualizarCampo(CampoTO campoTO) throws Exception {
		try {
			campoDAO.actualizarCampo(campoTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * listarCampos es un método que permite listar campos por el DAO y
	 * mostrarlos desde la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @return listaCampos
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CampoTO> listarCampos(CampoTO campoTO) throws Exception {

		Map<String, Object> mapCampos = new HashMap<String, Object>();
		List<CampoTO> listaCampos = null;
		try {
			mapCampos.put("codigoCampo", campoTO.getCodigoCampo());
			mapCampos.put("nombreCampo", campoTO.getNombreCampo());
			mapCampos.put("tipoCampo", campoTO.getTipoCampo());
			mapCampos.put("codigoTipoRegla", campoTO.getCodigoTipoRegla());
			mapCampos.put("subTipo", campoTO.getSubTipo());
			mapCampos.put("tipoDato", campoTO.getTipoDato());
			mapCampos.put("estado", campoTO.getEstado());

			campoDAO.listarCampo(mapCampos);
			listaCampos = (List<CampoTO>) mapCampos.get("resultados");
		} catch (Exception e) {
			throw e;
		}

		return listaCampos;
	}

	/**
	 * insertarCampo es un método que permite insertar campos por el DAO y
	 * almacenarlos en la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	@Override
	public void insertarCampo(CampoTO campoTO) throws Exception {
		try {
			campoDAO.insertarCampo(campoTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * obtenerCampoPorCodigo es un método que permite a partir de un codigo de
	 * campo, obtener campos por el DAO y mostrarlos de la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @return miCampoTO
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public CampoTO obtenerCampoPorCodigo(CampoTO campoTO) throws Exception {

		CampoTO miCampoTO = null;
		List<CampoTO> listaCampos = null;
		Map<String, Object> mapCampos = new HashMap<String, Object>();

		try {
			mapCampos.put("codigoCampo", campoTO.getCodigoCampo());
			campoDAO.buscarCampoPorCodigo(mapCampos);
			listaCampos = (List<CampoTO>) mapCampos.get("resultados");
			miCampoTO = listaCampos.get(0);

		} catch (Exception e) {
			throw e;
		}

		return miCampoTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CampoTO obtenerCampoPorNombre(CampoTO campoTO) throws Exception {
		CampoTO miCampoTO = null;
		List<CampoTO> listaCampos = null;
		Map<String, Object> mapCampos = new HashMap<String, Object>();

		try {
			mapCampos.put("nombreCampo", campoTO.getNombreCampo());
			campoDAO.buscarCampoPorNombre(mapCampos);
			listaCampos = (List<CampoTO>) mapCampos.get("resultados");
			miCampoTO = listaCampos.get(0);

		} catch (Exception e) {
			throw e;
		}

		return miCampoTO;
	}


}