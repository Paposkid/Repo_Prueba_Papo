package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.AttrdifinfoTO;




public interface AttrdifinfoDAO {
	public void insertarAttrdifinfo(AttrdifinfoTO AttrdifinfoTO)throws Exception ;	
	public void listarAttrdifinfo(Map<String, Object> attrdifinfoTO)throws Exception ;

}
