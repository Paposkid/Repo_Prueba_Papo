package cl.clarochile.aplicaciones.evalcrediticia.to;

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
	 * nombreTipoRegla es un atributo que contiene el nombre del tipo de regla
	 * Full Credit Evaluation o Ligth Credit Evaluation
	 */
	private String nombreTipoRegla;

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
	
	private int codCampo;

	public String getCodigoCampo() {
		return codigoCampo;
	}

	public void setCodigoCampo(String codigoCampo) {
		this.codigoCampo = codigoCampo;
	}

	public String getCodigoTipoRegla() {
		return codigoTipoRegla;
	}

	public void setCodigoTipoRegla(String codigoTipoRegla) {
		this.codigoTipoRegla = codigoTipoRegla;
	}
	
	public String getNombreTipoRegla() {
		return nombreTipoRegla;
	}

	public void setNombreTipoRegla(String nombreTipoRegla) {
		this.nombreTipoRegla = nombreTipoRegla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public String getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
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

	public int getCodigoUsuarioAlta() {
		return codigoUsuarioAlta;
	}

	public void setCodigoUsuarioAlta(int codigoUsuarioAlta) {
		this.codigoUsuarioAlta = codigoUsuarioAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	public int getCodCampo() {
		return codCampo;
	}
	
	public void setCodCampo(int codCampo) {
		this.codCampo = codCampo;
	}

	@Override
	public String toString() {
		return "CampoTO [codigoCampo=" + codigoCampo + ", codigoTipoRegla="
				+ codigoTipoRegla + ", nombreTipoRegla=" + nombreTipoRegla
				+ ", tipoCampo=" + tipoCampo + ", nombreCampo=" + nombreCampo
				+ ", subTipo=" + subTipo + ", tipoDato=" + tipoDato
				+ ", estado=" + estado + ", fechaAlta=" + fechaAlta
				+ ", codigoUsuarioAlta=" + codigoUsuarioAlta
				+ ", fechaModificacion=" + fechaModificacion
				+ ", codigoUsuario=" + codigoUsuario + ", codCampo=" + codCampo
				+ "]";
	}


	
	
}
