

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
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro el c�digo de accreditation data
	 */
	private Long corrAccrdata;
	/**
	 * Atributo �nico que identifica el registro el c�digo de accreditation information
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
	 * M�todo que obtiene el usuario
	 * @return usuario
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * M�todo que establece el usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * M�todo que obtiene el c�digo de accreditation data
	 * @return corrAccrdata
	 */
	public Long getCorrAccrdata() {
		return corrAccrdata;
	}
	/**
	 * M�todo que establece el c�digo de accreditation data
	 * @param corrAccrdata
	 */
	public void setCorrAccrdata(Long corrAccrdata) {
		this.corrAccrdata = corrAccrdata;
	}
	/**
	 * M�todo que obtine el c�digo de accreditation information
	 * @return corrAccrinfo
	 */
	public Long getCorrAccrinfo() {
		return corrAccrinfo;
	}
	/**
	 * M�todo que establece c�digo accreditation information
	 * @param corrAccrinfo
	 */
	public void setCorrAccrinfo(Long corrAccrinfo) {
		this.corrAccrinfo = corrAccrinfo;
	}
	/**
	 * M�todo que obtiene el accreditation name
	 * @return accrName
	 */
	public String getAccrName() {
		return accrName;
	}
	/**
	 *M�todo que establece accreditation name
	 * @param accrName
	 */
	public void setAccrName(String accrName) {
		this.accrName = accrName;
	}
	/**
	 * M�todo que obtiene el accreditation value
	 * @return accrValue
	 */
	public String getAccrValue() {
		return accrValue;
	}
	/**
	 * M�todo que establece el accreditation value
	 * @param accrValue
	 */
	public void setAccrValue(String accrValue) {
		this.accrValue = accrValue;
	}
	
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccreditationDataTO [corrAccrdata=" + corrAccrdata + ", corrAccrinfo="
				+ corrAccrinfo + ", accrName=" + accrName + ", accrValue="
				+ accrValue + ", usuario=" + usuario + "]";
	}
	
	
}
