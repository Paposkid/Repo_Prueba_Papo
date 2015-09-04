package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a Actual list request type.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ActualListRequestTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que identifica el registro id transaccion
	 */
	private String idTransaccion;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ActualListRequestTypeTO() {
	}

	/**
	 * Método que obtiene el id de la transaccion
	 * @return
	 */
	public String getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * Método que establece el id de la transaccion
	 * @param idTransaccion
	 */
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActualListRequestTypeTO [idTransaccion=" + idTransaccion + "]";
	}
	
		
}
