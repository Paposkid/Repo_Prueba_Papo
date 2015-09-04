package com.amx.service.adapter;

import com.amx.service.bean.ActualListRequestTypeTO;

import cl.claro.xsd.speciallist.RequestType;

public class ActualListAdapter {

	public static ActualListRequestTypeTO actualLisRequestTypeTobean(
			RequestType object) {

		ActualListRequestTypeTO response = new ActualListRequestTypeTO();
		response.setIdTransaccion(object.getIdTransaccion());
		return response;
	}
}