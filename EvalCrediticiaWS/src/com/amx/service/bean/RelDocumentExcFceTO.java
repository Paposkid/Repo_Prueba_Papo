package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a RelDocumentExcFce.
 * 
 * @author christian hincapié christian.hincapiemonsalve@tcs.com 
 * @since 22/04/2013
 * @version 1.0
 */
public class RelDocumentExcFceTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo único que identifica el registro codigo de FCE Documento
	 */
	private Long codFceDocument; 
	/**
	 * Atributo único que identifica el registro codigo de Excepcion de la FCE
	 */
	private Long codExcFce;
	/**
	 * Atributo único que identifica el registro codigo del Documento
	 */
	private Long codDocument;
	/**
	 * Atributo único que identifica el registro codigo de Usuario de Alta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public RelDocumentExcFceTO() {
		
	}
	public Long getCodFceDocument() {
		return codFceDocument;
	}
	public void setCodFceDocument(Long codFceDocument) {
		this.codFceDocument = codFceDocument;
	}
	public Long getCodExcFce() {
		return codExcFce;
	}
	public void setCodExcFce(Long codExcFce) {
		this.codExcFce = codExcFce;
	}
	public Long getCodDocument() {
		return codDocument;
	}
	public void setCodDocument(Long codDocument) {
		this.codDocument = codDocument;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "RelDocumentExcFceTO [codFceDocument=" + codFceDocument
				+ ", codExcFce=" + codExcFce + ", codDocument=" + codDocument
				+ ", codUsuarioAlta=" + codUsuarioAlta + "]";
	}
	
}

