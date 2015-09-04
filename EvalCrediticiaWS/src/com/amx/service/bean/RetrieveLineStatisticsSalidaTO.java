package com.amx.service.bean;



public class RetrieveLineStatisticsSalidaTO {
	
	private RetrieveLineStatisticsOutputSalidaTO retrieveLineStatisticsOutput;

	public RetrieveLineStatisticsSalidaTO() {
		
	}

	/**
	 * @return the retrieveLineStatisticsOutput
	 */
	public RetrieveLineStatisticsOutputSalidaTO getRetrieveLineStatisticsOutput() {
		if (retrieveLineStatisticsOutput==null) {
			retrieveLineStatisticsOutput= new RetrieveLineStatisticsOutputSalidaTO();
		}
		return retrieveLineStatisticsOutput;
	}

	/**
	 * @param retrieveLineStatisticsOutput the retrieveLineStatisticsOutput to set
	 */
	public void setRetrieveLineStatisticsOutput(
			RetrieveLineStatisticsOutputSalidaTO retrieveLineStatisticsOutput) {
		this.retrieveLineStatisticsOutput = retrieveLineStatisticsOutput;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetrieveLineStatisticsSalidaTO [retrieveLineStatisticsOutput="
				+ retrieveLineStatisticsOutput + "]";
	}

	
	
}
