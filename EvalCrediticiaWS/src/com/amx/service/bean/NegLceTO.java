package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a NegLce.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class NegLceTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro codLce
	 */
	private Long codLce;
	/**
	 *  Atributo único que identifica el registro nroOrden
	 */
	private Integer nroOrden;
	/**
	 *  Atributo único que identifica el registro plusGold
	 */
	private Integer plusGold;
	/**
	 *  Atributo único que identifica el registro previred
	 */
	private Integer previred;
	/**
	 *  Atributo único que identifica el registro equiFax
	 */
	private Integer equiFax;
	/**
	 *  Atributo único que identifica el registro codAmdocs
	 */
	private Integer codAmdocs;
	/**
	 *  Atributo único que identifica el registro estado
	 */
	private String estado;
	/**
	 *  Atributo único que identifica el registro fechaAlta
	 */
	private Date fechaAlta;
	/**
	 *  Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 *  Atributo único que identifica el registro fechaModificacion
	 */
	private Date fechaModificacion;
	/**
	 *  Atributo único que identifica el registro codUsuarioModificacion
	 */
	private Integer codUsuarioModificacion;
	
	/**
	 * Constructor vacio
	 */
	public NegLceTO() {
		
	}
	public Long getCodLce() {
		return codLce;
	}
	public void setCodLce(Long codLce) {
		this.codLce = codLce;
	}
	public Integer getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(Integer nroOrden) {
		this.nroOrden = nroOrden;
	}
	public Integer getPlusGold() {
		return plusGold;
	}
	public void setPlusGold(Integer plusGold) {
		this.plusGold = plusGold;
	}
	public Integer getPrevired() {
		return previred;
	}
	public void setPrevired(Integer previred) {
		this.previred = previred;
	}
	public Integer getEquiFax() {
		return equiFax;
	}
	public void setEquiFax(Integer equiFax) {
		this.equiFax = equiFax;
	}
	public Integer getCodAmdocs() {
		return codAmdocs;
	}
	public void setCodAmdocs(Integer codAmdocs) {
		this.codAmdocs = codAmdocs;
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
		return "NegLceTO [codLce=" + codLce + ", nroOrden=" + nroOrden
				+ ", plusGold=" + plusGold + ", previred=" + previred
				+ ", equiFax=" + equiFax + ", codAmdocs=" + codAmdocs
				+ ", estado=" + estado + ", fechaAlta=" + fechaAlta
				+ ", codUsuarioAlta=" + codUsuarioAlta + ", fechaModificacion="
				+ fechaModificacion + ", codUsuarioModificacion="
				+ codUsuarioModificacion + "]";
	}
		
}
