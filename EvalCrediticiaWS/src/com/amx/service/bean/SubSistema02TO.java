package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a SubSistema01.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 22/04/2013
 * @version 1.0
 */
public class SubSistema02TO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo único que identifica el registro serial Version
	 */
	private Long serialVersion;
	/**
	 *  Atributo único que identifica el registro cantDire
	 */
	private Integer cantDire;
	/**
	 *  Atributo único que identifica el registro direPart
	 */
	private String direPart;
	/**
	 *  Atributo único que identifica el registro ciudPart
	 */
	private String ciudPart;
	/**
	 *  Atributo único que identifica el registro comuPart
	 */
	private String comuPart;
	/**
	 *  Atributo único que identifica el registro primTele
	 */
	private String primTele;
	/**
	 *  Atributo único que identifica el registro seguTele 
	 */
	private String seguTele;
	/**
	 *  Atributo único que identifica el registro numeFaxs
	 */
	private String numeFaxs;
	/**
	 *  Atributo único que identifica el registro direMail
	 */
	private String direMail;
	/**
	 *  Atributo único que identifica el registro direDurl
	 */
	private String direDurl;
	/**
	 *  Atributo único que identifica el registro codiPost
	 */
	private String codiPost;
	/**
	 *  Atributo único que identifica el registro código Usuario Alta
	 */
	private Integer codUsuarioAlta;
	
	/**
	 * Constructor que inicializa la clase
	 */
	public SubSistema02TO() {
	}
	public Long getSerialVersion() {
		return serialVersion;
	}
	public void setSerialVersion(Long serialVersion) {
		this.serialVersion = serialVersion;
	}
	public Integer getCantDire() {
		return cantDire;
	}
	public void setCantDire(Integer cantDire) {
		this.cantDire = cantDire;
	}
	public String getDirePart() {
		return direPart;
	}
	public void setDirePart(String direPart) {
		this.direPart = direPart;
	}
	public String getCiudPart() {
		return ciudPart;
	}
	public void setCiudPart(String ciudPart) {
		this.ciudPart = ciudPart;
	}
	public String getComuPart() {
		return comuPart;
	}
	public void setComuPart(String comuPart) {
		this.comuPart = comuPart;
	}
	public String getPrimTele() {
		return primTele;
	}
	public void setPrimTele(String primTele) {
		this.primTele = primTele;
	}
	public String getSeguTele() {
		return seguTele;
	}
	public void setSeguTele(String seguTele) {
		this.seguTele = seguTele;
	}
	public String getNumeFaxs() {
		return numeFaxs;
	}
	public void setNumeFaxs(String numeFaxs) {
		this.numeFaxs = numeFaxs;
	}
	public String getDireMail() {
		return direMail;
	}
	public void setDireMail(String direMail) {
		this.direMail = direMail;
	}
	public String getDireDurl() {
		return direDurl;
	}
	public void setDireDurl(String direDurl) {
		this.direDurl = direDurl;
	}
	public String getCodiPost() {
		return codiPost;
	}
	public void setCodiPost(String codiPost) {
		this.codiPost = codiPost;
	}
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}
	@Override
	public String toString() {
		return "SubSistema02TO [serialVersion=" + serialVersion + ", cantDire="
				+ cantDire + ", direPart=" + direPart + ", ciudPart="
				+ ciudPart + ", comuPart=" + comuPart + ", primTele="
				+ primTele + ", seguTele=" + seguTele + ", numeFaxs="
				+ numeFaxs + ", direMail=" + direMail + ", direDurl="
				+ direDurl + ", codiPost=" + codiPost + ", codUsuarioAlta="
				+ codUsuarioAlta + "]";
	}
	
	
	
}
