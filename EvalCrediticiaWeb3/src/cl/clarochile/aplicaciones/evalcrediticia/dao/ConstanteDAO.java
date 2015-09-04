package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;

/**
 * Clase que expone los valores y datos que hace referencia a las constantes
 * 
 * @author Daniel Ocampo Gutiérrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */
public interface ConstanteDAO {

	/**
	 * Método abstracto para insertar en la base de datos una constante.
	 * 
	 * @param constanteTO
	 */
	public void insertarConstante(ConstanteTO constanteTO);

	/**
	 * Método abstracto para actualizar una constante en la base de datos.
	 * 
	 * @param constanteTO
	 */
	public void actualizarConstante(ConstanteTO constanteTO);

	/**
	 * Método abstracto para listar las constantes que le entrega la base de
	 * datos
	 * 
	 * @param constanteTO
	 */
	public void listarConstantes(Map<String, Object> constanteTO);

	/**
	 * Método abstracto para obtener una constante por código que se entrega a
	 * la base de datos para que la base de datos retorne una constante.
	 * 
	 * @param mapConstanteTO
	 */
	public void buscarConstantePorCodigo(Map<String, Object> mapConstanteTO);
}
