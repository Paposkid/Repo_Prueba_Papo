

package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a Accreditation Data.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AccreditationDataTO implements Serializable{

	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro el código de accreditation data
	 */
	private Long corrAccrdata;
	/**
	 * Atributo único que identifica el registro el código de accreditation information
	 */
	private Long corrAccrinfo; 
	/**
	 *  Atributo  que identifica el registro el accreditation name
	 */
	private String accrName;
	/**
	 *  Atributo  que identifica el registro el accreditation value
	 */
	private String accrValue;
	/**
	 * Atributo  que identifica el registro usuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor que inicializa la clase 
	 */
	public AccreditationDataTO() {
		
	}
	/**
	 * Método que obtiene el usuario
	 * @return usuario
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Método que establece el usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * Método que obtiene el código de accreditation data
	 * @return corrAccrdata
	 */
	public Long getCorrAccrdata() {
		return corrAccrdata;
	}
	/**
	 * Método que establece el código de accreditation data
	 * @param corrAccrdata
	 */
	public void setCorrAccrdata(Long corrAccrdata) {
		this.corrAccrdata = corrAccrdata;
	}
	/**
	 * Método que obtine el código de accreditation information
	 * @return corrAccrinfo
	 */
	public Long getCorrAccrinfo() {
		return corrAccrinfo;
	}
	/**
	 * Método que establece código accreditation information
	 * @param corrAccrinfo
	 */
	public void setCorrAccrinfo(Long corrAccrinfo) {
		this.corrAccrinfo = corrAccrinfo;
	}
	/**
	 * Método que obtiene el accreditation name
	 * @return accrName
	 */
	public String getAccrName() {
		return accrName;
	}
	/**
	 *Método que establece accreditation name
	 * @param accrName
	 */
	public void setAccrName(String accrName) {
		this.accrName = accrName;
	}
	/**
	 * Método que obtiene el accreditation value
	 * @return accrValue
	 */
	public String getAccrValue() {
		return accrValue;
	}
	/**
	 * Método que establece el accreditation value
	 * @param accrValue
	 */
	public void setAccrValue(String accrValue) {
		this.accrValue = accrValue;
	}
	
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccreditationDataTO [corrAccrdata=" + corrAccrdata + ", corrAccrinfo="
				+ corrAccrinfo + ", accrName=" + accrName + ", accrValue="
				+ accrValue + ", usuario=" + usuario + "]";
	}
	
	
}
