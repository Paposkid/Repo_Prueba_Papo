package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.BancoTO;



public interface BancoDAO {
	public void insertarBanco(BancoTO bancoTO)throws Exception ;	
	public void listarBanco(Map<String, Object> bancoTO)throws Exception ;

}
