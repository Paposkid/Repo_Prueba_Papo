package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a Update Request Type.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class UpdateRequestTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro id Transaccion
	 */
	private String idTransaccion;
	/**
	 * Atributo único que identifica la lista de objetos lista
	 */
	private List<UpdateListaTypeTO> lista;
	
	/**
	 * Constructor que inicializa la clase  
	 */
	public UpdateRequestTypeTO() {
	}
	
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public List<UpdateListaTypeTO> getLista() {
		if(lista == null){
			lista = new ArrayList<UpdateListaTypeTO>();
		}
		return lista;
	}
	public void setLista(List<UpdateListaTypeTO> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "UpdateRequestTypeTO [idTransaccion=" + idTransaccion
				+ ", lista=" + lista + "]";
	}
	
}
