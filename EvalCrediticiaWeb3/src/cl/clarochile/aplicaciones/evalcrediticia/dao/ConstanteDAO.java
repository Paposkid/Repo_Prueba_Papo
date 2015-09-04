package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;

/**
 * Clase que expone los valores y datos que hace referencia a las constantes
 * 
 * @author Daniel Ocampo Guti�rrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */
public interface ConstanteDAO {

	/**
	 * M�todo abstracto para insertar en la base de datos una constante.
	 * 
	 * @param constanteTO
	 */
	public void insertarConstante(ConstanteTO constanteTO);

	/**
	 * M�todo abstracto para actualizar una constante en la base de datos.
	 * 
	 * @param constanteTO
	 */
	public void actualizarConstante(ConstanteTO constanteTO);

	/**
	 * M�todo abstracto para listar las constantes que le entrega la base de
	 * datos
	 * 
	 * @param constanteTO
	 */
	public void listarConstantes(Map<String, Object> constanteTO);

	/**
	 * M�todo abstracto para obtener una constante por c�digo que se entrega a
	 * la base de datos para que la base de datos retorne una constante.
	 * 
	 * @param mapConstanteTO
	 */
	public void buscarConstantePorCodigo(Map<String, Object> mapConstanteTO);
}
