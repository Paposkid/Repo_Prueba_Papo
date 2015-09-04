package com.amx.service.xml;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;




public class PeticionServicio {
	
	
	private String tipo;
	
	
	private List<Parametro> parametro;
	
	public PeticionServicio() {
		
	}

	/**
	 * @return the parametro
	 */
	public List<Parametro> getParametro() {
		
		if(parametro == null){
			
			parametro = new ArrayList<Parametro>();
		}
		
		return parametro;
	}

	/**
	 * @param parametro the parametro to set
	 */
	public void setParametro(List<Parametro> parametro) {
		this.parametro = parametro;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	@XmlAttribute(name="tipo")
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}