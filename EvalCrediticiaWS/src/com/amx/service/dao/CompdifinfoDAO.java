package com.amx.service.dao;


import java.util.Map;

import com.amx.service.bean.CompdifinfoTO;

public interface CompdifinfoDAO {
	public void insertarCompdifinfo(CompdifinfoTO compdifinfoTO) throws Exception ;
	public void listarCompdifinfo(Map<String, Object> compdifinfoTO) throws Exception ;
	public void listarCompdifinfoBySubComponente(Map<String, Object> compdifinfoTO) throws Exception ;
	public void listarCompdifinfoByProducto(Map<String, Object> compdifinfoTO) throws Exception ;

}
