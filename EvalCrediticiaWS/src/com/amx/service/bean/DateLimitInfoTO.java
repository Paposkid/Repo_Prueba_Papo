package com.amx.service.bean;

import java.util.Date;

public class DateLimitInfoTO {
	
	private Date fromDate;
	private Date toDate;
	
	public DateLimitInfoTO() {
		
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "DateLimitInfoTO [fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}
	
	
	

}
