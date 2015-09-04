package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a ReadParametroType.
 * 
 * @author christian hincapié christian.hincapiemonsalve@tcs.com 
 * @since 22/04/2013
 * @version 1.0
 */
public class ReadParametroTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro idParam
	 */
	private String idParam;
	/**
	 * Atributo único que identifica el registro valor
	 */
	private String valor;
	/**
	 * Atributo único que identifica el registro codListaEspecial
	 */
	private Long codListaEspecial;
	/**
	 * Atributo único que identifica el registro codUsuario
	 */
	private Integer codUsuario;
	/**
	 * Atributo único que identifica el registro codParametro
	 */
	private Long codParametro;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ReadParametroTypeTO() {
		
	}
	public Long getCodListaEspecial() {
		return codListaEspecial;
	}
	public void setCodListaEspecial(Long codListaEspecial) {
		this.codListaEspecial = codListaEspecial;
	}
	public Integer getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}
	public Long getCodParametro() {
		return codParametro;
	}
	public void setCodParametro(Long codParametro) {
		this.codParametro = codParametro;
	}
	public String getIdParam() {
		return idParam;
	}
	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ReadParametroTypeTO [idParam=" + idParam + ", valor=" + valor
				+ ", codListaEspecial=" + codListaEspecial + ", codUsuario="
				+ codUsuario + ", codParametro=" + codParametro + "]";
	}
	
}
