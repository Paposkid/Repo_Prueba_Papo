package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.NegExcepcionTO;


public interface NegExcepcionBusiness {

	public void insertarNegExcepcion(NegExcepcionTO negExcepcionTO)
			throws Exception;

	public List<NegExcepcionTO> listNegExcepcion(Integer codExcepcion)
			throws Exception;

	public void actualizarEstadoNegExcepcion(NegExcepcionTO negExcepcionTO)
			throws Exception;

	public NegExcepcionTO buscarNegExcepcionPorCodExcepcion(Integer codExcepcion)
			throws Exception;
}
