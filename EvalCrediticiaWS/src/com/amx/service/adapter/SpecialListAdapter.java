package com.amx.service.adapter;

import java.util.ArrayList;
import java.util.List;

import com.amx.service.bean.ReadListaTypeTO;
import com.amx.service.bean.ReadParametroTypeTO;
import com.amx.service.bean.ReadRequestTypeTO;

import cl.claro.xsd.speciallist.ReadListaType;
import cl.claro.xsd.speciallist.ReadParametroType;
import cl.claro.xsd.speciallist.ReadRequestType;

public class SpecialListAdapter {

	public static ReadRequestTypeTO specialListReadRequestTypeToBean(
			ReadRequestType object, String resp) {

		ReadRequestTypeTO response = new ReadRequestTypeTO();
		response.setIdTransaccion(object.getIdTransaccion());

		List<ReadListaTypeTO> lstRead = new ArrayList<ReadListaTypeTO>();
		List<ReadParametroTypeTO> lstReadParm = new ArrayList<ReadParametroTypeTO>();

		for (ReadListaType itera : object.getLista()) {
			ReadListaTypeTO var = new ReadListaTypeTO();
			var.setIdLista(itera.getIdLista());
			var.setRespuesta(resp);
			var.setOrigen("Servicio Externo");
			for (ReadParametroType iteraDos : itera.getParametro()) {
				ReadParametroTypeTO varDos = new ReadParametroTypeTO();
				varDos.setIdParam(iteraDos.getId());
				varDos.setValor(iteraDos.getValor());
				lstReadParm.add(varDos);
			}
			var.setParametro(lstReadParm);
			lstRead.add(var);
		}
		response.setLista(lstRead);

		return response;
	}
}