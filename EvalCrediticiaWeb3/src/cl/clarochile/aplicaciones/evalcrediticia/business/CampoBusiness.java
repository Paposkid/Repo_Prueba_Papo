package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cl.clarochile.aplicaciones.evalcrediticia.form.CampoForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;

/**
 * CampoBusiness es una interfaz que permite todo lo relacionado con los métodos
 * abstractos para la reglas del negocio.
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
public interface CampoBusiness {

	/**
	 * insertarCampo es un método abstracto de CampoBusiness para insertar
	 * campos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public void insertarCampo(CampoTO campoTO) throws Exception;

	/**
	 * actualizarCampo es un método abstracto de CampoBusiness para actualizar
	 * campos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public void actualizarCampo(CampoTO campoTO) throws Exception;

	/**
	 * listarCampos es un método abstracto de CampoBusiness para listar campos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public List<CampoTO> listarCampos(CampoTO campoTO) throws Exception;

	/**
	 * obtenerCampoPorCodigo es un método abstracto de CampoBusiness para
	 * obtener el código de un campo dentro de la referencia del registro.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public CampoTO obtenerCampoPorCodigo(CampoTO campoTO) throws Exception;

	/**
	 * generarReporte es un método abstracto de CampoBusiness para obtener un
	 * reporte en excel del filtro realizado.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public HSSFWorkbook generarReporte(CampoForm campoForm) throws Exception;
}
