package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a ReglaFCE.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class ReglaFCETO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codReglaFCE
	 */
	private Long codReglaFCE;
	/**
	 * Atributo único que identifica el registro codFCE
	 */
	private Long codFCE;
	/**
	 * Atributo único que identifica el registro codRegla
	 */
	private String codRegla;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ReglaFCETO() {
		
	}
	public Long getCodReglaFCE() {
		return codReglaFCE;
	}
	public void setCodReglaFCE(Long codReglaFCE) {
		this.codReglaFCE = codReglaFCE;
	}
	public Long getCodFCE() {
		return codFCE;
	}
	public void setCodFCE(Long codFCE) {
		this.codFCE = codFCE;
	}
	public String getCodRegla() {
		return codRegla;
	}
	public void setCodRegla(String codRegla) {
		this.codRegla = codRegla;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "ReglaFCETO [codReglaFCE=" + codReglaFCE + ", codFCE=" + codFCE
				+ ", codRegla=" + codRegla + ", codUsuarioAlta="
				+ codUsuarioAlta + "]";
	}
	
}
