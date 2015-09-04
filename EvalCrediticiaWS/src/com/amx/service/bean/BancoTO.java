package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Banco.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class BancoTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo único que identifica el registro corrBanco
	 */
	private Long corrBanco;
	/**
	 * Atributo único que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro nombBcos
	 */
	private String nombBcos;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	
	
	/**
	 * Constructor vacio
	 */
	public BancoTO() {
		
	}
	/**
	 * Método que ebtiene el CorrBanco
	 * @return
	 */
	public Long getCorrBanco() {
		return corrBanco;
	}
	/**
	 * Método que establece el CorrBanco
	 * @param corrBanco
	 */
	public void setCorrBanco(Long corrBanco) {
		this.corrBanco = corrBanco;
	}
	/**
	 * Método que obtiene  el Serial Version 
	 * @return
	 */
	public Long getSerialVersion() {
		return serialVersion;
	}
	/**
	 * Método que establece el Serial Version 
	 * @param serialVersionUId
	 */
	
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	/**
	 * Método que obtiene el Nombre de Bancos
	 * @return
	 */
	public String getNombBcos() {
		return nombBcos;
	}
	/**
	 * Método que establece el Nombre de Bancos
	 * @param nombBcos
	 */
	public void setNombBcos(String nombBcos) {
		this.nombBcos = nombBcos;
	}
	/**
	 * Método que obtiene el codigo del usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Método que establece el código del usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BancoTO [corrBanco=" + corrBanco + ", serialVersion="
				+ serialVersion + ", nombBcos=" + nombBcos + ", usuario="
				+ usuario + "]";
	}
		
}
