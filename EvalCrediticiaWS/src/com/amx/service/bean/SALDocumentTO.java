
package com.amx.service.bean;

import java.io.Serializable;

public class SALDocumentTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigoDocument;
	private String descripcionDocument;
	private Integer codeUsuario;

	public SALDocumentTO() {
	}

	public Long getCodigoDocument() {
		return codigoDocument;
	}

	public void setCodigoDocument(Long codigoDocument) {
		this.codigoDocument = codigoDocument;
	}

	public String getDescripcionDocument() {
		return descripcionDocument;
	}

	public void setDescripcionDocument(String descripcionDocument) {
		this.descripcionDocument = descripcionDocument;
	}

	public Integer getCodeUsuario() {
		return codeUsuario;
	}

	public void setCodeUsuario(Integer codeUsuario) {
		this.codeUsuario = codeUsuario;
	}

	@Override
	public String toString() {
		return "DocumentFCETO [codigoDocument=" + codigoDocument
				+ ", descripcionDocument=" + descripcionDocument
				+ ", codeUsuario=" + codeUsuario + "]";
	}

}
