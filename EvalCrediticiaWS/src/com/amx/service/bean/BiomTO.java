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
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo único que identifica el registro corrBiom
	 */
	private Long corrBiom;
	/**
	 * Atributo único que identifica el registro corrEntLCE
	 */
	private Long corrEntLCE;
	/**
	 * Atributo único que identifica el registro type
	 */
	private String type;
	/**
	 * Atributo único que identifica el registro errorCode
	 */
	private String errorCode;
	/**
	 * Atributo único que identifica el registro errorDesc
	 */
	private String errorDesc;
	/**
	 * Atributo único que identifica el registro auditNumber
	 */
	private String auditNumber;
	/**
	 * Atributo único que identifica el registro isPrevire
	 */
	private String isPrevire;
	/**
	 * Atributo único que identifica el registro el usuario
	 */
	private Integer usuario;
	
	/**
	 * Constructor vacio
	 */
	public BiomTO() {
		
	}
	/**
	 * Método que obtiene a el Usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Método que establece a el Usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	
	
	/**
	 * Método que obtiene a CorrBiom
	 * @return
	 */
	public Long getCorrBiom() {
		return corrBiom;
	}
	/**
	 *  Método que establece a CorrBiom
	 * @param corrBiom
	 */
	public void setCorrBiom(Long corrBiom) {
		this.corrBiom = corrBiom;
	}
	/**
	 *  Método que obtiene  a CorrEntlce
	 * @return
	 */
	public Long getCorrEntLCE() {
		return corrEntLCE;
	}
	/**
	 * Método que establece a CorrEntlce
	 * @param corrEntlce
	 */
	
	public void setCorrEntLCE(Long corrEntLCE) {
		this.corrEntLCE = corrEntLCE;
	}
	/**
	 * Método que obtiene  a Type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Método que establece a Type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Método que obtiene a ErrorCode
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * Método que establece a ErrorCode
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * Método que obtiene a ErrorDesc
	 * @return
	 */
	public String getErrorDesc() {
		return errorDesc;
	}
	/**
	 * Método que establece a ErrorDesc
	 * @param errorDesc
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	/**
	 * Método que obtiene a AuditNumber
	 * @return
	 */
	public String getAuditNumber() {
		return auditNumber;
	}
	/**
	 * Método que establece a AuditNumber
	 * @param auditNumber
	 */
	public void setAuditNumber(String auditNumber) {
		this.auditNumber = auditNumber;
	}
	/**
	 * Método que obtiene a IsPrevire
	 * @return
	 */
	public String getIsPrevire() {
		return isPrevire;
	}
	/**
	 *  Método que establece a IsPrevire
	 * @param isPrevire
	 */
	public void setIsPrevire(String isPrevire) {
		this.isPrevire = isPrevire;
	}
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
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
