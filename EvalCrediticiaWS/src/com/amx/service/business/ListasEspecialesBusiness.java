package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.bean.ReadListaTypeTO;


public interface ListasEspecialesBusiness {
	
	public List<ReadListaTypeTO> obtenerRespuestaListasEspeciales(
			CredScoreInfoTO creditInfo) throws Exception;
	
}
