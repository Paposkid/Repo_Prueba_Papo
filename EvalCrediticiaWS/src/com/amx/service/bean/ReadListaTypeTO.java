package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a ReadListaType.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class ReadListaTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/** 
	 * Atributo único que identifica el registro idLista
	 */
	private String idLista;
	/**
	 * Atributo único que identifica el registro numCondiciones
	 */
	private Integer numCondiciones = 0;
	/**
	 * Atributo único que identifica la lista de objetos parametro
	 */
	private List<ReadParametroTypeTO> parametro;
	/**
	 * Atributo único que identifica el registro codListaEspecial
	 */
	private Long codListaEspecial;
	/**
	 * Atributo único que identifica el registro codUsuario
	 */
	private Integer codUsuario;
	/**
	 * Atributo único que identifica el registro respuesta
	 */
	private String respuesta;
	/**
	 * Atributo único que identifica el registro origen
	 */
	private String origen;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ReadListaTypeTO() {
		
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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
	public String getIdLista() {
		return idLista;
	}
	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}
	public Integer getNumCondiciones() {
		return numCondiciones;
	}
	public void setNumCondiciones(Integer numCondiciones) {
		this.numCondiciones = numCondiciones;
	}
	public List<ReadParametroTypeTO> getParametro() {
		if(parametro == null){
			parametro = new ArrayList<ReadParametroTypeTO>();
		}
		return parametro;
	}
	public void setParametro(List<ReadParametroTypeTO> parametro) {
		this.parametro = parametro;
	}
	@Override
	public String toString() {
		return "ReadListaTypeTO [idLista=" + idLista + ", numCondiciones="
				+ numCondiciones + ", parametro=" + parametro
				+ ", codListaEspecial=" + codListaEspecial + ", codUsuario="
				+ codUsuario + ", respuesta=" + respuesta + ", origen="
				+ origen + "]";
	}
	
}
