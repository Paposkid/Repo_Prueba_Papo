package com.amx.service.business;



import java.util.List;

import com.amx.service.bean.NegLceTO;



public interface NegLceBusiness {

	public void insertarNegLce (NegLceTO negLceTO) throws Exception;
	public List<NegLceTO> listNegLce (Integer codLce) throws Exception;
	public void actualizarNegLce (NegLceTO negLceTO) throws Exception;
	public void actualizarEstadoNegLce(NegLceTO negLceBean)throws Exception;
	public NegLceTO listNegLceOrder (Integer nroOrden) throws Exception;
}
