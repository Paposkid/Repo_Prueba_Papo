package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ConstanteTO;




/**
 * Interfaz donde esta todo los metodos abstractos para el manejo de las reglas
 * del negocio.
 * 
 * @author Daniel Ocampo Guti�rrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */

public interface ConstanteBusiness {

	/**
	 * M�todo abstracto para insertar una constante
	 * 
	 * @param constanteTO
	 * @throws Exception
	 */
	public void insertarConstante(ConstanteTO constanteTO) throws Exception;

	/**
	 * M�todo abstracto para actualizar la constante a trav�s del codigo enviado
	 * dentro del objeto constanteTO.
	 * 
	 * @param constanteTO
	 * @throws Exception
	 */
	public void actualizarConstante(ConstanteTO constanteTO) throws Exception;

	/**
	 * M�todo abstracto para listar todas las constantes que cumplan con los
	 * parametros de busqueda enviados en el objeto constanteTO.
	 * 
	 * @param constanteTO
	 * @return ListConstanteTO
	 * @throws Exception
	 */

	public List<ConstanteTO> listarConstantes(ConstanteTO constanteTO) throws Exception;

	/**
	 * M�todo abstracto para obtener una constante de la base de datos a trav�s
	 * del codigo enviado dentro del objeto constanteTO.
	 * 
	 * @param constanteTO
	 * @return ConstanteTO
	 * @throws Exception
	 */
	public ConstanteTO obtenerConstantePorCodigo(ConstanteTO constanteTO) throws Exception;

	/**
	 * M�todo abstracto para obtener una constante de la base de datos a trav�s
	 * del nombre enviado dentro del objeto constanteTO.
	 * 
	 * @param constanteTO
	 * @return ConstanteTO
	 * @throws Exception
	 */
	public ConstanteTO obtenerConstantePorNombre(ConstanteTO constanteTO) throws Exception;


}
