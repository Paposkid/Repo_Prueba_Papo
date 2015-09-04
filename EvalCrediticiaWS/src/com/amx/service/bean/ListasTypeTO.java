package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a ListasType.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ListasTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro idLista
	 */
	private Integer idLista;
	/**
	 * Atributo único que identifica el registro nombreLista
	 */
	private String nombreLista;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ListasTypeTO() {
		
	}
	public Integer getIdLista() {
		return idLista;
	}
	public void setIdLista(Integer idLista) {
		this.idLista = idLista;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	@Override
	public String toString() {
		return "ListasTypeTO [idLista=" + idLista + ", nombreLista="
				+ nombreLista + "]";
	}
	
}
