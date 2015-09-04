package com.amx.service.bean;

import java.io.Serializable;

/**
 Clase que expone los valores y datos que hace referencia a SubSistema08.
 * 
 * @author Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema08TO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro nombre Empresa
	 */
	private String nombEmpr;
	/**
	 * Atributo único que identifica el registro cargo en la Empresa
	 */
	private String cargEmpr;
	/**
	 * Atributo único que identifica el registro fuente de Información
	 */
	private String fuenInfo;
	/**
	 * Atributo único que identifica el registro direccion Laboral
	 */
	private String direLabo;
	/**
	 * Atributo único que identifica el registro ciudad Laboral
	 */
	private String ciudLabo;
	/**
	 * Atributo único que identifica el registro comuna Laboral
	 */
	private String comuLabo;
	/**
	 * Atributo único que identifica el registro fecha Verificación
	 */
	private Integer fechVeri;
	/**
	 * Atributo único que identifica el registro código Usuario Alta
	 */
	private Integer codUsuarioAlta;

	/**
	 *  Constructor que inicializa la clase
	 */
	public SubSistema08TO() {
	}

	public Long getSerialVersion() {
		return serialVersion;
	}

	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}

	public String getNombEmpr() {
		return nombEmpr;
	}

	public void setNombEmpr(String nombEmpr) {
		this.nombEmpr = nombEmpr;
	}

	public String getCargEmpr() {
		return cargEmpr;
	}

	public void setCargEmpr(String cargEmpr) {
		this.cargEmpr = cargEmpr;
	}

	public String getFuenInfo() {
		return fuenInfo;
	}

	public void setFuenInfo(String fuenInfo) {
		this.fuenInfo = fuenInfo;
	}

	public String getDireLabo() {
		return direLabo;
	}

	public void setDireLabo(String direLabo) {
		this.direLabo = direLabo;
	}

	public String getCiudLabo() {
		return ciudLabo;
	}

	public void setCiudLabo(String ciudLabo) {
		this.ciudLabo = ciudLabo;
	}

	public String getComuLabo() {
		return comuLabo;
	}

	public void setComuLabo(String comuLabo) {
		this.comuLabo = comuLabo;
	}

	public Integer getFechVeri() {
		return fechVeri;
	}

	public void setFechVeri(Integer fechVeri) {
		this.fechVeri = fechVeri;
	}

	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}

	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}

	@Override
	public String toString() {
		return "SubSistema08TO [serialVersion=" + serialVersion + ", nombEmpr="
				+ nombEmpr + ", cargEmpr=" + cargEmpr + ", fuenInfo="
				+ fuenInfo + ", direLabo=" + direLabo + ", ciudLabo="
				+ ciudLabo + ", comuLabo=" + comuLabo + ", fechVeri="
				+ fechVeri + ", codUsuarioAlta=" + codUsuarioAlta + "]";
	}

}
