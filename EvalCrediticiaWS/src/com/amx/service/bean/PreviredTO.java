package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a Previred.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class PreviredTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codPrevired
	 */
	private Long codPrevired;
	/**
	 * Atributo único que identifica el registro nombCliente
	 */
	private String nombCliente;
	/**
	 * Atributo único que identifica el registro rutCliente
	 */
	private String rutCliente;
	/**
	 * Atributo único que identifica el registro prevMontoPromedio
	 */
	private String prevMontoPromedio;
	/**
	 * Atributo único que identifica el registro prevAntiguedad
	 */
	private String prevAntiguedad;
	/**
	 * Atributo único que identifica el registro prevContinuidadLaboral
	 */
	private String prevContinuidadLaboral;
	/**
	 * Atributo único que identifica el registro fechConsultado
	 */
	private Date fechConsultado;
	/**
	 * Atributo único que identifica el registro estado
	 */
	private String estado;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo único que identifica el registro origen
	 */
	private String origen;
	/**
	 * Atributo único que identifica la lista de objetos listDetallePrevired
	 */
	private List<DetallePreviredTO> listDetallePrevired;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public PreviredTO() {
		
	}

	public List<DetallePreviredTO> getListDetallePrevired() {
		if(listDetallePrevired == null)
			listDetallePrevired = new ArrayList<DetallePreviredTO>();
		return listDetallePrevired;
	}
	
	public Long getCodPrevired() {
		return codPrevired;
	}
	public void setCodPrevired(Long codPrevired) {
		this.codPrevired = codPrevired;
	}
	public String getNombCliente() {
		return nombCliente;
	}
	public void setNombCliente(String nombCliente) {
		this.nombCliente = nombCliente;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getPrevMontoPromedio() {
		return prevMontoPromedio;
	}
	public void setPrevMontoPromedio(String prevMontoPromedio) {
		this.prevMontoPromedio = prevMontoPromedio;
	}
	public String getPrevAntiguedad() {
		return prevAntiguedad;
	}
	public void setPrevAntiguedad(String prevAntiguedad) {
		this.prevAntiguedad = prevAntiguedad;
	}
	public String getPrevContinuidadLaboral() {
		return prevContinuidadLaboral;
	}
	public void setPrevContinuidadLaboral(String prevContinuidadLaboral) {
		this.prevContinuidadLaboral = prevContinuidadLaboral;
	}
	public Date getFechConsultado() {
		return fechConsultado;
	}
	public void setFechConsultado(Date fechConsultado) {
		this.fechConsultado = fechConsultado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getOrigen() {
		return origen;
	}

	@Override
	public String toString() {
		return "PreviredTO [codPrevired=" + codPrevired + ", nombCliente="
				+ nombCliente + ", rutCliente=" + rutCliente
				+ ", prevMontoPromedio=" + prevMontoPromedio
				+ ", prevAntiguedad=" + prevAntiguedad
				+ ", prevContinuidadLaboral=" + prevContinuidadLaboral
				+ ", fechConsultado=" + fechConsultado + ", estado=" + estado
				+ ", codUsuarioAlta=" + codUsuarioAlta + ", origen=" + origen
				+ ", listDetallePrevired=" + listDetallePrevired + "]";
	}
	
}
