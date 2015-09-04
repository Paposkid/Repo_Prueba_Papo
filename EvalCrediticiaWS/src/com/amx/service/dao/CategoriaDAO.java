package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.CategoriaTO;




/**
 * Esta interfaz hace parte de la capa de la base de datos, donde est� todo los
 * m�todos abstractos para manipular los datos
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public interface CategoriaDAO {

	/**
	 * M�todo abstracto para insertar una categoria
	 * 
	 * @param categoriaTO
	 */
	public void insertarCategoria(CategoriaTO categoriaTO);

	/**
	 * M�todo abstracto para listar las categoria
	 * 
	 * @param categoriaTO
	 */
	public void listarCategorias(Map<String, Object> categoriaTO);

	/**
	 * M�todo abstracto para modificar una categoria
	 * 
	 * @param categoriaTO
	 */
	public void actualizarCategoria(CategoriaTO categoriaTO);

	/**
	 * M�todo abstracto para obtener una categpria por codigo
	 * 
	 * @param mapCategoriaTO
	 */
	public void obtenerCategoriaPorCodigo(Map<String, Object> mapCategoriaTO);
	
	/**
	 * @param categoriaTO
	 */
	public void obtenerDominioByCategoria(Map<String, Object> categoriaTO);
	/**
	 * M�todo abstracto para obtener una categpria por nombre
	 * 
	 * @param mapCategoriaTO
	 */
	public void obtenerCategoriaPorNombre(Map<String, Object> mapCategoriaTO);
	
}
