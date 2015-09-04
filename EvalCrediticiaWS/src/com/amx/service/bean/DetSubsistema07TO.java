package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DetSubsistema07.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DetSubsistema07TO implements Serializable {

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro corrDetallesubsistema07
	 */
	private Long corrDetallesubsistema07;
	/**
	 * Atributo �nico que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo �nico que identifica el registro ctacBloq
	 */
	private String ctacBloq;
	/**
	 * Atributo �nico que identifica el registro ctacBanc
	 */
	private String ctacBanc;
	/**
	 * Atributo �nico que identifica el registrousuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public DetSubsistema07TO() {
		
	}
	public Long getCorrDetallesubsistema07() {
		return corrDetallesubsistema07;
	}
	public void setCorrDetallesubsistema07(Long corrDetallesubsistema07) {
		this.corrDetallesubsistema07 = corrDetallesubsistema07;
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersionUId) {
		this.serialVersion = serialVersionUId;
	}
	public String getCtacBloq() {
		return ctacBloq;
	}
	public void setCtacBloq(String ctacBloq) {
		this.ctacBloq = ctacBloq;
	}
	public String getCtacBanc() {
		return ctacBanc;
	}
	public void setCtacBanc(String ctacBanc) {
		this.ctacBanc = ctacBanc;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "DetSubsistema07TO [corrDetallesubsistema07="
				+ corrDetallesubsistema07 + ", serialVersion=" + serialVersion
				+ ", ctacBloq=" + ctacBloq + ", ctacBanc=" + ctacBanc
				+ ", usuario=" + usuario + "]";
	}
		
}
