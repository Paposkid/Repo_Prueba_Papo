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
	 *  El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigoChargesinfo
	 */
	private Long codigoChargesinfo;
    /**
     * Atributo único que identifica el registro codigoCompdifinfo
     */
    private Long codigoCompdifinfo;
    /**
     * Atributo único que identifica el registro montoActual
     */
    private String montoActual; 
    /**
     * Atributo único que identifica el registro tipoCarga
     */
    private String tipoCarga;
    /**
     * Atributo único que identifica el registro id
     */
    private String id;
    /**
     * Atributo único que identifica el registro renuncia
     */
    private String renuncia;
    /**
     * Atributo único que identifica el registro usuario
     */
    private Integer usuario;
        
	/**
	 * Constructor que inicializa la clase
	 */
	public ChargesinfoTO() {
		
	}
	/**
	 * Método que obtiene el Usuario
	 * @return
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Método que establece el Usuario
	 * @param usuario
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * Método que obtiene el CodigoChargesinfo
	 * @return
	 */
	public Long getCodigoChargesinfo() {
		return codigoChargesinfo;
	}
	/**
	 * Método que establece el CodigoChargesinfo
	 * @param codigoChargesinfo
	 */
	public void setCodigoChargesinfo(Long codigoChargesinfo) {
		this.codigoChargesinfo = codigoChargesinfo;
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
	 * Método que obtiene el TipoCarga
	 * @return
	 */
	public String getTipoCarga() {
		return tipoCarga;
	}
	/**
	 * Método que establece el TipoCarga
	 * @param tipoCarga
	 */
	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
	/**
	 * Método que obtiene la Renuncia
	 * @return
	 */
	public String getRenuncia() {
		return renuncia;
	}
	/**
	 * Método que establece la Renuncia
	 * @param renuncia
	 */
	public void setRenuncia(String renuncia) {
		this.renuncia = renuncia;
	}
	/**
	 * Método que obtiene el MontoActual
	 * @param montoActual
	 */
	public void setMontoActual(String montoActual) {
		this.montoActual = montoActual;
	}
	/**
	 * Método que establece el MontoActual
	 * @return
	 */
	public String getMontoActual() {
		return montoActual;
	}
	/**
	 * Método que obtiene el id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Método que establece el id
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/* 
	 * Método que devuelve un String con el contenido todos los atributos
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
