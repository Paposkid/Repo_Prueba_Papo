package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.CreditScoreTO;
import com.amx.service.dao.CreditScoreDao;


@Service
public class CreditScoreBusinessImpl implements CreditScoreBusiness {

	private static Logger logger = Logger
			.getLogger(CreditScoreBusinessImpl.class);

	@Autowired
	CreditScoreDao creditScoreDao;

	@Override
	public void insertarCreditScore(CreditScoreTO creditScoreTO)
			throws Exception {
		try {
			creditScoreDao.insertarCreditScore(creditScoreTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public CreditScoreTO buscarCreditScore(String codLce) throws Exception {
		List<CreditScoreTO> listaCreditScore = null;
		CreditScoreTO creditScore = null;
		Map<String, Object> mapCreditScore = new HashMap<String, Object>();
		try {

			mapCreditScore.put("codLce", codLce);
			creditScoreDao.buscarCreditScore(mapCreditScore);
			listaCreditScore = (List<CreditScoreTO>) mapCreditScore
					.get("resultados");
			if (!listaCreditScore.isEmpty()) {
				creditScore = listaCreditScore.get(0);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return creditScore;
	}

}
