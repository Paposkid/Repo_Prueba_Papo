package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ContactInfoTO;
import com.amx.service.bean.OrderactionTO;
import com.amx.service.dao.OrderactionDAO;


@Service
public class OrderactionBusinessImpl implements OrderactionBusiness {

	private static Logger logger = Logger
			.getLogger(OrderactionBusinessImpl.class);

	@Autowired
	OrderactionDAO orderactionDao;

	@Autowired
	private ContactInfoBusiness contactInfoBL;

	@Override
	public void insertarLceOrderaction(OrderactionTO OrderactionTO)
			throws Exception {
		ContactInfoTO miContactInfo = null;
		try {
			miContactInfo = contactInfoBL.buscarContactInfo(OrderactionTO.getContactInfo().getContId());
			if(miContactInfo != null)
				contactInfoBL.insertarContactInfo(OrderactionTO.getContactInfo());
			OrderactionTO.setCorrContactinfo(OrderactionTO.getContactInfo().getContId());
			orderactionDao.ingresarOrder(OrderactionTO);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderactionTO> buscarOrderaction(Long codOrderaction)
			throws Exception {
		List<OrderactionTO> listaOrderaction = null;
		Map<String, Object> mapOrderaction = new HashMap<String, Object>();
		try {

			mapOrderaction.put("codOrderaction", codOrderaction);
			orderactionDao.buscarOrder(mapOrderaction);
			listaOrderaction = (List<OrderactionTO>) mapOrderaction
					.get("resultados");
			if (!listaOrderaction.isEmpty()) {
				for (OrderactionTO ds : listaOrderaction) {
					ds.setContactInfo(

					contactInfoBL.buscarContactInfo(ds.getCorrContactinfo()));

				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listaOrderaction;
	}

}
