package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a Product.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class ProductTO implements Serializable{

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro corrProduct
	 */
	private Long corrProduct;
	/**
	 *Atributo único que identifica el registro corrEntfce 
	 */
	private Long corrEntfce;
	/**
	 * Atributo único que identifica el registro offerName
	 */
	private String offerName;
	/**
	 * Atributo único que identifica el registro sumCurrentrc
	 */
	private String sumCurrentrc;
	/**
	 * Atributo único que identifica el registro sumOc
	 */
	private String sumOc;
	/**
	 * Atributo único que identifica el registro campId
	 */
	private String campId;
	/**
	 * Atributo único que identifica el registro campDescription
	 */
	private String campDescription;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public ProductTO() {
		
	}
	/**
	 * Atributo único que identifica la lista de objetos component
	 */
	private List<CompdifinfoTO> component;
	/**
	 * Atributo único que identifica la lista de objetos orderAction
	 */
	private OrderactionTO orderAction;
	
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
	public Long getCorrEntfce() {
		return corrEntfce;
	}
	public void setCorrEntfce(Long corrEntfce) {
		this.corrEntfce = corrEntfce;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getSumCurrentrc() {
		return sumCurrentrc;
	}
	public void setSumCurrentrc(String sumCurrentrc) {
		this.sumCurrentrc = sumCurrentrc;
	}
	public String getSumOc() {
		return sumOc;
	}
	public void setSumOc(String sumOc) {
		this.sumOc = sumOc;
	}
	public String getCampId() {
		return campId;
	}
	public void setCampId(String campId) {
		this.campId = campId;
	}
	public String getCampDescription() {
		return campDescription;
	}
	public void setCampDescription(String campDescription) {
		this.campDescription = campDescription;
	}
	
	
	public List<CompdifinfoTO> getComponent() {
		if(component == null){
			component = new ArrayList<CompdifinfoTO>();
		}
		return component;
	}
	
	
	
	public OrderactionTO getOrderAction() {
		if (orderAction == null) {
			orderAction = new OrderactionTO();
		}
		return orderAction;
	}
	
	public void setOrderAction(OrderactionTO orderAction) {
		this.orderAction = orderAction;
	}
	@Override
	public String toString() {
		return "ProductTO [corrProduct=" + corrProduct + ", corrEntfce="
				+ corrEntfce + ", offerName=" + offerName + ", sumCurrentrc="
				+ sumCurrentrc + ", sumOc=" + sumOc + ", campId=" + campId
				+ ", campDescription=" + campDescription + ", usuario="
				+ usuario + ", component=" + component + ", orderAction="
				+ orderAction + "]";
	}
	
}
