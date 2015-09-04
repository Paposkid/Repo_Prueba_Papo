package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.TipoReglaTO;



public interface TipoReglaBusiness {

	public List<TipoReglaTO> listarTipoReglas(TipoReglaTO tipoRegla) throws Exception;
}
