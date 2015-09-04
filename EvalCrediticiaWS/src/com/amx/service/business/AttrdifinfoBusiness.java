package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.AttrdifinfoTO;




public interface AttrdifinfoBusiness {
	public void insertarAttrdifinfo(AttrdifinfoTO AttrdifinfoTO) throws Exception;
	public List<AttrdifinfoTO> listarAttrdifinfo(String codigoAttrdifinfo) throws Exception;


}
