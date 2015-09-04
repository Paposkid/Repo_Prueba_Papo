package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *Clase que expone los valores y datos que hace referencia a GetCreditScoreByCustomerRequest.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class GetCreditScoreByCustomerRequestTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro credScoreInfo
	 */
	private CredScoreInfoTO credScoreInfo;
	/**
	 * Atributo único que identifica el registro accrInfo
	 */
	private AccrinfoTO accrInfo;
	/**
	 * Atributo único que identifica el registro AffInfo
	 */
	private AffiinformationTO AffInfo;
	/**
	 * Atributo único que identifica la lista de objetos listBiom
	 */
	private List<BiomTO> listBiom;
	/**
	 * Atributo único que identifica el registro creditApprovalId
	 */
	private String creditApprovalId;

	/**
	 * Constructor que inicializa la clase
	 */
	public GetCreditScoreByCustomerRequestTO() {
		
	}
	public CredScoreInfoTO getCredScoreInfo() {
		if(credScoreInfo ==null){
			credScoreInfo=new CredScoreInfoTO();
		}
		return credScoreInfo;
	}
	public void setCredScoreInfo(CredScoreInfoTO credScoreInfo) {

		this.credScoreInfo = credScoreInfo;
	}
	public AccrinfoTO getAccrInfo() {
		if(accrInfo == null){
			accrInfo = new AccrinfoTO();
		}
		return accrInfo;
	}
	public void setAccrInfo(AccrinfoTO accrInfo) {
		this.accrInfo = accrInfo;
	}

	public AffiinformationTO getAffInfo() {
		if(AffInfo == null){
			AffInfo = new AffiinformationTO();
		}
		return AffInfo;
	}
	public void setAffInfo(AffiinformationTO affInfo) {
		AffInfo = affInfo;
	}
	public List<BiomTO> getListBiom() {
		if(listBiom == null){
			listBiom = new ArrayList<BiomTO>();
		}
		return listBiom;
	}
	
	public String getCreditApprovalId() {
		return creditApprovalId;
	}
	public void setCreditApprovalId(String creditApprovalId) {
		this.creditApprovalId = creditApprovalId;
	}
	@Override
	public String toString() {
		return "GetCreditScoreByCustomerRequestTO [credScoreInfo="
				+ credScoreInfo + ", accrInfo=" + accrInfo + ", AffInfo="
				+ AffInfo + ", listBiom=" + listBiom + ", creditApprovalId="
				+ creditApprovalId + "]";
	}
 	
}
