package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CampoTO;



/**
 * CampoBusiness es una interfaz que permite todo lo relacionado con los m�todos
 * abstractos para la reglas del negocio.
 * 
 * 
 * @author Johann Esteban Hern�ndez [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
public interface CampoBusiness {

	/**
	 * insertarCampo es un m�todo abstracto de CampoBusiness para insertar
	 * campos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public void insertarCampo(CampoTO campoTO) throws Exception;

	/**
	 * actualizarCampo es un m�todo abstracto de CampoBusiness para actualizar
	 * campos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public void actualizarCampo(CampoTO campoTO) throws Exception;

	/**
	 * listarCampos es un m�todo abstracto de CampoBusiness para listar campos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public List<CampoTO> listarCampos(CampoTO campoTO) throws Exception;

	/**
	 * obtenerCampoPorCodigo es un m�todo abstracto de CampoBusiness para
	 * obtener el c�digo de un campo dentro de la referencia del registro.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public CampoTO obtenerCampoPorCodigo(CampoTO campoTO) throws Exception;

	/**
	 * generarReporte es un m�todo abstracto de CampoBusiness para obtener un
	 * reporte en excel del filtro realizado.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	public CampoTO obtenerCampoPorNombre(CampoTO campoTO) throws Exception;

}
