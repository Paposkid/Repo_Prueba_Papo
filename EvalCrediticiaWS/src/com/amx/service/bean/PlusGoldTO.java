package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *Clase que expone los valores y datos que hace referencia a PlusGold.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class PlusGoldTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro serialVersion
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro fechConsultado
	 */
	private Date fechConsultado;
	/**
	 * Atributo único que identifica el registro estado
	 */
	private String estado;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica el objeto subsistema00
	 */
	private SubSistema00TO subsistema00;
	/**
	 * Atributo único que identifica el objeto subsistema01
	 */
	private SubSistema01TO subsistema01;
	/**
	 * Atributo único que identifica el objeto subsistema02
	 */
	private SubSistema02TO subsistema02;
	/**
	 * Atributo único que identifica el objeto subsistema03
	 */
	private SubSistema03TO subsistema03;
	/**
	 * Atributo único que identifica el objeto subsistema05
	 */
	private SubSistema05TO subsistema05;
	/**
	 * Atributo único que identifica el objeto subsistema06
	 */
	private SubSistema06TO subsistema06;
	/**
	 * Atributo único que identifica el objeto subsistema07
	 */
	private SubSistema07TO subsistema07;
	/**
	 * Atributo único que identifica el objeto subsistema08
	 */
	private SubSistema08TO subsistema08;
	/**
	 * Atributo único que identifica el objeto subsistema09
	 */
	private SubSistema09TO subsistema09;
	/**
	 * Atributo único que identifica el objeto subsistema10
	 */
	private SubSistema10TO subsistema10;
	/**
	 * Atributo único que identifica el registro origen
	 */
	private String origen;
	/**
	 * Constructor que inicializa la clase
	 */
	public PlusGoldTO() {
		
	}
	public SubSistema00TO getSubsistema00() {
		return subsistema00;
	}
	public void setSubsistema00(SubSistema00TO subsistema00) {
		this.subsistema00 = subsistema00;
	}
	public SubSistema01TO getSubsistema01() {
		return subsistema01;
	}
	public void setSubsistema01(SubSistema01TO subsistema01) {
		this.subsistema01 = subsistema01;
	}
	public SubSistema02TO getSubsistema02() {
		return subsistema02;
	}
	public void setSubsistema02(SubSistema02TO subsistema02) {
		this.subsistema02 = subsistema02;
	}
	public SubSistema03TO getSubsistema03() {
		return subsistema03;
	}
	public void setSubsistema03(SubSistema03TO subsistema03) {
		this.subsistema03 = subsistema03;
	}
	public SubSistema05TO getSubsistema05() {
		return subsistema05;
	}
	public void setSubsistema05(SubSistema05TO subsistema05) {
		this.subsistema05 = subsistema05;
	}
	public SubSistema06TO getSubsistema06() {
		return subsistema06;
	}
	public void setSubsistema06(SubSistema06TO subsistema06) {
		this.subsistema06 = subsistema06;
	}
	public SubSistema07TO getSubsistema07() {
		return subsistema07;
	}
	public void setSubsistema07(SubSistema07TO subsistema07) {
		this.subsistema07 = subsistema07;
	}
	public SubSistema08TO getSubsistema08() {
		return subsistema08;
	}
	public void setSubsistema08(SubSistema08TO subsistema08) {
		this.subsistema08 = subsistema08;
	}
	public SubSistema09TO getSubsistema09() {
		return subsistema09;
	}
	public void setSubsistema09(SubSistema09TO subsistema09) {
		this.subsistema09 = subsistema09;
	}
	public SubSistema10TO getSubsistema10() {
		return subsistema10;
	}
	public void setSubsistema10(SubSistema10TO subsistema10) {
		this.subsistema10 = subsistema10;
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersionUId) {
		this.serialVersion = serialVersionUId;
	}
	public Date getFechConsultado() {
		return fechConsultado;
	}
	public void setFechConsultado(Date fechConsultado) {
		this.fechConsultado = fechConsultado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getOrigen() {
		return origen;
	}
	@Override
	public String toString() {
		return "PlusGoldTO [serialVersion=" + serialVersion
				+ ", fechConsultado=" + fechConsultado + ", estado=" + estado
				+ ", usuario=" + usuario + ", subsistema00=" + subsistema00
				+ ", subsistema01=" + subsistema01 + ", subsistema02="
				+ subsistema02 + ", subsistema03=" + subsistema03
				+ ", subsistema05=" + subsistema05 + ", subsistema06="
				+ subsistema06 + ", subsistema07=" + subsistema07
				+ ", subsistema08=" + subsistema08 + ", subsistema09="
				+ subsistema09 + ", subsistema10=" + subsistema10 + ", origen="
				+ origen + "]";
	}
	
}
