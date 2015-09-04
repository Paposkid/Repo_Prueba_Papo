package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema10.
 * 
 * @author Daniel Ocampo daniel.ocampogutierrez@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema10TO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro total impagos 
	 */
	private Integer totaImpa;
	/**
	 * Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro maximo Impagos
	 */
	private Integer maxImpa;
	/**
	 * Atributo único que identifica el registro usuario
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica la lista de objetos lista de Detalles SubSistema10
	 */
	private List<DetSubsistema10TO> listDetSubSistema10;

	/**
	 * Constructor que inicializa la clase
	 */
	public SubSistema10TO() {
	}

	public Integer getTotaImpa() {
		return totaImpa;
	}

	public void setTotaImpa(Integer totaImpa) {
		this.totaImpa = totaImpa;
	}

	public Long getSerialVersion() {
		return serialVersion;
	}

	public void setSerialVersion(Long serialVersionuid) {
		this.serialVersion = serialVersionuid;
	}

	public Integer getMaxImpa() {
		return maxImpa;
	}

	public void setMaxImpa(Integer maxImpa) {
		this.maxImpa = maxImpa;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	
	public List<DetSubsistema10TO> getListDetSubSistema10() {
		if(listDetSubSistema10 == null)
			listDetSubSistema10 = new ArrayList<DetSubsistema10TO>();
		return listDetSubSistema10;
	}

	@Override
	public String toString() {
		return "SubSistema10TO [totaImpa=" + totaImpa + ", serialVersion="
				+ serialVersion + ", maxImpa=" + maxImpa + ", usuario="
				+ usuario + ", listDetSubSistema10=" + listDetSubSistema10
				+ "]";
	}

}
