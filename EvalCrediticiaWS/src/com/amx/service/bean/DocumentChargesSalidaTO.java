package com.amx.service.bean;

import com.amx.schema.charge.getdocumentcharges.ChargeAllDetailsInfo;
import com.amx.schema.charge.getdocumentcharges.PaginationInfo;

public class DocumentChargesSalidaTO {
	
	private ChargeAllDetailsInfo chargeAllDetailsInfo;
	private PaginationInfo paginationInfo;
	
	public DocumentChargesSalidaTO() {
		
	}

	/**
	 * @return the chargeAllDetailsInfo
	 */
	public ChargeAllDetailsInfo getChargeAllDetailsInfo() {
		if (chargeAllDetailsInfo==null) {
			chargeAllDetailsInfo = new ChargeAllDetailsInfo();
		}
		return chargeAllDetailsInfo;
	}

	/**
	 * @param chargeAllDetailsInfo the chargeAllDetailsInfo to set
	 */
	public void setChargeAllDetailsInfo(ChargeAllDetailsInfo chargeAllDetailsInfo) {
		this.chargeAllDetailsInfo = chargeAllDetailsInfo;
	}

	/**
	 * @return the paginationInfo
	 */
	public PaginationInfo getPaginationInfo() {
		if (paginationInfo==null) {
			paginationInfo = new PaginationInfo();
		}
		return paginationInfo;
	}

	/**
	 * @param paginationInfo the paginationInfo to set
	 */
	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DocumentChargesSalida [chargeAllDetailsInfo="
				+ chargeAllDetailsInfo + ", paginationInfo=" + paginationInfo
				+ "]";
	}
	
	
	

}
