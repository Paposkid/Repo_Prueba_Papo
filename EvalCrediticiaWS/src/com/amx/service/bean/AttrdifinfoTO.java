package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Attrdifinfo.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class AttrdifinfoTO implements Serializable{
    

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Atributo �nico que identifica el registro codigoAttrdifinfo
	 */
	private Long codigoAttrdifinfo;
    /**
     * Atributo �nico que identifica el registro codigoCompdifinfo
     */
    private Long codigoCompdifinfo;
    /**
     * Atributo �nico que identifica el registro nombre
     */
    private String nombre; 
    /**
     * Atributo �nico que identifica el registro idatributo
     */
    private String idatributo;
    /**
     * Atributo �nico que identifica el registro valor
     */
    private String valor; 
    /**
     * Atributo �nico que identifica el registro antiguoValor
     */
    private String antiguoValor; 
    /**
     * Atributo �nico que identifica el registro accion
     */
    private String accion;
    /**
     * Atributo �nico que identifica el registro usuario
     */
    private Integer usuario;
    
    
	/**
	 * Constructor vacio
	 */
	public AttrdifinfoTO() {
		
	}
	/**
	 * M�todo que obtiene el CodigoAttrdifinfo
	 * @return
	 */
	public Long getCodigoAttrdifinfo() {
		return codigoAttrdifinfo;
	}
	/**
	 * M�todo que establece el CodigoAttrdifinfo
	 * @param codigoAttrdifinfo
	 */
	public void setCodigoAttrdifinfo(Long codigoAttrdifinfo) {
		this.codigoAttrdifinfo = codigoAttrdifinfo;
	}
	/**
	 * M�todo que obtiene el CodigoCompdifinfo
	 * @return
	 */
	public Long getCodigoCompdifinfo() {
		return codigoCompdifinfo;
	}
	/**
	 * M�todo que establece el CodigoCompdifinfo
	 * @param codigoCompdifinfo
	 */
	public void setCodigoCompdifinfo(Long codigoCompdifinfo) {
		this.codigoCompdifinfo = codigoCompdifinfo;
	}
	/**
	 * M�todo que obtiene el Nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * M�todo que establece el Nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * M�todo que obtiene el Idatributo
	 * @return
	 */
	public String getIdatributo() {
		return idatributo;
	}
	/**
	 * M�todo que establece el Idatributo
	 * @param idatributo
	 */
	public void setIdatributo(String idatributo) {
		this.idatributo = idatributo;
	}
	/**
	 * M�todo que obtiene el Valor
	 * @return
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * M�todo que establece el Valor
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * M�todo que obtiene el AntiguoValor
	 * @return
	 */
	public String getAntiguoValor() {
		return antiguoValor;
	}
	/**
	 * M�todo que establece el AntiguoValor
	 * @param antiguoValor
	 */
	public void setAntiguoValor(String antiguoValor) {
		this.antiguoValor = antiguoValor;
	}
	/**
	 * M�todo que obtiene la Accion
	 * @return
	 */
	public String getAccion() {
		return accion;
	}
	/**
	 * M�todo que establece la Accion
	 * @param accion
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	/**
	 * M�todo que obtiene el Usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * M�todo que establece el Usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AttrdifinfoTO [codigoAttrdifinfo=" + codigoAttrdifinfo
				+ ", codigoCompdifinfo=" + codigoCompdifinfo + ", nombre="
				+ nombre + ", idatributo=" + idatributo + ", valor=" + valor
				+ ", antiguoValor=" + antiguoValor + ", accion=" + accion
				+ ", usuario=" + usuario + "]";
	}
    
}
