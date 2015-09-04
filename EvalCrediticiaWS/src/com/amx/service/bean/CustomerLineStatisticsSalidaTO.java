package com.amx.service.bean;

import java.util.ArrayList;

import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetentionCase;

public class CustomerLineStatisticsSalidaTO {
	
	private ArrayList<GamaStatisticsSalidaTO> gamaStatisticsX11;
	private OrderActionAndProductsStatisticsSalidaTO orderActionAndProductsStatisticsX11;
	private ArrayList<RetentionCase> retentionCaseX11;
	
	public CustomerLineStatisticsSalidaTO() {
		
	}

	/**
	 * @return the gamaStatisticsX11
	 */
	public ArrayList<GamaStatisticsSalidaTO> getGamaStatisticsX11() {
		if (gamaStatisticsX11 == null) {
            gamaStatisticsX11 = new ArrayList<GamaStatisticsSalidaTO>();
        }
		return gamaStatisticsX11;
	}

	/**
	 * @param gamaStatisticsX11 the gamaStatisticsX11 to set
	 */
	public void setGamaStatisticsX11(ArrayList<GamaStatisticsSalidaTO> gamaStatisticsX11) {
		this.gamaStatisticsX11 = gamaStatisticsX11;
	}

	/**
	 * @return the orderActionAndProductsStatisticsX11
	 */
	public OrderActionAndProductsStatisticsSalidaTO getOrderActionAndProductsStatisticsX11() {
		return orderActionAndProductsStatisticsX11;
	}

	/**
	 * @param orderActionAndProductsStatisticsX11 the orderActionAndProductsStatisticsX11 to set
	 */
	public void setOrderActionAndProductsStatisticsX11(
			OrderActionAndProductsStatisticsSalidaTO orderActionAndProductsStatisticsX11) {
		this.orderActionAndProductsStatisticsX11 = orderActionAndProductsStatisticsX11;
	}

	/**
	 * @return the retentionCaseX11
	 */
	public ArrayList<RetentionCase> getRetentionCaseX11() {
		 if (retentionCaseX11 == null) {
	            retentionCaseX11 = new ArrayList<RetentionCase>();
	        }
		return retentionCaseX11;
	}

	/**
	 * @param retentionCaseX11 the retentionCaseX11 to set
	 */
	public void setRetentionCaseX11(ArrayList<RetentionCase> retentionCaseX11) {
		this.retentionCaseX11 = retentionCaseX11;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerLineStatisticsSalidaTO [gamaStatisticsX11=" + gamaStatisticsX11 + ", orderActionAndProductsStatisticsX11=" + orderActionAndProductsStatisticsX11 + ", retentionCaseX11="
				+ retentionCaseX11 + "]";
	}

	
	
	

}
