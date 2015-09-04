package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ConditionFCETO;
import com.amx.service.bean.SalFceTO;
import com.amx.service.dao.SalFceDAO;


@Service
public class SalFceBusinessImpl implements SalFceBusiness {

	private static Logger logger = Logger.getLogger(SalFceBusinessImpl.class);

	@Autowired
	private SalFceDAO fCEDAO;

	@Autowired
	private ConditionFCEBusiness conditionBL;

	@Override
	public void insertarFCE(SalFceTO salFceTO) throws Exception {
		try {
			fCEDAO.insertarFCE(salFceTO);
			for (ConditionFCETO cond : salFceTO.getConditions()) {
				cond.setCodSalidaFCE(salFceTO.getCodFCE());
				conditionBL.insertarConditionFCE(cond);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SalFceTO buscarFCE(long codigo) throws Exception {

		List<SalFceTO> lstFCE = null;
		SalFceTO salFce = null;
		Map<String, Object> mapFCE = new HashMap<String, Object>();

		try {
			mapFCE.put("codFCE", codigo);
			fCEDAO.listarFCEById(mapFCE);
			lstFCE = (List<SalFceTO>) mapFCE.get("resultados");
			if (!lstFCE.isEmpty()) {
				salFce = lstFCE.get(0);
				List<ConditionFCETO> lstCondition = new ArrayList<ConditionFCETO>();
				lstCondition = conditionBL.buscarConditionFCE(codigo);
				if (!lstCondition.isEmpty()) {
					salFce.getConditions().addAll(lstCondition);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return salFce;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalFceTO> buscarFCEAproIdOut(String aprobacionCred)
			throws Exception {
		List<SalFceTO> lstFCEAproIdOut = null;
		Map<String, Object> mapFCE = new HashMap<String, Object>();
		try {
			mapFCE.put("aprobacionCred", aprobacionCred);
			fCEDAO.listarFCECredAprIdOut(mapFCE);
			lstFCEAproIdOut = (List<SalFceTO>) mapFCE.get("resultados");
			if (!lstFCEAproIdOut.isEmpty()) {
				for (SalFceTO ds : lstFCEAproIdOut) {
					buscarFCE(ds.getCodFCE());

				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstFCEAproIdOut;
	}
	
	@Override
	public void actualizarSalFCEOnlyLineas(SalFceTO salFceTO) throws Exception {
		
		try {
			
			fCEDAO.updateSalFCEOnlyLineas(salFceTO);
		}  catch (Exception e) {
			logger.error(e.getMessage());
		}


	} 
}
