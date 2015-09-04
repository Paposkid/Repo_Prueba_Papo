package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AffiinformationTO;
import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.bean.EntFceTO;
import com.amx.service.bean.ProductTO;
import com.amx.service.dao.EntFceDAO;


@Service
public class EntFCEBusinessImpl implements EntFCEBusiness {

	private static Logger logger = Logger.getLogger(EntFCEBusinessImpl.class);

	@Autowired
	private EntFceDAO entFCEDAO;

	@Autowired
	private ProductBusiness productBusinessImpl;

	@Autowired
	private AffiIformationBusiness affiIformationBusinessImpl;

	@Autowired
	private CredScoreInfoBusiness credScoreInfoBusinessImpl;

	@Override
	public void insertarEntFCE(EntFceTO entFceTO) throws Exception {
		try {

			credScoreInfoBusinessImpl.insertarCredScoreInfo(entFceTO
					.getCredScoreInfo());
			entFceTO.setCorrCredScoreInfo(entFceTO.getCredScoreInfo()
					.getCodigoCredScoreInfo());

			affiIformationBusinessImpl.insertarAfiiInformation(entFceTO
					.getAfiliado());
			entFceTO.setCorrAffiInformation(entFceTO.getAfiliado()
					.getCorrAffInformation());

			entFCEDAO.ingresarFce(entFceTO);

			for (ProductTO ds : entFceTO.getProducto()) {
				ds.setCorrEntfce(entFceTO.getCorrFCE());
				productBusinessImpl.insertarProduct(ds);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntFceTO> searchListEntFCE(Long corrFCE) throws Exception {
		List<EntFceTO> listEntFCE = null;
		List<ProductTO> listProductTO = new ArrayList<ProductTO>();

		Map<String, Object> mapEntFCEBean = new HashMap<String, Object>();
		try {
			mapEntFCEBean.put("corrFCE", corrFCE);
			entFCEDAO.buscarFce(mapEntFCEBean);
			listEntFCE = (List<EntFceTO>) mapEntFCEBean.get("resultados");
			if (!listEntFCE.isEmpty()) {
				for (EntFceTO ds : listEntFCE) {
					CredScoreInfoTO credScoreInfoTO = new CredScoreInfoTO();
					credScoreInfoTO.setCodigoCredScoreInfo(ds
							.getCorrCredScoreInfo());
					List<CredScoreInfoTO> listCredScoreInfoTO = new ArrayList<CredScoreInfoTO>();
					listCredScoreInfoTO = credScoreInfoBusinessImpl
							.consultarCredScoreInfoByCodigo(credScoreInfoTO);
					if (!listCredScoreInfoTO.isEmpty()) {
						ds.setCredScoreInfo(listCredScoreInfoTO.get(0));
					}

					List<AffiinformationTO> listAffiinformationTO = new ArrayList<AffiinformationTO>();
					listAffiinformationTO = affiIformationBusinessImpl
							.searchListAfiInfo(ds.getCorrAffiInformation());
					if (!listAffiinformationTO.isEmpty()) {
						ds.setAfiliado(listAffiinformationTO.get(0));
					}
					listProductTO = productBusinessImpl.buscarProductByEFCE(ds
							.getCorrFCE());
					if (!listProductTO.isEmpty()) {
						ds.getProducto().addAll(listProductTO);
					}

				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listEntFCE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntFceTO> searchListEntFCEAproId(String credApproValidInput)
			throws Exception {
		List<ProductTO> listProductTO = new ArrayList<ProductTO>();
		List<EntFceTO> listEntFCEAproId = null;
		Map<String, Object> mapEntFCEBean = new HashMap<String, Object>();

		try {
			mapEntFCEBean.put("credApproValidInput", credApproValidInput);
			entFCEDAO.buscarFceXAprovalId(mapEntFCEBean);
			listEntFCEAproId = (List<EntFceTO>) mapEntFCEBean.get("resultados");

			if (!listEntFCEAproId.isEmpty()) {
				for (EntFceTO ds : listEntFCEAproId) {
					CredScoreInfoTO credScoreInfoTO = new CredScoreInfoTO();
					credScoreInfoTO.setCodigoCredScoreInfo(ds
							.getCorrCredScoreInfo());
					List<CredScoreInfoTO> listCredScoreInfoTO = new ArrayList<CredScoreInfoTO>();
					listCredScoreInfoTO = credScoreInfoBusinessImpl
							.consultarCredScoreInfoByCodigo(credScoreInfoTO);
					if (!listCredScoreInfoTO.isEmpty()) {
						ds.setCredScoreInfo(listCredScoreInfoTO.get(0));
					}

					List<AffiinformationTO> listAffiinformationTO = new ArrayList<AffiinformationTO>();
					listAffiinformationTO = affiIformationBusinessImpl
							.searchListAfiInfo(ds.getCorrAffiInformation());
					if (!listAffiinformationTO.isEmpty()) {
						ds.setAfiliado(listAffiinformationTO.get(0));
					}
					listProductTO = productBusinessImpl.buscarProductByEFCE(ds
							.getCorrFCE());
					if (!listProductTO.isEmpty()) {
						ds.getProducto().addAll(listProductTO);
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listEntFCEAproId;
	}

}
