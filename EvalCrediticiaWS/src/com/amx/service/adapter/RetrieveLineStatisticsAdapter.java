package com.amx.service.adapter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.ApplicationContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.GamaStatistics;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.MaskInfo;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.OrderingContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatisticsInput;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatisticsOutput;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatisticsResponse;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatistics_Type;
import com.amx.service.bean.GamaStatisticsSalidaTO;
import com.amx.service.bean.RetrieveLineStatisticsSalidaTO;
import com.amx.service.bean.RetrieveLineStatisticsTypeTO;

public class RetrieveLineStatisticsAdapter {

	private static Logger logger = Logger.getLogger(RetrieveLineStatisticsAdapter.class);

	public static RetrieveLineStatistics_Type beanToRequest(RetrieveLineStatisticsTypeTO retrieveLine) throws Exception {

		RetrieveLineStatistics_Type retrieveLineStatisticsType = new RetrieveLineStatistics_Type();
		ApplicationContext applicationContext = new ApplicationContext();
		OrderingContext orderingContext = new OrderingContext();
		RetrieveLineStatisticsInput retrieveLineStatisticsInput = new RetrieveLineStatisticsInput();
		MaskInfo maskInfo = new MaskInfo();

		try {
			// if (retrieveLineStatisticsType.getArg0()!=null) {
			// retrieveLineStatisticsType.getArg0().setEnforcedTargetBinding(retrieveLine.getArg0().getEnforcedTargetBinding());
			// retrieveLineStatisticsType.getArg0().setForcedTargetSystem(retrieveLine.getArg0().getForcedTargetSystem());
			// retrieveLineStatisticsType.getArg0().setFormatLocale(retrieveLine.getArg0().getFormatLocale());
			// retrieveLineStatisticsType.getArg0().setInitiatorSystemId(retrieveLine.getArg0().getInitiatorSystemId());
			// retrieveLineStatisticsType.getArg0().setNavData(retrieveLine.getArg0().getNavData());
			// retrieveLineStatisticsType.getArg0().setNavType(retrieveLine.getArg0().getNavType());
			// retrieveLineStatisticsType.getArg0().setOperationDomain(retrieveLine.getArg0().getOperationDomain());
			// retrieveLineStatisticsType.getArg0().setUiType(retrieveLine.getArg0().getUiType());
			// }else {
			// retrieveLineStatisticsType.setArg0(applicationContext);
			// retrieveLineStatisticsType.getArg0().setEnforcedTargetBinding(retrieveLine.getArg0().getEnforcedTargetBinding());
			// retrieveLineStatisticsType.getArg0().setForcedTargetSystem(retrieveLine.getArg0().getForcedTargetSystem());
			// retrieveLineStatisticsType.getArg0().setFormatLocale(retrieveLine.getArg0().getFormatLocale());
			// retrieveLineStatisticsType.getArg0().setInitiatorSystemId(retrieveLine.getArg0().getInitiatorSystemId());
			// retrieveLineStatisticsType.getArg0().setNavData(retrieveLine.getArg0().getNavData());
			// retrieveLineStatisticsType.getArg0().setNavType(retrieveLine.getArg0().getNavType());
			// retrieveLineStatisticsType.getArg0().setOperationDomain(retrieveLine.getArg0().getOperationDomain());
			// retrieveLineStatisticsType.getArg0().setUiType(retrieveLine.getArg0().getUiType());
			// }if (retrieveLineStatisticsType.getArg1()!=null) {
			// retrieveLineStatisticsType.getArg1().setAvailableProductLazyLoadLevel(retrieveLine.getArg1().getAvailableProductLazyLoadLevel());
			// retrieveLineStatisticsType.getArg1().setCachingMode(retrieveLine.getArg1().getCachingMode());
			// retrieveLineStatisticsType.getArg1().setFrameworkId(retrieveLine.getArg1().getFrameworkId());
			// retrieveLineStatisticsType.getArg1().setLocale(retrieveLine.getArg1().getLocale());
			// retrieveLineStatisticsType.getArg1().setSalesChannel(retrieveLine.getArg1().getSalesChannel());
			// retrieveLineStatisticsType.getArg1().setSecurityToken(retrieveLine.getArg1().getSecurityToken());
			// retrieveLineStatisticsType.getArg1().setTimeZone(retrieveLine.getArg1().getTimeZone());
			// retrieveLineStatisticsType.getArg1().setUserID(retrieveLine.getArg1().getUserID());
			// }else {
			// retrieveLineStatisticsType.setArg1(orderingContext);
			// retrieveLineStatisticsType.getArg1().setAvailableProductLazyLoadLevel(retrieveLine.getArg1().getAvailableProductLazyLoadLevel());
			// retrieveLineStatisticsType.getArg1().setCachingMode(retrieveLine.getArg1().getCachingMode());
			// retrieveLineStatisticsType.getArg1().setFrameworkId(retrieveLine.getArg1().getFrameworkId());
			// retrieveLineStatisticsType.getArg1().setLocale(retrieveLine.getArg1().getLocale());
			// retrieveLineStatisticsType.getArg1().setSalesChannel(retrieveLine.getArg1().getSalesChannel());
			// retrieveLineStatisticsType.getArg1().setSecurityToken(retrieveLine.getArg1().getSecurityToken());
			// retrieveLineStatisticsType.getArg1().setTimeZone(retrieveLine.getArg1().getTimeZone());
			// retrieveLineStatisticsType.getArg1().setUserID(retrieveLine.getArg1().getUserID());
			// }
			// if (retrieveLineStatisticsType.getArg2()!=null) {
			// retrieveLineStatisticsType.getArg2().setCustomerIdX11(retrieveLine.getArg2().getCustomerIdX11());
			// }else {
			// retrieveLineStatisticsType.setArg2(retrieveLineStatisticsInput);
			// retrieveLineStatisticsType.getArg2().setCustomerIdX11(retrieveLine.getArg2().getCustomerIdX11());
			// }
			// if (retrieveLineStatisticsType.getArg3()!=null) {
			//
			// for (int i = 0; i <
			// retrieveLine.getArg3().getMaskPropertyPathList().size(); i++) {
			// retrieveLineStatisticsType.getArg3().getMaskPropertyPathList().add(retrieveLine.getArg3().getMaskPropertyPathList().get(i));
			// }
			// }else {
			// retrieveLineStatisticsType.setArg3(maskInfo);
			// for (int i = 0; i <
			// retrieveLine.getArg3().getMaskPropertyPathList().size(); i++) {
			// retrieveLineStatisticsType.getArg3().getMaskPropertyPathList().add(retrieveLine.getArg3().getMaskPropertyPathList().get(i));
			// }
			// }

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return retrieveLineStatisticsType;
	}

	public static RetrieveLineStatisticsSalidaTO responseToBean(RetrieveLineStatisticsResponse retrieveLine) throws Exception {

		RetrieveLineStatisticsSalidaTO retrieveLineStatisticsSalidaTO = new RetrieveLineStatisticsSalidaTO();
		RetrieveLineStatisticsOutput retrieveLineStatisticsOutput = new RetrieveLineStatisticsOutput();
		RetrieveLineStatisticsResponse retrieveLineStatisticsResponse = new RetrieveLineStatisticsResponse();
		
		try {

			
			for (GamaStatistics gamaStatisticsSalida : retrieveLine.getRetrieveLineStatisticsOutput().getCustomerLineStatisticsX11().getGamaStatisticsX11()) {
				
				retrieveLineStatisticsSalidaTO.getRetrieveLineStatisticsOutput().getCustomerLineStatisticsX11().getGamaStatisticsX11().add(responseToBean(gamaStatisticsSalida));
				
			}

			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return retrieveLineStatisticsSalidaTO;
	}
	
	public static GamaStatisticsSalidaTO responseToBean (GamaStatistics gamaStatistics)throws Exception {
		GamaStatisticsSalidaTO gamaStatisticsSalidaTO = new GamaStatisticsSalidaTO();
		try {
			
			gamaStatisticsSalidaTO.setGamaTypeX11(gamaStatistics.getGAMATypeX11());
			gamaStatisticsSalidaTO.setTotalActiveLinesX11(gamaStatistics.getTotalActiveLinesX11());
			gamaStatisticsSalidaTO.setTotalAssignedLinesX11(gamaStatistics.getTotalAssignedLinesX11());
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return gamaStatisticsSalidaTO;
	}

}
