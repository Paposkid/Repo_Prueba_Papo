package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a add information detail.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ADDRInfoDetTO implements Serializable{
	
	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro codigo Credit Score Information
	 */
	private Long codigoCredScoreInfo; 
	/**
	 * Atributo que identifica el registro address Text
	 */
	private String addrText;
	/**
	 * Atributo que identifica el registro city
	 */
	private String city; 
	/**
	 * Atributo que identifica el registro distric
	 */
	private String distric;
	/**
	 * Atributo que identifica el registro state
	 */
	private String state;
	/**
	 * Atributo que identifica el registro cost Center Region
	 */
	private String costCenterRegion;
	/**
	 * Atributo que identifica el registro country
	 */
	private String country; 
	/**
	 * Atributo que identifica el registro area
	 */
	private String area;
	/**
	 * Atributo que identifica el registro quarter
	 */
	private String quarter;
	/**
	 * Atributo que identifica el registro st Type
	 */
	private String stType; 
	/**
	 * Atributo que identifica el registro st Name
	 */
	private String stName;
	/**
	 * Atributo que identifica el registro st Prefix
	 */
	private String stPrefix;
	/**
	 * Atributo que identifica el registro st Number
	 */
	private String stNumber; 
	/**
	 * Atributo que identifica el registro st Suffix
	 */
	private String stSuffix;
	/**
	 * Atributo que identifica el registro st Intersection
	 */
	private String stIntersection;
	/**
	 * Atributo que identifica el registro st IntersectionS uffix
	 */
	private String stIntersectionSuffix; 
	/**
	 * Atributo que identifica el registro addi Information
	 */
	private String addiInfo;
	/**
	 *  Atributo que identifica el registro build Type
	 */
	private String buildType;
	/**
	 *  Atributo que identifica el registro build Number
	 */
	private String buildNumber; 
	/**
	 * Atributo que identifica el registro int Building Number
	 */
	private String intBuildingNumber;
	/**
	 * Atributo que identifica el registro int Building Number Suffix
	 */
	private String intBuildingNumberSuffix;
	/**
	 *  Atributo que identifica el registro apart Number
	 */
	private String aptNumber; 
	/**
	 *  Atributo que identifica el registro total Numbers Off Loors
	 */
	private String totalNumOffLoors;
	/**
	 * Atributo que identifica el registro neighborhood
	 */
	private String neighborhood;
	/**
	 * Atributo que identifica el registro po Box
	 */
	private String poBox; 
	/**
	 * Atributo que identifica el registro postal code
	 */
	private String postalCode;
	/**
	 * Atributo que identifica el registro socio economical rank
	 */
	private String socioEconomicalRank;
	/**
	 * Atributo que identifica el registro codigo de usuario 
	 */
	private Integer codUsuarioAlta;
	
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ADDRInfoDetTO() {
		
	}
	/**
	 * M�todo que obtiene el codigo credit score information
	 * @return
	 */
	public Long getCodigoCredScoreInfo() {
		return codigoCredScoreInfo;
	}
	/**
	 * M�todo que establece el codigo credit score information
	 * @param codigoCredScoreInfo
	 */
	public void setCodigoCredScoreInfo(Long codigoCredScoreInfo) {
		this.codigoCredScoreInfo = codigoCredScoreInfo;
	}
	/**
	 * M�todo que obtiene la address text
	 * @return
	 */
	public String getAddrText() {
		return addrText;
	}
	/**
	 *  M�todo que establece la address text
	 * @param addrText
	 */
	public void setAddrText(String addrText) {
		this.addrText = addrText;
	}
	/**
	 *  M�todo que obtiene  la city 
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 *  M�todo que establece la city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 *  M�todo que obtiene el distric
	 * @return
	 */
	public String getDistric() {
		return distric;
	}
	/**
	 *  M�todo que establece el distric
	 * @param distric
	 */
	public void setDistric(String distric) {
		this.distric = distric;
	}
	/**
	 * M�todo que obtiene el state 
	 * @return
	 */
	public String getState() {
		return state;
	}
	/**
	 * M�todo que establece el state
	 * @param state 
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * M�todo que obtiene el cost center region 
	 * @return
	 */
	public String getCostCenterRegion() {
		return costCenterRegion;
	}
	/**
	 * M�todo que establece el cost center region 
	 * @param costCenterRegion
	 */
	public void setCostCenterRegion(String costCenterRegion) {
		this.costCenterRegion = costCenterRegion;
	}
	/**
	 * M�todo que obtiene el country 
	 * @return
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * M�todo que establece el country
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * M�todo que obtiene el area
	 * @return
	 */
	public String getArea() {
		return area;
	}
	/**
	 * M�todo que establece el area
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * M�todo que obtiene el quarter 
	 * @return
	 */
	public String getQuarter() {
		return quarter;
	}
	/**
	 * M�todo que establece el quarter 
	 * @param quarter
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	/**
	 * M�todo que obtiene st type
	 * @return
	 */
	public String getStType() {
		return stType;
	}
	/**
	 * M�todo que establece st type
	 * @param stType
	 */
	public void setStType(String stType) {
		this.stType = stType;
	}
	/**
	 * M�todo que obtiene st name
	 * @return
	 */
	public String getStName() {
		return stName;
	}
	/**
	 * M�todo que establece st name
	 * @param stName
	 */
	public void setStName(String stName) {
		this.stName = stName;
	}
	/**
	 * M�todo que obtiene st prefix
	 * @return
	 */
	public String getStPrefix() {
		return stPrefix;
	}
	/**
	 * M�todo que establece st prefix
	 * @param stPrefix
	 */
	public void setStPrefix(String stPrefix) {
		this.stPrefix = stPrefix;
	}
	/**
	 * M�todo que obtiene st number
	 * @return
	 */
	public String getStNumber() {
		return stNumber;
	}
	/**
	 * M�todo que establece st number
	 * @param stNumber
	 */
	public void setStNumber(String stNumber) {
		this.stNumber = stNumber;
	}
	/**
	 * M�todo que obtiene el st suffix
	 * @return
	 */
	public String getStSuffix() {
		return stSuffix;
	}
	/**
	 * M�todo que establece el st suffix
	 * @param stSuffix
	 */
	public void setStSuffix(String stSuffix) {
		this.stSuffix = stSuffix;
	}
	/**
	 * M�todo que obtiene el st interseccion 
	 * @return
	 */
	public String getStIntersection() {
		return stIntersection;
	}
	/**
	 * M�todo que establece el st interseccion 
	 * @param stIntersection
	 */
	public void setStIntersection(String stIntersection) {
		this.stIntersection = stIntersection;
	}
	/**
	 * M�todo que obtiene el st interseccion suffix
	 * @return
	 */
	public String getStIntersectionSuffix() {
		return stIntersectionSuffix;
	}
	/**
	 * M�todo que establece el st interseccion suffix
	 * @param stIntersectionSuffix
	 */
	public void setStIntersectionSuffix(String stIntersectionSuffix) {
		this.stIntersectionSuffix = stIntersectionSuffix;
	}
	/**
	 * M�todo que obtiene el add information
	 * @return
	 */
	public String getAddiInfo() {
		return addiInfo;
	}
	/**
	 * M�todo que establece el add information
	 * @param addiInfo
	 */
	public void setAddiInfo(String addiInfo) {
		this.addiInfo = addiInfo;
	}
	/**
	 * M�todo que obtiene el build type
	 * @return
	 */
	public String getBuildType() {
		return buildType;
	}
	/**
	 * M�todo que establece el build type
	 * @param buildType
	 */
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}
	/**
	 * M�todo que obtiene el build number
	 * @return buildNumber
	 */
	public String getBuildNumber() {
		return buildNumber;
	}
	/**
	 * M�todo que establece el build number 
	 * @param buildNumber
	 */
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	/**
	 * M�todo que obtiene el int building number 
	 * @return
	 */
	public String getIntBuildingNumber() {
		return intBuildingNumber;
	}
	/**
	 * M�todo que establece el int building number 
	 * @param intBuildingNumber
	 */
	public void setIntBuildingNumber(String intBuildingNumber) {
		this.intBuildingNumber = intBuildingNumber;
	}
	/**
	 * M�todo que obtiene el int building number suffix
	 * @return
	 */
	public String getIntBuildingNumberSuffix() {
		return intBuildingNumberSuffix;
	}
	/**
	 * M�todo que establece el int building number suffix
	 * @param intBuildingNumberSuffix
	 */
	public void setIntBuildingNumberSuffix(String intBuildingNumberSuffix) {
		this.intBuildingNumberSuffix = intBuildingNumberSuffix;
	}
	/**
	 * M�todo que obtiene el apartament  number
	 * @return
	 */
	public String getAptNumber() {
		return aptNumber;
	}
	/**
	 * M�todo que establece el apartament  number
	 * @param aptNumber 
	 */
	public void setAptNumber(String aptNumber) {
		this.aptNumber = aptNumber;
	}
	/**
	 * M�todo que obtiene el total numbers off loors
	 * @return
	 */
	public String getTotalNumOffLoors() {
		return totalNumOffLoors;
	}
	/**
	 * M�todo que establece el atributo total numbers off loors
	 * @param totalNumOffLoors
	 */
	public void setTotalNumOffLoors(String totalNumOffLoors) {
		this.totalNumOffLoors = totalNumOffLoors;
	}
	/**
	 * M�todo que obtiene el neighborhood
	 * @return
	 */
	public String getNeighborhood() {
		return neighborhood;
	}
	/**
	 * M�todo que establece el neighborhood
	 * @param neighborhood
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	/**
	 * M�todo que obtiene el po box
	 * @return
	 */
	public String getPoBox() {
		return poBox;
	}
	/**
	 * M�todo que establece el po box
	 * @param poBox
	 */
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}
	/**
	 * M�todo que obtiene el postal code
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * M�todo que establece el postal code
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * M�todo que obtiene socio economical rank
	 * @return
	 */
	public String getSocioEconomicalRank() {
		return socioEconomicalRank;
	}
	/**
	 * M�todo que establece el socio economical rank
	 * @param socioEconomicalRank
	 */
	public void setSocioEconomicalRank(String socioEconomicalRank) {
		this.socioEconomicalRank = socioEconomicalRank;
	}
	/**
	 * M�tod que obtiene el codigo de usuario de creaci�n 
	 * @return codUsuarioAlta
	 */
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	/**
	 * M�todo que establece el codigo de usuario de creaci�n
	 * @param codUsuarioAlta
	 */
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ADDRInfoDetTO [codigoCredScoreInfo=" + codigoCredScoreInfo
				+ ", addrText=" + addrText + ", city=" + city + ", distric="
				+ distric + ", state=" + state + ", costCenterRegion="
				+ costCenterRegion + ", country=" + country + ", area=" + area
				+ ", quarter=" + quarter + ", stType=" + stType + ", stName="
				+ stName + ", stPrefix=" + stPrefix + ", stNumber=" + stNumber
				+ ", stSuffix=" + stSuffix + ", stIntersection="
				+ stIntersection + ", stIntersectionSuffix="
				+ stIntersectionSuffix + ", addiInfo=" + addiInfo
				+ ", buildType=" + buildType + ", buildNumber=" + buildNumber
				+ ", intBuildingNumber=" + intBuildingNumber
				+ ", intBuildingNumberSuffix=" + intBuildingNumberSuffix
				+ ", aptNumber=" + aptNumber + ", totalNumOffLoors="
				+ totalNumOffLoors + ", neighborhood=" + neighborhood
				+ ", poBox=" + poBox + ", postalCode=" + postalCode
				+ ", socioEconomicalRank=" + socioEconomicalRank
				+ ", codUsuarioAlta=" + codUsuarioAlta + "]";
	}
	
	
}
