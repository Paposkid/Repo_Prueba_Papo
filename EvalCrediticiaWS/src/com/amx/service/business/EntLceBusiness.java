package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.EntLceTO;



public interface EntLceBusiness {
	public void insertarLce(EntLceTO entLceTO) throws Exception;
	public List<EntLceTO> buscarEntLce (Integer codEntLce )throws Exception;
	public List<EntLceTO> buscarLceCredApprovalid(Integer idLceCredApprovalid)throws Exception;
}
