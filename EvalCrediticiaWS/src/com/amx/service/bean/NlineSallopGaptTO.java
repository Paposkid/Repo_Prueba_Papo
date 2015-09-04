package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a NlineSallopGapt.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class NlineSallopGaptTO implements Serializable{
	
	/**
	 *  El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro CorrNlineSallopGapt
	 */
	private Long CorrNlineSallopGapt;
	/**
	 *  Atributo único que identifica el registro CorrSallce
	 */
	private Long CorrSallce;
	/**
	 *  Atributo único que identifica el registro TotalNumbLineSallowed
	 */
	private String TotalNumbLineSallowed;
	/**
	 *  Atributo único que identifica el registro gama
	 */
	private String gama;
	/**
	 *  Atributo único que identifica el registro ProdType
	 */
	private String ProdType;
	/**
	 *  Atributo único que identifica el registro corrUsuarioAlta
	 */
	private Integer corrUsuarioAlta;
	
	/**
	 *  Constructor vacio
	 */
	public NlineSallopGaptTO() {
		
	}
	public Long getCorrNlineSallopGapt() {
		return CorrNlineSallopGapt;
	}
	public void setCorrNlineSallopGapt(Long corrNlineSallopGapt) {
		CorrNlineSallopGapt = corrNlineSallopGapt;
	}
	public Long getCorrSallce() {
		return CorrSallce;
	}
	public void setCorrSallce(Long corrSallce) {
		CorrSallce = corrSallce;
	}
	public String getTotalNumbLineSallowed() {
		return TotalNumbLineSallowed;
	}
	public void setTotalNumbLineSallowed(String totalNumbLineSallowed) {
		TotalNumbLineSallowed = totalNumbLineSallowed;
	}
	public String getGama() {
		return gama;
	}
	public void setGama(String gama) {
		this.gama = gama;
	}
	public String getProdType() {
		return ProdType;
	}
	public void setProdType(String prodType) {
		ProdType = prodType;
	}
	public Integer getCorrUsuarioAlta() {
		return corrUsuarioAlta;
	}
	public void setCorrUsuarioAlta(Integer corrUsuarioAlta) {
		this.corrUsuarioAlta = corrUsuarioAlta;
	}
	@Override
	public String toString() {
		return "NlineSallopGaptTO [CorrNlineSallopGapt=" + CorrNlineSallopGapt
				+ ", CorrSallce=" + CorrSallce + ", TotalNumbLineSallowed="
				+ TotalNumbLineSallowed + ", gama=" + gama + ", ProdType="
				+ ProdType + ", corrUsuarioAlta=" + corrUsuarioAlta + "]";
	}
	
}
