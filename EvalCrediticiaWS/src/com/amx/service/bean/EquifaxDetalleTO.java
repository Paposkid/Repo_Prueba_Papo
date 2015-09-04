package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a EquifaxDetalle.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class EquifaxDetalleTO implements Serializable {
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo único que identifica el registro codigoDetalleEquifax
	 */
	private Long codigoDetalleEquifax;
	/**
	 * Atributo único que identifica el registro codigoEquifax
	 */
	private Long codigoEquifax;
	/**
	 * Atributo único que identifica el registro codigoEntrada
	 */
	private String codigoEntrada;
	/**
	 * Atributo único que identifica el registro codigoBanco
	 */
	private String codigoBanco;
	/**
	 * Atributo único que identifica el registro cuentaCorriente
	 */
	private String cuentaCorriente;
	/**
	 * Atributo único que identifica el registro numeroCheque
	 */
	private String numeroCheque;
	/**
	 * Atributo único que identifica el registro tipoDocumento
	 */
	private String tipoDocumento;
	/**
	 * Atributo único que identifica el registro rut
	 */
	private String rut;
	/**
	 * Atributo único que identifica el registro numeroSerie
	 */
	private String numeroSerie;
	/**
	 * Atributo único que identifica el registro indConsulta
	 */
	private String indConsulta;
	/**
	 * Atributo único que identifica el registro usosrcel
	 */
	private String usosrcel;
	/**
	 * Atributo único que identifica el registro autorizado
	 */
	private String autorizado;
	/**
	 * Atributo único que identifica el registro codigoRespuesta
	 */
	private String codigoRespuesta;
	/**
	 * Atributo único que identifica el registro codigoRechazo
	 */
	private String codigoRechazo;
	/**
	 * Atributo único que identifica el registro nombreRut
	 */
	private String nombreRut;
	/**
	 * Atributo único que identifica el registro indIcom
	 */
	private String indIcom;
	/**
	 * Atributo único que identifica el registro sexo
	 */
	private String sexo;
	/**
	 * Atributo único que identifica el registro edad
	 */
	private String edad;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;

	/**
	 * Constructro que inicializa la clase
	 */
	public EquifaxDetalleTO() {

	}

	public Long getCodigoDetalleEquifax() {
		return codigoDetalleEquifax;
	}

	public void setCodigoDetalleEquifax(Long codigoDetalleEquifax) {
		this.codigoDetalleEquifax = codigoDetalleEquifax;
	}

	public Long getCodigoEquifax() {
		return codigoEquifax;
	}

	public void setCodigoEquifax(Long codigoEquifax) {
		this.codigoEquifax = codigoEquifax;
	}

	public String getCodigoEntrada() {
		return codigoEntrada;
	}

	public void setCodigoEntrada(String codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getIndConsulta() {
		return indConsulta;
	}

	public void setIndConsulta(String indConsulta) {
		this.indConsulta = indConsulta;
	}

	public String getUsosrcel() {
		return usosrcel;
	}

	public void setUsosrcel(String usosrcel) {
		this.usosrcel = usosrcel;
	}

	public String getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getCodigoRechazo() {
		return codigoRechazo;
	}

	public void setCodigoRechazo(String codigoRechazo) {
		this.codigoRechazo = codigoRechazo;
	}

	public String getNombreRut() {
		return nombreRut;
	}

	public void setNombreRut(String nombreRut) {
		this.nombreRut = nombreRut;
	}

	public String getIndIcom() {
		return indIcom;
	}

	public void setIndIcom(String indIcom) {
		this.indIcom = indIcom;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EquifaxDetalleTO [codigoDetalleEquifax=" + codigoDetalleEquifax + ", codigoEquifax=" + codigoEquifax + ", codigoEntrada=" + codigoEntrada + ", codigoBanco=" + codigoBanco
				+ ", cuentaCorriente=" + cuentaCorriente + ", numeroCheque=" + numeroCheque + ", tipoDocumento=" + tipoDocumento + ", rut=" + rut + ", numeroSerie=" + numeroSerie + ", indConsulta="
				+ indConsulta + ", usosrcel=" + usosrcel + ", autorizado=" + autorizado + ", codigoRespuesta=" + codigoRespuesta + ", codigoRechazo=" + codigoRechazo + ", nombreRut=" + nombreRut
				+ ", indIcom=" + indIcom + ", sexo=" + sexo + ", edad=" + edad + ", usuario=" + usuario + "]";
	}

}
