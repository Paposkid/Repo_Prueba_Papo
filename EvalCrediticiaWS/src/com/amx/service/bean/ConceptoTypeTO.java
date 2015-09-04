package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a ConceptoType.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ConceptoTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro idConcepto
	 */
	private Integer idConcepto;
	/**
	 * Atributo único que identifica el registro nombre Concepto
	 */
	private String nombreConcepto;
	/**
	 * Atributo único que identifica la lista de objetos listas
	 */
	private List<ListasTypeTO> listas;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ConceptoTypeTO() {
		
	}
	public Integer getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}
	public String getNombreConcepto() {
		return nombreConcepto;
	}
	public void setNombreConcepto(String nombreConcepto) {
		this.nombreConcepto = nombreConcepto;
	}
	public List<ListasTypeTO> getListas() {
		if(listas==null){
			listas  = new ArrayList<ListasTypeTO>();
		}
		return listas;
	}
	public void setListas(List<ListasTypeTO> listas) {
		this.listas = listas;
	}
	@Override
	public String toString() {
		return "ConceptoTypeTO [idConcepto=" + idConcepto + ", nombreConcepto="
				+ nombreConcepto + ", listas=" + listas + "]";
	}
		
}
