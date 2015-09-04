package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a NegExcepcion.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class NegExcepcionTO implements Serializable {

	/**
	 *  El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codExcepcion
	 */
	private Long codExcepcion;
	/**
	 * Atributo único que identifica el registro estado
	 */
	private String estado;
	/**
	 * Atributo único que identifica el registro fechaAlta
	 */
	private Date fechaAlta;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo único que identifica el registro fechaModificacion
	 */
	private Date fechaModificacion;
	/**
	 * Atributo único que identifica el registro codUsuarioModificacion
	 */
	private Integer codUsuarioModificacion;
	
	/**
	 *  Constructor vacio
	 */
	public NegExcepcionTO() {
		
	}
	public Long getCodExcepcion() {
		return codExcepcion;
	}
	public void setCodExcepcion(Long codExcepcion) {
		this.codExcepcion = codExcepcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Integer getCodUsuarioModificacion() {
		return codUsuarioModificacion;
	}
	public void setCodUsuarioModificacion(Integer codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}
	@Override
	public String toString() {
		return "NegExcepcionTO [codExcepcion=" + codExcepcion + ", estado="
				+ estado + ", fechaAlta=" + fechaAlta + ", codUsuarioAlta="
				+ codUsuarioAlta + ", fechaModificacion=" + fechaModificacion
				+ ", codUsuarioModificacion=" + codUsuarioModificacion
				+ ", getCodExcepcion()=" + getCodExcepcion() + ", getEstado()="
				+ getEstado() + ", getFechaAlta()=" + getFechaAlta()
				+ ", getCodUsuarioAlta()=" + getCodUsuarioAlta()
				+ ", getFechaModificacion()=" + getFechaModificacion()
				+ ", getCodUsuarioModificacion()="
				+ getCodUsuarioModificacion() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
