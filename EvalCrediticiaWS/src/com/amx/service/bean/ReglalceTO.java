package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Reglalce.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class ReglalceTO implements Serializable {

	/**
	 * El código representa el serial 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigoReglalce
	 */
	private Long codigoReglalce;
	/**
	 * Atributo único que identifica el registro codigolce
	 */
	private Long codigolce;
	/**
	 * Atributo único que identifica el registro codigoRegla
	 */
	private Long codigoRegla;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;

	/**
	 * Constructor que inicializa la clase 
	 */
	public ReglalceTO() {
		
	}

	public Long getCodigoReglalce() {
		return codigoReglalce;
	}

	public void setCodigoReglalce(Long codigoReglalce) {
		this.codigoReglalce = codigoReglalce;
	}

	public Long getCodigolce() {
		return codigolce;
	}

	public void setCodigolce(Long codigolce) {
		this.codigolce = codigolce;
	}

	public Long getCodigoRegla() {
		return codigoRegla;
	}

	public void setCodigoRegla(Long codigoRegla) {
		this.codigoRegla = codigoRegla;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ReglalceTO [codigoReglalce=" + codigoReglalce + ", codigolce="
				+ codigolce + ", codigoRegla=" + codigoRegla + ", usuario="
				+ usuario + "]";
	}

}
