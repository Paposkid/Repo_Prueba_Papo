package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DocExtra.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DocExtraTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codDocExtra
	 */
	private Long codDocExtra;
	/**
	 * Atributo único que identifica el registro nomDoc
	 */
	private String nomDoc;
	/**
	 * Atributo único que identifica el registro codeUsuario
	 */
	private Integer codeUsuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public DocExtraTO() {
		
	}
	public Long getCodDocExtra() {
		return codDocExtra;
	}
	public void setCodDocExtra(Long codDocExtra) {
		this.codDocExtra = codDocExtra;
	}
	public String getNomDoc() {
		return nomDoc;
	}
	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}
	public Integer getCodeUsuario() {
		return codeUsuario;
	}
	public void setCodeUsuario(Integer codeUsuario) {
		this.codeUsuario = codeUsuario;
	}
	@Override
	public String toString() {
		return "DocExtraTO [codDocExtra=" + codDocExtra + ", nomDoc=" + nomDoc
				+ ", codeUsuario=" + codeUsuario + "]";
	}
	
}
