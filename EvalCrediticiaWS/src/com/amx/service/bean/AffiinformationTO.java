package com.amx.service.bean;

import java.io.Serializable;

/**
 * Clase que expone los valores y datos que hace referencia a Actual list response type.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AffiinformationTO implements Serializable{

	
	/**
	 *El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Atributo �nico que identifica el registro corrAffInformation
	 */
	private Long corrAffInformation;
	/**
	 * Atributo �nico que identifica el registro affiliate
	 */
	private String affiliate;
	/**
	 * Atributo �nico que identifica el registro market
	 */
	private String market;
	/**
	 * Atributo �nico que identifica el registro usuario
	 */
	private Integer usuario;

	
	/**
	 * Constructor que inicializa la clase
	 */
	public AffiinformationTO() {
		
	}
	/**
	 * M�todo que obtine usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * M�todo que establece usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * M�todo que obtiene CorrAffinformation
	 * @return
	 */
	public Long getCorrAffInformation() {
		return corrAffInformation;
	}
	/**
	 * M�todo que establece CorrAffinformation
	 * @param corrAffinformation
	 */
	
	public void setCorrAffInformation(Long corrAffInformation) {
		this.corrAffInformation = corrAffInformation;
	}
	/**
	 * M�todo que obtiene Affiliate
	 * @return affiliate
	 */
	public String getAffiliate() {
		return affiliate;
	}
	/**
	 * M�todo que establece Affiliate
	 * @param affiliate
	 */
	public void setAffiliate(String affiliate) {
		this.affiliate = affiliate;
	}
	/**
	 * M�todo que establece Market
	 * @return
	 */
	public String getMarket() {
		return market;
	}
	/**
	 * M�todo que establece Market
	 * @param market
	 */
	public void setMarket(String market) {
		this.market = market;
	}
	
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AffiinformationTO [corrAffInformation=" + corrAffInformation
				+ ", affiliate=" + affiliate + ", market=" + market
				+ ", usuario=" + usuario + "]";
	}
		
}
