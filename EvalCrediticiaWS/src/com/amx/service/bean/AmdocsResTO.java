package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a Amdocs respaldo
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */

public class AmdocsResTO implements Serializable {

	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro rut
	 */
	private String rut;
	/**
	 * Atributo único que identifica el registro antuiguedad
	 */
	private Integer antgLineasAct;
	/**
	 * Atributo único que identifica el registro deudaVencida
	 */
	private Integer deudaVencida;
	/**
	 *Atributo único que identifica el registro notaComportamineto
	 */
	private String notaComportamineto;
	/**
	 * Atributo único que identifica el registro cantLineasAct
	 */
	private Integer cantLineasAct;
	/**
	 * Atributo único que identifica el registro pagoRecurrenteAct
	 */
	private Integer pagoRecurrenteAct;
	/**
	 * Atributo único que identifica el registro fechaAlta
	 */
	private Date fechaAlta;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo único que identifica el registro fechaModificacion
	 */
	private Date fechaModificacion;
	/**
	 * Atributo único que identifica el registro codUsuario
	 */
	private Integer codUsuario;
	/**
	 * Atributo único que identifica el registro clienteAntiguo
	 */
	private String clienteAntiguo;  
	
	
	/**
	 * Contructor que inicializa la clase
	 */
	public AmdocsResTO() {
		
	}
	/**
	 * Método que obtiene el rut
	 * @return
	 */
	public String getRut() {
		return rut;
	}
	/**
	 * Método que establece el rut
	 * 
	 * @param rut
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}
	/**
	 * Método que obtiene AntgLineasAct
	 * @return
	 */
	public Integer getAntgLineasAct() {
		return antgLineasAct;
	}
	/**
	 * Método que establece el AntgLineasAct
	 * @param antgLineasAct
	 */
	public void setAntgLineasAct(Integer antgLineasAct) {
		this.antgLineasAct = antgLineasAct;
	}
	/**
	 * Método que obtiene DeudaVencida
	 * @return
	 */
	public Integer getDeudaVencida() {
		return deudaVencida;
	}
	/**
	 * Método que establece la DeudaVencida
	 * @param deudaVencida
	 */
	public void setDeudaVencida(Integer deudaVencida) {
		this.deudaVencida = deudaVencida;
	}
	/**
	 * Método que obtiene la NotaComportamineto
	 * @return
	 */
	public String getNotaComportamineto() {
		return notaComportamineto;
	}
	/**
	 * Método que establece la NotaComportamineto
	 * @param notaComportamineto
	 */
	public void setNotaComportamineto(String notaComportamineto) {
		this.notaComportamineto = notaComportamineto;
	}
	/**
	 * Método que obtiene la CantLineasAct
	 * @return
	 */
	public Integer getCantLineasAct() {
		return cantLineasAct;
	}
	/**
	 * Método que establece la CantLineasAct
	 * @param cantLineasAct
	 */
	public void setCantLineasAct(Integer cantLineasAct) {
		this.cantLineasAct = cantLineasAct;
	}
	/**
	 * Método que obtiene el PagoRecurrenteAct
	 * @return
	 */
	public Integer getPagoRecurrenteAct() {
		return pagoRecurrenteAct;
	}
	/**
	 * Método que establece el PagoRecurrenteAct
	 * @param pagoRecurrenteAct
	 */
	public void setPagoRecurrenteAct(Integer pagoRecurrenteAct) {
		this.pagoRecurrenteAct = pagoRecurrenteAct;
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
	 * Método que obtiene el CodUsuarioAlta
	 * @return
	 */
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	/**
	 * Método que establece el CodUsuarioAlta
	 * @param codUsuarioAlta
	 */
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
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
	 * Método que obtiene el CodUsuario
	 * @return
	 */
	public Integer getCodUsuario() {
		return codUsuario;
	}
	/**
	 * Método que establece el CodUsuario
	 * @param codUsuario
	 */
	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}
	/**
	 * Método que establece el ClienteAntiguo
	 * @param clienteAntiguo
	 */
	public void setClienteAntiguo(String clienteAntiguo) {
		this.clienteAntiguo = clienteAntiguo;
	}
	/**
	 * Método que obtiene el ClienteAntiguo
	 * @return
	 */
	public String getClienteAntiguo() {
		return clienteAntiguo;
	}
	
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AmdocsResTO [rut=" + rut + ", antgLineasAct=" + antgLineasAct
				+ ", deudaVencida=" + deudaVencida + ", notaComportamineto="
				+ notaComportamineto + ", cantLineasAct=" + cantLineasAct
				+ ", pagoRecurrenteAct=" + pagoRecurrenteAct + ", fechaAlta="
				+ fechaAlta + ", codUsuarioAlta=" + codUsuarioAlta
				+ ", fechaModificacion=" + fechaModificacion + ", codUsuario="
				+ codUsuario + ", clienteAntiguo=" + clienteAntiguo + "]";
	}
	
}
