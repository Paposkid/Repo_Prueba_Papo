package com.amx.service.business;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DominioTO;
import com.amx.service.dao.DominioDAO;



/**
 * DominioBussinessImpl es una clase donde se encuentran los diferentes metodos,
 * para realizar la administracion de los Dominios, con estos metodos nos
 * comunicamos con el dao para recibir informacion de el mapeo que hace a la DB.
 * 
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */
@Service
public class DominioBusinessImpl implements DominioBusiness {

	@Autowired
	DominioDAO dominioDao;

	/**
	 * Método que permite insertar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 * @see com.amx.service.business.DominioBusiness#insertarDominio(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	public void insertarDominio(DominioTO dominioTO) throws Exception {

		try {
			dominioDao.insertarDominio(dominioTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método que permite actualizar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 * @see com.amx.service.business.DominioBusiness#actualizarDominio(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	public void actualizarDominio(DominioTO dominioTO) throws Exception {

		try {
			dominioDao.actualizarDominio(dominioTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método que permite listar un dominio por medio del DAO y guardarlo en la
	 * DB
	 * 
	 * @return List<DominioTO>
	 * @throws Exception
	 * @see com.amx.service.business.DominioBusiness#listarDominio()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DominioTO> listarDominio() throws Exception {

		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {
			dominioDao.listarDominio(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

		} catch (Exception e) {
			throw e;
		}

		return lstDominios;
	}

	/**
	 * Método que permite obtener un dominio por codigo por medio del DAO y
	 * guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return DominioTO
	 * @throws Exception
	 * @see com.amx.service.business.DominioBusiness#obtenerDominioPorCodigo(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public DominioTO obtenerDominioPorCodigo(DominioTO dominioTO) throws Exception {

		DominioTO dominio = new DominioTO();
		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {

			mapDominioTO.put("codigo", dominioTO.getCodigo());
			dominioDao.obtenerDominioPorCodigo(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

			if (!lstDominios.isEmpty()) {
				dominio = lstDominios.get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return dominio;
	}

	/**
	 * Método que permite buscar un dominio por varios campos por medio del DAO
	 * y guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return List<DominioTO>
	 * @throws Exception
	 * @see com.amx.service.business.DominioBusiness#buscarDominioPorCampos(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DominioTO> buscarDominioPorCampos(DominioTO dominioTO) throws Exception {

		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {

			mapDominioTO.put("codigo", dominioTO.getCodigo());
			mapDominioTO.put("nombre", dominioTO.getNombre());
			mapDominioTO.put("tipoCaracter", dominioTO.getTipoCaracter());
			mapDominioTO.put("tipoDato", dominioTO.getTipoDato());
			mapDominioTO.put("estado", dominioTO.getEstado());
			mapDominioTO.put("valor", dominioTO.getValor());

			dominioDao.buscarDominioPorCampos(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

		} catch (Exception e) {
			throw e;
		}
		return lstDominios;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DominioTO obtenerDominioPorNombre(DominioTO dominioTO) throws Exception {
		DominioTO dominio = new DominioTO();
		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {

			mapDominioTO.put("nombre", dominioTO.getNombre());
			dominioDao.obtenerDominioPorNombre(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

			if (!lstDominios.isEmpty()) {
				dominio = lstDominios.get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return dominio;
	}

}
