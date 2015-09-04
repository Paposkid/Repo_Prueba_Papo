package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a ReadRequestType.
 * 
 * @author Julian Montoya julian.montollapalacio@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class ReadRequestTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro  idTransaccion
	 */
	private String idTransaccion;
	/**
	 * Atributo único que identifica el registro lista
	 */
	private List<ReadListaTypeTO> lista;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ReadRequestTypeTO() {
		
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public List<ReadListaTypeTO> getLista() {
		if(lista == null){
			lista = new ArrayList<ReadListaTypeTO>();
		}
		return lista;
	}
	public void setLista(List<ReadListaTypeTO> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "ReadRequestTypeTO [idTransaccion=" + idTransaccion + ", lista="
				+ lista + "]";
	}
	
}
