package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ContactInfoTO;
import com.amx.service.dao.ContactInfoDao;


@Service
public class ContactInfoBusinessImpl implements ContactInfoBusiness {

	private static Logger logger = Logger
			.getLogger(ContactInfoBusinessImpl.class);

	@Autowired
	ContactInfoDao contactInfoDao;

	@Override
	public void insertarContactInfo(ContactInfoTO contactInfoTO)
			throws Exception {
		try {
			contactInfoDao.insertarContactInfo(contactInfoTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ContactInfoTO buscarContactInfo(String codContactInfo)
			throws Exception {
		ContactInfoTO contactInfo = null;
		List<ContactInfoTO> listaContactInfo = null;
		Map<String, Object> mapContactInfo = new HashMap<String, Object>();
		try {

			mapContactInfo.put("codContactInfo", codContactInfo);
			contactInfoDao.buscarContactInfo(mapContactInfo);
			listaContactInfo = (List<ContactInfoTO>) mapContactInfo
					.get("resultados");
			if (!listaContactInfo.isEmpty()) {
				contactInfo = listaContactInfo.get(0);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return contactInfo;
	}

}
