package com.amx.service.bean;


import java.io.Serializable;

/**
*Clase que expone los valores y datos que hace referencia a ExcFce.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ExcFceTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codExcFce
	 */
	private Long codExcFce;
	/**
	 * Atributo único que identifica el registro codFce
	 */
	private Long codFce;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor vacio
	 */
	public ExcFceTO() {
		
	}
	public Long getCodExcFce() {
		return codExcFce;
	}
	public void setCodExcFce(Long codExcFce) {
		this.codExcFce = codExcFce;
	}
	public Long getCodFce() {
		return codFce;
	}
	public void setCodFce(Long codFce) {
		this.codFce = codFce;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ExcFceTO [codExcFce=" + codExcFce + ", codFce=" + codFce
				+ ", codUsuarioAlta=" + codUsuarioAlta + "]";
	}
	
	
}
