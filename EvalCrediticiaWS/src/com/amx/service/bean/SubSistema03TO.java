package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema03.
 *
 @author christian hincapié christian.hincapiemonsalve@tcs.com 
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema03TO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 * Atributo único que identifica el registro pcjePred
	 */
	private Integer pcjePred;
	/**
	 * Atributo único que identifica el registro vlorPred
	 */
	private Integer vlorPred;
	/**
	 * Atributo único que identifica el registro caliExpl
	 */
	private String caliExpl;
	/**
	 * Atributo único que identifica el registro caliOrig
	 */
	private String caliOrig;
	/**
	 * Atributo único que identifica el registro caliOrig
	 */
	private Integer usuario;
	/**
	 * Atributo único que identifica la lista de objetos  listDetSubSistema03
	 */
	private	 List<DetSubsistema03TO> listDetSubSistema03;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public SubSistema03TO() {
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	public Integer getPcjePred() {
		return pcjePred;
	}
	public void setPcjePred(Integer pcjePred) {
		this.pcjePred = pcjePred;
	}
	public Integer getVlorPred() {
		return vlorPred;
	}
	public void setVlorPred(Integer vlorPred) {
		this.vlorPred = vlorPred;
	}
	public String getCaliExpl() {
		return caliExpl;
	}
	public void setCaliExpl(String caliExpl) {
		this.caliExpl = caliExpl;
	}
	public String getCaliOrig() {
		return caliOrig;
	}
	public void setCaliOrig(String caliOrig) {
		this.caliOrig = caliOrig;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	
	public List<DetSubsistema03TO> getListDetSubSistema03() {
		if(listDetSubSistema03 == null)
			listDetSubSistema03 = new ArrayList<DetSubsistema03TO>();
		return listDetSubSistema03;
	}
	@Override
	public String toString() {
		return "SubSistema03TO [serialVersion=" + serialVersion + ", pcjePred="
				+ pcjePred + ", vlorPred=" + vlorPred + ", caliExpl="
				+ caliExpl + ", caliOrig=" + caliOrig + ", usuario=" + usuario
				+ ", listDetSubSistema03=" + listDetSubSistema03 + "]";
	}
	
	

}
