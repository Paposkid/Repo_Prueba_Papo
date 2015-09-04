package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.NegLceTO;



public interface NegLceDAO {

	public void insertarNegLce(NegLceTO negLceTO)throws Exception ;
	public void listNegLce(Map<String, Object> negLceBean) throws Exception ;
	public void actualizarNegLce (NegLceTO negLceTO) throws Exception ;
	public void actualizarEstadoNegLce(NegLceTO negLceBean)throws Exception ;
	public void listNegLceOrder(Map<String, Object> negLceBean) throws Exception ;
}
