package com.amx.service.dao;

import java.util.Map;


/**
 * Clase que expone los valores y datos que hace referencia a los Parametros
 * 
 * @author Jorge Armado Montoya J. [jorge.montoyajaramillo@tcs.com]
 * @since 04/08/2013
 * @version 1.0
 */
public interface ParametroDAO {


	/**
	 * Método abstracto para obtener un parametro por nombre que se entrega a la
	 * base de datos para que la base de datos retorne un parametro.
	 * 
	 * @param mapParametroTO
	 * @throws Exception 
	 */
	public void buscarParametroPorNombre(Map<String, Object> mapParametroTO);

	/**
	 * Método abstracto para obtener una lista de parametros cuyo nombre sea igual o se encuentre contenido
	 * dentro del nombre enviado como parametro a través de un objeto tipo parametro.
	 * 
	 * @param mapParametroTO
	 * @throws Exception 
	 */
	public void buscarParametroPorNomb(Map<String, Object> mapParametroTO);

	

}
