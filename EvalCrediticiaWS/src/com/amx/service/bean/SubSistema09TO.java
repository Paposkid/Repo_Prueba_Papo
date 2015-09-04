package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema09.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema09TO implements Serializable {

	/**
	 * Atributo único que identifica el registro
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro topeCons
	 */
	private Integer topeCons;
	/**
	 * Atributo único que identifica el registro totaCons
	 */
	private Integer totaCons;
	/**
	 * Atributo único que identifica el registro indiCons
	 */
	private String indiCons;
	/**
	 * Atributo único que identifica el registro mediCons
	 */
	private String mediCons;
	/**
	 * Atributo único que identifica el registro  Usuario 
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica la lista de objetos lista Detalle SubSistema09
	 */
	private List<DetSubsistema09TO> listDetSubSistema09;

	/**
	 * Constructor que inicializa la clase
	 */
	public SubSistema09TO() {
	}

	public Long getSerialVersion() {
		return serialVersion;
	}

	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}

	public Integer getTopeCons() {
		return topeCons;
	}

	public void setTopeCons(Integer topeCons) {
		this.topeCons = topeCons;
	}

	public Integer getTotaCons() {
		return totaCons;
	}

	public void setTotaCons(Integer totaCons) {
		this.totaCons = totaCons;
	}

	public String getIndiCons() {
		return indiCons;
	}

	public void setIndiCons(String indiCons) {
		this.indiCons = indiCons;
	}

	public String getMediCons() {
		return mediCons;
	}

	public void setMediCons(String mediCons) {
		this.mediCons = mediCons;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}


	public List<DetSubsistema09TO> getListDetSubSistema09() {
		if(listDetSubSistema09 == null)
			listDetSubSistema09 = new ArrayList<DetSubsistema09TO>();
		return listDetSubSistema09;
	}

	@Override
	public String toString() {
		return "SubSistema09TO [serialVersion=" + serialVersion + ", topeCons="
				+ topeCons + ", totaCons=" + totaCons + ", indiCons="
				+ indiCons + ", mediCons=" + mediCons + ", usuario=" + usuario
				+ ", listDetSubSistema09=" + listDetSubSistema09 + "]";
	}

}
