package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema05.
 * 
 * @author christian hincapié christian.hincapiemonsalve@tcs.com 
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema05TO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro  serial Version
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro indiImpa
	 */ 
	private String indiImpa;
	/**
	 * Atributo único que identifica el registro acceIcom
	 */
	private String acceIcom;
	/**
	 * Atributo único que identifica el registro errorIcom
	 */
	private String errorIcom;
	/**
	 * Atributo único que identifica el registro totaImpa
	 */
	private Integer totaImpa;
	/**
	 * Atributo único que identifica el registro mtoImpa
	 */
	private Integer mtoImpa;
	/**
	 * Atributo único que identifica el registro fultImpa
	 */
	private Integer fultImpa;
	/**
	 * Atributo único que identifica el registro multImpa
	 */
	private Integer multImpa;
	/**
	 * Atributo único que identifica el registro tultImpa
	 */
	private String tultImpa;
	/**
	 * Atributo único que identifica el registro mto0mt06
	 */
	private Integer mto0mt06;
	/**
	 * Atributo único que identifica el registro mes0mes06
	 */
	private Integer mes0mes06;
	/**
	 * Atributo único que identifica el registro mto6mt012
	 */
	private Integer mto6mt012;
	/**
	 * Atributo único que identifica el registro mes6mes12
	 */
	private Integer mes6mes12;
	/**
	 * Atributo único que identifica el registro mto12mt024
	 */
	private Integer mto12mt024;	
	/**
	 * Atributo único que identifica el registro mes12mes24
	 */ 
	private Integer mes12mes24;
	/**
	 *  Atributo único que identifica el registro  mto24mt099
	 */
	private Integer mto24mt099;
	/**
	 * Atributo único que identifica el registro mes24mes99
	 */
	private Integer mes24mes99;
	/**
	 * Atributo único que identifica el registro código Usuario Alta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public SubSistema05TO() {
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	public String getIndiImpa() {
		return indiImpa;
	}
	public void setIndiImpa(String indiImpa) {
		this.indiImpa = indiImpa;
	}
	public String getAcceIcom() {
		return acceIcom;
	}
	public void setAcceIcom(String acceIcom) {
		this.acceIcom = acceIcom;
	}
	public String getErrorIcom() {
		return errorIcom;
	}
	public void setErrorIcom(String errorIcom) {
		this.errorIcom = errorIcom;
	}
	public Integer getTotaImpa() {
		return totaImpa;
	}
	public void setTotaImpa(Integer totaImpa) {
		this.totaImpa = totaImpa;
	}
	public Integer getMtoImpa() {
		return mtoImpa;
	}
	public void setMtoImpa(Integer mtoImpa) {
		this.mtoImpa = mtoImpa;
	}
	public Integer getFultImpa() {
		return fultImpa;
	}
	public void setFultImpa(Integer fultImpa) {
		this.fultImpa = fultImpa;
	}
	public Integer getMultImpa() {
		return multImpa;
	}
	public void setMultImpa(Integer multImpa) {
		this.multImpa = multImpa;
	}
	public String getTultImpa() {
		return tultImpa;
	}
	public void setTultImpa(String tultImpa) {
		this.tultImpa = tultImpa;
	}
	public Integer getMto0mt06() {
		return mto0mt06;
	}
	public void setMto0mt06(Integer mto0mt06) {
		this.mto0mt06 = mto0mt06;
	}
	public Integer getMes0mes06() {
		return mes0mes06;
	}
	public void setMes0mes06(Integer mes0mes06) {
		this.mes0mes06 = mes0mes06;
	}
	public Integer getMto6mt012() {
		return mto6mt012;
	}
	public void setMto6mt012(Integer mto6mt012) {
		this.mto6mt012 = mto6mt012;
	}
	public Integer getMes6mes12() {
		return mes6mes12;
	}
	public void setMes6mes12(Integer mes6mes12) {
		this.mes6mes12 = mes6mes12;
	}
	public Integer getMto12mt024() {
		return mto12mt024;
	}
	public void setMto12mt024(Integer mto12mt024) {
		this.mto12mt024 = mto12mt024;
	}
	public Integer getMes12mes24() {
		return mes12mes24;
	}
	public void setMes12mes24(Integer mes12mes24) {
		this.mes12mes24 = mes12mes24;
	}
	public Integer getMto24mt099() {
		return mto24mt099;
	}
	public void setMto24mt099(Integer mto24mt099) {
		this.mto24mt099 = mto24mt099;
	}
	public Integer getMes24mes99() {
		return mes24mes99;
	}
	public void setMes24mes99(Integer mes24mes99) {
		this.mes24mes99 = mes24mes99;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "SubSistema05TO [serialVersion=" + serialVersion + ", indiImpa="
				+ indiImpa + ", acceIcom=" + acceIcom + ", errorIcom="
				+ errorIcom + ", totaImpa=" + totaImpa + ", mtoImpa=" + mtoImpa
				+ ", fultImpa=" + fultImpa + ", multImpa=" + multImpa
				+ ", tultImpa=" + tultImpa + ", mto0mt06=" + mto0mt06
				+ ", mes0mes06=" + mes0mes06 + ", mto6mt012=" + mto6mt012
				+ ", mes6mes12=" + mes6mes12 + ", mto12mt024=" + mto12mt024
				+ ", mes12mes24=" + mes12mes24 + ", mto24mt099=" + mto24mt099
				+ ", mes24mes99=" + mes24mes99 + ", codUsuarioAlta="
				+ codUsuarioAlta + "]";
	}
	
	

}
