package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a Accreditation Data.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AccrdataTO implements Serializable{

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro correlativo Accreditacion data 
	 */
	private Long corrAccrdata;
	/**
	 * Atributo �nico que identifica el registro  correlativo  Accreditacion informacion
	 */
	private Long corrAccrinfo; 
	/**
	 * Atributo �nico que identifica el registro Accreditacion Nombre
	 */
	private String accrName;
	/**
	 * Atributo �nico que identifica el registro Accreditaci�n valor
	 */
	private String accrValue;
	/**
	 * Atributo �nico que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Constructor que inicializa la clase 
	 */
	public AccrdataTO() {
		
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public Long getCorrAccrdata() {
		return corrAccrdata;
	}
	public void setCorrAccrdata(Long corrAccrdata) {
		this.corrAccrdata = corrAccrdata;
	}
	public Long getCorrAccrinfo() {
		return corrAccrinfo;
	}
	public void setCorrAccrinfo(Long corrAccrinfo) {
		this.corrAccrinfo = corrAccrinfo;
	}
	public String getAccrName() {
		return accrName;
	}
	public void setAccrName(String accrName) {
		this.accrName = accrName;
	}
	public String getAccrValue() {
		return accrValue;
	}
	public void setAccrValue(String accrValue) {
		this.accrValue = accrValue;
	}
	@Override
	public String toString() {
		return "AccrdataTO [corrAccrdata=" + corrAccrdata + ", corrAccrinfo="
				+ corrAccrinfo + ", accrName=" + accrName + ", accrValue="
				+ accrValue + ", usuario=" + usuario + "]";
	}
	
}
