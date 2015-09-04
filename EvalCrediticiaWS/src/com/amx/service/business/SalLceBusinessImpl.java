package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.CreditScoreTO;
import com.amx.service.bean.NegLceTO;
import com.amx.service.bean.NlineSallopGaptTO;
import com.amx.service.bean.SalLceTO;
import com.amx.service.dao.SalLceDao;


@Service
public class SalLceBusinessImpl implements SalLceBusiness {

	private static Logger logger = Logger.getLogger(SalLceBusinessImpl.class);

	@Autowired
	SalLceDao salLceDao;
	@Autowired
	NegLceBusiness negLCEBL;
	@Autowired
	NlineSallopGaptBusiness nLineSallopGaptBL;
	@Autowired
	CreditScoreBusiness creditScoreBL;

	@Override
	public void insertarLce(SalLceTO salLceTO) throws Exception {
		CreditScoreTO creditScore = null;
		try {
			salLceDao.insertarLce(salLceTO);
			for (NlineSallopGaptTO nl : salLceTO.getNumOfLinAllowedPerGamaAndPro()) {
				nl.setCorrSallce(salLceTO.getCorrLce());
				nLineSallopGaptBL.insertarNlineSallopGapt(nl);
			}
			creditScore = salLceTO.getCredScoreResInfo();
			creditScore.setCorrLce(salLceTO.getCorrLce());
			creditScoreBL.insertarCreditScore(creditScore);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SalLceTO buscarSalLce(Integer codSalLce) throws Exception {
		List<SalLceTO> listaSalLce = null;
		Map<String, Object> mapSalLce = new HashMap<String, Object>();
		SalLceTO miSalLce = null;
		try {
			mapSalLce.put("codSalLce", codSalLce);
			salLceDao.buscarLce(mapSalLce);
			listaSalLce = (List<SalLceTO>) mapSalLce.get("resultados");
			if (!listaSalLce.isEmpty()) {
				miSalLce = listaSalLce.get(0);
				miSalLce.setCredScoreResInfo(creditScoreBL.buscarCreditScore(String.valueOf(codSalLce)));
				miSalLce.getNumOfLinAllowedPerGamaAndPro().addAll(nLineSallopGaptBL.buscarNlineSallopGapt(codSalLce.longValue()));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return miSalLce;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SalLceTO buscarSalLceCredAproId(String credAprovalId) throws Exception {
		List<SalLceTO> listaSalLceCredAproId = null;
		SalLceTO miSalLceTO = null;
		Map<String, Object> mapSalLce = new HashMap<String, Object>();
		try {

			mapSalLce.put("credAprovalId", credAprovalId);
			salLceDao.buscarLceCredApro(mapSalLce);
			listaSalLceCredAproId = (List<SalLceTO>) mapSalLce.get("resultados");
			if (!listaSalLceCredAproId.isEmpty()) {
				miSalLceTO = listaSalLceCredAproId.get(0);
				miSalLceTO.setCredScoreResInfo(creditScoreBL.buscarCreditScore(miSalLceTO.getCorrLce().toString()));
				miSalLceTO.getNumOfLinAllowedPerGamaAndPro().addAll(nLineSallopGaptBL.buscarNlineSallopGapt(miSalLceTO.getCorrLce()));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return miSalLceTO;
	}

	@Override
	public SalLceTO buscarSalLceOrderId(String orderId) throws Exception {
		SalLceTO objSalLCE = null;
		try {
			NegLceTO miNegLceTO = negLCEBL.listNegLceOrder(Integer.parseInt(orderId));

			if (miNegLceTO != null) {
				if (miNegLceTO.getFechaModificacion() != null && !miNegLceTO.getFechaModificacion().equals("")) {
					objSalLCE = buscarSalLce(miNegLceTO.getCodLce().intValue());
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return objSalLCE;
	}

}
