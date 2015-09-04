package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DetallePrevired.
 * 
 * @author Julian Montoya julian.montollapalacio@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DetallePreviredTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codDetallePrevired
	 */
	private Long codDetallePrevired;
	/**
	 * Atributo único que identifica el registro codPrevired
	 */
	private Long codPrevired;
	/**
	 * Atributo único que identifica el registro fechImposicion
	 */
	private String fechImposicion;
	/**
	 * Atributo único que identifica el registro emplImposicion
	 */
	private String emplImposicion;
	/**
	 * Atributo único que identifica el registro montoImposicion
	 */ 
	private String montoImposicion;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public DetallePreviredTO() {
		
	}
	public Long getCodDetallePrevired() {
		return codDetallePrevired;
	}
	public void setCodDetallePrevired(Long corrDetallePrevired) {
		this.codDetallePrevired = corrDetallePrevired;
	}
	public Long getCodPrevired() {
		return codPrevired;
	}
	public void setCodPrevired(Long corrPrevired) {
		this.codPrevired = corrPrevired;
	}
	public String getFechImposicion() {
		return fechImposicion;
	}
	public void setFechImposicion(String fechImposicion) {
		this.fechImposicion = fechImposicion;
	}
	public String getEmplImposicion() {
		return emplImposicion;
	}
	public void setEmplImposicion(String emplImposicion) {
		this.emplImposicion = emplImposicion;
	}
	public String getMontoImposicion() {
		return montoImposicion;
	}
	public void setMontoImposicion(String montoImposicion) {
		this.montoImposicion = montoImposicion;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	
	@Override
	public String toString() {
		return "DetallePreviredTO [codDetallePrevired=" + codDetallePrevired
				+ ", codPrevired=" + codPrevired + ", fechImposicion="
				+ fechImposicion + ", emplImposicion=" + emplImposicion
				+ ", montoImposicion=" + montoImposicion + ", codUsuarioAlta="
				+ codUsuarioAlta + "]";
	}
	
}
