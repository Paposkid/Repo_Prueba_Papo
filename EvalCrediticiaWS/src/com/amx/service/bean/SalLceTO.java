package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que expone los valores y datos que hace referencia a SalLce.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SalLceTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro credit Score Response
	 * Information
	 */
	private CreditScoreTO credScoreResInfo;
	/**
	 * Atributo único que identifica la lista de objetos
	 * numOfLinAllowedPerGamaAndPro
	 */
	private List<NlineSallopGaptTO> numOfLinAllowedPerGamaAndPro;
	/**
	 * Atributo único que identifica el registro numb Offinanced Active Lines
	 */
	private String numbOffinancedActiveLines;
	/**
	*Atributo en el que se almacena el nombre de las reglas ejecutadas en el transcurso de la evaluacion.
	**/
	private String reglas;
	public String getReglas() {
		return reglas;
	}

	public void setReglas(String reglas) {
		this.reglas = reglas;
	}

	/**
	 * Atributo único que identifica el registro correlativo LCE
	 */
	private Long corrLce;
	/**
	 * Atributo único que identifica el registro correlativo Usuario Alta
	 */
	private Integer corrUsuarioAlta;
	/**
	 * Atributo único que identifica el registro credit Aproval Id
	 */
	private String credAprovalId;

	/**
	 * Constructor que inicializa la clase
	 */
	public SalLceTO() {
	}

	public Long getCorrLce() {
		return corrLce;
	}

	public void setCorrLce(Long corrLce) {
		this.corrLce = corrLce;
	}

	public Integer getCorrUsuarioAlta() {
		return corrUsuarioAlta;
	}

	public void setCorrUsuarioAlta(Integer corrUsuarioAlta) {
		this.corrUsuarioAlta = corrUsuarioAlta;
	}

	public CreditScoreTO getCredScoreResInfo() {
		if (credScoreResInfo == null) {
			credScoreResInfo = new CreditScoreTO();
		}
		return credScoreResInfo;
	}

	public void setCredScoreResInfo(CreditScoreTO credScoreResInfo) {
		this.credScoreResInfo = credScoreResInfo;
	}

	public List<NlineSallopGaptTO> getNumOfLinAllowedPerGamaAndPro() {
		if (numOfLinAllowedPerGamaAndPro == null) {
			numOfLinAllowedPerGamaAndPro = new ArrayList<NlineSallopGaptTO>();
		}
		return numOfLinAllowedPerGamaAndPro;
	}

	public String getNumbOffinancedActiveLines() {
		return numbOffinancedActiveLines;
	}

	public void setNumbOffinancedActiveLines(String numbOffinancedActiveLines) {
		this.numbOffinancedActiveLines = numbOffinancedActiveLines;
	}

	public void setCredAprovalId(String credAprovalId) {
		this.credAprovalId = credAprovalId;
	}

	public String getCredAprovalId() {
		return credAprovalId;
	}

	@Override
	public String toString() {
		return "SalLceTO [credScoreResInfo=" + credScoreResInfo + ", numOfLinAllowedPerGamaAndPro=" + numOfLinAllowedPerGamaAndPro + ", numbOffinancedActiveLines=" + numbOffinancedActiveLines
				+ ", corrLce=" + corrLce + ", corrUsuarioAlta=" + corrUsuarioAlta + ", credAprovalId=" + credAprovalId + "]";
	}

}
