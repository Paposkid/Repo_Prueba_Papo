package com.amx.service.bean;

import java.util.ArrayList;

import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.DisactiveProductsInfo;

public class OrderActionAndProductsStatisticsSalidaTO {

	private ArrayList<DisactiveProductsInfo> disactiveProductsInfoX11;
	private String totalActiveLinesNoCreditStudyX11;
	private String totalPendingCeaseLinesX11;
	
	public OrderActionAndProductsStatisticsSalidaTO() {
		
	}

	/**
	 * @return the disactiveProductsInfoX11
	 */
	public ArrayList<DisactiveProductsInfo> getDisactiveProductsInfoX11() {
		if (disactiveProductsInfoX11 == null) {
            disactiveProductsInfoX11 = new ArrayList<DisactiveProductsInfo>();
        }
		return disactiveProductsInfoX11;
	}

	/**
	 * @param disactiveProductsInfoX11 the disactiveProductsInfoX11 to set
	 */
	public void setDisactiveProductsInfoX11(
			ArrayList<DisactiveProductsInfo> disactiveProductsInfoX11) {
		this.disactiveProductsInfoX11 = disactiveProductsInfoX11;
	}

	/**
	 * @return the totalActiveLinesNoCreditStudyX11
	 */
	public String getTotalActiveLinesNoCreditStudyX11() {
		return totalActiveLinesNoCreditStudyX11;
	}

	/**
	 * @param totalActiveLinesNoCreditStudyX11 the totalActiveLinesNoCreditStudyX11 to set
	 */
	public void setTotalActiveLinesNoCreditStudyX11(
			String totalActiveLinesNoCreditStudyX11) {
		this.totalActiveLinesNoCreditStudyX11 = totalActiveLinesNoCreditStudyX11;
	}

	/**
	 * @return the totalPendingCeaseLinesX11
	 */
	public String getTotalPendingCeaseLinesX11() {
		return totalPendingCeaseLinesX11;
	}

	/**
	 * @param totalPendingCeaseLinesX11 the totalPendingCeaseLinesX11 to set
	 */
	public void setTotalPendingCeaseLinesX11(String totalPendingCeaseLinesX11) {
		this.totalPendingCeaseLinesX11 = totalPendingCeaseLinesX11;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderActionAndProductsStatisticsSalidaTO [disactiveProductsInfoX11="
				+ disactiveProductsInfoX11
				+ ", totalActiveLinesNoCreditStudyX11="
				+ totalActiveLinesNoCreditStudyX11
				+ ", totalPendingCeaseLinesX11="
				+ totalPendingCeaseLinesX11
				+ "]";
	}
	
	
	
}
