package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;

import cl.clarochile.aplicaciones.evalcrediticia.to.ParametroTO;

/**
 * Clase que expone los valores y datos que hace referencia a los Parametros
 * 
 * @author Carlos Andres Castrill0n [carlos.castrillonescobar@tcs.com]
 * @since 03/17/2013
 * @version 1.0
 */
public interface ParametroDAO {

	/**
	 * Método abstracto para insertar en la base de datos un Parametro.
	 * 
	 * @param parametroTO
	 * @throws Exception
	 */
	public void insertarParametro(ParametroTO parametroTO);

	/**
	 * Método abstracto para actualizar un parametro en la base de datos.
	 * 
	 * @param parametroTO
	 * @throws Exception
	 */
	public void actualizarParametro(ParametroTO parametroTO);

	/**
	 * Método abstracto para obtener un parametro por código que se entrega a la
	 * base de datos para que la base de datos retorne un parametro.
	 * 
	 * @param mapParametroTO
	 * @throws Exception
	 */
	public void buscarParametroPorCodigo(Map<String, Object> mapParametroTO);

	/**
	 * Método abstracto para listar los Parametros que le entrega la base de
	 * datos.
	 * 
	 * @param parametroTO
	 *            .
	 * @throws Exception
	 */
	public void listarParametro(Map<String, Object> parametroTO);

}
