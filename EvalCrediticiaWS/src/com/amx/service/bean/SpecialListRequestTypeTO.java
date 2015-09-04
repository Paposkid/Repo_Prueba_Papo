package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SpecialListRequestType.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SpecialListRequestTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	 /**
	 * Atributo único que identifica el registro id transaccion
	 */
	private String idtransaccion;
	 /**
	 * Atributo único que identifica la lista de objetos  lista
	 */
	private List<ListaTypeTO> lista;
	 
	/**
	 * Constructor que inicializa la clase
	 */
	public SpecialListRequestTypeTO() {
	}
	public String getIdtransaccion() {
		return idtransaccion;
	}
	public void setIdtransaccion(String idtransaccion) {
		this.idtransaccion = idtransaccion;
	}
	public List<ListaTypeTO> getLista() {
		if(lista == null){
			lista = new ArrayList<ListaTypeTO>();
		}
		return lista;
	}
	public void setLista(List<ListaTypeTO> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "SpecialListRequestTypeTO [idtransaccion=" + idtransaccion
				+ ", lista=" + lista + "]";
	}
	
}
