package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a EquivalenteEntrada.
 * 
 * @author  Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class EquivalenteEntradaTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro campo
	 */
	private String campo;
	/**
	 * Atributo único que identifica el registro atributo
	 */
	private String atributo;
	/**
	 * Atributo único que identifica el registro objeto
	 */
	private String objeto;

	/**
	 * Constructor que inicializa la clase
	 */
	public EquivalenteEntradaTO() {
		
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	@Override
	public String toString() {
		return "EquivalenteEntradaTO [campo=" + campo + ", atributo="
				+ atributo + ", objeto=" + objeto + "]";
	}
	
	
}
