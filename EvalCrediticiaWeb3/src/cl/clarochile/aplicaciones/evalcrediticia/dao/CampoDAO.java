package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;

import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;

/**
 * CampoDao es una interfaz que permite todo lo relacionado con la base de datos
 * y con respuesta a campoBusiness.
 * 
 * 
 * @author Johann Esteban Hern�ndez [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
public interface CampoDAO {

	/**
	 * insertarCampo es un m�todo abstracto de CampoDao para insertar campos en
	 * la base de datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void insertarCampo(CampoTO campoTO);

	/**
	 * actualizarCampo es un m�todo abstracto de CampoDao para actualizar campos
	 * en la base de datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void actualizarCampo(CampoTO campoTO);

	/**
	 * listarCampo es un m�todo abstracto de CampoDao para listar campos de la
	 * base de datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void listarCampo(Map<String, Object> CampoTO);

	/**
	 * buscarCampoPorCodigo es un m�todo abstracto de CampoDao para obtener el
	 * c�digo de un campo dentro de la referencia del registro de la base de
	 * datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void buscarCampoPorCodigo(Map<String, Object> mapCampoTO);
}
