package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.OrderactionTO;




public interface OrderactionBusiness {
	public void insertarLceOrderaction(OrderactionTO orderactionTO) throws Exception;
	public List<OrderactionTO> buscarOrderaction (Long codOrderaction )throws Exception;
}
