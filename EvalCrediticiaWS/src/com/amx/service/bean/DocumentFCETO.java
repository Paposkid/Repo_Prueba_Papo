package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DocumentFCE.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DocumentFCETO implements Serializable {
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codDocumentosRequeridos
	 */
	private Long codDocumentosRequeridos;
	/**
	 * Atributo único que identifica el registro codSalidaFCE
	 */
	private Long codSalidaFCE;
	/**
	 * Atributo único que identifica el registro codDocumento
	 */
	private Long codDocumento;
	/**
	 * Atributo único que identifica el registro codeUsuario
	 */
	private Integer codeUsuario;
		
   /**
    * Constructor que inicializa la clase
    */
public DocumentFCETO(){
	   
   }

public Long getCodDocumentosRequeridos() {
	return codDocumentosRequeridos;
}

public void setCodDocumentosRequeridos(Long codDocumentosRequeridos) {
	this.codDocumentosRequeridos = codDocumentosRequeridos;
}

public Long getCodSalidaFCE() {
	return codSalidaFCE;
}

public void setCodSalidaFCE(Long codSalidaFCE) {
	this.codSalidaFCE = codSalidaFCE;
}

public Long getCodDocumento() {
	return codDocumento;
}

public void setCodDocumento(Long codDocumento) {
	this.codDocumento = codDocumento;
}

public Integer getCodeUsuario() {
	return codeUsuario;
}

public void setCodeUsuario(Integer codeUsuario) {
	this.codeUsuario = codeUsuario;
}

@Override
public String toString() {
	return "DocumentFCETO [codDocumentosRequeridos=" + codDocumentosRequeridos
			+ ", codSalidaFCE=" + codSalidaFCE + ", codDocumento="
			+ codDocumento + ", codeUsuario=" + codeUsuario + "]";
}	

}
