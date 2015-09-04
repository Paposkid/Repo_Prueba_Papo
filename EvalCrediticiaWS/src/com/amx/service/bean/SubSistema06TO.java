package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema06.
 * 
 * @author Julian Montoya julian.montollapalacio@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema06TO implements Serializable {

	/**
	 *El código representa el serial 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro  vigeSisf
	 */
	private Integer vigeSisf;
	/**
	 *  Atributo único que identifica el registro  tavaFisc
	 */
	private Integer tavaFisc;
	/**
	 *  Atributo único que identifica el registro icnuSisf
	 */
	private Integer icnuSisf;
	/** 
	 *  Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro comeMimp
	 */
	private Double comeMimp;
	/**
	 *  Atributo único que identifica el registro comeMimp
	 */
	private Double comeMexp;
	/**
	 *  Atributo único que identifica el registro comeFexp
	 */
	private Integer comeFexp;
	/**
	 *  Atributo único que identifica el registro foliUdec
	 */
	private Integer foliUdec;
	/**
	 *  Atributo único que identifica el registro nsocRela
	 */
	private Integer nsocRela;
	/**
	 *  Atributo único que identifica el registro totaBcos
	 */
	private Integer totaBcos;
	/**
	 *  Atributo único que identifica el registro comeFimp
	 */
	private Integer comeFimp;
	/**
	 * Atributo único que identifica el registro  numeProp
	 */
	private Integer numeProp;
	/**
	 *  Atributo único que identifica el registro nsocSoci
	 */
	private Integer nsocSoci;
	/**
	 *  Atributo único que identifica el registro periSisf
	 */
	private Integer periSisf;
	/**
	 *  Atributo único que identifica el registro fechUdec
	 */
	private Integer fechUdec;
	/**
	 *  Atributo único que identifica el registro fechVeri
	 */
	private Integer fechVeri;
	/**
	 *  Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica la lista de objetos listBanco 
	 */
	private List<BancoTO> listBanco;

	/**
	 *  Constructor que inicializa la clase
	 */
	public SubSistema06TO() {
	}

	public Integer getVigeSisf() {
		return vigeSisf;
	}

	public void setVigeSisf(Integer vigeSisf) {
		this.vigeSisf = vigeSisf;
	}

	public Integer getTavaFisc() {
		return tavaFisc;
	}

	public void setTavaFisc(Integer tavaFisc) {
		this.tavaFisc = tavaFisc;
	}

	public Integer getIcnuSisf() {
		return icnuSisf;
	}

	public void setIcnuSisf(Integer icnuSisf) {
		this.icnuSisf = icnuSisf;
	}

	public Double getComeMimp() {
		return comeMimp;
	}

	public void setComeMimp(Double comeMimp) {
		this.comeMimp = comeMimp;
	}

	public Double getComeMexp() {
		return comeMexp;
	}

	public void setComeMexp(Double comeMexp) {
		this.comeMexp = comeMexp;
	}

	public Integer getComeFexp() {
		return comeFexp;
	}

	public void setComeFexp(Integer comeFexp) {
		this.comeFexp = comeFexp;
	}

	public Integer getFoliUdec() {
		return foliUdec;
	}

	public void setFoliUdec(Integer foliUdec) {
		this.foliUdec = foliUdec;
	}

	public Integer getNsocRela() {
		return nsocRela;
	}

	public void setNsocRela(Integer nsocRela) {
		this.nsocRela = nsocRela;
	}

	public Integer getTotaBcos() {
		return totaBcos;
	}

	public void setTotaBcos(Integer totaBcos) {
		this.totaBcos = totaBcos;
	}

	public Integer getComeFimp() {
		return comeFimp;
	}

	public void setComeFimp(Integer comeFimp) {
		this.comeFimp = comeFimp;
	}

	public Integer getNumeProp() {
		return numeProp;
	}

	public void setNumeProp(Integer numeProp) {
		this.numeProp = numeProp;
	}

	public Integer getNsocSoci() {
		return nsocSoci;
	}

	public void setNsocSoci(Integer nsocSoci) {
		this.nsocSoci = nsocSoci;
	}

	public Integer getPeriSisf() {
		return periSisf;
	}

	public void setPeriSisf(Integer periSisf) {
		this.periSisf = periSisf;
	}

	public Integer getFechUdec() {
		return fechUdec;
	}

	public void setFechUdec(Integer fechUdec) {
		this.fechUdec = fechUdec;
	}

	public Integer getFechVeri() {
		return fechVeri;
	}

	public void setFechVeri(Integer fechVeri) {
		this.fechVeri = fechVeri;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}

	public Long getSerialVersion() {
		return serialVersion;
	}

	public List<BancoTO> getListBanco() {
		if(listBanco == null)
			listBanco = new ArrayList<BancoTO>();
		return listBanco;
	}

	@Override
	public String toString() {
		return "SubSistema06TO [vigeSisf=" + vigeSisf + ", tavaFisc="
				+ tavaFisc + ", icnuSisf=" + icnuSisf + ", serialVersion="
				+ serialVersion + ", comeMimp=" + comeMimp + ", comeMexp="
				+ comeMexp + ", comeFexp=" + comeFexp + ", foliUdec="
				+ foliUdec + ", nsocRela=" + nsocRela + ", totaBcos="
				+ totaBcos + ", comeFimp=" + comeFimp + ", numeProp="
				+ numeProp + ", nsocSoci=" + nsocSoci + ", periSisf="
				+ periSisf + ", fechUdec=" + fechUdec + ", fechVeri="
				+ fechVeri + ", usuario=" + usuario + ", listBanco="
				+ listBanco + "]";
	}
	

}
