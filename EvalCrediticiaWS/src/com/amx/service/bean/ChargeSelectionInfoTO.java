package com.amx.service.bean;

public class ChargeSelectionInfoTO {
	
	private String chargeCode;
	private String revenueCode;
	private String dateRange;
	private String chargeOrigin;
	private String billedChargesIsolated;
	
	public ChargeSelectionInfoTO() {
		
	}

	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}

	public String getRevenueCode() {
		return revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public String getChargeOrigin() {
		return chargeOrigin;
	}

	public void setChargeOrigin(String chargeOrigin) {
		this.chargeOrigin = chargeOrigin;
	}

	public String getBilledChargesIsolated() {
		return billedChargesIsolated;
	}

	public void setBilledChargesIsolated(String billedChargesIsolated) {
		this.billedChargesIsolated = billedChargesIsolated;
	}

	@Override
	public String toString() {
		return "ChargeSelectionInfoTO [chargeCode=" + chargeCode
				+ ", revenueCode=" + revenueCode + ", dateRange=" + dateRange
				+ ", chargeOrigin=" + chargeOrigin + ", billedChargesIsolated="
				+ billedChargesIsolated + "]";
	}
	
	

}
