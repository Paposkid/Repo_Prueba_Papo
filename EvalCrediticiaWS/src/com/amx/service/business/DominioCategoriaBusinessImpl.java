package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DominioCategoriaTO;
import com.amx.service.dao.DominioCategoriaDAO;


/**
 * DominioCategoriaBusinessImpl es una clase donde se encuentran todos los
 * metodos ya implementados, los cuales se comunicaran con el Dao para obtenber
 * la la informacion del mapeo de la DB.
 * 
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */

@Service
public class DominioCategoriaBusinessImpl implements DominioCategoriaBusiness {

	@Autowired
	DominioCategoriaDAO dominioCategoriaDao;

	/*
	 * Método que permite insertar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @see
	 * com.amx.service.business.DominioCategoriaBusiness
	 * #insertarDominioCategoria(cl.clarochile.aplicaciones.evalcrediticia.to.
	 * DominioCategoriaTO)
	 */
	@Override
	public void insertarDominioCategoria(DominioCategoriaTO dominioCategoriaTO) throws Exception {
		try {
			dominioCategoriaDao.insertarDominioCategoria(dominioCategoriaTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * Método que permite listar los dominios por medio del DAO, guardados en la
	 * DB y y que le pertenecen a una categoria
	 * 
	 * @see
	 * com.amx.service.business.DominioCategoriaBusiness
	 * #listarDominioCategorias(cl.clarochile.aplicaciones.evalcrediticia.to.
	 * DominioCategoriaTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DominioCategoriaTO> listarDominioCategorias(DominioCategoriaTO dominioCategoriaTO) throws Exception {

		List<DominioCategoriaTO> listaDominioCategoria = new ArrayList<DominioCategoriaTO>();
		Map<String, Object> mapDomCatTO = new HashMap<String, Object>();

		try {
			mapDomCatTO.put("codigoCategoria", dominioCategoriaTO.getCategoria().getCodigoCategoria());
			dominioCategoriaDao.listarDominioCategorias(mapDomCatTO);
			listaDominioCategoria = (List<DominioCategoriaTO>) mapDomCatTO.get("resultadosDomCat");
		} catch (Exception e) {
			throw e;
		}

		return listaDominioCategoria;
	}

	/*
	 * Método que permite eliminar(Logicamente) un dominio perteneciente
	 * categoria
	 * 
	 * @see
	 * com.amx.service.business.DominioCategoriaBusiness
	 * #eliminarDominioCategoria(cl.clarochile.aplicaciones.evalcrediticia.to.
	 * DominioCategoriaTO)
	 */
	@Override
	public void eliminarDominioCategoria(DominioCategoriaTO dominioCategoriaTO) throws Exception {
		try {

			dominioCategoriaDao.eliminarDominioCategoria(dominioCategoriaTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
