package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a GenericParametroType.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class GenericParametroTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro id
	 */
	private String id;
	/**
	 * Atributo único que identifica el registro valor
	 */
	private String valor;
	/**
	 * Atributo único que identifica el registro mensaje
	 */
	private String mensaje;
	/**
	 * Atributo único que identifica el registro resultado
	 */
	private int resultado;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public GenericParametroTypeTO() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "GenericParametroTypeTO [id=" + id + ", valor=" + valor
				+ ", mensaje=" + mensaje + ", resultado=" + resultado + "]";
	}
	
}
