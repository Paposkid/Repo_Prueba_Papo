package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;



/**
 *Clase que expone los valores y datos que hace referencia a CredScoreInfo.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class CredScoreInfoTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro orderID
	 */
	private String orderID;
	/**
	 * Atributo único que identifica el registro oaType
	 */
	private String oaType;
	/**
	 * Atributo único que identifica el registro credCheckapprovel
	 */
	private String credCheckapprovel;
	/**
	 * Atributo único que identifica el registro credRefNumber
	 */
	private String credRefNumber;
	/**
	 * Atributo único que identifica el registrosaleChannel
	 */
	private String saleChannel; 
	/**
	 * Atributo único que identifica el registro location
	 */
	private String location;
	/**
	 * Atributo único que identifica el registro dealerOnBehalf
	 */
	private String dealerOnBehalf; 
	/**
	 * Atributo único que identifica el registro dealerId
	 */
	private String dealerId;
	/**
	 * Atributo único que identifica el registro userId;
	 */
	private String userId; 
	/**
	 * Atributo único que identifica el registro region
	 */
	private String region;
	/**
	 * Atributo único que identifica el registro idenNumber
	 */
	private String idenNumber; 
	/**
	 * Atributo único que identifica el registro idenType
	 */
	private String idenType;
	/**
	 * Atributo único que identifica el registro firstName
	 */
	private String firstName; 
	/**
	 * Atributo único que identifica el registro lastName
	 */
	private String lastName;
	/**
	 * Atributo único que identifica el registro vIPIndication
	 */
	private String vIPIndication; 
	/**
	 * Atributo único que identifica el registro nuncaIndication
	 */
	private String nuncaIndication;
	/**
	 * Atributo único que identifica el registro phoneNumber
	 */
	private String phoneNumber;
	/**
	 * Atributo único que identifica el registro dateBirth
	 */
	private Date dateBirth;
	/**
	 * Atributo único que identifica el registro custType
	 */
	private String custType;
	/**
	 * Atributo único que identifica el registro custSubtype
	 */
	private String custSubtype; 
	/**
	 * Atributo único que identifica el registro custId
	 */
	private String custId;
	/**
	 * Atributo único que identifica el registro codigoCredScoreInfo
	 */
	private Long codigoCredScoreInfo;
	/**
	 * Atributo único que identifica el registro codUsuarioAlta
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo único que identifica el registro direccionInfo
	 */
	private ADDRInfoDetTO direccionInfo;
	

	/**
	 * Constructor que inicializa la clase
	 */
	public CredScoreInfoTO() {
		
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOaType() {
		return oaType;
	}

	public void setOaType(String oaType) {
		this.oaType = oaType;
	}

	public String getCredCheckapprovel() {
		return credCheckapprovel;
	}

	public void setCredCheckapprovel(String credCheckapprovel) {
		this.credCheckapprovel = credCheckapprovel;
	}

	public String getCredRefNumber() {
		return credRefNumber;
	}

	public void setCredRefNumber(String credRefNumber) {
		this.credRefNumber = credRefNumber;
	}

	public String getSaleChannel() {
		return saleChannel;
	}

	public void setSaleChannel(String saleChannel) {
		this.saleChannel = saleChannel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDealerOnBehalf() {
		return dealerOnBehalf;
	}

	public void setDealerOnBehalf(String dealerOnBehalf) {
		this.dealerOnBehalf = dealerOnBehalf;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIdenNumber() {
		return idenNumber;
	}

	public void setIdenNumber(String idenNumber) {
		this.idenNumber = idenNumber;
	}

	public String getIdenType() {
		return idenType;
	}

	public void setIdenType(String idenType) {
		this.idenType = idenType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getvIPIndication() {
		return vIPIndication;
	}

	public void setvIPIndication(String vIPIndication) {
		this.vIPIndication = vIPIndication;
	}

	public String getNuncaIndication() {
		return nuncaIndication;
	}

	public void setNuncaIndication(String nuncaIndication) {
		this.nuncaIndication = nuncaIndication;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustSubtype() {
		return custSubtype;
	}

	public void setCustSubtype(String custSubtype) {
		this.custSubtype = custSubtype;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Long getCodigoCredScoreInfo() {
		return codigoCredScoreInfo;
	}

	public void setCodigoCredScoreInfo(Long codigoCredScoreInfo) {
		this.codigoCredScoreInfo = codigoCredScoreInfo;
	}

	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}

	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}

	public ADDRInfoDetTO getDireccionInfo() {
		if(direccionInfo == null){
			direccionInfo = new ADDRInfoDetTO();
		}
		return direccionInfo;
	}

	public void setDireccionInfo(ADDRInfoDetTO direccionInfo) {
		this.direccionInfo = direccionInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CredScoreInfoTO [orderID=" + orderID + ", oaType=" + oaType
				+ ", credCheckapprovel=" + credCheckapprovel
				+ ", credRefNumber=" + credRefNumber + ", saleChannel="
				+ saleChannel + ", location=" + location + ", dealerOnBehalf="
				+ dealerOnBehalf + ", dealerId=" + dealerId + ", userId="
				+ userId + ", region=" + region + ", idenNumber=" + idenNumber
				+ ", idenType=" + idenType + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", vIPIndication=" + vIPIndication
				+ ", nuncaIndication=" + nuncaIndication + ", phoneNumber="
				+ phoneNumber + ", dateBirth=" + dateBirth + ", custType="
				+ custType + ", custSubtype=" + custSubtype + ", custId="
				+ custId + ", codigoCredScoreInfo=" + codigoCredScoreInfo
				+ ", codUsuarioAlta=" + codUsuarioAlta + ", direccionInfo="
				+ direccionInfo + "]";
	}

	
}
