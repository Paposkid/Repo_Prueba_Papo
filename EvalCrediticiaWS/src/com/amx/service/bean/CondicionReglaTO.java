package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a CondicionRegla.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class CondicionReglaTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigoCondicion
	 */
	private String codigoCondicion;
	/**
	 * Atributo único que identifica el registro codigoRegla
	 */
	private String codigoRegla;
	/**
	 * Atributo único que identifica el registro codigoCampo
	 */
	private String codigoCampo;
	/**
	 * Atributo único que identifica el registro codigoConstante
	 */
	private String codigoConstante;
	/**
	 * Atributo único que identifica el registro codigoDominio
	 */
	private String codigoDominio;
	/**
	 * Atributo único que identifica el registro codigoCategoria
	 */
	private String codigoCategoria;
	/**
	 * Atributo único que identifica el registro operador
	 */
	private String operador;
	/**
	 * Atributo único que identifica el registro parenIzqu
	 */
	private String parenIzqu;
	/**
	 * Atributo único que identifica el registro valor
	 */
	private String valor;
	/**
	 * Atributo único que identifica el registro tipow
	 */
	private String tipo;

	/**
	 * Constructor que inicializa la clase
	 */
	public CondicionReglaTO() {

	}

	public String getCodigoCondicion() {
		return codigoCondicion;
	}

	public void setCodigoCondicion(String codigoCondicion) {
		this.codigoCondicion = codigoCondicion;
	}

	public String getCodigoRegla() {
		return codigoRegla;
	}

	public void setCodigoRegla(String codigoRegla) {
		this.codigoRegla = codigoRegla;
	}

	public String getCodigoCampo() {
		return codigoCampo;
	}

	public void setCodigoCampo(String codigoCampo) {
		this.codigoCampo = codigoCampo;
	}

	public String getCodigoConstante() {
		return codigoConstante;
	}

	public void setCodigoConstante(String codigoConstante) {
		this.codigoConstante = codigoConstante;
	}

	public String getCodigoDominio() {
		return codigoDominio;
	}

	public void setCodigoDominio(String codigoDominio) {
		this.codigoDominio = codigoDominio;
	}

	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getParenIzqu() {
		return parenIzqu;
	}

	public void setParenIzqu(String parenIzqu) {
		this.parenIzqu = parenIzqu;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "CondicionReglaTO [codigoCondicion=" + codigoCondicion + ", codigoRegla=" + codigoRegla + ", codigoCampo=" + codigoCampo + ", codigoConstante=" + codigoConstante + ", codigoDominio="
				+ codigoDominio + ", codigoCategoria=" + codigoCategoria + ", operador=" + operador + ", parenIzqu=" + parenIzqu + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
}
