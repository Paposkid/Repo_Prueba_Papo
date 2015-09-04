package com.amx.service.xml;


import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class MainTest {
	
	
	public static void main(String[] args) throws JAXBException{
		
		Peticion peticion = new Peticion();
		PeticionServicio peticionServicio = new PeticionServicio();
		Parametro parametro = new Parametro();
		ByteArrayOutputStream bouttream;
		
		peticion.setLlave("");
		
		peticionServicio.setTipo("AUT");
		
		parametro.setNombre("Jorge");
		parametro.setValor("12345");
		peticionServicio.getParametro().add(parametro);
		
		parametro = new Parametro();
		
		parametro.setNombre("Daniel");
		parametro.setValor("12345");
		peticionServicio.getParametro().add(parametro);
		
		peticion.getPeticionServicio().add(peticionServicio);
		
		
		peticionServicio = new PeticionServicio();
		
		peticionServicio.setTipo("CCX");
		
		parametro = new Parametro();
		
		parametro.setNombre("Julian");
		parametro.setValor("12345");
		peticionServicio.getParametro().add(parametro);
		
		parametro = new Parametro();
		
		parametro.setNombre("Mendoza");
		parametro.setValor("12345");
		peticionServicio.getParametro().add(parametro);
		
		peticion.getPeticionServicio().add(peticionServicio);
		
		
		bouttream = new ByteArrayOutputStream();
		
		JAXBContext context = JAXBContext.newInstance(Peticion.class);
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.marshal(peticion, bouttream);
		System.out.println(bouttream.toString());
	
	}

}
