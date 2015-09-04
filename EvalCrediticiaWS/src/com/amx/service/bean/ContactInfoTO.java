package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a ConceptoType.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ContactInfoTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Atributo único que identifica el registro contId
	 */
	private String contId;
	/**
	 * Atributo único que identifica el registro fistName
	 */
	private String fistName;
	/**
	 * Atributo único que identifica el registro lastName
	 */
	private String lastName;
	/**
	 * Atributo único que identifica el registro homePhone
	 */
	private String homePhone;
	/**
	 * Atributo único que identifica el registro mobilPhone
	 */
	private String mobilPhone;
	/**
	 * Atributo único que identifica el registro busiPhone
	 */
	private String busiPhone;
	/**
	 * Atributo único que identifica el registro tittle
	 */
	private String tittle;
	/**
	 * Atributo único que identifica el registro birthDate
	 */
	private Date birthDate;
	/**
	 * Atributo único que identifica el registro vip
	 */
	private String vip;
	/**
	 * Atributo único que identifica el registro nunca
	 */
	private String nunca;
	/**
	 * Atributo único que identifica el registro address
	 */
	private String address;
	/**
	 * Atributo único que identifica el registro AddrId
	 */
	private String AddrId;
	/**
	 * Atributo único que identifica el registro IdenType
	 */
	private String IdenType;
	/**
	 * Atributo único que identifica el registro IdenNumber
	 */
	private String IdenNumber;
	/**
	 * Atributo único que identifica el registro corrUsuarioAlta
	 */
	private Integer corrUsuarioAlta;
	/**
	 * Atributo único que identifica la lista de objetos String
	 */
	private List<String> listTittle;
	
		
	/**
	 * Constructor que inicializa la clase
	 */
	public ContactInfoTO() {
		
	}

	public List<String> getListTittle() {
		if(listTittle == null)
			listTittle = new ArrayList<String>();
		return listTittle;
	}
	
	public String getContId() {
		return contId;
	}
	public void setContId(String contId) {
		this.contId = contId;
	}
	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilPhone() {
		return mobilPhone;
	}
	public void setMobilPhone(String mobilPhone) {
		this.mobilPhone = mobilPhone;
	}
	public String getBusiPhone() {
		return busiPhone;
	}
	public void setBusiPhone(String busiPhone) {
		this.busiPhone = busiPhone;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getNunca() {
		return nunca;
	}
	public void setNunca(String nunca) {
		this.nunca = nunca;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddrId() {
		return AddrId;
	}
	public void setAddrId(String addrId) {
		AddrId = addrId;
	}
	public String getIdenType() {
		return IdenType;
	}
	public void setIdenType(String idenType) {
		IdenType = idenType;
	}
	public String getIdenNumber() {
		return IdenNumber;
	}
	public void setIdenNumber(String idenNumber) {
		IdenNumber = idenNumber;
	}
	public Integer getCorrUsuarioAlta() {
		return corrUsuarioAlta;
	}
	public void setCorrUsuarioAlta(Integer corrUsuarioAlta) {
		this.corrUsuarioAlta = corrUsuarioAlta;
	}

	@Override
	public String toString() {
		return "ContactInfoTO [contId=" + contId + ", fistName=" + fistName
				+ ", lastName=" + lastName + ", homePhone=" + homePhone
				+ ", mobilPhone=" + mobilPhone + ", busiPhone=" + busiPhone
				+ ", tittle=" + tittle + ", birthDate=" + birthDate + ", vip="
				+ vip + ", nunca=" + nunca + ", address=" + address
				+ ", AddrId=" + AddrId + ", IdenType=" + IdenType
				+ ", IdenNumber=" + IdenNumber + ", corrUsuarioAlta="
				+ corrUsuarioAlta + ", listTittle=" + listTittle + "]";
	}
	
}
