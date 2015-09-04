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
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro rut
	 */
	private String rut;
	/**
	 * Atributo �nico que identifica el registro antuiguedad
	 */
	private Integer antgLineasAct;
	/**
	 * Atributo �nico que identifica el registro deudaVencida
	 */
	private Integer deudaVencida;
	/**
	 *Atributo �nico que identifica el registro notaComportamineto
	 */
	private String notaComportamineto;
	/**
	 * Atributo �nico que identifica el registro cantLineasAct
	 */
	private Integer cantLineasAct;
	/**
	 * Atributo �nico que identifica el registro pagoRecurrenteAct
	 */
	private Integer pagoRecurrenteAct;
	/**
	 * Atributo �nico que identifica el registro fechaAlta
	 */
	private Date fechaAlta;
	/**
	 * Atributo �nico que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo �nico que identifica el registro fechaModificacion
	 */
	private Date fechaModificacion;
	/**
	 * Atributo �nico que identifica el registro codUsuario
	 */
	private Integer codUsuario;
	/**
	 * Atributo �nico que identifica el registro clienteAntiguo
	 */
	private String clienteAntiguo;  
	
	
	/**
	 * Contructor que inicializa la clase
	 */
	public AmdocsResTO() {
		
	}
	/**
	 * M�todo que obtiene el rut
	 * @return
	 */
	public String getRut() {
		return rut;
	}
	/**
	 * M�todo que establece el rut
	 * 
	 * @param rut
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}
	/**
	 * M�todo que obtiene AntgLineasAct
	 * @return
	 */
	public Integer getAntgLineasAct() {
		return antgLineasAct;
	}
	/**
	 * M�todo que establece el AntgLineasAct
	 * @param antgLineasAct
	 */
	public void setAntgLineasAct(Integer antgLineasAct) {
		this.antgLineasAct = antgLineasAct;
	}
	/**
	 * M�todo que obtiene DeudaVencida
	 * @return
	 */
	public Integer getDeudaVencida() {
		return deudaVencida;
	}
	/**
	 * M�todo que establece la DeudaVencida
	 * @param deudaVencida
	 */
	public void setDeudaVencida(Integer deudaVencida) {
		this.deudaVencida = deudaVencida;
	}
	/**
	 * M�todo que obtiene la NotaComportamineto
	 * @return
	 */
	public String getNotaComportamineto() {
		return notaComportamineto;
	}
	/**
	 * M�todo que establece la NotaComportamineto
	 * @param notaComportamineto
	 */
	public void setNotaComportamineto(String notaComportamineto) {
		this.notaComportamineto = notaComportamineto;
	}
	/**
	 * M�todo que obtiene la CantLineasAct
	 * @return
	 */
	public Integer getCantLineasAct() {
		return cantLineasAct;
	}
	/**
	 * M�todo que establece la CantLineasAct
	 * @param cantLineasAct
	 */
	public void setCantLineasAct(Integer cantLineasAct) {
		this.cantLineasAct = cantLineasAct;
	}
	/**
	 * M�todo que obtiene el PagoRecurrenteAct
	 * @return
	 */
	public Integer getPagoRecurrenteAct() {
		return pagoRecurrenteAct;
	}
	/**
	 * M�todo que establece el PagoRecurrenteAct
	 * @param pagoRecurrenteAct
	 */
	public void setPagoRecurrenteAct(Integer pagoRecurrenteAct) {
		this.pagoRecurrenteAct = pagoRecurrenteAct;
	}
	/**
	 * M�todo que obtiene la FechaAlta
	 * @return
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * M�todo que establece la FechaAlta
	 * @param fechaAlta
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * M�todo que obtiene el CodUsuarioAlta
	 * @return
	 */
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	/**
	 * M�todo que establece el CodUsuarioAlta
	 * @param codUsuarioAlta
	 */
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	/**
	 * M�todo que obtiene la FechaModificacion
	 * @return
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * M�todo que establece la FechaModificacion
	 * @param fechaModificacion
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * M�todo que obtiene el CodUsuario
	 * @return
	 */
	public Integer getCodUsuario() {
		return codUsuario;
	}
	/**
	 * M�todo que establece el CodUsuario
	 * @param codUsuario
	 */
	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}
	/**
	 * M�todo que establece el ClienteAntiguo
	 * @param clienteAntiguo
	 */
	public void setClienteAntiguo(String clienteAntiguo) {
		this.clienteAntiguo = clienteAntiguo;
	}
	/**
	 * M�todo que obtiene el ClienteAntiguo
	 * @return
	 */
	public String getClienteAntiguo() {
		return clienteAntiguo;
	}
	
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
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
