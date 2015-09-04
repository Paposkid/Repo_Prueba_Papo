package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.EquifaxDetalleTO;





public interface EquifaxDetalleBusiness {
	
	public void insertarDetalleEquifax(EquifaxDetalleTO detalleEquifaxTO) throws Exception;
	public List<EquifaxDetalleTO> listarDetalleEquifax(String codigoEquifax) throws Exception;
	public List<EquifaxDetalleTO> listarDetalleEquifaxByRut(String rut) throws Exception;
}
