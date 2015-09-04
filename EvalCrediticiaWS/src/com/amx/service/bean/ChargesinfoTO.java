package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Chargesinfo.
 * 
 * @author Jeisson Ruiz jeisson.ruizcardenas@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ChargesinfoTO implements Serializable{

    
	/**
	 *  El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro codigoChargesinfo
	 */
	private Long codigoChargesinfo;
    /**
     * Atributo �nico que identifica el registro codigoCompdifinfo
     */
    private Long codigoCompdifinfo;
    /**
     * Atributo �nico que identifica el registro montoActual
     */
    private String montoActual; 
    /**
     * Atributo �nico que identifica el registro tipoCarga
     */
    private String tipoCarga;
    /**
     * Atributo �nico que identifica el registro id
     */
    private String id;
    /**
     * Atributo �nico que identifica el registro renuncia
     */
    private String renuncia;
    /**
     * Atributo �nico que identifica el registro usuario
     */
    private Integer usuario;
        
	/**
	 * Constructor que inicializa la clase
	 */
	public ChargesinfoTO() {
		
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
	/**
	 * M�todo que obtiene el CodigoChargesinfo
	 * @return
	 */
	public Long getCodigoChargesinfo() {
		return codigoChargesinfo;
	}
	/**
	 * M�todo que establece el CodigoChargesinfo
	 * @param codigoChargesinfo
	 */
	public void setCodigoChargesinfo(Long codigoChargesinfo) {
		this.codigoChargesinfo = codigoChargesinfo;
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
	 * M�todo que obtiene el TipoCarga
	 * @return
	 */
	public String getTipoCarga() {
		return tipoCarga;
	}
	/**
	 * M�todo que establece el TipoCarga
	 * @param tipoCarga
	 */
	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
	/**
	 * M�todo que obtiene la Renuncia
	 * @return
	 */
	public String getRenuncia() {
		return renuncia;
	}
	/**
	 * M�todo que establece la Renuncia
	 * @param renuncia
	 */
	public void setRenuncia(String renuncia) {
		this.renuncia = renuncia;
	}
	/**
	 * M�todo que obtiene el MontoActual
	 * @param montoActual
	 */
	public void setMontoActual(String montoActual) {
		this.montoActual = montoActual;
	}
	/**
	 * M�todo que establece el MontoActual
	 * @return
	 */
	public String getMontoActual() {
		return montoActual;
	}
	/**
	 * M�todo que obtiene el id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * M�todo que establece el id
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChargesinfoTO [codigoChargesinfo=" + codigoChargesinfo
				+ ", codigoCompdifinfo=" + codigoCompdifinfo + ", montoActual="
				+ montoActual + ", tipoCarga=" + tipoCarga + ", id=" + id
				+ ", renuncia=" + renuncia + ", usuario=" + usuario + "]";
	}
		
}
