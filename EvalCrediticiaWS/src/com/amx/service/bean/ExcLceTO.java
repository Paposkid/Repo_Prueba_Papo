package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a ExcLce.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ExcLceTO implements Serializable{
	
	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro  codExcLce
	 */
	private Long codExcLce;
	/**
	 * Atributo �nico que identifica el registro codLce
	 */
	private Long codLce;
	/**
	 * Atributo �nico que identifica el registro tipoPlan
	 */
	private String 	tipoPlan;
	/**
	 * Atributo �nico que identifica el registro purcLimit
	 */
	private String 	purcLimit;
	/**
	 * Atributo �nico que identifica el registro totalNumberFlines
	 */
	private Integer totalNumberFlines;
	/**
	 * Atributo �nico que identifica el registro rcPaymentRequired
	 */
	private String	rcPaymentRequired;
	/**
	 * Atributo �nico que identifica el registro equiInmediatePaymentRequired
	 */
	private String	equiInmediatePaymentRequired;
	/**
	 * Atributo �nico que identifica el registro payMeanRequired
	 */
	private String	payMeanRequired;
	/**
	 * Atributo �nico que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ExcLceTO() {
		
	}
	public Long getCodExcLce() {
		return codExcLce;
	}
	public void setCodExcLce(Long codExcLce) {
		this.codExcLce = codExcLce;
	}
	public Long getCodLce() {
		return codLce;
	}
	public void setCodLce(Long codLce) {
		this.codLce = codLce;
	}
	public String getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public String getPurcLimit() {
		return purcLimit;
	}
	public void setPurcLimit(String purcLimit) {
		this.purcLimit = purcLimit;
	}
	public Integer getTotalNumberFlines() {
		return totalNumberFlines;
	}
	public void setTotalNumberFlines(Integer totalNumberFlines) {
		this.totalNumberFlines = totalNumberFlines;
	}
	public String getRcPaymentRequired() {
		return rcPaymentRequired;
	}
	public void setRcPaymentRequired(String rcPaymentRequired) {
		this.rcPaymentRequired = rcPaymentRequired;
	}
	public String getEquiInmediatePaymentRequired() {
		return equiInmediatePaymentRequired;
	}
	public void setEquiInmediatePaymentRequired(String equiInmediatePaymentRequired) {
		this.equiInmediatePaymentRequired = equiInmediatePaymentRequired;
	}
	public String getPayMeanRequired() {
		return payMeanRequired;
	}
	public void setPayMeanRequired(String payMeanRequired) {
		this.payMeanRequired = payMeanRequired;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "ExcLceTO [codExcLce=" + codExcLce + ", codLce=" + codLce
				+ ", tipoPlan=" + tipoPlan + ", purcLimit=" + purcLimit
				+ ", totalNumberFlines=" + totalNumberFlines
				+ ", rcPaymentRequired=" + rcPaymentRequired
				+ ", equiInmediatePaymentRequired="
				+ equiInmediatePaymentRequired + ", payMeanRequired="
				+ payMeanRequired + ", codUsuarioAlta=" + codUsuarioAlta + "]";
	}
		
}
