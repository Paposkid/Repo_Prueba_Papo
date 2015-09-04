package com.amx.service.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * CampoTO es una clase que contiene los objetos de transferencia de datos que
 * hace referencia a los campos
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
public class CampoTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * codigoCampo es un atributo que contiene el codigo del campo
	 */
	private String codigoCampo;

	/**
	 * codigoTipoRegla es un atributo que contiene el codigo del tipo de regla
	 * Full Credit Evaluation o Ligth Credit Evaluation
	 */
	private String codigoTipoRegla;

	/**
	 * tipoCampo es un atributo que contiene el tipo campo de entreda o salida
	 */
	private String tipoCampo;

	/**
	 * nombreCampo es un atributo que contiene el nombre del campo
	 */
	private String nombreCampo;

	/**
	 * subTipo es un atributo que contiene el subtipo de campo simple o múltiple
	 */
	private String subTipo;

	/**
	 * tipoDato es un atributo que contiene el tipo de dato numérico o de texto
	 */
	private String tipoDato;

	/**
	 * estado es un atributo que contiene el estadp activo o inactivo del campo
	 */
	private String estado;

	/**
	 * fechaAlta es un atributo que contiene la fecha de creacion del campo
	 */
	private Date fechaAlta;

	/**
	 * codigoUsuarioAlta es un atributo que contiene el codigo del usuario que
	 * creo el campo
	 */
	private int codigoUsuarioAlta;

	/**
	 * fechaModificacion es un atributo que contiene la fecha de modificacion
	 * del campo
	 */
	private Date fechaModificacion;

	/**
	 * codigoUsuario es un atributo que contiene el codigo del usuario que
	 * modifico el campo
	 */
	private int codigoUsuario;
	
	/**
	 * Constructor vacio
	 */
	public CampoTO() {
		
	}

	/**
	 * Método que obtiene el CodigoCampo
	 * @return
	 */
	public String getCodigoCampo() {
		return codigoCampo;
	}

	/**
	 * Método que establece el CodigoCampo
	 * @param codigoCampo
	 */
	public void setCodigoCampo(String codigoCampo) {
		this.codigoCampo = codigoCampo;
	}

	/**
	 * Método que obtiene el CodigoTipoRegla
	 * @return
	 */
	public String getCodigoTipoRegla() {
		return codigoTipoRegla;
	}

	/**
	 * Método que establece el CodigoTipoRegla
	 * @param codigoTipoRegla
	 */
	public void setCodigoTipoRegla(String codigoTipoRegla) {
		this.codigoTipoRegla = codigoTipoRegla;
	}

	/**
	 * Método que obtiene el TipoCampo
	 * @return
	 */
	public String getTipoCampo() {
		return tipoCampo;
	}

	/**
	 * Método que establece el TipoCampo
	 * @param tipoCampo
	 */
	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	/**
	 * Método que obtiene el NombreCampo
	 * @return
	 */
	public String getNombreCampo() {
		return nombreCampo;
	}

	/**
	 *  Método que establece el NombreCampo
	 * @param nombreCampo
	 */
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	/**
	 * Método que obtiene el SubTipo
	 * @return
	 */
	public String getSubTipo() {
		return subTipo;
	}

	/**
	 * Método que establece  el SubTipo
	 * @param subTipo
	 */
	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

	/**
	 * Método que obtiene el TipoDato
	 * @return
	 */
	public String getTipoDato() {
		return tipoDato;
	}

	/**
	 * Método que establece el TipoDato
	 * @param tipoDato
	 */
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	/**
	 * Método que obtiene el  Estado
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Método que establece el Estado
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Método que obtiene la FechaAlta
	 * @return
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Método que establece la FechaAlta
	 * @param fechaAlta
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Método que obtiene el CodigoUsuarioAlta
	 * @return
	 */
	public int getCodigoUsuarioAlta() {
		return codigoUsuarioAlta;
	}

	/**
	 * Método que establece el CodigoUsuarioAlta
	 * @param codigoUsuarioAlta
	 */
	public void setCodigoUsuarioAlta(int codigoUsuarioAlta) {
		this.codigoUsuarioAlta = codigoUsuarioAlta;
	}

	/**
	 * Método que obtiene la FechaModificacion
	 * @return
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método que establece la FechaModificacion
	 * @param fechaModificacion
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método que obtiene el CodigoUsuario
	 * @return
	 */
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * Método que establece el CodigoUsuario
	 * @param codigoUsuario
	 */
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CampoTO [codigoCampo=" + codigoCampo + ", codigoTipoRegla=" + codigoTipoRegla + ", tipoCampo=" + tipoCampo + ", nombreCampo=" + nombreCampo + ", subTipo=" + subTipo + ", tipoDato="
				+ tipoDato + ", estado=" + estado + ", fechaAlta=" + fechaAlta + ", codigoUsuarioAlta=" + codigoUsuarioAlta + ", fechaModificacion=" + fechaModificacion + ", codigoUsuario="
				+ codigoUsuario + "]";
	}
}
