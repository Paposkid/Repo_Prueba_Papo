package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema07.
 * 
 * @author Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema07TO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 *  Atributo único que identifica el registro cantQuie
	 */
	private Integer cantQuie;
	/**
	 *  Atributo único que identifica el registro fechDefu
	 */
	private Integer fechDefu;
	/**
	 *  Atributo único que identifica el registro fechInte
	 */
	private Integer fechInte;
	/**
	 *  Atributo único que identifica el registro ibolFlag
	 */
	private Integer ibolFlag;
	/**
	 *  Atributo único que identifica el registro impeCtac
	 */
	private String impeCtac;
	/**
	 *  Atributo único que identifica el registro perfDefu
	 */
	private String perfDefu;
	/**
	 *  Atributo único que identifica el registro indiDeud
	 */
	private String indiDeud;
	/**
	 *  Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica la lista de objetos  listDetSubsistema07
	 */
	private List<DetSubsistema07TO> listDetSubsistema07;

	/**
	 * Constructor que inicializa la clase
	 */
	public SubSistema07TO() {
	}

	public Long getSerialVersion() {
		return serialVersion;
	}

	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}

	public Integer getCantQuie() {
		return cantQuie;
	}

	public void setCantQuie(Integer cantQuie) {
		this.cantQuie = cantQuie;
	}

	public Integer getFechDefu() {
		return fechDefu;
	}

	public void setFechDefu(Integer fechDefu) {
		this.fechDefu = fechDefu;
	}

	public Integer getFechInte() {
		return fechInte;
	}

	public void setFechInte(Integer fechInte) {
		this.fechInte = fechInte;
	}

	public Integer getIbolFlag() {
		return ibolFlag;
	}

	public void setIbolFlag(Integer ibolFlag) {
		this.ibolFlag = ibolFlag;
	}

	public String getImpeCtac() {
		return impeCtac;
	}

	public void setImpeCtac(String impeCtac) {
		this.impeCtac = impeCtac;
	}

	public String getPerfDefu() {
		return perfDefu;
	}

	public void setPerfDefu(String perfDefu) {
		this.perfDefu = perfDefu;
	}

	public String getIndiDeud() {
		return indiDeud;
	}

	public void setIndiDeud(String indiDeud) {
		this.indiDeud = indiDeud;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	
	public List<DetSubsistema07TO> getListDetSubsistema07() {
		if(listDetSubsistema07 == null)
			listDetSubsistema07 = new ArrayList<DetSubsistema07TO>();
		return listDetSubsistema07;
	}

	@Override
	public String toString() {
		return "SubSistema07TO [serialVersion=" + serialVersion + ", cantQuie="
				+ cantQuie + ", fechDefu=" + fechDefu + ", fechInte="
				+ fechInte + ", ibolFlag=" + ibolFlag + ", impeCtac="
				+ impeCtac + ", perfDefu=" + perfDefu + ", indiDeud="
				+ indiDeud + ", usuario=" + usuario + ", listDetSubsistema07="
				+ listDetSubsistema07 + "]";
	}
	
}
