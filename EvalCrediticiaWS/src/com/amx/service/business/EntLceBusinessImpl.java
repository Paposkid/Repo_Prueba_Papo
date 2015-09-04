package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AccrinfoTO;
import com.amx.service.bean.AffiinformationTO;
import com.amx.service.bean.BiomTO;
import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.bean.EntLceTO;
import com.amx.service.dao.EntLceDAO;


@Service
public class EntLceBusinessImpl implements EntLceBusiness {

	private static Logger logger = Logger.getLogger(EntLceBusinessImpl.class);

	@Autowired
	EntLceDAO entLceDao;

	@Autowired
	private CredScoreInfoBusiness creditScoreInfoBL;
	@Autowired
	private AccrinfoBusiness accreditationInfoBL;
	@Autowired
	private AffiIformationBusiness affiliateInformationBL;
	@Autowired
	private BiomBusiness biometricValidationBL;

	@Override
	public void insertarLce(EntLceTO entLceTO) throws Exception {
		try {
			creditScoreInfoBL
					.insertarCredScoreInfo(entLceTO.getCredScoreInfo());//test ok
			entLceTO.setCorrCredscoreinfo(entLceTO.getCredScoreInfo()
					.getCodigoCredScoreInfo());

			affiliateInformationBL.insertarAfiiInformation(entLceTO
					.getAffInfo());//test ok
			entLceTO.setCorrAffiinformation(entLceTO.getAffInfo()
					.getCorrAffInformation());

			entLceDao.ingresarLce(entLceTO);//test ok

			for (BiomTO biometricValidation : entLceTO.getListBiom()) {
				biometricValidation.setCorrEntLCE(entLceTO.getCorrLce());
				biometricValidationBL.insertarBiometric(biometricValidation);//test ok
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntLceTO> buscarEntLce(Integer codEntLce) throws Exception {
		List<EntLceTO> listaEntLce = null;
		List<CredScoreInfoTO> listaCredScoreInfo = null;
		List<AccrinfoTO> listaAccrinfo = null;
		List<AffiinformationTO> listaAffiinformation = null;

		CredScoreInfoTO credScoreInfoTO = null;
		AccrinfoTO accrInfoTO = null;
		AffiinformationTO affiInformationTO = null;
		List<BiomTO> listBiomTO = null;

		Map<String, Object> mapEntLce = new HashMap<String, Object>();
		try {

			mapEntLce.put("codEntLce", codEntLce);
			entLceDao.buscarLce(mapEntLce);
			listaEntLce = (List<EntLceTO>) mapEntLce.get("resultados");
			if (!listaEntLce.isEmpty()) {
				for (EntLceTO ds : listaEntLce) {

					listaAccrinfo = accreditationInfoBL.buscarAccrinfo(ds
							.getCorrLce());
					if (!listaAccrinfo.isEmpty()) {
						accrInfoTO = listaAccrinfo.get(0);
						ds.setAccrInfo(accrInfoTO);
					}
					listaAffiinformation = affiliateInformationBL
							.searchListAfiInfo(ds.getCorrAffiinformation());
					if (!listaAffiinformation.isEmpty()) {
						affiInformationTO = listaAffiinformation.get(0);
						ds.setAffInfo(affiInformationTO);
					}
					listaCredScoreInfo = creditScoreInfoBL
							.consultarCredScoreInfoByCodigo(ds
									.getCredScoreInfo());
					if (!listaCredScoreInfo.isEmpty()) {
						credScoreInfoTO = listaCredScoreInfo.get(0);
						ds.setCredScoreInfo(credScoreInfoTO);
					}
					listBiomTO = biometricValidationBL.searchListBio(ds
							.getCorrAffiinformation());
					if (!listBiomTO.isEmpty()) {
						ds.getListBiom().addAll(listBiomTO);
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listaEntLce;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntLceTO> buscarLceCredApprovalid(Integer idLceCredApprovalid)
			throws Exception {
		List<EntLceTO> listaEntLce = null;
		Map<String, Object> mapEntLce = new HashMap<String, Object>();
		List<CredScoreInfoTO> listaCredScoreInfo = null;
		List<AccrinfoTO> listaAccrinfo = null;
		List<AffiinformationTO> listaAffiinformation = null;

		CredScoreInfoTO credScoreInfoTO = null;
		AccrinfoTO accrInfoTO = null;
		AffiinformationTO affiInformationTO = null;
		List<BiomTO> listBiomTO = null;

		try {

			mapEntLce.put("idLceCredApprovalid", idLceCredApprovalid);
			entLceDao.buscarLceCredApprovalid(mapEntLce);
			listaEntLce = (List<EntLceTO>) mapEntLce.get("resultados");
			if (!listaEntLce.isEmpty()) {
				for (EntLceTO ds : listaEntLce) {

					listaAccrinfo = accreditationInfoBL.buscarAccrinfo(ds
							.getCorrLce());
					if (!listaAccrinfo.isEmpty()) {
						accrInfoTO = listaAccrinfo.get(0);
						ds.setAccrInfo(accrInfoTO);
					}
					listaAffiinformation = affiliateInformationBL
							.searchListAfiInfo(ds.getCorrAffiinformation());
					if (!listaAffiinformation.isEmpty()) {
						affiInformationTO = listaAffiinformation.get(0);
						ds.setAffInfo(affiInformationTO);
					}
					listaCredScoreInfo = creditScoreInfoBL
							.consultarCredScoreInfoByCodigo(ds
									.getCredScoreInfo());
					if (!listaCredScoreInfo.isEmpty()) {
						credScoreInfoTO = listaCredScoreInfo.get(0);
						ds.setCredScoreInfo(credScoreInfoTO);
					}
					listBiomTO = biometricValidationBL.searchListBio(ds
							.getCorrAffiinformation());
					if (!listBiomTO.isEmpty()) {
						ds.getListBiom().addAll(listBiomTO);
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listaEntLce;
	}

}
