package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CompdifinfoTO;



public interface CompdifinfoBusiness {
	public void insertarCompdifinfo(CompdifinfoTO compdifinfoTO) throws Exception;
	public CompdifinfoTO listarCompdifinfo(String codigoCompdifinfo) throws Exception;
	public List<CompdifinfoTO> listarCompdifinfoBySubComponente(String SubComponente) throws Exception;
	public List<CompdifinfoTO> listarCompdifinfoByProducto(String Producto) throws Exception;

}
