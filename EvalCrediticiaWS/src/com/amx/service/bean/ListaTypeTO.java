package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a ListaType.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ListaTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro idLista
	 */
	private String idLista;
	/**
	 * Atributo único que identifica la lista de objetos parametro
	 */
	private List<ParametroTypeTO> parametro;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ListaTypeTO() {
		
	}
	public String getIdLista() {
		return idLista;
	}
	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}
	public List<ParametroTypeTO> getParametro() {
		if(parametro == null){
			parametro = new ArrayList<ParametroTypeTO>();
		}
		return parametro;
	}
	public void setParametro(List<ParametroTypeTO> parametro) {
		this.parametro = parametro;
	}
	@Override
	public String toString() {
		return "ListaTypeTO [idLista=" + idLista + ", parametro=" + parametro
				+ "]";
	}
	
}
