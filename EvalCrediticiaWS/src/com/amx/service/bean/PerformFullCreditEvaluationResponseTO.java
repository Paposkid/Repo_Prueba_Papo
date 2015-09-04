package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a PerformFullCreditEvaluationResponse.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class PerformFullCreditEvaluationResponseTO implements Serializable{
	
	/**
	 *  El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro status
	 */
	private String status;
	/**
	 * Atributo único que identifica el registro description
	 */
	private String description;
	/**
	 * Atributo único que identifica el registro exceptions
	 */
	private List<String> exceptions;
	/**
	 * Atributo único que identifica el registro creditRefNumber
	 */
	private String creditRefNumber;
	/**
	 * Atributo único que identifica el registro homeVisitRequired
	 */
	private String homeVisitRequired;
	/**
	 * Atributo único que identifica el registro isOverrideImmediatePayment
	 */
	private String isOverrideImmediatePayment;
	/**
	 * Atributo único que identifica la lista de objetos conditions
	 */
	private List<ConditionFCETO> conditions;
	/**
	 * Atributo único que identifica la lista de objetos documents
	 */
	private List<String> documents;
	/**
	 * Atributo único que identifica la lista de objetos extraDocuments
	 */
	private List<String> extraDocuments;
	/**
	 * Atributo único que identifica el registro
	 */
	private String creditApprovalIDOutput;
	
	
	/**
	 *  Constructor que inicializa la clase
	 */
	public PerformFullCreditEvaluationResponseTO() {
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getExceptions() {
		if(exceptions == null)
			exceptions = new ArrayList<String>();
		return exceptions;
	}
	
	public String getCreditRefNumber() {
		return creditRefNumber;
	}
	public void setCreditRefNumber(String creditRefNumber) {
		this.creditRefNumber = creditRefNumber;
	}
	public String getHomeVisitRequired() {
		return homeVisitRequired;
	}
	public void setHomeVisitRequired(String homeVisitRequired) {
		this.homeVisitRequired = homeVisitRequired;
	}
	public String getIsOverrideImmediatePayment() {
		return isOverrideImmediatePayment;
	}
	public void setIsOverrideImmediatePayment(String isOverrideImmediatePayment) {
		this.isOverrideImmediatePayment = isOverrideImmediatePayment;
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
		return creditApprovalIDOutput;
	}
	public void setCreditApprovalIDOutput(String creditApprovalIDOutput) {
		this.creditApprovalIDOutput = creditApprovalIDOutput;
	}
	@Override
	public String toString() {
		return "PerformFullCreditEvaluationResponseTO [status=" + status
				+ ", description=" + description + ", exceptions=" + exceptions
				+ ", creditRefNumber=" + creditRefNumber
				+ ", homeVisitRequired=" + homeVisitRequired
				+ ", isOverrideImmediatePayment=" + isOverrideImmediatePayment
				+ ", conditions=" + conditions + ", documents=" + documents
				+ ", extraDocuments=" + extraDocuments
				+ ", creditApprovalIDOutput=" + creditApprovalIDOutput + "]";
	}
	
}
