package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ReglaTO;



public interface ReglaBusiness {

	public void insertarRegla(ReglaTO reglaTO) throws Exception;

	public List<ReglaTO> buscarRegla(ReglaTO reglaTO) throws Exception;

	public void actualizarRegla(ReglaTO reglaTO) throws Exception;
	
	public List<ReglaTO> buscarReglaAEvaluar(ReglaTO reglaTO) throws Exception;
}
