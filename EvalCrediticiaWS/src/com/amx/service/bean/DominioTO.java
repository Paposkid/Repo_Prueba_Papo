package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Data transfer object para la entidad <code> DominioTO </code>
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */
public class DominioTO implements Serializable {

	/**
	 * el codigo representa el serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * El codigo representa el dominio, expresado en numero.
	 */
	private String codigo;

	/**
	 * El nombre del dominio, valor esperado.
	 */
	private String nombre;

	/**
	 * El tipo de caracter determina msi es alguno de los dos valores. Solamente
	 * se admiten los valores:
	 * <UL>
	 * <LI>"Alfanumérico"
	 * <LI>"Numérico"
	 * </UL>
	 */

	private String tipoCaracter;

	/**
	 * El tipo de dato determina si es alguno de los dos valores. Solamente se
	 * admiten los valores:
	 * <UL>
	 * <LI>"Entrada"
	 * <LI>"Salida"
	 * </UL>
	 */
	private String tipoDato;

	/**
	 * El valor que toma el dominio, valor esperado.
	 */
	private String valor;

	/**
	 * El estado determina si es alguno de los dos valores. Solamente se admiten
	 * los valores:
	 * <UL>
	 * <LI>"Activo"
	 * <LI>"Inactivo"
	 * </UL>
	 */
	private String estado;

	/**
	 * La fecha de creación, determina la fecha de la primera creacion del
	 * domino
	 */
	private Date fechaCreacion;

	/**
	 * El usuario de creación, determina el usuarioque creo el dominio por
	 * primera vez.
	 */
	private String usuarioCreacion;

	/**
	 * La fecha de modificación, determina la fecha de la modificación mas
	 * actual del domino
	 */
	private Date fechaModificacion;

	/**
	 * El usuario de modificacion, determina el usuario que moficó el dominio
	 * por ultima vez.
	 */
	private String usuarioModificacion;

	public DominioTO() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoCaracter() {
		return tipoCaracter;
	}

	public void setTipoCaracter(String tipoCaracter) {
		this.tipoCaracter = tipoCaracter;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
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
		return "DominioTO [codigo=" + codigo + ", nombre=" + nombre + ", tipoCaracter=" + tipoCaracter + ", tipoDato=" + tipoDato + ", valor=" + valor + ", estado=" + estado + ", fechaCreacion="
				+ fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + ", fechaModificacion=" + fechaModificacion + ", usuarioModificacion=" + usuarioModificacion + "]";
	}
}
