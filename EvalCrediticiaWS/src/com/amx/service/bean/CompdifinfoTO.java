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
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro codigoCompdifinfo
	 */
	private Long codigoCompdifinfo; 
	/**
	 * Atributo �nico que identifica el registro codigoProductdifinfo
	 */
	private Long codigoProductdifinfo;
    /**
     * Atributo �nico que identifica el registro nombre
     */
    private String nombre; 
    /**
     * Atributo �nico que identifica el registro cid
     */
    private String cid;
    /**
     * Atributo �nico que identifica el registro accion
     */
    private String accion;
    /**
     * Atributo �nico que identifica el registro subComponente
     */
    private Long subComponente;
    /**
     * Atributo �nico que identifica el registro usuario
     */
    private Integer usuario;
    /**
     * Atributo �nico que identifica Compdifinfo
     */
    private List<CompdifinfoTO> listsubComponente;
    /**
     * Atributo �nico que identifica la lista de objetos Attrdifinfo
     */
    private List<AttrdifinfoTO> listAttrdifinfo;
    /**
     * Atributo �nico que identifica la lista de objetos Chargesinfo
     */
    private List<ChargesinfoTO> listChargesinfo;
    
    /**
     * Constructor que inicializa la clase
     */
    public CompdifinfoTO() {
		
	}

	/**
	 * M�todo que obtiene la lista de objetos Compdifinfo
	 * @return
	 */
	public List<CompdifinfoTO> getListsubComponente() {
		if(listsubComponente == null){
			listsubComponente = new ArrayList<CompdifinfoTO>();
		}
		return listsubComponente;
	}
	
	/**
	 * M�todo que obtiene la lista de objetos Attrdifinfo
	 * @return
	 */
	public List<AttrdifinfoTO> getListAttrdifinfo() {
		if(listAttrdifinfo == null){
			listAttrdifinfo = new ArrayList<AttrdifinfoTO>();
		}
		return listAttrdifinfo;
	}
	
	/**
	 * M�todo que obtiene la lista de objetos Chargesinfo
	 * @return
	 */
	public List<ChargesinfoTO> getListChargesinfo() {
		if(listChargesinfo == null){
			listChargesinfo = new ArrayList<ChargesinfoTO>();
		}
		return listChargesinfo;
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
	 *M�todo que obtiene el CodigoProductdifinfo
	 * @return
	 */
	public Long getCodigoProductdifinfo() {
		return codigoProductdifinfo;
	}
	/**
	 * M�todo que establece el CodigoProductdifinfo
	 * @param codigoProductdifinfo
	 */
	public void setCodigoProductdifinfo(Long codigoProductdifinfo) {
		this.codigoProductdifinfo = codigoProductdifinfo;
	}
	/**
	 * M�todo que obtiene el Nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * M�todo que establece  Nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * M�todo que obtiene el Cid
	 * @return
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * M�todo que establece el Cid
	 * @param cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
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
	 * M�todo que obtiene el SubComponente
	 * @return
	 */
	public Long getSubComponente() {
		return subComponente;
	}
	/**
	 * M�todo que establece el SubComponente
	 * @param subComponente
	 */
	public void setSubComponente(Long subComponente) {
		this.subComponente = subComponente;
	}
	/**
	 * M�todo que obtiene el Usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * M�todo que establece el usuario
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
		return "CompdifinfoTO [codigoCompdifinfo=" + codigoCompdifinfo
				+ ", codigoProductdifinfo=" + codigoProductdifinfo
				+ ", nombre=" + nombre + ", cid=" + cid + ", accion=" + accion
				+ ", subComponente=" + subComponente + ", usuario=" + usuario
				+ ", listsubComponente=" + listsubComponente
				+ ", listAttrdifinfo=" + listAttrdifinfo + ", listChargesinfo="
				+ listChargesinfo + "]";
	}
    
}
