package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a GetCreditScoreByCustomerResponse.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class GetCreditScoreByCustomerResponseTO implements Serializable {
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro credScoreResInfo
	 */
	private CreditScoreTO credScoreResInfo;
	/**
	 * Atributo único que identifica la lista de objetos numOfLinAllowedPerGamaAndPro
	 */
	private List<NlineSallopGaptTO> numOfLinAllowedPerGamaAndPro;
	/**
	 * Atributo único que identifica el registro numOfFinancedActiveLin
	 */
	private String numOfFinancedActiveLin;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public GetCreditScoreByCustomerResponseTO() {
		
	}
	public CreditScoreTO getCredScoreInfo() {
		if(credScoreResInfo == null){
			credScoreResInfo = new CreditScoreTO();
		}
		return credScoreResInfo;
	}
	public void setCredScoreInfo(CreditScoreTO credScoreInfo) {
		this.credScoreResInfo = credScoreInfo;
	}
	public List<NlineSallopGaptTO> getNumOfLinAllowedPerGamaAndPro() {
		if(numOfLinAllowedPerGamaAndPro == null){
			numOfLinAllowedPerGamaAndPro = new ArrayList<NlineSallopGaptTO>();
		}
		return numOfLinAllowedPerGamaAndPro;
	}
	
	public String getNumOfFinancedActiveLin() {
		return numOfFinancedActiveLin;
	}
	public void setNumOfFinancedActiveLin(String numOfFinancedActiveLin) {
		this.numOfFinancedActiveLin = numOfFinancedActiveLin;
	}
	@Override
	public String toString() {
		return "GetCreditScoreByCustomerResponseTO [credScoreResInfo="
				+ credScoreResInfo + ", numOfLinAllowedPerGamaAndPro="
				+ numOfLinAllowedPerGamaAndPro + ", numOfFinancedActiveLin="
				+ numOfFinancedActiveLin + "]";
	}
		
}
