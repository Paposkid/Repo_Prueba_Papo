package com.amx.service.xml;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name= "peticion")
public class Peticion {

	
	private String llave;
	
	private List<PeticionServicio> peticionServicio;
	/**
	 * @return the llave
	 */
	public String getLlave() {
		return llave;
	}
	/**
	 * @param llave the llave to set
	 */
	@XmlAttribute(name="llave")
	public void setLlave(String llave) {
		this.llave = llave;
	}
	/**
	 * @return the peticionServicio
	 */
	public List<PeticionServicio> getPeticionServicio() {
		
		if(peticionServicio == null){
			
			peticionServicio = new ArrayList<PeticionServicio>();
		}
		
		return peticionServicio;
	}
	/**
	 * @param peticionServicio the peticionServicio to set
	 */
	public void setPeticionServicio(List<PeticionServicio> peticionServicio) {
		this.peticionServicio = peticionServicio;
	}
	
	
	
}
