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
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo �nico que identifica el registro corrBanco
	 */
	private Long corrBanco;
	/**
	 * Atributo �nico que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo �nico que identifica el registro nombBcos
	 */
	private String nombBcos;
	/**
	 * Atributo �nico que identifica el registro usuario
	 */
	private Integer usuario;
	
	
	/**
	 * Constructor vacio
	 */
	public BancoTO() {
		
	}
	/**
	 * M�todo que ebtiene el CorrBanco
	 * @return
	 */
	public Long getCorrBanco() {
		return corrBanco;
	}
	/**
	 * M�todo que establece el CorrBanco
	 * @param corrBanco
	 */
	public void setCorrBanco(Long corrBanco) {
		this.corrBanco = corrBanco;
	}
	/**
	 * M�todo que obtiene  el Serial Version 
	 * @return
	 */
	public Long getSerialVersion() {
		return serialVersion;
	}
	/**
	 * M�todo que establece el Serial Version 
	 * @param serialVersionUId
	 */
	
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	/**
	 * M�todo que obtiene el Nombre de Bancos
	 * @return
	 */
	public String getNombBcos() {
		return nombBcos;
	}
	/**
	 * M�todo que establece el Nombre de Bancos
	 * @param nombBcos
	 */
	public void setNombBcos(String nombBcos) {
		this.nombBcos = nombBcos;
	}
	/**
	 * M�todo que obtiene el codigo del usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * M�todo que establece el c�digo del usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BancoTO [corrBanco=" + corrBanco + ", serialVersion="
				+ serialVersion + ", nombBcos=" + nombBcos + ", usuario="
				+ usuario + "]";
	}
		
}
