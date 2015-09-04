package com.amx.service.business;



import java.util.List;

import com.amx.service.bean.AmdocsTO;

public interface AmdocsBusiness {
	
	public void insertarAmdocs(AmdocsTO amdocsTO) throws Exception;	
	public List<AmdocsTO> searchListAmdocs(Long codAmdocs) throws Exception;
	public AmdocsTO consultarApiAmdocs(String rut, String idType) throws Exception;
	
	
}
