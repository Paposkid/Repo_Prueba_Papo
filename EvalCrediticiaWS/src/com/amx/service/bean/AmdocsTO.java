package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a Amdocs.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AmdocsTO implements Serializable{

	/**
	 *  El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo �nico que identifica el registro codAmdocs
	 */
	private Long codAmdocs;
	/**
	 * Atributo �nico que identifica el registro fechaConsulta
	 */
	private Date fechaConsulta;
	/**
	 * Atributo �nico que identifica el registro antiguedaLineasAct
	 */
	private Integer antiguedaLineasAct;
	/**
	 * Atributo �nico que identifica el registro deudaVencida;
	 */
	private Integer deudaVencida;
	/**
	 * Atributo �nico que identifica el registro notaComportamiento
	 */
	private String notaComportamiento;
	/**
	 * Atributo �nico que identifica el registro cantLineasAct
	 */
	private Integer cantLineasAct;
	/**
	 * Atributo �nico que identifica el registro pagoRecurrenteAct
	 */
	private Integer pagoRecurrenteAct;
	/**
	 * Atributo �nico que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo �nico que identifica el registro clienteAntiguo
	 */
	private String clienteAntiguo;
	/**
	 * Atributo �nico que identifica el registro origen
	 */
	private String origen;
	
	
	/**
	 * Constructor que inicializa la clase
	 */
	public AmdocsTO() {
		
	}

	/**
	 * M�todo que obtiene el CodAmdocs
	 * @return
	 */
	public Long getCodAmdocs() {
		return codAmdocs;
	}

	/**
	 * M�todo que establece el CodAmdocs
	 * @param codAmdocs
	 */
	public void setCodAmdocs(Long codAmdocs) {
		this.codAmdocs = codAmdocs;
	}

	/**
	 * M�todo que obtiene la FechaConsulta
	 * @return
	 */
	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	/**
	 * M�todo que establece la FechaConsulta
	 * @param fechaConsulta
	 */
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	/**
	 * M�todo que obtiene la AntiguedaLineasAct
	 * @return
	 */
	public Integer getAntiguedaLineasAct() {
		return antiguedaLineasAct;
	}

	/**
	 * M�todo que establece la AntiguedaLineasAct
	 * @param antiguedaLineasAct
	 */
	public void setAntiguedaLineasAct(Integer antiguedaLineasAct) {
		this.antiguedaLineasAct = antiguedaLineasAct;
	}

	/**
	 * M�todo que obtiene la DeudaVencida
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
	 * M�todo que obtiene la NotaComportamiento
	 * @return
	 */
	public String getNotaComportamiento() {
		return notaComportamiento;
	}

	/**
	 * M�todo que establece la NotaComportamiento
	 * @param notaComportamiento
	 */
	public void setNotaComportamiento(String notaComportamiento) {
		this.notaComportamiento = notaComportamiento;
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
	 * M�todo que obtiene el Serialversionuid
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * M�todo que establece el CodUsuarioAlta
	 * @param codUsuarioAlta
	 */
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}

	/**
	 * M�todo que obtiene el CodUsuarioAlta
	 * @return
	 */
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
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

	/**
	 * M�todo que establece el Origen
	 * @param origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * M�todo que obtiene el Origen
	 * @return
	 */
	public String getOrigen() {
		return origen;
	}

	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AmdocsTO [codAmdocs=" + codAmdocs + ", fechaConsulta="
				+ fechaConsulta + ", antiguedaLineasAct=" + antiguedaLineasAct
				+ ", deudaVencida=" + deudaVencida + ", notaComportamiento="
				+ notaComportamiento + ", cantLineasAct=" + cantLineasAct
				+ ", pagoRecurrenteAct=" + pagoRecurrenteAct
				+ ", codUsuarioAlta=" + codUsuarioAlta + ", clienteAntiguo="
				+ clienteAntiguo + ", origen=" + origen + "]";
	}

}
