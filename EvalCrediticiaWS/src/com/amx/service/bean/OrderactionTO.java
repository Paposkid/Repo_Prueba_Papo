package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a Orderaction.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class OrderactionTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro corrProduct
	 */
	private Long corrProduct;
	/**
	 * Atributo único que identifica el registro corrContactinfo
	 */
	private String corrContactinfo;
	/**
	 * Atributo único que identifica el registro orderActionid
	 */
	private String orderActionid;
	/**
	 * Atributo único que identifica el registro orderActiontype
	 */
	private String orderActiontype;
	/**
	 * Atributo único que identifica el registro oaSrd
	 */
	private Date oaSrd;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica el registro contactInfo
	 */
	private ContactInfoTO contactInfo;
	
	/**
	 * Constructor vacio
	 */
	public OrderactionTO() {
		
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public Long getCorrProduct() {
		return corrProduct;
	}
	public void setCorrProduct(Long corrProduct) {
		this.corrProduct = corrProduct;
	}
	public String getCorrContactinfo() {
		return corrContactinfo;
	}
	public void setCorrContactinfo(String corrContactinfo) {
		this.corrContactinfo = corrContactinfo;
	}
	public String getOrderActionid() {
		return orderActionid;
	}
	public void setOrderActionid(String orderActionid) {
		this.orderActionid = orderActionid;
	}
	public String getOrderActiontype() {
		return orderActiontype;
	}
	public void setOrderActiontype(String orderActiontype) {
		this.orderActiontype = orderActiontype;
	}
	public Date getOaSrd() {
		return oaSrd;
	}
	public void setOaSrd(Date oaSrd) {
		this.oaSrd = oaSrd;
	}
	public void setContactInfo(ContactInfoTO contactInfo) {
		
		this.contactInfo = contactInfo;
	}
	public ContactInfoTO getContactInfo() {
		if(contactInfo == null){
			contactInfo = new ContactInfoTO();
		}
		return contactInfo;
	}
	@Override
	public String toString() {
		return "OrderactionTO [corrProduct=" + corrProduct
				+ ", corrContactinfo=" + corrContactinfo + ", orderActionid="
				+ orderActionid + ", orderActiontype=" + orderActiontype
				+ ", oaSrd=" + oaSrd + ", usuario=" + usuario
				+ ", contactInfo=" + contactInfo + "]";
	}
		
}
