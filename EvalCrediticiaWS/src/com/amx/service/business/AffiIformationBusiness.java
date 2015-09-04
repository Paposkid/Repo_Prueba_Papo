package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.AffiinformationTO;



public interface AffiIformationBusiness {

	public void insertarAfiiInformation (AffiinformationTO afiInformation)throws Exception;
	public List<AffiinformationTO> searchListAfiInfo (Long corrAffInfo) throws Exception;
	public List<AffiinformationTO> searchListAfiInfoAfiliate (String affiliate) throws Exception;
}
