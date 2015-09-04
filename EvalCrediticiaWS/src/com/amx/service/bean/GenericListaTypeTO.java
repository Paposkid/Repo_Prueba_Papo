package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a GenericListaType.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class GenericListaTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro idLista;
	 */
	private String idLista;
	/**
	 * Atributo único que identifica la lista de objetos parametro
	 */
	private List<GenericParametroTypeTO> parametro;
	
	/**
	 * Constructor que inicialia la clase
	 */
	public GenericListaTypeTO() {
		
	}
	public String getIdLista() {
		return idLista;
	}
	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}
	public List<GenericParametroTypeTO> getParametro() {
		if(parametro == null){
			parametro = new ArrayList<GenericParametroTypeTO>();
		}
		return parametro;
	}
	public void setParametro(List<GenericParametroTypeTO> parametro) {
		this.parametro = parametro;
	}
	@Override
	public String toString() {
		return "GenericListaTypeTO [idLista=" + idLista + ", parametro="
				+ parametro + "]";
	}
	
}
