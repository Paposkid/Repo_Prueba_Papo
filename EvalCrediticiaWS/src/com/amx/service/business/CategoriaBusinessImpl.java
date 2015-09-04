package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.CategoriaTO;
import com.amx.service.bean.DominioTO;
import com.amx.service.dao.CategoriaDAO;



/**
 * CategoriaBusinessImpl es una clase donde se encuentran todos los metodos ya
 * implementados, los cuales se comunicaran con el Dao para obtenber la la
 * informacion del mapeo de la DB.
 * 
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
@Service
public class CategoriaBusinessImpl implements CategoriaBusiness {

	@Autowired
	CategoriaDAO categoriaDao;

	/*
	 * Método que permite insertar una categoria por medio del DAO y guardarlo
	 * en la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.amx.service.business.CategoriaBusiness#
	 * insertarCategoria
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	public void insertarCategoria(CategoriaTO categoriaTO) throws Exception {
		try {
			categoriaDao.insertarCategoria(categoriaTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * Método que permite actualizar una categoria por medio del DAO y guardarlo
	 * en la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.amx.service.business.CategoriaBusiness#
	 * actualizarCategoria
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	public void actualizarCategoria(CategoriaTO categoriaTO) throws Exception {
		try {
			categoriaDao.actualizarCategoria(categoriaTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Método que permite listar las categorias por medio del DAO, guardados en
	 * la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @return List<CategoriaTO>
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.amx.service.business.CategoriaBusiness#
	 * listarCategorias
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaTO> listarCategorias(CategoriaTO categoriaTO) throws Exception {

		List<CategoriaTO> lstCategorias = new ArrayList<CategoriaTO>();
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();
		try {

			mapCategoriaTO.put("nombreCategoria", categoriaTO.getNombreCategoria());
			mapCategoriaTO.put("codigoCampo", categoriaTO.getCodigoCampo());
			mapCategoriaTO.put("tipoCategoria", categoriaTO.getTipoCategoria());
			mapCategoriaTO.put("estado", categoriaTO.getEstado());
			mapCategoriaTO.put("tipoRegla", categoriaTO.getTipoRegla());
			mapCategoriaTO.put("tipoCampo", categoriaTO.getTipoCampo());

			categoriaDao.listarCategorias(mapCategoriaTO);
			lstCategorias = (ArrayList<CategoriaTO>) mapCategoriaTO.get("resultados");
		} catch (Exception e) {
			throw e;
		}
		return lstCategorias;
	}

	/*
	 * Método que permite obtener una categoria por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @return CategoriaTO
	 * 
	 * @see
	 * com.amx.service.business.CategoriaBusiness#
	 * obtenerCategoriaPorCodigo
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public CategoriaTO obtenerCategoriaPorCodigo(CategoriaTO categoriaTO) throws Exception {

		CategoriaTO lCategoriaTO = new CategoriaTO();
		List<CategoriaTO> listaCategoria = null;
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();
		try {

			mapCategoriaTO.put("codigoCategoria", categoriaTO.getCodigoCategoria());
			categoriaDao.obtenerCategoriaPorCodigo(mapCategoriaTO);
			listaCategoria = (List<CategoriaTO>) mapCategoriaTO.get("resultados");

			if (!listaCategoria.isEmpty()) {
				lCategoriaTO = listaCategoria.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return lCategoriaTO;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DominioTO> listarDominiosByCategoria(CategoriaTO categoriaTO)
			throws Exception {
		
		List<DominioTO> listaDominios = null;
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();
		
		try {

			mapCategoriaTO.put("codigoCategoria", categoriaTO.getCodigoCategoria());
			categoriaDao.obtenerDominioByCategoria(mapCategoriaTO);
			listaDominios = (List<DominioTO>) mapCategoriaTO.get("resultados");

			
		} catch (Exception e) {
			throw e;
		}
		return listaDominios;
	}

	@Override
	public CategoriaTO obtenerCategoriaPorNombre(CategoriaTO categoriaTO) throws Exception {
		CategoriaTO lCategoriaTO = new CategoriaTO();
		List<CategoriaTO> listaCategoria = null;
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();
		try {

			mapCategoriaTO.put("nombreCategoria", categoriaTO.getNombreCategoria());
			categoriaDao.obtenerCategoriaPorNombre(mapCategoriaTO);
			listaCategoria = (List<CategoriaTO>) mapCategoriaTO.get("resultados");

			if (!listaCategoria.isEmpty()) {
				lCategoriaTO = listaCategoria.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return lCategoriaTO;
	}
}
