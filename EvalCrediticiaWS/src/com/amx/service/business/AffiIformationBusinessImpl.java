package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AffiinformationTO;
import com.amx.service.dao.AffiinformationDAO;


@Service
public class AffiIformationBusinessImpl implements AffiIformationBusiness {

	private static Logger logger = Logger
			.getLogger(AffiIformationBusinessImpl.class);

	@Autowired
	private AffiinformationDAO affiInfoDAO;

	@Override
	public void insertarAfiiInformation(AffiinformationTO afiInformation)
			throws Exception {
		try {
			affiInfoDAO.ingresarAffiinformation(afiInformation);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AffiinformationTO> searchListAfiInfo(Long corrAffInfo)
			throws Exception {
		List<AffiinformationTO> listAfiInfo = null;
		Map<String, Object> mapAffiinformationBean = new HashMap<String, Object>();
		try {
			mapAffiinformationBean.put("corrAffInfo", corrAffInfo);
			affiInfoDAO.buscarAffiinformation(mapAffiinformationBean);
			listAfiInfo = (List<AffiinformationTO>) mapAffiinformationBean
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listAfiInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AffiinformationTO> searchListAfiInfoAfiliate(String affiliate)
			throws Exception {
		List<AffiinformationTO> listAfiInfoAfiliate = null;
		Map<String, Object> mapAffiinformationBean = new HashMap<String, Object>();
		try {
			mapAffiinformationBean.put("affiliate", affiliate);
			affiInfoDAO.buscarAffiinformationAfiliate(mapAffiinformationBean);
			listAfiInfoAfiliate = (List<AffiinformationTO>) mapAffiinformationBean
					.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listAfiInfoAfiliate;
	}

}
