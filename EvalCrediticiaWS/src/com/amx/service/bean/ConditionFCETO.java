package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a ConceptoType.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ConditionFCETO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo único que identifica el registro codCondicionFCE
	 */
	private Long codCondicionFCE;
	/**
	 * Atributo único que identifica el registro codSalidaFCE
	 */
	private Long codSalidaFCE;
	/**
	 * Atributo único que identifica el registro codOrdenActionInfo
	 */
	private Long codOrdenActionInfo;
	/**
	 * Atributo único que identifica el registro mesesAdelanto
	 */
	private String mesesAdelanto;
	/**
	 * Atributo único que identifica el registro instZero
	 */
	private String instZero;
	/**
	 * Atributo único que identifica el registro cantCuotas
	 */
	private String cantCuotas;
	/**
	 * Atributo único que identifica el registro amount
	 */
	private String amount;
	/**
	 * Atributo único que identifica el registro deposit
	 */
	private String deposit;
	/**
	 * Atributo único que identifica el registro codeUsuario
	 */
	private Integer codeUsuario;
	/**
	 * Atributo único que identifica el registro orderActionId
	 */
	private String orderActionId;
	
	
	/**
	 * Constructor vacio
	 */
	public ConditionFCETO() {
	}
	public Long getCodCondicionFCE() {
		return codCondicionFCE;
	}
	public void setCodCondicionFCE(Long codCondicionFCE) {
		this.codCondicionFCE = codCondicionFCE;
	}
	public Long getCodSalidaFCE() {
		return codSalidaFCE;
	}
	public void setCodSalidaFCE(Long codSalidaFCE) {
		this.codSalidaFCE = codSalidaFCE;
	}
	public Long getCodOrdenActionInfo() {
		return codOrdenActionInfo;
	}
	public void setCodOrdenActionInfo(Long codOrdenActionInfo) {
		this.codOrdenActionInfo = codOrdenActionInfo;
	}
	public String getMesesAdelanto() {
		return mesesAdelanto;
	}
	public void setMesesAdelanto(String mesesAdelanto) {
		this.mesesAdelanto = mesesAdelanto;
	}
	public String getInstZero() {
		return instZero;
	}
	public void setInstZero(String instZero) {
		this.instZero = instZero;
	}
	public String getCantCuotas() {
		return cantCuotas;
	}
	public void setCantCuotas(String cantCuotas) {
		this.cantCuotas = cantCuotas;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public Integer getCodeUsuario() {
		return codeUsuario;
	}
	public void setCodeUsuario(Integer codeUsuario) {
		this.codeUsuario = codeUsuario;
	}
	@Override
	public String toString() {
		return "ConditionFCETO [codCondicionFCE=" + codCondicionFCE
				+ ", codSalidaFCE=" + codSalidaFCE + ", codOrdenActionInfo="
				+ codOrdenActionInfo + ", mesesAdelanto=" + mesesAdelanto
				+ ", instZero=" + instZero + ", cantCuotas=" + cantCuotas
				+ ", amount=" + amount + ", deposit=" + deposit
				+ ", codeUsuario=" + codeUsuario + "]";
	}
	public void setOrderActionId(String orderActionId) {
		this.orderActionId = orderActionId;
	}
	public String getOrderActionId() {
		return orderActionId;
	}
	
}
