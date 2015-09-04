package com.amx.service.bean;



public class RetrieveLineStatisticsOutputSalidaTO {
	
	private CustomerLineStatisticsSalidaTO customerLineStatisticsX11;

	public RetrieveLineStatisticsOutputSalidaTO() {
		
	}

	/**
	 * @return the customerLineStatisticsX11
	 */
	public CustomerLineStatisticsSalidaTO getCustomerLineStatisticsX11() {
		if (customerLineStatisticsX11==null) {
			customerLineStatisticsX11 = new  CustomerLineStatisticsSalidaTO();
		}
		return customerLineStatisticsX11;
	}

	/**
	 * @param customerLineStatisticsX11 the customerLineStatisticsX11 to set
	 */
	public void setCustomerLineStatisticsX11(
			CustomerLineStatisticsSalidaTO customerLineStatisticsX11) {
		this.customerLineStatisticsX11 = customerLineStatisticsX11;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetrieveLineStatisticsOutputSalidaTO [customerLineStatisticsX11="
				+ customerLineStatisticsX11 + "]";
	}
	
	

}
