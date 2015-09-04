package com.amx.service.business;


import java.util.List;

import com.amx.service.bean.ParametroTO;


/**
 * Interfaz donde esta todo los metodos abstractos para el manejo de las reglas
 * del negocio.
 * 
 * @author Jorge Armado Montoya J. [jorge.montoyajaramillo@tcs.com]
 * @since 04/08/2013
 * @version 1.0
 */

public interface ParametroBusiness {
	

	/**
	 * Método abstracto para obtener un parametro de la base de datos a través
	 * del codigo enviado dentro del objeto parametroTO.
	 * 
	 * @param nombreParametro
	 * @return parametroTO
	 * @throws Exception
	 */
	public ParametroTO buscarParametroPorNombre(String nombreParametro) throws Exception;
	public List<ParametroTO> buscarParametroPorNomb(String nombreParametro) throws Exception;
}
