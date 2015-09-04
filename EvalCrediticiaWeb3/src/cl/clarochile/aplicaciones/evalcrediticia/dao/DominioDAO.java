package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;

/**
 * Dao interface esta clase tiene los diferentes m�todos de la clase Dominio que
 * necesitamos para capturar informaci�n de la base de datos
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */

public interface DominioDAO {

	/**
	 * M�todo que permite insertar un dominio por medio de un mapeo a la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 */
	public void insertarDominio(DominioTO dominioTO) throws Exception;

	/**
	 * M�todo que permite actualizar un dominio por medio de un mapeo a la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 */
	public void actualizarDominio(DominioTO dominioTO) throws Exception;

	/**
	 * M�todo que permite listar un dominio por medio de un mapeo a la DB
	 * 
	 * @param Map
	 *            <String, Object>
	 * @throws Exception
	 */
	public void listarDominio(Map<String, Object> dominioTO) throws Exception;

	/**
	 * M�todo que permite obtener un dominio por codigo por medio de un mapeo a
	 * la DB
	 * 
	 * @param Map
	 *            <String, Object>
	 * @throws Exception
	 */
	public void obtenerDominioPorCodigo(Map<String, Object> dominioTO) throws Exception;

	/**
	 * M�todo que permite buscar un dominio por varios campos por medio de un
	 * mapeo a la DB
	 * 
	 * @param Map
	 *            <String, Object>
	 * @throws Exception
	 */
	public void buscarDominioPorCampos(Map<String, Object> dominioTO) throws Exception;

}
