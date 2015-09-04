package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a EntFce.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class EntFceTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Atributo único que identifica el registro producto
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
	 * Atributo único que identifica el registro credApproValidInput
	 */
	private String credApproValidInput;
	/**
	 * Atributo único que identifica el registro corrFCE
	 */
	private Long corrFCE;
	/**
	 * Atributo único que identifica el registro corrAffiInformation
	 */
	private Long corrAffiInformation;
	/**
	 * Atributo único que identifica el registro corrCredScoreInfo
	 */
	private Long corrCredScoreInfo;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;

	/**
	 * Constructor que inicializa la clase
	 */
	public EntFceTO() {
		
	}

	public Long getCorrFCE() {
		return corrFCE;
	}

	public void setCorrFCE(Long corrFCE) {
		this.corrFCE = corrFCE;
	}

	public Long getCorrAffiInformation() {
		return corrAffiInformation;
	}

	public void setCorrAffiInformation(Long corrAffiInformation) {
		this.corrAffiInformation = corrAffiInformation;
	}

	public Long getCorrCredScoreInfo() {
		return corrCredScoreInfo;
	}

	public void setCorrCredScoreInfo(Long corrCredScoreInfo) {
		this.corrCredScoreInfo = corrCredScoreInfo;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
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

	public String getCredApproValidInput() {
		return credApproValidInput;
	}

	public void setCredApproValidInput(String credApproValidInput) {
		this.credApproValidInput = credApproValidInput;
	}

	@Override
	public String toString() {
		return "EntFceTO [producto=" + producto + ", afiliado=" + afiliado
				+ ", credScoreInfo=" + credScoreInfo + ", credApproValidInput="
				+ credApproValidInput + ", corrFCE=" + corrFCE
				+ ", corrAffiInformation=" + corrAffiInformation
				+ ", corrCredScoreInfo=" + corrCredScoreInfo + ", usuario="
				+ usuario + "]";
	}
	
}
