package com.amx.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que expone los valores y datos que hace referencia a Chargesinfo.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class CompdifinfoTO implements Serializable{
	
	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigoCompdifinfo
	 */
	private Long codigoCompdifinfo; 
	/**
	 * Atributo único que identifica el registro codigoProductdifinfo
	 */
	private Long codigoProductdifinfo;
    /**
     * Atributo único que identifica el registro nombre
     */
    private String nombre; 
    /**
     * Atributo único que identifica el registro cid
     */
    private String cid;
    /**
     * Atributo único que identifica el registro accion
     */
    private String accion;
    /**
     * Atributo único que identifica el registro subComponente
     */
    private Long subComponente;
    /**
     * Atributo único que identifica el registro usuario
     */
    private Integer usuario;
    /**
     * Atributo único que identifica Compdifinfo
     */
    private List<CompdifinfoTO> listsubComponente;
    /**
     * Atributo único que identifica la lista de objetos Attrdifinfo
     */
    private List<AttrdifinfoTO> listAttrdifinfo;
    /**
     * Atributo único que identifica la lista de objetos Chargesinfo
     */
    private List<ChargesinfoTO> listChargesinfo;
    
    /**
     * Constructor que inicializa la clase
     */
    public CompdifinfoTO() {
		
	}

	/**
	 * Método que obtiene la lista de objetos Compdifinfo
	 * @return
	 */
	public List<CompdifinfoTO> getListsubComponente() {
		if(listsubComponente == null){
			listsubComponente = new ArrayList<CompdifinfoTO>();
		}
		return listsubComponente;
	}
	
	/**
	 * Método que obtiene la lista de objetos Attrdifinfo
	 * @return
	 */
	public List<AttrdifinfoTO> getListAttrdifinfo() {
		if(listAttrdifinfo == null){
			listAttrdifinfo = new ArrayList<AttrdifinfoTO>();
		}
		return listAttrdifinfo;
	}
	
	/**
	 * Método que obtiene la lista de objetos Chargesinfo
	 * @return
	 */
	public List<ChargesinfoTO> getListChargesinfo() {
		if(listChargesinfo == null){
			listChargesinfo = new ArrayList<ChargesinfoTO>();
		}
		return listChargesinfo;
	}
	
	/**
	 * Método que obtiene el CodigoCompdifinfo
	 * @return
	 */
	public Long getCodigoCompdifinfo() {
		return codigoCompdifinfo;
	}
	/**
	 * Método que establece el CodigoCompdifinfo
	 * @param codigoCompdifinfo
	 */
	public void setCodigoCompdifinfo(Long codigoCompdifinfo) {
		this.codigoCompdifinfo = codigoCompdifinfo;
	}
	/**
	 *Método que obtiene el CodigoProductdifinfo
	 * @return
	 */
	public Long getCodigoProductdifinfo() {
		return codigoProductdifinfo;
	}
	/**
	 * Método que establece el CodigoProductdifinfo
	 * @param codigoProductdifinfo
	 */
	public void setCodigoProductdifinfo(Long codigoProductdifinfo) {
		this.codigoProductdifinfo = codigoProductdifinfo;
	}
	/**
	 * Método que obtiene el Nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Método que establece  Nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método que obtiene el Cid
	 * @return
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * Método que establece el Cid
	 * @param cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * Método que obtiene la Accion
	 * @return
	 */
	public String getAccion() {
		return accion;
	}
	/** 
	 * Método que establece la Accion
	 * @param accion
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	/**
	 * Método que obtiene el SubComponente
	 * @return
	 */
	public Long getSubComponente() {
		return subComponente;
	}
	/**
	 * Método que establece el SubComponente
	 * @param subComponente
	 */
	public void setSubComponente(Long subComponente) {
		this.subComponente = subComponente;
	}
	/**
	 * Método que obtiene el Usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Método que establece el usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompdifinfoTO [codigoCompdifinfo=" + codigoCompdifinfo
				+ ", codigoProductdifinfo=" + codigoProductdifinfo
				+ ", nombre=" + nombre + ", cid=" + cid + ", accion=" + accion
				+ ", subComponente=" + subComponente + ", usuario=" + usuario
				+ ", listsubComponente=" + listsubComponente
				+ ", listAttrdifinfo=" + listAttrdifinfo + ", listChargesinfo="
				+ listChargesinfo + "]";
	}
    
}
