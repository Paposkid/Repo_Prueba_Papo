package com.amx.service.bean;

import java.math.BigDecimal;
import java.util.Date;



public class ChargeAllDetailsInfoSalidaTO {

	private Integer taxSequenceNumber;
	private Double totalTaxAmount;
	private BigDecimal accountCurrencyAmount;
	private String accountCurrency;
	private Byte taxRelation;
	private Double amountIncludeTax;
	private long payChannel;
    private String chargeCode;
    private String description;
    private Byte serviceReceiverType;
    private Long serviceReceiverId;
    private Long receiverCustomerID;
    private Long baId;
    private Long offerId;
    private Long offerItemId;
    private Integer offerInstanceId;
    private Date effectiveDate;
    private double amount;
    private String amountCurrency;
    private String chargeOrigin;
    private String eventType;
    private Integer businessEntity;
    private Integer cycleSeqRun;
    private long chargeId;
    private Integer correctionSeqNo;
    private Integer cycleSeqNo;
    private Byte manualPolicy;
    private String chargeClassification;
    private String revenueCode;
    private Byte prepaidIndicator;
    private Byte isCorrectable;
    private Byte externalReceiverType;
    private String externalReceiverId;
    private String chargeType;
    
	public ChargeAllDetailsInfoSalidaTO() {
		
	}

	/**
	 * @return the taxSequenceNumber
	 */
	public Integer getTaxSequenceNumber() {
		return taxSequenceNumber;
	}

	/**
	 * @param taxSequenceNumber the taxSequenceNumber to set
	 */
	public void setTaxSequenceNumber(Integer taxSequenceNumber) {
		this.taxSequenceNumber = taxSequenceNumber;
	}

	/**
	 * @return the totalTaxAmount
	 */
	public Double getTotalTaxAmount() {
		return totalTaxAmount;
	}

	/**
	 * @param totalTaxAmount the totalTaxAmount to set
	 */
	public void setTotalTaxAmount(Double totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	/**
	 * @return the accountCurrencyAmount
	 */
	public BigDecimal getAccountCurrencyAmount() {
		return accountCurrencyAmount;
	}

	/**
	 * @param accountCurrencyAmount the accountCurrencyAmount to set
	 */
	public void setAccountCurrencyAmount(BigDecimal accountCurrencyAmount) {
		this.accountCurrencyAmount = accountCurrencyAmount;
	}

	/**
	 * @return the accountCurrency
	 */
	public String getAccountCurrency() {
		return accountCurrency;
	}

	/**
	 * @param accountCurrency the accountCurrency to set
	 */
	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	/**
	 * @return the taxRelation
	 */
	public Byte getTaxRelation() {
		return taxRelation;
	}

	/**
	 * @param taxRelation the taxRelation to set
	 */
	public void setTaxRelation(Byte taxRelation) {
		this.taxRelation = taxRelation;
	}

	/**
	 * @return the amountIncludeTax
	 */
	public Double getAmountIncludeTax() {
		return amountIncludeTax;
	}

	/**
	 * @param amountIncludeTax the amountIncludeTax to set
	 */
	public void setAmountIncludeTax(Double amountIncludeTax) {
		this.amountIncludeTax = amountIncludeTax;
	}

	/**
	 * @return the payChannel
	 */
	public long getPayChannel() {
		return payChannel;
	}

	/**
	 * @param payChannel the payChannel to set
	 */
	public void setPayChannel(long payChannel) {
		this.payChannel = payChannel;
	}

	/**
	 * @return the chargeCode
	 */
	public String getChargeCode() {
		return chargeCode;
	}

	/**
	 * @param chargeCode the chargeCode to set
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the serviceReceiverType
	 */
	public Byte getServiceReceiverType() {
		return serviceReceiverType;
	}

	/**
	 * @param serviceReceiverType the serviceReceiverType to set
	 */
	public void setServiceReceiverType(Byte serviceReceiverType) {
		this.serviceReceiverType = serviceReceiverType;
	}

	/**
	 * @return the serviceReceiverId
	 */
	public Long getServiceReceiverId() {
		return serviceReceiverId;
	}

	/**
	 * @param serviceReceiverId the serviceReceiverId to set
	 */
	public void setServiceReceiverId(Long serviceReceiverId) {
		this.serviceReceiverId = serviceReceiverId;
	}

	/**
	 * @return the receiverCustomerID
	 */
	public Long getReceiverCustomerID() {
		return receiverCustomerID;
	}

	/**
	 * @param receiverCustomerID the receiverCustomerID to set
	 */
	public void setReceiverCustomerID(Long receiverCustomerID) {
		this.receiverCustomerID = receiverCustomerID;
	}

	/**
	 * @return the baId
	 */
	public Long getBaId() {
		return baId;
	}

	/**
	 * @param baId the baId to set
	 */
	public void setBaId(Long baId) {
		this.baId = baId;
	}

	/**
	 * @return the offerId
	 */
	public Long getOfferId() {
		return offerId;
	}

	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	/**
	 * @return the offerItemId
	 */
	public Long getOfferItemId() {
		return offerItemId;
	}

	/**
	 * @param offerItemId the offerItemId to set
	 */
	public void setOfferItemId(Long offerItemId) {
		this.offerItemId = offerItemId;
	}

	/**
	 * @return the offerInstanceId
	 */
	public Integer getOfferInstanceId() {
		return offerInstanceId;
	}

	/**
	 * @param offerInstanceId the offerInstanceId to set
	 */
	public void setOfferInstanceId(Integer offerInstanceId) {
		this.offerInstanceId = offerInstanceId;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountCurrency
	 */
	public String getAmountCurrency() {
		return amountCurrency;
	}

	/**
	 * @param amountCurrency the amountCurrency to set
	 */
	public void setAmountCurrency(String amountCurrency) {
		this.amountCurrency = amountCurrency;
	}

	/**
	 * @return the chargeOrigin
	 */
	public String getChargeOrigin() {
		return chargeOrigin;
	}

	/**
	 * @param chargeOrigin the chargeOrigin to set
	 */
	public void setChargeOrigin(String chargeOrigin) {
		this.chargeOrigin = chargeOrigin;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the businessEntity
	 */
	public Integer getBusinessEntity() {
		return businessEntity;
	}

	/**
	 * @param businessEntity the businessEntity to set
	 */
	public void setBusinessEntity(Integer businessEntity) {
		this.businessEntity = businessEntity;
	}

	/**
	 * @return the cycleSeqRun
	 */
	public Integer getCycleSeqRun() {
		return cycleSeqRun;
	}

	/**
	 * @param cycleSeqRun the cycleSeqRun to set
	 */
	public void setCycleSeqRun(Integer cycleSeqRun) {
		this.cycleSeqRun = cycleSeqRun;
	}

	/**
	 * @return the chargeId
	 */
	public long getChargeId() {
		return chargeId;
	}

	/**
	 * @param chargeId the chargeId to set
	 */
	public void setChargeId(long chargeId) {
		this.chargeId = chargeId;
	}

	/**
	 * @return the correctionSeqNo
	 */
	public Integer getCorrectionSeqNo() {
		return correctionSeqNo;
	}

	/**
	 * @param correctionSeqNo the correctionSeqNo to set
	 */
	public void setCorrectionSeqNo(Integer correctionSeqNo) {
		this.correctionSeqNo = correctionSeqNo;
	}

	/**
	 * @return the cycleSeqNo
	 */
	public Integer getCycleSeqNo() {
		return cycleSeqNo;
	}

	/**
	 * @param cycleSeqNo the cycleSeqNo to set
	 */
	public void setCycleSeqNo(Integer cycleSeqNo) {
		this.cycleSeqNo = cycleSeqNo;
	}

	/**
	 * @return the manualPolicy
	 */
	public Byte getManualPolicy() {
		return manualPolicy;
	}

	/**
	 * @param manualPolicy the manualPolicy to set
	 */
	public void setManualPolicy(Byte manualPolicy) {
		this.manualPolicy = manualPolicy;
	}

	/**
	 * @return the chargeClassification
	 */
	public String getChargeClassification() {
		return chargeClassification;
	}

	/**
	 * @param chargeClassification the chargeClassification to set
	 */
	public void setChargeClassification(String chargeClassification) {
		this.chargeClassification = chargeClassification;
	}

	/**
	 * @return the revenueCode
	 */
	public String getRevenueCode() {
		return revenueCode;
	}

	/**
	 * @param revenueCode the revenueCode to set
	 */
	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	/**
	 * @return the prepaidIndicator
	 */
	public Byte getPrepaidIndicator() {
		return prepaidIndicator;
	}

	/**
	 * @param prepaidIndicator the prepaidIndicator to set
	 */
	public void setPrepaidIndicator(Byte prepaidIndicator) {
		this.prepaidIndicator = prepaidIndicator;
	}

	/**
	 * @return the isCorrectable
	 */
	public Byte getIsCorrectable() {
		return isCorrectable;
	}

	/**
	 * @param isCorrectable the isCorrectable to set
	 */
	public void setIsCorrectable(Byte isCorrectable) {
		this.isCorrectable = isCorrectable;
	}

	/**
	 * @return the externalReceiverType
	 */
	public Byte getExternalReceiverType() {
		return externalReceiverType;
	}

	/**
	 * @param externalReceiverType the externalReceiverType to set
	 */
	public void setExternalReceiverType(Byte externalReceiverType) {
		this.externalReceiverType = externalReceiverType;
	}

	/**
	 * @return the externalReceiverId
	 */
	public String getExternalReceiverId() {
		return externalReceiverId;
	}

	/**
	 * @param externalReceiverId the externalReceiverId to set
	 */
	public void setExternalReceiverId(String externalReceiverId) {
		this.externalReceiverId = externalReceiverId;
	}

	/**
	 * @return the chargeType
	 */
	public String getChargeType() {
		return chargeType;
	}

	/**
	 * @param chargeType the chargeType to set
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChargeAllDetailsInfoSalidaTO [taxSequenceNumber="
				+ taxSequenceNumber + ", totalTaxAmount=" + totalTaxAmount
				+ ", accountCurrencyAmount=" + accountCurrencyAmount
				+ ", accountCurrency=" + accountCurrency + ", taxRelation="
				+ taxRelation + ", amountIncludeTax=" + amountIncludeTax
				+ ", payChannel=" + payChannel + ", chargeCode=" + chargeCode
				+ ", description=" + description + ", serviceReceiverType="
				+ serviceReceiverType + ", serviceReceiverId="
				+ serviceReceiverId + ", receiverCustomerID="
				+ receiverCustomerID + ", baId=" + baId + ", offerId="
				+ offerId + ", offerItemId=" + offerItemId
				+ ", offerInstanceId=" + offerInstanceId + ", effectiveDate="
				+ effectiveDate + ", amount=" + amount + ", amountCurrency="
				+ amountCurrency + ", chargeOrigin=" + chargeOrigin
				+ ", eventType=" + eventType + ", businessEntity="
				+ businessEntity + ", cycleSeqRun=" + cycleSeqRun
				+ ", chargeId=" + chargeId + ", correctionSeqNo="
				+ correctionSeqNo + ", cycleSeqNo=" + cycleSeqNo
				+ ", manualPolicy=" + manualPolicy + ", chargeClassification="
				+ chargeClassification + ", revenueCode=" + revenueCode
				+ ", prepaidIndicator=" + prepaidIndicator + ", isCorrectable="
				+ isCorrectable + ", externalReceiverType="
				+ externalReceiverType + ", externalReceiverId="
				+ externalReceiverId + ", chargeType=" + chargeType + "]";
	}
    
	
    
}
