package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a  ExcCondicionFce.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ExcCondicionFceTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codCondicionFce
	 */
	private Long codCondicionFce;
	/**
	 * Atributo único que identifica el registro codExcFce
	 */
	private Long codExcFce;
	/**
	 * Atributo único que identifica el registro codOrderactionInfo
	 */
	private Long codOrderactionInfo;
	/**
	 * Atributo único que identifica el registro numRcInAvanced
	 */
	private String 	numRcInAvanced;
	/**
	 * Atributo único que identifica el registro instZero
	 */
	private String	instZero;
	/**
	 * Atributo único que identifica el registro numInstallment
	 */
	private String	numInstallment;
	/**
	 * Atributo único que identifica el registro deposit
	 */
	private String	deposit;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicialia la clase
	 */
	public ExcCondicionFceTO() {
		
	}
	public Long getCodCondicionFce() {
		return codCondicionFce;
	}
	public void setCodCondicionFce(Long codCondicionFce) {
		this.codCondicionFce = codCondicionFce;
	}
	public Long getCodExcFce() {
		return codExcFce;
	}
	public void setCodExcFce(Long codExcFce) {
		this.codExcFce = codExcFce;
	}
	public Long getCodOrderactionInfo() {
		return codOrderactionInfo;
	}
	public void setCodOrderactionInfo(Long codOrderactionInfo) {
		this.codOrderactionInfo = codOrderactionInfo;
	}
	public String getNumRcInAvanced() {
		return numRcInAvanced;
	}
	public void setNumRcInAvanced(String numRcInAvanced) {
		this.numRcInAvanced = numRcInAvanced;
	}
	public String getInstZero() {
		return instZero;
	}
	public void setInstZero(String instZero) {
		this.instZero = instZero;
	}
	public String getNumInstallment() {
		return numInstallment;
	}
	public void setNumInstallment(String numInstallment) {
		this.numInstallment = numInstallment;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "ExcCondicionFceTO [codCondicionFce=" + codCondicionFce
				+ ", codExcFce=" + codExcFce + ", codOrderactionInfo="
				+ codOrderactionInfo + ", numRcInAvanced=" + numRcInAvanced
				+ ", instZero=" + instZero + ", numInstallment="
				+ numInstallment + ", deposit=" + deposit + ", codUsuarioAlta="
				+ codUsuarioAlta + "]";
	}
		
}
