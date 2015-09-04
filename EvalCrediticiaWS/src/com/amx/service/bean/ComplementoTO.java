package com.amx.service.bean;
import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a Complemento.
 * 
 * @author Carlos Castrillon carlos.castrillonescobar@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class ComplementoTO implements Serializable {

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el registro codigo
	 */
	private String codigo;
	/**
	 * Atributo �nico que identifica el registro condicion
	 */
	private CondicionTO condicion;
	/**
	 * Atributo �nico que identifica el registro orden
	 */
	private String orden;
	/**
	 * Atributo �nico que identifica el registro operador
	 */
	private String operador;
	/**
	 * Atributo �nico que identifica el registro pareIzq
	 */
	private String pareIzq;
	/**
	 * Atributo �nico que identifica el registro pareDec
	 */
	private String pareDec;
	/**
	 * Atributo �nico que identifica el registro dominio
	 */
	private DominioTO dominio;
	/**
	 * Atributo �nico que identifica el registro constante
	 */
	private ConstanteTO constante;

	/**
	 * Constructor que inicializa la clase
	 */
	public ComplementoTO() {
	}

	/**
	 * M�todo que obtiene el Codigo
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo que establece el Codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo que obtiene la Condicion
	 * @return
	 */
	public CondicionTO getCondicion() {
		if (condicion == null) {
			condicion = new CondicionTO();
		}
		return condicion;
	}

	/**
	 * M�todo que establece la Condicion
	 * @param condicion
	 */
	public void setCondicion(CondicionTO condicion) {
		this.condicion = condicion;
	}

	/**
	 *  M�todo que obtiene el Orden
	 * @return
	 */
	public String getOrden() {
		return orden;
	}

	/**
	 * M�todo que establece el Orden
	 * @param orden
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}

	/**
	 * M�todo que obtiene el Operador
	 * @return
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * M�todo que establece el Operador
	 * @param operador
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}

	/**
	 * M�todo que obtiene la PareIzq
	 * @return
	 */
	public String getPareIzq() {
		return pareIzq;
	}

	/**
	 * M�todo que establece la PareIzq
	 * @param pareIzq
	 */
	public void setPareIzq(String pareIzq) {
		this.pareIzq = pareIzq;
	}

	/**
	 * M�todo que obtiene la PareDec
	 * @return
	 */
	public String getPareDec() {
		return pareDec;
	}

	/**
	 * M�todo que establece la PareDec
	 * @param pareDec
	 */
	public void setPareDec(String pareDec) {
		this.pareDec = pareDec;
	}

	/**
	 * M�todo que obtiene el Dominio
	 * @return
	 */
	public DominioTO getDominio() {
		if (dominio == null) {
			dominio = new DominioTO();
		}
		return dominio;
	}

	/**
	 * M�todo que establece el Dominio
	 * @param dominio
	 */
	public void setDominio(DominioTO dominio) {
		this.dominio = dominio;
	}

	/**
	 * M�todo que obtiene la Constante
	 * @return
	 */
	public ConstanteTO getConstante() {
		if (constante == null) {
			constante = new ConstanteTO();
		}
		return constante;
	}

	/**
	 * M�todo que establece la Constante
	 * @param constante
	 */
	public void setConstante(ConstanteTO constante) {
		this.constante = constante;
	}

	/* 
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComplementoTO [codigo=" + codigo + ", condicion=" + condicion + ", orden=" + orden + ", operador=" + operador + ", pareIzq=" + pareIzq + ", pareDec=" + pareDec
				+ ", dominio=" + dominio + ", constante=" + constante + "]";
	}
}
