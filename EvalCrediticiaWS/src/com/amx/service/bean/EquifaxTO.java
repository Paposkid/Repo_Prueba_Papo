package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a Equifax.
 * 
 * @author Julian Montoya julian.montollapalacio@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class EquifaxTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigoEquifax
	 */
	private Long codigoEquifax;
	/**
	 * Atributo único que identifica el registro autorizacion;
	 */
	private String autorizacion;
	/**
	 * Atributo único que identifica el registro cantdetalle
	 */
	private Integer cantdetalle;
	/**
	 * Atributo único que identifica el registro fechaConsultado
	 */
	private Date fechaConsultado;
	/**
	 * Atributo único que identifica el registro estado
	 */
	private String estado;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica el registro origen
	 */
	private String origen;
	/**
	 * Atributo único que identifica la lista de objetos listEquifaxDetalle
	 */
	private List<EquifaxDetalleTO> listEquifaxDetalle;

	/**
	 * Constructor que inicializa la clase
	 */
	public EquifaxTO() {
		
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Long getCodigoEquifax() {
		return codigoEquifax;
	}

	public void setCodigoEquifax(Long codigoEquifax) {
		this.codigoEquifax = codigoEquifax;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public Integer getCantdetalle() {
		return cantdetalle;
	}

	public void setCantdetalle(Integer cantdetalle) {
		this.cantdetalle = cantdetalle;
	}

	public Date getFechaConsultado() {
		return fechaConsultado;
	}

	public void setFechaConsultado(Date fechaConsultado) {
		this.fechaConsultado = fechaConsultado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public List<EquifaxDetalleTO> getListEquifaxDetalle() {
		if(listEquifaxDetalle == null)
			listEquifaxDetalle = new ArrayList<EquifaxDetalleTO>();
		return listEquifaxDetalle;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getOrigen() {
		return origen;
	}

	@Override
	public String toString() {
		return "EquifaxTO [codigoEquifax=" + codigoEquifax + ", autorizacion="
				+ autorizacion + ", cantdetalle=" + cantdetalle
				+ ", fechaConsultado=" + fechaConsultado + ", estado=" + estado
				+ ", usuario=" + usuario + ", origen=" + origen
				+ ", listEquifaxDetalle=" + listEquifaxDetalle + "]";
	}

}
