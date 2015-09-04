package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AccrdocumentTO;
import com.amx.service.bean.AccreditationDataTO;
import com.amx.service.bean.AccrinfoTO;
import com.amx.service.dao.AccrinfoDAO;


@Service
public class AccrinfoBusinessImpl implements AccrinfoBusiness {

	private static Logger logger = Logger.getLogger(AccreditationDataBusinessImpl.class);

	@Autowired
	private AccrinfoDAO accrInfoDAO;

	@Autowired
	private AccreditationDataBusiness accreditationDataBL;

	@Autowired
	private AccrdocumentBusiness accreditationDocumentsBL;

	@Override
	public void insertarAccrinfo(AccrinfoTO accrinfo) throws Exception {

		try {
			accrInfoDAO.ingresarAccrinfo(accrinfo);
			for (AccreditationDataTO accreditationData : accrinfo.getAccrData()) {
				accreditationData.setCorrAccrinfo(accrinfo.getCorrLce());
				accreditationDataBL.insertarAccrdata(accreditationData);
			}
			for (AccrdocumentTO accreditationDocuments : accrinfo
					.getAccrdocumentTO()) {
				accreditationDocuments.setCorrAccrinfo(accrinfo.getCorrLce());
				accreditationDocumentsBL
						.insertarAccrdocument(accreditationDocuments);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccrinfoTO> buscarAccrinfo(Long corrAccrinfo) throws Exception {
		List<AccrinfoTO> listAccr = null;
		Map<String, Object> mapAccrdataTO = new HashMap<String, Object>();
		try {
			mapAccrdataTO.put("corrAccrdocument", corrAccrinfo);
			accrInfoDAO.buscarAccrinfo(mapAccrdataTO);
			listAccr = (List<AccrinfoTO>) mapAccrdataTO.get("resultados");
			if (!listAccr.isEmpty()) {
				for (AccrinfoTO ds : listAccr) {
					List<AccreditationDataTO> listAccrdata = new ArrayList<AccreditationDataTO>();
					listAccrdata = accreditationDataBL.buscarAccrdata(ds
							.getCorrLce());
					if (!listAccrdata.isEmpty()) {
						ds.getAccrData().addAll(listAccrdata);
					}
					List<AccrdocumentTO> listAccrdocument = new ArrayList<AccrdocumentTO>();
					listAccrdocument = accreditationDocumentsBL
							.buscarAccrdocument(ds.getCorrLce());
					if (!listAccrdocument.isEmpty()) {
						ds.getAccrdocumentTO().addAll(listAccrdocument);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listAccr;
	}

}
