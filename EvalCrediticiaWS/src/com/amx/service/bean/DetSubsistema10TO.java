package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a DetSubsistema10.
 * 
 * @author Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class DetSubsistema10TO implements Serializable {

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro corrDetallesubsistema10
	 */
	private Long corrDetallesubsistema10;
	/**
	 * Atributo �nico que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo �nico que identifica el registro montImpa
	 */
	private Double montImpa;
	/**
	 * Atributo �nico que identifica el registro fechImpa
	 */ 
	private Integer fechImpa;
	/**
	 * Atributo �nico que identifica el registro fechIngr
	 */
	private Integer fechIngr;
	/**
	 * Atributo �nico que identifica el registro fechJust
	 */ 
	private Integer fechJust;
	/**
	 * Atributo �nico que identifica el registro tipoDeJud
	 */
	private String tipoDeud;
	/**
	 * Atributo �nico que identifica el registro ncheOper
	 */
	private String ncheOper;
	/**
	 * Atributo �nico que identifica el registro tipoDocu
	 */
	private String tipoDocu;
	/**
	 * Atributo �nico que identifica el registro tipoMone
	 */
	private String tipoMone;
	/**
	 * Atributo �nico que identifica el registro tipoCred
	 */
	private String tipoCred;
	/**
	 * Atributo �nico que identifica el registro nombLoca
	 */
	private String nombLoca;
	/**
	 * Atributo �nico que identifica el registro  nombNota
	 */
	private String nombNota;
	/**
	 * Atributo �nico que identifica el registro tipoMoti
	 */
	private String tipoMoti;
	/**
	 * Atributo �nico que identifica el registro detaJust
	 */
	private String detaJust;
	/**
	 * Atributo �nico que identifica el registro nombLibr
	 */
	private String nombLibr;
	/**
	 * Atributo �nico que identifica el registro usuario
	 */
	private Integer usuario;

	/**
	 * Constructor que inicializa la clase
	 */
	public DetSubsistema10TO() {

	}

	public Long getCorrDetallesubsistema10() {
		return corrDetallesubsistema10;
	}

	public void setCorrDetallesubsistema10(Long corrDetallesubsistema10) {
		this.corrDetallesubsistema10 = corrDetallesubsistema10;
	}

	public Long getSerialVersion() {
		return serialVersion;
	}

	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}

	public Double getMontImpa() {
		return montImpa;
	}

	public void setMontImpa(Double montImpa) {
		this.montImpa = montImpa;
	}

	public double getFechImpa() {
		return fechImpa;
	}

	public void setFechImpa(Integer fechImpa) {
		this.fechImpa = fechImpa;
	}

	public Integer getFechIngr() {
		return fechIngr;
	}

	public void setFechIngr(Integer fechIngr) {
		this.fechIngr = fechIngr;
	}

	public Integer getFechJust() {
		return fechJust;
	}

	public void setFechJust(Integer fechJust) {
		this.fechJust = fechJust;
	}

	public String getTipoDeud() {
		return tipoDeud;
	}

	public void setTipoDeud(String tipoDeud) {
		this.tipoDeud = tipoDeud;
	}

	public String getNcheOper() {
		return ncheOper;
	}

	public void setNcheOper(String ncheOper) {
		this.ncheOper = ncheOper;
	}

	public String getTipoDocu() {
		return tipoDocu;
	}

	public void setTipoDocu(String tipoDocu) {
		this.tipoDocu = tipoDocu;
	}

	public String getTipoMone() {
		return tipoMone;
	}

	public void setTipoMone(String tipoMone) {
		this.tipoMone = tipoMone;
	}

	public String getTipoCred() {
		return tipoCred;
	}

	public void setTipoCred(String tipoCred) {
		this.tipoCred = tipoCred;
	}

	public String getNombLoca() {
		return nombLoca;
	}

	public void setNombLoca(String nombLoca) {
		this.nombLoca = nombLoca;
	}

	public String getNombNota() {
		return nombNota;
	}

	public void setNombNota(String nombNota) {
		this.nombNota = nombNota;
	}

	public String getTipoMoti() {
		return tipoMoti;
	}

	public void setTipoMoti(String tipoMoti) {
		this.tipoMoti = tipoMoti;
	}

	public String getDetaJust() {
		return detaJust;
	}

	public void setDetaJust(String detaJust) {
		this.detaJust = detaJust;
	}

	public String getNombLibr() {
		return nombLibr;
	}

	public void setNombLibr(String nombLibr) {
		this.nombLibr = nombLibr;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DetSubsistema10TO [corrDetallesubsistema10="
				+ corrDetallesubsistema10 + ", serialVersion=" + serialVersion
				+ ", montImpa=" + montImpa + ", fechImpa=" + fechImpa
				+ ", fechIngr=" + fechIngr + ", fechJust=" + fechJust
				+ ", tipoDeud=" + tipoDeud + ", ncheOper=" + ncheOper
				+ ", tipoDocu=" + tipoDocu + ", tipoMone=" + tipoMone
				+ ", tipoCred=" + tipoCred + ", nombLoca=" + nombLoca
				+ ", nombNota=" + nombNota + ", tipoMoti=" + tipoMoti
				+ ", detaJust=" + detaJust + ", nombLibr=" + nombLibr
				+ ", usuario=" + usuario + "]";
	}

}
