package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a Regla.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class ReglaTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigo
	 */
	private String codigo;
	/**
	 * Atributo único que identifica el registro nombre
	 */
	private String nombre;
	/**
	 * Atributo único que identifica el registro valor
	 */
	private String valor;
	/**
	 * Atributo único que identifica el registro descripcion
	 */
	private String descripcion;
	/**
	 * Atributo único que identifica el registro tipoRegla
	 */
	private String tipoRegla;
	/**
	 * Atributo único que identifica el registro subtipoRegla
	 */
	private String subtipoRegla;
	/**
	 * Atributo único que identifica el registro tipoEvaluacion
	 */
	private String tipoEvaluacion;
	/**
	 * Atributo único que identifica el registro fechaVigenciaDesde
	 */
	private Date fechaVigenciaDesde;
	/**
	 * Atributo único que identifica el registro fechaVigenciaHasta
	 */
	private Date fechaVigenciaHasta;
	/**
	 * Atributo único que identifica el registro sinVigencia
	 */ 
	private String sinVigencia;
	/**
	 * Atributo único que identifica el registro estado
	 */
	private String estado;
	/**
	 * Atributo único que identifica el registro fechaAlta
	 */
	private Date fechaAlta;
	/**
	 * Atributo único que identifica el registro usuarioAlta
	 */
	private String usuarioAlta;
	/**
	 * Atributo único que identifica el registro fechaModificacion
	 */
	private Date fechaModificacion;
	/**
	 * Atributo único que identifica el registro usuarioModificacion
	 */
	private String usuarioModificacion;

	/**
	 * Constructor que inicializa la clase
	 */
	public ReglaTO() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoRegla() {
		return tipoRegla;
	}

	public void setTipoRegla(String tipoRegla) {
		this.tipoRegla = tipoRegla;
	}

	public String getSubtipoRegla() {
		return subtipoRegla;
	}

	public void setSubtipoRegla(String subtipoRegla) {
		this.subtipoRegla = subtipoRegla;
	}

	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public Date getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(Date fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	public Date getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(Date fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}

	public String getSinVigencia() {
		return sinVigencia;
	}

	public void setSinVigencia(String sinVigencia) {
		this.sinVigencia = sinVigencia;
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

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	@Override
	public String toString() {
		return "ReglaTO [codigo=" + codigo + ", nombre=" + nombre + ", valor=" + valor + ", descripcion=" + descripcion + ", tipoRegla=" + tipoRegla + ", subtipoRegla=" + subtipoRegla
				+ ", tipoEvaluacion=" + tipoEvaluacion + ", fechaVigenciaDesde=" + fechaVigenciaDesde + ", fechaVigenciaHasta=" + fechaVigenciaHasta + ", sinVigencia=" + sinVigencia + ", estado="
				+ estado + ", fechaAlta=" + fechaAlta + ", usuarioAlta=" + usuarioAlta + ", fechaModificacion=" + fechaModificacion + ", usuarioModificacion=" + usuarioModificacion + "]";
	}
	
	
}
