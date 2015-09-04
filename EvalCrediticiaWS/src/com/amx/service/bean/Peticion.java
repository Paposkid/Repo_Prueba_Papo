package com.amx.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name= "peticion")
public class Peticion {

	@XmlAttribute(name="llave")
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
