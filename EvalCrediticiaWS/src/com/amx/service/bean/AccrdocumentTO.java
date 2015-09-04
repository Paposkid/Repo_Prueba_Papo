package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a Acreditation Document.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AccrdocumentTO implements Serializable{

	/**
	 * El código representa el serial 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro de Acreditation
	 */
	private Long corrAccrdocument;
	/**
	 * Atributo único que identifica el registro de Acreditation Information 
	 */
	private Long corrAccrinfo;
	/**
	 * Atributo  que identifica el registro de document categoria
	 */
	private String docCategory;
	/**
	 * Atributo  que identifica el registro de  document Type
	 */
	private String docType;
	/**
	 * Atributo  que identifica el registro de documnet name
	 */
	private String docName;
	/**
	 * * Atributo  que identifica el registro de usuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public AccrdocumentTO() {
		
	}
	/**
	 * Método que obtiene el usuario 
	 * @return
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
	 * Método que obtiene el código de Accreditation document
	 * @return
	 */
	public Long getCorrAccrdocument() {
		return corrAccrdocument;
	}
	/**
	 * Método que establece el código de Accreditation documen
	 * @param corrAccrdocument
	 */
	public void setCorrAccrdocument(Long corrAccrdocument) {
		this.corrAccrdocument = corrAccrdocument;
	}
	/** 
	 * Método que obtiene el código de accreditation information
	 * @return
	 */
	public Long getCorrAccrinfo() {
		return corrAccrinfo;
	}
	/**
	 * Método que estable el código de accreditation information
	 * @param corrAccrinfo
	 */
	public void setCorrAccrinfo(Long corrAccrinfo) {
		this.corrAccrinfo = corrAccrinfo;
	}
	/**
	 * Método que obtiene el codigo de document category
	 * @return
	 */
	public String getDocCategory() {
		return docCategory;
	}
	/**
	 * Método que establece el codigo document de category
	 * @param docCategory
	 */
	public void setDocCategory(String docCategory) {
		this.docCategory = docCategory;
	}
	/**
	 * Método que obtine el document type
	 * @return
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * Método que establece el document type
	 * @param docType
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
	/**
	 * Método que obtiene el document name
	 * @return
	 */
	public String getDocName() {
		return docName;
	}
	/**
	 * Método que establece el document name
	 * @param docName
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccrdocumentTO [corrAccrdocument=" + corrAccrdocument
				+ ", corrAccrinfo=" + corrAccrinfo + ", docCategory="
				+ docCategory + ", docType=" + docType + ", docName=" + docName
				+ ", usuario=" + usuario + "]";
	}

	
	
}
