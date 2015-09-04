package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a ConceptoType.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class CreditScoreTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro corrLce
	 */
	private Long corrLce;
	/**
	 * Atributo único que identifica el registro fistName
	 */
	private String fistName; 
	/**
	 * Atributo único que identifica el registro secondName
	 */
	private String secondName; 
	/**
	 * Atributo único que identifica el registro lastName
	 */
	private String lastName; 
	/**
	 * Atributo único que identifica el registro secondLastName
	 */
	private String secondLastName; 
	/**
	 * Atributo único que identifica el registro issueDateofid
	 */
	private Date issueDateofid; 
	/**
	 * Atributo único que identifica el registro scoreExpiryDate
	 */
	private Date scoreExpiryDate; 
	/**
	 * Atributo único que identifica el registro dateCredBureaouConsulted
	 */
	private Date dateCredBureaouConsulted; 
	/**
	 * Atributo único que identifica el registro cerdRefNumber
	 */
	private String cerdRefNumber; 
	/**
	 * Atributo único que identifica el registro evidAlreadyValid
	 */
	private String evidAlreadyValid; 
	/**
	 * Atributo único que identifica el registro credScoreCode
	 */
	private String credScoreCode; 
	/**
	 * Atributo único que identifica el registro credScoreDescription
	 */
	private String credScoreDescription; 
	/**
	 * Atributo único que identifica el registro gama
	 */
	private String gama;  
	/**
	 * Atributo único que identifica el registro evaStatus
	 */
	private String evaStatus; 
	/**
	 * Atributo único que identifica el registro ceRejectMEessage
	 */
	private String ceRejectMEessage; 
	/**
	 * Atributo único que identifica el registro ageRange
	 */
	private String ageRange; 
	/**
	 * Atributo único que identifica el registro idPlaceOfissue
	 */
	private String idPlaceOfissue; 
	/**
	 * Atributo único que identifica el registro idExpirationDate
	 */
	private Date idExpirationDate; 
	/**
	 * Atributo único que identifica el registro paynBehavior
	 */
	private String paynBehavior; 
	/**
	 * Atributo único que identifica el registro pastDueamount
	 */
	private String pastDueamount; 
	/**
	 * Atributo único que identifica el registro planType
	 */
	private String planType; 
	/**
	 * Atributo único que identifica el registro purcLimit
	 */
	private String purcLimit; 
	/**
	 * Atributo único que identifica el registro totalNumerRofline
	 */
	private Integer totalNumerRofline; 
	/**
	 * Atributo único que identifica el registro rcPaymentinaVancedRequied
	 */
	private String rcPaymentinaVancedRequied; 
	/**
	 * Atributo único que identifica el registro equiInmediatePaymentRequired
	 */
	private String equiInmediatePaymentRequired; 
	/**
	 * Atributo único que identifica el registro payMeansRequired
	 */
	private String payMeansRequired; 
	/**
	 * Atributo único que identifica el registro acquType
	 */
	private String acquType; 
	/**
	 * Atributo único que identifica el registro url
	 */
	private String url;
	/**
	 * Atributo único que identifica el registro corrUsuarioAlta
	 */
	private Integer corrUsuarioAlta;
	/**
	 * Atributo único que identifica a lista de objetos String
	 */
	private List<String> listOfRequiredDocum;
	/**
	 * Atributo único que identifica a lista de objetos String
	 */
	private List<String> exceptions;
	
	
	/**
	 * Constructor que inicializa la clase
	 */
	public CreditScoreTO() {
		
	}
	public List<String> getListOfRequiredDocum() {
		return listOfRequiredDocum;
	}
	public void setListOfRequiredDocum(List<String> listOfRequiredDocum) {
		this.listOfRequiredDocum = listOfRequiredDocum;
	}
	public Long getCorrLce() {
		return corrLce;
	}
	public void setCorrLce(Long corrLce) {
		this.corrLce = corrLce;
	}
	public List<String> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}
	
	public Long getCorrLCE() {
		return corrLce;
	}
	public void setCorrLCE(Long corrLCE) {
		this.corrLce = corrLCE;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public Date getIssueDateofid() {
		return issueDateofid;
	}
	public void setIssueDateofid(Date issueDateofid) {
		this.issueDateofid = issueDateofid;
	}
	public Date getScoreExpiryDate() {
		return scoreExpiryDate;
	}
	public void setScoreExpiryDate(Date scoreExpiryDate) {
		this.scoreExpiryDate = scoreExpiryDate;
	}
	public Date getDateCredBureaouConsulted() {
		return dateCredBureaouConsulted;
	}
	public void setDateCredBureaouConsulted(Date dateCredBureaouConsulted) {
		this.dateCredBureaouConsulted = dateCredBureaouConsulted;
	}
	public String getCerdRefNumber() {
		return cerdRefNumber;
	}
	public void setCerdRefNumber(String cerdRefNumber) {
		this.cerdRefNumber = cerdRefNumber;
	}
	public String getEvidAlreadyValid() {
		return evidAlreadyValid;
	}
	public void setEvidAlreadyValid(String evidAlreadyValid) {
		this.evidAlreadyValid = evidAlreadyValid;
	}
	public String getCredScoreCode() {
		return credScoreCode;
	}
	public void setCredScoreCode(String credScoreCode) {
		this.credScoreCode = credScoreCode;
	}
	public String getCredScoreDescription() {
		return credScoreDescription;
	}
	public void setCredScoreDescription(String credScoreDescription) {
		this.credScoreDescription = credScoreDescription;
	}
	public String getGama() {
		return gama;
	}
	public void setGama(String gama) {
		this.gama = gama;
	}
	public String getEvaStatus() {
		return evaStatus;
	}
	public void setEvaStatus(String evaStatus) {
		this.evaStatus = evaStatus;
	}
	public String getCeRejectMEessage() {
		return ceRejectMEessage;
	}
	public void setCeRejectMEessage(String ceRejectMEessage) {
		this.ceRejectMEessage = ceRejectMEessage;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public String getIdPlaceOfissue() {
		return idPlaceOfissue;
	}
	public void setIdPlaceOfissue(String idPlaceOfissue) {
		this.idPlaceOfissue = idPlaceOfissue;
	}
	public Date getIdExpirationDate() {
		return idExpirationDate;
	}
	public void setIdExpirationDate(Date idExpirationDate) {
		this.idExpirationDate = idExpirationDate;
	}
	public String getPaynBehavior() {
		return paynBehavior;
	}
	public void setPaynBehavior(String paynBehavior) {
		this.paynBehavior = paynBehavior;
	}
	public String getPastDueamount() {
		return pastDueamount;
	}
	public void setPastDueamount(String pastDueamount) {
		this.pastDueamount = pastDueamount;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getPurcLimit() {
		return purcLimit;
	}
	public void setPurcLimit(String purcLimit) {
		this.purcLimit = purcLimit;
	}
	public Integer getTotalNumerRofline() {
		return totalNumerRofline;
	}
	public void setTotalNumerRofline(Integer totalNumerRofline) {
		this.totalNumerRofline = totalNumerRofline;
	}
	public String getRcPaymentinaVancedRequied() {
		return rcPaymentinaVancedRequied;
	}
	public void setRcPaymentinaVancedRequied(String rcPaymentinaVancedRequied) {
		this.rcPaymentinaVancedRequied = rcPaymentinaVancedRequied;
	}
	public String getEquiInmediatePaymentRequired() {
		return equiInmediatePaymentRequired;
	}
	public void setEquiInmediatePaymentRequired(String equiInmediatePaymentRequired) {
		this.equiInmediatePaymentRequired = equiInmediatePaymentRequired;
	}
	public String getPayMeansRequired() {
		return payMeansRequired;
	}
	public void setPayMeansRequired(String ayMeansRequired) {
		this.payMeansRequired = ayMeansRequired;
	}
	public String getAcquType() {
		return acquType;
	}
	public void setAcquType(String acquType) {
		this.acquType = acquType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getCorrUsuarioAlta() {
		return corrUsuarioAlta;
	}
	public void setCorrUsuarioAlta(Integer corrUsuarioAlta) {
		this.corrUsuarioAlta = corrUsuarioAlta;
	}
	@Override
	public String toString() {
		return "CreditScoreTO [corrLce=" + corrLce + ", fistName=" + fistName
				+ ", secondName=" + secondName + ", lastName=" + lastName
				+ ", secondLastName=" + secondLastName + ", issueDateofid="
				+ issueDateofid + ", scoreExpiryDate=" + scoreExpiryDate
				+ ", dateCredBureaouConsulted=" + dateCredBureaouConsulted
				+ ", cerdRefNumber=" + cerdRefNumber + ", evidAlreadyValid="
				+ evidAlreadyValid + ", credScoreCode=" + credScoreCode
				+ ", credScoreDescription=" + credScoreDescription + ", gama="
				+ gama + ", evaStatus=" + evaStatus + ", ceRejectMEessage="
				+ ceRejectMEessage + ", ageRange=" + ageRange
				+ ", idPlaceOfissue=" + idPlaceOfissue + ", idExpirationDate="
				+ idExpirationDate + ", paynBehavior=" + paynBehavior
				+ ", pastDueamount=" + pastDueamount + ", planType=" + planType
				+ ", purcLimit=" + purcLimit + ", totalNumerRofline="
				+ totalNumerRofline + ", rcPaymentinaVancedRequied="
				+ rcPaymentinaVancedRequied + ", equiInmediatePaymentRequired="
				+ equiInmediatePaymentRequired + ", payMeansRequired="
				+ payMeansRequired + ", acquType=" + acquType + ", url=" + url
				+ ", corrUsuarioAlta=" + corrUsuarioAlta
				+ ", listOfRequiredDocum=" + listOfRequiredDocum
				+ ", exceptions=" + exceptions + "]";
	}
	
	
}
