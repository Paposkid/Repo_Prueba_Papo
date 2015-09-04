/**
 * 
 */
package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.SALDocumentTO;



public interface SALDocumentDAO {

	public void listarSALDocumentById(Map<String, Object> salDocument)	throws Exception ;
	public void listarSALDocumentByNombre(Map<String, Object> salDocumentnNombre)	throws Exception ;
	public void insertarSALDocument(SALDocumentTO salDocument) throws Exception ;
}
