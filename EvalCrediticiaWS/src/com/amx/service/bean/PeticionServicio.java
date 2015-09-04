package com.amx.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class PeticionServicio {
	
	
	@XmlElement
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
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
