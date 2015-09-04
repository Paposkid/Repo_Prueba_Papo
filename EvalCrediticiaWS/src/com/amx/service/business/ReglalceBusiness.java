package com.amx.service.business;



import java.util.List;

import com.amx.service.bean.ReglalceTO;



public interface ReglalceBusiness {
	public void insertarReglalce(ReglalceTO reglalceTO) throws Exception;
	public List<ReglalceTO> listarReglalce(String codigoReglalce) throws Exception;


}
