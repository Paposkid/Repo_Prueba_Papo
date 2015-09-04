package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a PerformFullCreditEvaluationRequest.
 * 
 * @author Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class PerformFullCreditEvaluationRequestTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica la lista de objetos producto
	 */
	private List<ProductTO> producto;
	/**
	 * Atributo único que identifica el registro afiliado
	 */
	private AffiinformationTO afiliado;
	/**
	 * Atributo único que identifica el registro credScoreInfo
	 */
	private CredScoreInfoTO credScoreInfo;
	/** 
	 * Atributo único que identifica el registro creditApprovalIDInput
	 */
	private String creditApprovalIDInput;

	/**
	 * Constructor que inicializa la clase
	 */
	public PerformFullCreditEvaluationRequestTO() {
		
	}

	public List<ProductTO> getProducto() {
		if (producto == null)
			producto = new ArrayList<ProductTO>();
		return producto;
	}

	public AffiinformationTO getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(AffiinformationTO afiliado) {
		this.afiliado = afiliado;
	}

	public CredScoreInfoTO getCredScoreInfo() {
		return credScoreInfo;
	}

	public void setCredScoreInfo(CredScoreInfoTO credScoreInfo) {
		this.credScoreInfo = credScoreInfo;
	}

	public String getCreditApprovalIDInput() {
		return creditApprovalIDInput;
	}

	public void setCreditApprovalIDInput(String creditApprovalIDInput) {
		this.creditApprovalIDInput = creditApprovalIDInput;
	}

	@Override
	public String toString() {
		return "PerformFullCreditEvaluationRequestTO [producto=" + producto
				+ ", afiliado=" + afiliado + ", credScoreInfo=" + credScoreInfo
				+ ", creditApprovalIDInput=" + creditApprovalIDInput + "]";
	}

}
