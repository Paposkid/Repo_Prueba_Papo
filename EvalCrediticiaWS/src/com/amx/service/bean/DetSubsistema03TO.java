package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DetSubsistema03.
 * 
 * @author Julian Montoya julian.montollapalacio@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DetSubsistema03TO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro corrDetallesubsistema03
	 */
	private Long corrDetallesubsistema03;
	
	/**
	 * Atributo único que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro codiExpl
	 */
	private String codiExpl;
	/**
	 * Atributo único que identifica el registro descExpl
	 */
	private String descExpl;
	/**
	 * Atributo único que identifica el registrousuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public DetSubsistema03TO() {
		
	}
	public Long getCorrDetallesubsistema03() {
		return corrDetallesubsistema03;
	}
	public void setCorrDetallesubsistema03(Long corrDetallesubsistema03) {
		this.corrDetallesubsistema03 = corrDetallesubsistema03;
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	
	public String getCodiExpl() {
		return codiExpl;
	}
	public void setCodiExpl(String codiExpl) {
		this.codiExpl = codiExpl;
	}
	public String getDescExpl() {
		return descExpl;
	}
	public void setDescExpl(String descExpl) {
		this.descExpl = descExpl;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "DetSubsistema03TO [corrDetallesubsistema03="
				+ corrDetallesubsistema03 + ", serialVersion=" + serialVersion
				+ ", codiExpl=" + codiExpl + ", descExpl=" + descExpl
				+ ", usuario=" + usuario + "]";
	}
		
}
