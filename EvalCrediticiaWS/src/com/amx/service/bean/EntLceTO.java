package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 Clase que expone los valores y datos que hace referencia a EntLce.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class EntLceTO implements Serializable{
	
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
	 * Atributo único que identifica el registro corrLce
	 */
	private Long corrLce;
	/**
	 * Atributo único que identifica el registro corrAffiinformation
	 */
	private Long corrAffiinformation;
	/**
	 * Atributo único que identifica el registro corrCredscoreinfo
	 */
	private Long corrCredscoreinfo;
	/**
	 * Atributo único que identifica el registro credApprovalid
	 */
	private String credApprovalid;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Constructor que inicializa la clase
	 */
	public EntLceTO() {
		
	}
	public Long getCorrLce() {
		return corrLce;
	}
	public void setCorrLce(Long corrLce) {
		this.corrLce = corrLce;
	}
	public Long getCorrAffiinformation() {
		return corrAffiinformation;
	}
	public void setCorrAffiinformation(Long corrAffiinformation) {
		this.corrAffiinformation = corrAffiinformation;
	}
	public Long getCorrCredscoreinfo() {
		return corrCredscoreinfo;
	}
	public void setCorrCredscoreinfo(Long corrCredscoreinfo) {
		this.corrCredscoreinfo = corrCredscoreinfo;
	}
	public String getCredApprovalid() {
		return credApprovalid;
	}
	public void setCredApprovalid(String credApprovalid) {
		this.credApprovalid = credApprovalid;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setListBiom(List<BiomTO> listBiom) {
		this.listBiom = listBiom;
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
	@Override
	public String toString() {
		return "EntLceTO [credScoreInfo=" + credScoreInfo + ", accrInfo="
				+ accrInfo + ", AffInfo=" + AffInfo + ", listBiom=" + listBiom
				+ ", corrLce=" + corrLce + ", corrAffiinformation="
				+ corrAffiinformation + ", corrCredscoreinfo="
				+ corrCredscoreinfo + ", credApprovalid=" + credApprovalid
				+ ", usuario=" + usuario + "]";
	}
		
}
