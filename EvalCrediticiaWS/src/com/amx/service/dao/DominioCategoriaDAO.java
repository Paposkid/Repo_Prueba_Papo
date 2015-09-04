package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.DominioCategoriaTO;


/**
 * Esta interfaz hace parte de la capa de la base de datos, dónde está todo los
 * métodos abstractos para manipular los datos.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */

public interface DominioCategoriaDAO {

	/**
	 * Método abstracto para insertar un dominio en una categoria
	 * 
	 * @param DominioCategoriaTO
	 */
	public void insertarDominioCategoria(DominioCategoriaTO categoriaTO);

	/**
	 * Método abstracto para listar los dominios pertenecientes a una categoria
	 * 
	 * @param dominioCategoriaTO
	 */
	public void listarDominioCategorias(Map<String, Object> dominioCategoriaTO);

	/**
	 * Método abstracto para eliminjar logicamente un dominio de una categoria
	 * 
	 * @param DominioCategoriaTO
	 */
	public void eliminarDominioCategoria(DominioCategoriaTO categoriaTO);

}
