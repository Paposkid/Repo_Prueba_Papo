package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.CampoTO;




/**
 * CampoDao es una interfaz que permite todo lo relacionado con la base de datos
 * y con respuesta a campoBusiness.
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
public interface CampoDAO {

	/**
	 * insertarCampo es un método abstracto de CampoDao para insertar campos en
	 * la base de datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void insertarCampo(CampoTO campoTO) throws Exception  ;

	/**
	 * actualizarCampo es un método abstracto de CampoDao para actualizar campos
	 * en la base de datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void actualizarCampo(CampoTO campoTO) throws Exception  ;

	/**
	 * listarCampo es un método abstracto de CampoDao para listar campos de la
	 * base de datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void listarCampo(Map<String, Object> CampoTO) throws Exception  ;

	/**
	 * buscarCampoPorCodigo es un método abstracto de CampoDao para obtener el
	 * código de un campo dentro de la referencia del registro de la base de
	 * datos.
	 * 
	 * 
	 * @param campoTO
	 */
	public void buscarCampoPorCodigo(Map<String, Object> mapCampoTO) throws Exception  ;
	
	/**
	 * buscarCampoPorNombre es un método abstracto de CampoDao 
	 * para obtener un registro de campos buscando por el nombre del campo.
	 * 
	 * 
	 * @param campoTO
	 */
	public void buscarCampoPorNombre(Map<String, Object> mapCampoTO) throws Exception  ;
}
