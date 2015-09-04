package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Banco.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class BiomTO implements Serializable{

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo �nico que identifica el registro corrBiom
	 */
	private Long corrBiom;
	/**
	 * Atributo �nico que identifica el registro corrEntLCE
	 */
	private Long corrEntLCE;
	/**
	 * Atributo �nico que identifica el registro type
	 */
	private String type;
	/**
	 * Atributo �nico que identifica el registro errorCode
	 */
	private String errorCode;
	/**
	 * Atributo �nico que identifica el registro errorDesc
	 */
	private String errorDesc;
	/**
	 * Atributo �nico que identifica el registro auditNumber
	 */
	private String auditNumber;
	/**
	 * Atributo �nico que identifica el registro isPrevire
	 */
	private String isPrevire;
	/**
	 * Atributo �nico que identifica el registro el usuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor vacio
	 */
	public BiomTO() {
		
	}
	/**
	 * M�todo que obtiene a el Usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * M�todo que establece a el Usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	
	
	/**
	 * M�todo que obtiene a CorrBiom
	 * @return
	 */
	public Long getCorrBiom() {
		return corrBiom;
	}
	/**
	 *  M�todo que establece a CorrBiom
	 * @param corrBiom
	 */
	public void setCorrBiom(Long corrBiom) {
		this.corrBiom = corrBiom;
	}
	/**
	 *  M�todo que obtiene  a CorrEntlce
	 * @return
	 */
	public Long getCorrEntLCE() {
		return corrEntLCE;
	}
	/**
	 * M�todo que establece a CorrEntlce
	 * @param corrEntlce
	 */
	
	public void setCorrEntLCE(Long corrEntLCE) {
		this.corrEntLCE = corrEntLCE;
	}
	/**
	 * M�todo que obtiene  a Type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * M�todo que establece a Type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * M�todo que obtiene a ErrorCode
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * M�todo que establece a ErrorCode
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * M�todo que obtiene a ErrorDesc
	 * @return
	 */
	public String getErrorDesc() {
		return errorDesc;
	}
	/**
	 * M�todo que establece a ErrorDesc
	 * @param errorDesc
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	/**
	 * M�todo que obtiene a AuditNumber
	 * @return
	 */
	public String getAuditNumber() {
		return auditNumber;
	}
	/**
	 * M�todo que establece a AuditNumber
	 * @param auditNumber
	 */
	public void setAuditNumber(String auditNumber) {
		this.auditNumber = auditNumber;
	}
	/**
	 * M�todo que obtiene a IsPrevire
	 * @return
	 */
	public String getIsPrevire() {
		return isPrevire;
	}
	/**
	 *  M�todo que establece a IsPrevire
	 * @param isPrevire
	 */
	public void setIsPrevire(String isPrevire) {
		this.isPrevire = isPrevire;
	}
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiomTO [corrBiom=" + corrBiom + ", corrEntLCE=" + corrEntLCE
				+ ", type=" + type + ", errorCode=" + errorCode
				+ ", errorDesc=" + errorDesc + ", auditNumber=" + auditNumber
				+ ", isPrevire=" + isPrevire + ", usuario=" + usuario + "]";
	}
		
}
