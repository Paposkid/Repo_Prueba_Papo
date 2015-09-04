package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Update Parametro Type.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class UpdateParametroTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro  id Parametro
	 */
	private String idParam;
	/**
	 * Atributo único que identifica el registro valor
	 */
	private String valor;
	/**
	 * Constructor que inicializa la clase
	 */
	public UpdateParametroTypeTO() {
	}
	public String getIdParam() {
		return idParam;
	}
	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "UpdateParametroTypeTO [idParam=" + idParam + ", valor=" + valor
				+ "]";
	}
	
}
