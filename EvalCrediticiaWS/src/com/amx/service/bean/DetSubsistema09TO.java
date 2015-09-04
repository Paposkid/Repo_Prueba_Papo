package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DetSubsistema09.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DetSubsistema09TO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo único que identifica el registro corrDetallesubsistema09
	 */
	private Long corrDetallesubsistema09;
	/**
	 * Atributo único que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro fechCons
	 */
	private Integer fechCons;
	/**
	 * Atributo único que identifica el registro emprCons
	 */
	private String emprCons;
	/**
	 * Atributo único que identifica el registro infoCons
	 */
	private String infoCons;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public DetSubsistema09TO() {
		
	}
	public Long getCorrDetallesubsistema09() {
		return corrDetallesubsistema09;
	}
	public void setCorrDetallesubsistema09(Long corrDetallesubsistema09) {
		this.corrDetallesubsistema09 = corrDetallesubsistema09;
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	public Integer getFechCons() {
		return fechCons;
	}
	public void setFechCons(Integer fechCons) {
		this.fechCons = fechCons;
	}
	public String getEmprCons() {
		return emprCons;
	}
	public void setEmprCons(String emprCons) {
		this.emprCons = emprCons;
	}
	public String getInfoCons() {
		return infoCons;
	}
	public void setInfoCons(String infoCons) {
		this.infoCons = infoCons;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "DetSubsistema09TO [corrDetallesubsistema09="
				+ corrDetallesubsistema09 + ", serialVersion=" + serialVersion
				+ ", fechCons=" + fechCons + ", emprCons=" + emprCons
				+ ", infoCons=" + infoCons + ", usuario=" + usuario + "]";
	}
	
}
