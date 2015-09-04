package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SalFce.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SalFceTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro status
	 */
	private String status;
	/**
	 * Atributo único que identifica el registro descStatus
	 */
	private String descStatus;
	/**
	 * Atributo único que identifica la lista de objetos  exceptions
	 */
	private List<String> exceptions;
	/**
	 * Atributo único que identifica el registro número Crédito
	 */
	private String numCredito;
	/**
	 * Atributo en el cual se almacenan los nombres de las rglas ejecutadas durante una evaluacion
	 */
	private String reglas;

	/**
	 * Atributo único que identifica el registro visita
	 */
	private String visita;
	/**
	 * Atributo único que identifica el registro pago Inmediato
	 */
	private String pagoInmediato;
	/**
	 * Atributo único que identifica la lista de objetos  conditions
	 */
	private List<ConditionFCETO> conditions;
	/**
	 *  Atributo único que identifica la lista de objetos documents
	 */
	private List<String> documents;
	/**
	 * Atributo único que identifica la lista de objetos extra Documents
	 */
	private List<String> extraDocuments;
	/**
	 * Atributo único que identifica el registro aprobacion Credito
	 */
	private String aprobacionCred;
	/**
	 * Atributo único que identifica el registro codigo FCE
	 */
	private Long codFCE;
	/**
	 * Atributo único que identifica el registro código Usuario
	 */
	private Integer codeUsuario;
	/**
	 * Atributo único que identifica el registro lineas Disponibles
	 */
	private Integer lineasDisponibles; 
	
	/**
	 * Constructor vacio
	 */
	public SalFceTO() {
	}
	public String getDescStatus() {
		return descStatus;
	}
	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}
	public String getNumCredito() {
		return numCredito;
	}
	public void setNumCredito(String numCredito) {
		this.numCredito = numCredito;
	}
	public String getVisita() {
		return visita;
	}
	public void setVisita(String visita) {
		this.visita = visita;
	}
	public String getPagoInmediato() {
		return pagoInmediato;
	}
	public void setPagoInmediato(String pagoInmediato) {
		this.pagoInmediato = pagoInmediato;
	}
	public String getAprobacionCred() {
		return aprobacionCred;
	}
	public void setAprobacionCred(String aprobacionCred) {
		this.aprobacionCred = aprobacionCred;
	}
	public Integer getLineasDisponibles() {
		return lineasDisponibles;
	}
	public void setLineasDisponibles(Integer lineasDisponibles) {
		this.lineasDisponibles = lineasDisponibles;
	}
	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}
	public void setConditions(List<ConditionFCETO> conditions) {
		this.conditions = conditions;
	}
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	public void setExtraDocuments(List<String> extraDocuments) {
		this.extraDocuments = extraDocuments;
	}
	public Long getCodFCE() {
		return codFCE;
	}
	public void setCodFCE(Long codFCE) {
		this.codFCE = codFCE;
	}
	public Integer getCodeUsuario() {
		return codeUsuario;
	}
	public void setCodeUsuario(Integer codeUsuario) {
		this.codeUsuario = codeUsuario;
	}
	public String getStatus() {
		return status;
	}
	
	public String getReglas() {
		return reglas;
	}
	public void setReglas(String reglas) {
		this.reglas = reglas;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return descStatus;
	}
	public void setDescription(String description) {
		this.descStatus = description;
	}
	public List<String> getExceptions() {
		if(exceptions == null)
			exceptions = new ArrayList<String>();
		return exceptions;
	}
	
	public String getCreditRefNumber() {
		return numCredito;
	}
	public void setCreditRefNumber(String creditRefNumber) {
		this.numCredito = creditRefNumber;
	}
	public String getHomeVisitRequired() {
		return visita;
	}
	public void setHomeVisitRequired(String homeVisitRequired) {
		this.visita = homeVisitRequired;
	}
	public String getIsOverrideImmediatePayment() {
		return pagoInmediato;
	}
	public void setIsOverrideImmediatePayment(String isOverrideImmediatePayment) {
		this.pagoInmediato = isOverrideImmediatePayment;
	}
	public List<ConditionFCETO> getConditions() {
		if(conditions ==null)
			conditions = new ArrayList<ConditionFCETO>();
		
		return conditions;
	}
	
	public List<String> getDocuments() {
		if(documents ==null)
			documents = new ArrayList<String>();
		return documents;
	}
	
	public List<String> getExtraDocuments() {
		if(extraDocuments ==null)
			extraDocuments = new ArrayList<String>();
		return extraDocuments;
	}
	
	public String getCreditApprovalIDOutput() {
		return aprobacionCred;
	}
	
	public void setCreditApprovalIDOutput(String creditApprovalIDOutput) {
		this.aprobacionCred = creditApprovalIDOutput;
	}
	@Override
	public String toString() {
		return "SalFceTO [status=" + status + ", descStatus=" + descStatus
				+ ", exceptions=" + exceptions + ", numCredito=" + numCredito
				+ ", visita=" + visita + ", pagoInmediato=" + pagoInmediato
				+ ", conditions=" + conditions + ", documents=" + documents
				+ ", extraDocuments=" + extraDocuments + ", aprobacionCred="
				+ aprobacionCred + ", codFCE=" + codFCE + ", codeUsuario="
				+ codeUsuario + ", lineasDisponibles=" + lineasDisponibles
				+ "]";
	}
	
	
	

}
