package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que expone los valores y datos que hace referencia a Accreditation information.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AccrinfoTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Atributo único que identifica el registro el código de la LCE
	 */
	private Long corrLce;
	/**
	 * Atributo que identifica el registro el accreditation type
	 */
	private String accrType;
	/**
	 * Atributo que identifica el registro el on behalf
	 */
	private String onBehalf;
	/**
	 * Atributo que identifica el registro el usuario
	 */
	private Integer usuario;
	/**
	 * Atributo que identifica el una lista de obejtos accreditation data
	 */
	private List<AccreditationDataTO> accrData;
	/**
	 * Atributo que identifica el una lista de obejtos accreditation document
	 */
	private List<AccrdocumentTO> AccrdocumentTO;
	
	
	/**
	 * Constructor que inicializa la clase
	 */
	public AccrinfoTO() {
		
	}
	/**
	 * Método que obtiene la accreditation type
	 * @return accrType
	 */
	public String getAccrType() {
		return accrType;
	}
	/**
	 * Método que obtiene el usuario
	 * @return usuario
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Método que establece el atributo usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * Método que obtiene el codigo de la LCE
	 * @return corrLce
	 */
	public Long getCorrLce() {
		return corrLce;
	}
	/**
	 * Método que establece el codigo de la LCE
	 * @param corrLce
	 */
	public void setCorrLce(Long corrLce) {
		this.corrLce = corrLce;
	}
	/**
	 * Método que obtiene el atributo accreditation type
	 * @return accrType
	 */
	public String getAccr_type() {
		return accrType;
	}
	/**
	 * Método que establece el accreditation type
	 * @param accrType
	 */
	public void setAccrType(String accrType) {
		this.accrType = accrType;
	}
	/**
	 * Método que obtine el atributo on behalf
	 * @return onBehalf
	 */
	public String getOnBehalf() {
		return onBehalf;
	}
	/**
	 * Método que establece el  atributo on behalf
	 * @param onBehalf
	 */
	public void setOnBehalf(String onBehalf) {
		this.onBehalf = onBehalf;
	}
	
	/**
	 * Método que obtiene  una lista con atributos de  accreditation data
	 * @return accrData
	 */
	public List<AccreditationDataTO> getAccrData() {
		if(accrData == null)
			accrData = new ArrayList<AccreditationDataTO>();
		return accrData;
	}
	
	/**
	 * Método que obtiene  una lista con atributos de  accreditation document
	 * @return AccrdocumentTO
	 */
	public List<AccrdocumentTO> getAccrdocumentTO() {
		if(AccrdocumentTO == null)
			AccrdocumentTO = new ArrayList<AccrdocumentTO>();
		return AccrdocumentTO;
	}
	
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccrinfoTO [corrLce=" + corrLce + ", accrType=" + accrType
				+ ", onBehalf=" + onBehalf + ", usuario=" + usuario
				+ ", accrData=" + accrData + ", AccrdocumentTO="
				+ AccrdocumentTO + "]";
	}
		
}
