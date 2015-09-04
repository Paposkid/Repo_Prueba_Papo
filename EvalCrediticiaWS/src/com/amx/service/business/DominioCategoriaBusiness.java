package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DominioCategoriaTO;


/**
 * DominioCategoriaBusiness es una interface donde se encuentran todos los
 * metodos a ser implementados en la clase DominioCategoriaBusinessImpl.
 * 
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public interface DominioCategoriaBusiness {

	/**
	 * Método que permite insertar un dominio a una categoria.
	 * 
	 * @param dominioCategoriaTO
	 * @throws Exception
	 */
	public void insertarDominioCategoria(DominioCategoriaTO dominioCategoriaTO) throws Exception;

	/**
	 * Método que permite listar los dominios asociados a una categoria
	 * 
	 * @param dominioCategoriaTO
	 * @return
	 * @throws Exception
	 */
	public List<DominioCategoriaTO> listarDominioCategorias(DominioCategoriaTO dominioCategoriaTO) throws Exception;

	/**
	 * Método que permite eliminar(logico), desasociar un dominio a una
	 * categoria.
	 * 
	 * @param dominioCategoriaTO
	 * @throws Exception
	 */
	public void eliminarDominioCategoria(DominioCategoriaTO dominioCategoriaTO) throws Exception;

}
