package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Log.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class LogTO implements Serializable {
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro id
	 */
	private String id;
	/**
	 * Atributo único que identifica el registro service Name
	 */
	private String serviceName;
	/**
	 * Atributo único que identifica el registro level
	 */
	private String level;
	/**
	 * Atributo único que identifica el registro message
	 */
	private String message;
	/**
	 * Atributo único que identifica el registro isBusiness 
	 */
	private Boolean isBusiness;
	/**
	 * Atributo único que identifica el registro var
	 */
	private Object var;

	/**
	 * Constructor que inicializa la clase
	 */
	public LogTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsBusiness() {
		return isBusiness;
	}

	public void setIsBusiness(Boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

	public Object getVar() {
		return var;
	}

	public void setVar(Object var) {
		this.var = var;
	}

	@Override
	public String toString() {
		return "LogTO [id=" + id + ", serviceName=" + serviceName + ", level="
				+ level + ", message=" + message + ", isBusiness=" + isBusiness
				+ ", var=" + var + "]";
	}
	
}
