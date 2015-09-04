package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que expone los valores y datos que hace referencia a Actual list response type.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ActualListResponseTypeTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo unico que identifica el Id de la transaccion
	 */
	private String idTransaccion;
	/**
	 * Atributo que identifica  una lista de obejtos de concepto type
	 */
	private List<ConceptoTypeTO> concepto;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ActualListResponseTypeTO() {
		
	}
	/**
	 * Método que obtiene el id transaccion 
	 * @return idTransaccion
	 */
	public String getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * Método que establece el id transaccion
	 * @param idTransaccion
	 */
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	/**
	 * Método que obtiene la lista de conceptos
	 * @return concepto
	 */
	public List<ConceptoTypeTO> getConcepto() {
		if(concepto==null){
			concepto = new ArrayList<ConceptoTypeTO>();
		}
		return concepto;
	}
	/**
	 * Método que establece la lista con sus atributos
	 * @param concepto
	 */
	public void setConcepto(List<ConceptoTypeTO> concepto) {
		this.concepto = concepto;
	}
	
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActualListResponseTypeTO [idTransaccion=" + idTransaccion
				+ ", concepto=" + concepto + "]";
	} 
	
}
