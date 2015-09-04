package com.amx.service.bean;

import java.util.Date;



public class CustomerEntitiesByIdentifierTO {
	
	private String identifierType;
	private String identifierNumber;
	private String businessIdentifier;
	private Date expiryDate;
	private boolean isPrimary;
	private Date issueDate;
	private String issuePlace;
	private String serialNumber;
	
	public CustomerEntitiesByIdentifierTO() {
		}

	public String getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	public String getIdentifierNumber() {
		return identifierNumber;
	}

	public void setIdentifierNumber(String identifierNumber) {
		this.identifierNumber = identifierNumber;
	}

	public String getBusinessIdentifier() {
		return businessIdentifier;
	}

	public void setBusinessIdentifier(String businessIdentifier) {
		this.businessIdentifier = businessIdentifier;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "CustomerEntitiesByIdentifierTO [identifierType="
				+ identifierType + ", identifierNumber=" + identifierNumber
				+ ", businessIdentifier=" + businessIdentifier
				+ ", expiryDate=" + expiryDate + ", isPrimary=" + isPrimary
				+ ", issueDate=" + issueDate + ", issuePlace=" + issuePlace
				+ ", serialNumber=" + serialNumber + "]";
	}
	
		
	
}
