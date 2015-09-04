package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cl.clarochile.aplicaciones.evalcrediticia.form.ParametroForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ParametroTO;

/**
 * Interfaz donde esta todo los metodos abstractos para el manejo de las reglas
 * del negocio.
 * 
 * @author Carlos Andres Castrill0n [carlos.castrillonescobar@tcs.com]
 * @since 03/17/2013
 * @version 1.0
 */

public interface ParametroBusiness {
	/**
	 * Método abstracto para insertar un Parametro
	 * 
	 * @param parametroTO
	 * @throws Exception
	 */
	public void insertarParametro(ParametroTO parametroTO) throws Exception;

	/**
	 * Método abstracto para obtener un parametro de la base de datos a través
	 * del codigo enviado dentro del objeto parametroTO.
	 * 
	 * @param parametroTO
	 * @return parametroTO
	 * @throws Exception
	 */
	public ParametroTO buscarParametroPorCodigo(ParametroTO parametroTO) throws Exception;

	/**
	 * Método abstracto para actualizar el parametro a través del codigo enviado
	 * dentro del objeto parametroTO.
	 * 
	 * @param parametroTO
	 * @throws Exception
	 */
	public void actualizarParametro(ParametroTO parametroTO) throws Exception;

	/**
	 * Método abstracto para listar todos los parametros que cumplan con los
	 * parametros de busqueda enviados en el objeto parametroTO.
	 * 
	 * @param parametroTO
	 * @return List<ParametroTO>
	 * @throws Exception
	 */
	public List<ParametroTO> listarParametros(ParametroTO ParametroTO) throws Exception;

	/**
	 * Método abstracto exportar todos los parametros que cumplan con los
	 * parametros de busqueda enviados en el objeto parametroTO.
	 * 
	 * @param parametroTO
	 * @return HSSFWorkbook
	 * @throws Exception
	 */
	public HSSFWorkbook generarReporte(ParametroForm parametroForm) throws Exception;

}
