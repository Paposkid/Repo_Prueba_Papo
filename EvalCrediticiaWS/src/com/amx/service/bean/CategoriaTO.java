package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que expone los valores y datos que hace referencia a la categoria.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public class CategoriaTO implements Serializable {

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;

	

	/**
	 * Atributo �nico que identifica el registro de una categoria
	 */
	private String codigoCategoria;

	/**
	 * Atributo �nico que identifica el c�digo en la tabla campo
	 */
	private String codigoCampo;

	/**
	 * Atributo que identifica el tipo de la categoria
	 */
	private String tipoCategoria;

	/**
	 * Atributo que identifica el nombre de la categoria
	 */
	private String nombreCategoria;

	/**
	 * Atributo que identifica el estado de la categoria
	 */
	private String estado;

	/**
	 * Atributo que identifica la fecha de creaci�n de la categoria
	 */
	private Date fechaAlta;

	/**
	 * Atributo �nico que identifica el c�digo del usuario que crea la categoria
	 */
	private int codigoUsuarioAlta;

	/**
	 * Atributo que identifica la fecha de la modificacion de la categoria
	 */
	private Date fechaModificacion;

	/**
	 * Atributo que identifica el usuario que esta registrado para accerder a la
	 * categoria
	 */
	private int codigoUsuario;

	/**
	 * Atributo que identifica el l�mite inferior del dominio de la categoria
	 */
	private String rangoDesde;

	/**
	 * Atributo que identifica el l�mite supeiror de dominio de la categoria
	 */
	private String rangoHasta;
	
	/**
	 * Atributo que identifica el tipo de regla
	 */
	private String tipoRegla;
	
	/**
	 * Atributo que identifica el tipo de campo
	 */
	private String tipoCampo;

	/**
	 * M�todo que obtiene desde donde v� el rango de dominio de la categoria
	 * 
	 * @return rangoDesde.
	 */
	public String getRangoDesde() {
		return rangoDesde;
	}

	/**
	 * M�todo que esatablece desde donde v� el rango de dominio de la categoria
	 * 
	 * @param rangoDesde
	 *            .
	 */
	public void setRangoDesde(String rangoDesde) {
		this.rangoDesde = rangoDesde;
	}

	/**
	 * M�todo que obtiene hasta donde v� el rango de dominio de la categoria
	 * 
	 * @return rangoHasta.
	 */
	public String getRangoHasta() {
		return rangoHasta;
	}

	/**
	 * M�todo que esatablece hasta donde va el rango de dominio de la categoria
	 * 
	 * @param rangoDesde
	 *            .
	 */
	public void setRangoHasta(String rangoHasta) {
		this.rangoHasta = rangoHasta;
	}

	/**
	 * M�todo que obtiene el c�digo en la tabla campo
	 * 
	 * @return codigoCampo.
	 */
	public String getCodigoCampo() {
		return codigoCampo;
	}

	/**
	 * M�todo que oestablece el codigo en la tabla campo
	 * 
	 * @return codigoCampo.
	 */
	public void setCodigoCampo(String codigoCampo) {
		this.codigoCampo = codigoCampo;
	}

	/**
	 * M�todo que obtiene el c�digo de la categoria
	 * 
	 * @return codigoCategoria.
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	/**
	 * M�todo que establece el c�digo de la categoria
	 * 
	 * @return codigoCategoria.
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	/**
	 * Constructor que inicializa la clase
	 */
	public CategoriaTO() {

	}

	/**
	 * M�todo que obtiene el tipo de la categoria
	 * 
	 * @return tipoCategoria.
	 */
	public String getTipoCategoria() {
		return tipoCategoria;
	}

	/**
	 * M�todo que establece el tipo de la categoria
	 * 
	 * @return tipoCategoria.
	 */
	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	/**
	 * M�todo que obtiene el nombre de la categoria
	 * 
	 * @return nombreCategoria.
	 */
	public String getNombreCategoria() {
		return nombreCategoria;
	}

	/**
	 * M�todo que establece el nombre de la categoria
	 * 
	 * @return nombreCategoria.
	 */
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	/**
	 * M�todo que obtiene el estado de la categoria
	 * 
	 * @return estado.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * M�todo que establece el estado de la categoria
	 * 
	 * @return estado.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * M�todo que obtiene la fecha de creacion de la categoria
	 * 
	 * @return fechaAlta.
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * M�todo que establece la fecha de creacion de la categoria
	 * 
	 * @return fechaAlta.
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * M�todo que obtiene el c�digo del usuario que crea la categoria
	 * 
	 * @return codigoUsuarioAlta.
	 */
	public int getCodigoUsuarioAlta() {
		return codigoUsuarioAlta;
	}

	/**
	 * M�todo que establece el c�digo del usuario que crea la categoria
	 * 
	 * @return codigoUsuarioAlta.
	 */
	public void setCodigoUsuarioAlta(int codigoUsuarioAlta) {
		this.codigoUsuarioAlta = codigoUsuarioAlta;
	}

	/**
	 * M�todo que obtiene la fecha de modificaci�n de la categoria
	 * 
	 * @return fechaModificacion.
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * M�todo que establece la fecha de modificaci�n de la categoria
	 * 
	 * @return fechaModificacion.
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * M�todo que obtiene el c�digo del usuario que esta registrado para
	 * accerder a la categoria
	 * 
	 * @return codigoUsuario.
	 */
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * M�todo que establece el c�digo del usuario que esta registrado para
	 * accerder a la categoria
	 * 
	 * @return codigoUsuario.
	 */
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	/**
	 *  M�todo que obtiene el TipoRegla
	 * @return
	 */
	public String getTipoRegla() {
		return tipoRegla;
	}
	
	/**
	 * M�todo que establece el TipoRegla
	 * @param tipoRegla
	 */
	public void setTipoRegla(String tipoRegla) {
		this.tipoRegla = tipoRegla;
	}
	
	/**
	 *  M�todo que obtiene el TipoCampo
	 * @return
	 */
	public String getTipoCampo() {
		return tipoCampo;
	}
	
	/**
	 * M�todo que establece el TipoCampo
	 * @param tipoCampo
	 */
	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	/**
	 * M�todo que devuelve un String con el contenido todos los atributos
	 */
	@Override
	public String toString() {
		return "CategoriaTO [codigoCategoria=" + codigoCategoria + ", codigoCampo=" + codigoCampo + ", tipoCategoria=" + tipoCategoria + ", nombreCategoria=" + nombreCategoria + ", estado=" + estado
				+ ", fechaAlta=" + fechaAlta + ", codigoUsuarioAlta=" + codigoUsuarioAlta + ", fechaModificacion=" + fechaModificacion + ", codigoUsuario=" + codigoUsuario + ", rangoDesde="
				+ rangoDesde + ", rangoHasta=" + rangoHasta + "]";
	}
}