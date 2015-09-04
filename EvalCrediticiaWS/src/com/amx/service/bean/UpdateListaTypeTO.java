package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a Update Lista Type.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class UpdateListaTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro id Lista
	 */
	private String idLista;
	/**
	 * Atributo único que identifica el registro número Condiciones
	 */
	private Integer numCondiciones = 0;
	/**
	 * Atributo único que identifica la lista de objetos parametro
	 */
	private List<UpdateParametroTypeTO> parametro;
	/**
	 *Constructor  que inicializa la clase 
	 */
	public UpdateListaTypeTO() {
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
	public List<UpdateParametroTypeTO> getParametro() {
		if(parametro == null){
			parametro = new ArrayList<UpdateParametroTypeTO>();
		}
		return parametro;
	}
	public void setParametro(List<UpdateParametroTypeTO> parametro) {
		this.parametro = parametro;
	}
	@Override
	public String toString() {
		return "UpdateListaTypeTO [idLista=" + idLista + ", numCondiciones="
				+ numCondiciones + ", parametro=" + parametro + "]";
	}
	
	
}
