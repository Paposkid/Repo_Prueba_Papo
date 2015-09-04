package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.DominioCategoriaTO;


/**
 * Esta interfaz hace parte de la capa de la base de datos, d�nde est� todo los
 * m�todos abstractos para manipular los datos.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */

public interface DominioCategoriaDAO {

	/**
	 * M�todo abstracto para insertar un dominio en una categoria
	 * 
	 * @param DominioCategoriaTO
	 */
	public void insertarDominioCategoria(DominioCategoriaTO categoriaTO);

	/**
	 * M�todo abstracto para listar los dominios pertenecientes a una categoria
	 * 
	 * @param dominioCategoriaTO
	 */
	public void listarDominioCategorias(Map<String, Object> dominioCategoriaTO);

	/**
	 * M�todo abstracto para eliminjar logicamente un dominio de una categoria
	 * 
	 * @param DominioCategoriaTO
	 */
	public void eliminarDominioCategoria(DominioCategoriaTO categoriaTO);

}
