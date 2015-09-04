package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a RelExcFceDocExtra.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class RelExcFceDocExtraTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro  código excepcion documento extra
	 */
	private Long codExcFceDocExtra;
	/**
	 *  Atributo único que identifica el registro código excepcion  FCE
	 */
	private Long codExcFce;
	/**
	 *  Atributo único que identifica el registro código documento extra
	 */
	private Long codDocExtra;
	/**
	 * Atributo único que identifica el registro  código usuario alta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public RelExcFceDocExtraTO() {
	}
	public Long getCodExcFceDocExtra() {
		return codExcFceDocExtra;
	}
	public void setCodExcFceDocExtra(Long codExcFceDocExtra) {
		this.codExcFceDocExtra = codExcFceDocExtra;
	}
	public Long getCodExcFce() {
		return codExcFce;
	}
	public void setCodExcFce(Long codExcFce) {
		this.codExcFce = codExcFce;
	}
	public Long getCodDocExtra() {
		return codDocExtra;
	}
	public void setCodDocExtra(Long codDocExtra) {
		this.codDocExtra = codDocExtra;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "RelExcFceDocExtraTO [codExcFceDocExtra=" + codExcFceDocExtra
				+ ", codExcFce=" + codExcFce + ", codDocExtra=" + codDocExtra
				+ ", codUsuarioAlta=" + codUsuarioAlta + "]";
	}
	
}
