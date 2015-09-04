package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.SALDocumentTO;


public interface SALDocumentBusiness {
	public void insertarSALDocument(SALDocumentTO sALDocumentTO)throws Exception;
	public List<SALDocumentTO>buscarSALDocument(String codigo) throws Exception;
	public List<SALDocumentTO>buscarSALDocumentByNombre(String nombre) throws Exception;
}
