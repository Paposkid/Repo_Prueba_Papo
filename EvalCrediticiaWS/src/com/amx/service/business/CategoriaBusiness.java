package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CategoriaTO;
import com.amx.service.bean.DominioTO;




/**
 * CategoriaBusiness es una interface donde se encuentran todos los metodos a
 * ser implementados en la clase CategoriaBusinessImpl.
 * 
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public interface CategoriaBusiness {

	/**
	 * Método que permite insertar una categoria.
	 * 
	 * @param categoriaTO
	 * @throws Exception
	 */
	public void insertarCategoria(CategoriaTO categoriaTO) throws Exception;

	/**
	 * Método que permite actualizar una categoria.
	 * 
	 * @param categoriaTO
	 * @throws Exception
	 */
	public void actualizarCategoria(CategoriaTO categoriaTO) throws Exception;

	/**
	 * Método que permite listar las categorias.
	 * 
	 * @param categoriaTO
	 * @return List<CategoriaTO>
	 * @throws Exception
	 */
	public List<CategoriaTO> listarCategorias(CategoriaTO categoriaTO) throws Exception;

	/**
	 * Método que permite obtener una categoria por código.
	 * 
	 * @param categoriaTO
	 * @return CategoriaTO
	 * @throws Exception
	 */
	public CategoriaTO obtenerCategoriaPorCodigo(CategoriaTO categoriaTO) throws Exception;

	/**
	 * @param categoriaTO
	 * @return List<DominioTO>
	 * @throws Exception
	 */
	public List<DominioTO> listarDominiosByCategoria(CategoriaTO categoriaTO) throws Exception;
	/**
	 * Método que permite obtener una categoria por nombre.
	 * 
	 * @param categoriaTO
	 * @return CategoriaTO
	 * @throws Exception
	 */
	public CategoriaTO obtenerCategoriaPorNombre(CategoriaTO categoriaTO) throws Exception;

}
