/**
 * 
 */
package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.SalFceTO;




public interface SalFceDAO {

	public void listarFCEById(Map<String, Object> fCETO)throws Exception ;
	public void insertarFCE(SalFceTO salFceTO) throws Exception ;
	public void listarFCECredAprIdOut(Map<String, Object> fCETO)throws Exception ;
	public void updateSalFCEOnlyLineas(SalFceTO salFceTO) throws Exception ;
}
