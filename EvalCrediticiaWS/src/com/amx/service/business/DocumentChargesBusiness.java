package com.amx.service.business;

import com.amx.service.bean.DocumentChargesSalidaTO;
import com.amx.service.bean.DocumentChargesTO;

public interface DocumentChargesBusiness {
	
	public DocumentChargesSalidaTO consultarAporteDeIVA (String id)throws Exception;

}
