package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DocumentLce.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DocumentLceTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro corrSallceDocument
	 */
	private Long corrSallceDocument;
	/**
	 * Atributo único que identifica el registro corrSallce
	 */
	private Long corrSallce;
	/**
	 * Atributo único que identifica el registro corrDocument
	 */
	private Long corrDocument;
	/**
	 * Atributo único que identifica el registro  corrUsuarioAlta
	 */
	private Integer corrUsuarioAlta;
	
	/**
	 * Constructor vacio
	 */
	public DocumentLceTO() {
		
	}
	public Long getCorrSallceDocument() {
		return corrSallceDocument;
	}
	public void setCorrSallceDocument(Long corrSallceDocument) {
		this.corrSallceDocument = corrSallceDocument;
	}
	public Long getCorrSallce() {
		return corrSallce;
	}
	public void setCorrSallce(Long corrSallce) {
		this.corrSallce = corrSallce;
	}
	public Long getCorrDocument() {
		return corrDocument;
	}
	public void setCorrDocument(Long corrDocument) {
		this.corrDocument = corrDocument;
	}
	public Integer getCorrUsuarioAlta() {
		return corrUsuarioAlta;
	}
	public void setCorrUsuarioAlta(Integer corrUsuarioAlta) {
		this.corrUsuarioAlta = corrUsuarioAlta;
	}
	@Override
	public String toString() {
		return "DocumentLceTO [corrSallceDocument=" + corrSallceDocument
				+ ", corrSallce=" + corrSallce + ", corrDocument="
				+ corrDocument + ", corrUsuarioAlta=" + corrUsuarioAlta + "]";
	}
	
		
}
