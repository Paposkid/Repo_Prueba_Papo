package com.amx.service.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase que expone los valores y datos que hace referencia a los parametros
 * 
 * @author Carlos Andres Castrill0n [carlos.castrillonescobar@tcs.com]
 * @since 03/17/2013
 * @version 1.0
 */

public class ParametroTO implements Serializable {


	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que identifica codigo parametro.
	 */
	private String codigoParametro;
	/**
	 * Atributo que identifica nombre parametro.
	 */
	private String nombreParametro;
	/**
	 * Atributo que identifica tipo parametro. 1-->Limites excepcionador
	 * 2-->Tiempo de espera servicios externos 3-->Tiempo de vigencia servicios
	 * externos 4-->Tiempo vigencia evaluacion 5-->Respuesta servicios externos
	 */
	private String tipoParametro;
	/**
	 * Atributo que identifica valor parametro.
	 */
	private String valorParametro;
	/**
	 * Atributo que identifica estado parametro. I-->Inactivo A-->Activo
	 */
	private String estadoParametro;
	/**
	 * Atributo que identifica fecha creacion parametro.
	 */
	private Date fechaAlta;
	/**
	 * Atributo que identifica codigo usuario.
	 */
	private int codigoUsuarioAlta;
	/**
	 * Atributo que identifica fecha modificacion parametro.
	 */
	private Date fechaModificacion;
	/**
	 * Atributo que identifica codigo usuario modifica.
	 */
	private int codigoUsuario;

	/**
	 * Constructor vacio
	 */
	public ParametroTO() {

	}

	/**
	 * M�todo que obtiene el c�digo de un parametro.
	 * 
	 * @return codigoParametro.
	 */
	public String getCodigoParametro() {
		return codigoParametro;
	}

	/**
	 * M�todo que estabece el c�digo de un parametro.
	 */
	public void setCodigoParametro(String codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	/**
	 * M�todo que obtiene el nombre de un parametro.
	 * 
	 * @return nombreParametro.
	 */
	public String getNombreParametro() {
		return nombreParametro;
	}

	/**
	 * M�todo que establece el nombre de un parametro.
	 */
	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	/**
	 * M�todo que obtiene el tipo de un parametro.
	 * 
	 * @return tipoParametro.
	 */
	public String getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * M�todo que establece el tipo de un parametro.
	 */
	public void setTipoParametro(String tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	/**
	 * M�todo que obtiene el valor de un parametro.
	 * 
	 * @return valorParametro.
	 */
	public String getValorParametro() {
		return valorParametro;
	}

	/**
	 * M�todo que establece el valor de un parametro.
	 */
	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}

	/**
	 * M�todo que obtiene el estado de un parametro.
	 * 
	 * @return estadoParametro.
	 */
	public String getEstadoParametro() {
		return estadoParametro;
	}

	/**
	 * M�todo que estblece el estado de un parametro.
	 */
	public void setEstadoParametro(String estadoParametro) {
		this.estadoParametro = estadoParametro;
	}

	/**
	 * M�todo que obtiene la fecha de alta de un parametro.
	 * 
	 * @return fechaAlta.
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * M�todo que establece la fecha de alta de un parametro.
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * M�todo que obtiene el codigo de usuario de alta de un parametro.
	 * 
	 * @return codigoUsuarioAlta.
	 */
	public int getCodigoUsuarioAlta() {
		return codigoUsuarioAlta;
	}

	/**
	 * M�todo que establece el codigo de usuario de alta de un parametro.
	 */
	public void setCodigoUsuarioAlta(int codigoUsuarioAlta) {
		this.codigoUsuarioAlta = codigoUsuarioAlta;
	}

	/**
	 * M�todo que obtiene la fecha de modificacion de un parametro.
	 * 
	 * @return fechaModificacion.
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * M�todo que establece la fecha de modificacion de un parametro.
	 */
	
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * M�todo que obtiene el codigo del usuario que modifica un parametro.
	 * 
	 * @return codigoUsuario.
	 */
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * M�todo que establece el codigo del usuario que modifica un parametro.
	 */
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	@Override
	public String toString() {
		return "ParametroTO [codigoParametro=" + codigoParametro + ", nombreParametro=" + nombreParametro + ", tipoParametro=" + tipoParametro + ", valorParametro=" + valorParametro
				+ ", estadoParametro=" + estadoParametro + ", fechaAlta=" + fechaAlta + ", codigoUsuarioAlta=" + codigoUsuarioAlta + ", fechaModificacion=" + fechaModificacion + ", codigoUsuario="
				+ codigoUsuario + "]";
	}

}
