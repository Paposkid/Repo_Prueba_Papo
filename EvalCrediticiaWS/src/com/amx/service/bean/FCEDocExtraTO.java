package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a FCEDocExtra.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class FCEDocExtraTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigoDocExtrasFCE
	 */
	private Long codigoDocExtrasFCE;
	/**
	 * Atributo único que identifica el registro codigoFCE
	 */
	private Long codigoFCE;
	/**
	 * Atributo único que identifica el registro codigoDocExtras
	 */
	private Long codigoDocExtras;
	/**
	 * Atributo único que identifica el registro codeUsuario
	 */
	private Integer codeUsuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public 	FCEDocExtraTO(){
		
	}
	public Long getCodigoDocExtrasFCE() {
		return codigoDocExtrasFCE;
	}
	public void setCodigoDocExtrasFCE(Long codigoDocExtrasFCE) {
		this.codigoDocExtrasFCE = codigoDocExtrasFCE;
	}
	public Long getCodigoFCE() {
		return codigoFCE;
	}
	public void setCodigoFCE(Long codigoFCE) {
		this.codigoFCE = codigoFCE;
	}
	public Long getCodigoDocExtras() {
		return codigoDocExtras;
	}
	public void setCodigoDocExtras(Long codigoDocExtras) {
		this.codigoDocExtras = codigoDocExtras;
	}
	public Integer getCodeUsuario() {
		return codeUsuario;
	}
	public void setCodeUsuario(Integer codeUsuario) {
		this.codeUsuario = codeUsuario;
	}
	@Override
	public String toString() {
		return "FcedocextraTO [codigoDocExtrasFCE=" + codigoDocExtrasFCE
				+ ", codigoFCE=" + codigoFCE + ", codigoDocExtras="
				+ codigoDocExtras + ", codeUsuario=" + codeUsuario + "]";
	}	


}
