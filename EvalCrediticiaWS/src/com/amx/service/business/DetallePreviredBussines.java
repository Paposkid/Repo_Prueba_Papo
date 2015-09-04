package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DetallePreviredTO;


public interface DetallePreviredBussines {
	
	public void insertarDetallePrevired(DetallePreviredTO detallePreviredTO)throws Exception ;
	public List<DetallePreviredTO> consultarDetallePreviredByCodigo(DetallePreviredTO detallePreviredTO)throws Exception ;


}
