package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a GenericResponseType.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class GenericResponseTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro idTransaccion
	 */
	private String idTransaccion;
	/**
	 *  Atributo único que identifica la lista de objetos lista
	 */
	private List<GenericListaTypeTO> lista;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public GenericResponseTypeTO() {
		
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public List<GenericListaTypeTO> getLista() {
		if(lista == null){
			lista = new ArrayList<GenericListaTypeTO>();
		}
		return lista;
	}
	public void setLista(List<GenericListaTypeTO> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "GenericResponseTypeTO [idTransaccion=" + idTransaccion
				+ ", lista=" + lista + "]";
	}
	
}
