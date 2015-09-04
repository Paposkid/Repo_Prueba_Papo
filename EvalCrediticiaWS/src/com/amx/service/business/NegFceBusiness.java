package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.NegFceTO;


public interface NegFceBusiness {

	public void insertarNegFce (NegFceTO negFceTO) throws Exception;
	public NegFceTO listNegFce(Integer codFce,Integer codLce) throws Exception;
	public void actualizarEstadoNegFce(NegFceTO negFceBean)throws Exception;
	public List<NegFceTO> listNegFCEByCodLCE (Integer codLce) throws Exception;
}
