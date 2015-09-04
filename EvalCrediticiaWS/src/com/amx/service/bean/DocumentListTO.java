package com.amx.service.bean;


public class DocumentListTO {
	
	private BaIdInfoTO baIdInfo;
	private DateLimitInfoTO dateLimitInfo;
	private PaginationInfoTO paginationInfo;
	
	public DocumentListTO() {
		
	}

	/**
	 * @return the baIdInfo
	 */
	public BaIdInfoTO getBaIdInfo() {
		if (baIdInfo == null) {
			baIdInfo = new BaIdInfoTO();
		}
		return baIdInfo;
	
	}

	/**
	 * @param baIdInfo the baIdInfo to set
	 */
	public void setBaIdInfo(BaIdInfoTO baIdInfo) {
		this.baIdInfo = baIdInfo;
	}

	/**
	 * @return the dateLimitInfo
	 */
	public DateLimitInfoTO getDateLimitInfo() {
		if (dateLimitInfo == null) {
			dateLimitInfo = new DateLimitInfoTO();
		}
		return dateLimitInfo;
	}

	/**
	 * @param dateLimitInfo the dateLimitInfo to set
	 */
	public void setDateLimitInfo(DateLimitInfoTO dateLimitInfo) {
		this.dateLimitInfo = dateLimitInfo;
	}

	/**
	 * @return the paginationInfo
	 */
	public PaginationInfoTO getPaginationInfo() {
		if (paginationInfo==null) {
			paginationInfo = new PaginationInfoTO();
		}
		return paginationInfo;
	}

	/**
	 * @param paginationInfo the paginationInfo to set
	 */
	public void setPaginationInfo(PaginationInfoTO paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DocumentListTO [baIdInfo=" + baIdInfo + ", dateLimitInfo="
				+ dateLimitInfo + ", paginationInfo=" + paginationInfo + "]";
	}
	
	
	

}
