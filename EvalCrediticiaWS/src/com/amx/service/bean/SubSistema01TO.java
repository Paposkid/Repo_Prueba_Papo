package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema01.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema01TO implements Serializable{

	/**
	 *  El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	
	/**
	 *  Atributo único que identifica el registro nombreEval
	 */
	private String nombreEval;
	/**
	 *  Atributo único que identifica el registro fecha Nacimiento
	 */
	private String fechaNacimiento;
	/**
	 *  Atributo único que identifica el registro edadEval
	 */
	private String edadEval;
	/**
	 *  Atributo único que identifica el registro descActi
	 */
	private String descActi;
	/**
	 *  Atributo único que identifica el registro descRubr
	 */
	private String descRubr;
	/**
	 *  Atributo único que identifica el registro código Usuario Alta
	 */
	private Integer codUsuarioAlta;
	/**
	 *  Constructor que inicializa la clase
	 */
	public SubSistema01TO() {
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	public String getNombreEval() {
		return nombreEval;
	}
	public void setNombreEval(String nombreEval) {
		this.nombreEval = nombreEval;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEdadEval() {
		return edadEval;
	}
	public void setEdadEval(String edadEval) {
		this.edadEval = edadEval;
	}
	public String getDescActi() {
		return descActi;
	}
	public void setDescActi(String descActi) {
		this.descActi = descActi;
	}
	public String getDescRubr() {
		return descRubr;
	}
	public void setDescRubr(String descRubr) {
		this.descRubr = descRubr;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "SubSistema01TO [serialVersion=" + serialVersion
				+ ", nombreEval=" + nombreEval + ", fechaNacimiento="
				+ fechaNacimiento + ", edadEval=" + edadEval + ", descActi="
				+ descActi + ", descRubr=" + descRubr + ", codUsuarioAlta="
				+ codUsuarioAlta + "]";
	}
	
	
}
