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
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro codigo
	 */
	private String codigo;
	/**
	 * Atributo único que identifica el registro condicion
	 */
	private CondicionTO condicion;
	/**
	 * Atributo único que identifica el registro orden
	 */
	private String orden;
	/**
	 * Atributo único que identifica el registro operador
	 */
	private String operador;
	/**
	 * Atributo único que identifica el registro pareIzq
	 */
	private String pareIzq;
	/**
	 * Atributo único que identifica el registro pareDec
	 */
	private String pareDec;
	/**
	 * Atributo único que identifica el registro dominio
	 */
	private DominioTO dominio;
	/**
	 * Atributo único que identifica el registro constante
	 */
	private ConstanteTO constante;

	/**
	 * Constructor que inicializa la clase
	 */
	public ComplementoTO() {
	}

	/**
	 * Método que obtiene el Codigo
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que establece el Codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método que obtiene la Condicion
	 * @return
	 */
	public CondicionTO getCondicion() {
		if (condicion == null) {
			condicion = new CondicionTO();
		}
		return condicion;
	}

	/**
	 * Método que establece la Condicion
	 * @param condicion
	 */
	public void setCondicion(CondicionTO condicion) {
		this.condicion = condicion;
	}

	/**
	 *  Método que obtiene el Orden
	 * @return
	 */
	public String getOrden() {
		return orden;
	}

	/**
	 * Método que establece el Orden
	 * @param orden
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}

	/**
	 * Método que obtiene el Operador
	 * @return
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Método que establece el Operador
	 * @param operador
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}

	/**
	 * Método que obtiene la PareIzq
	 * @return
	 */
	public String getPareIzq() {
		return pareIzq;
	}

	/**
	 * Método que establece la PareIzq
	 * @param pareIzq
	 */
	public void setPareIzq(String pareIzq) {
		this.pareIzq = pareIzq;
	}

	/**
	 * Método que obtiene la PareDec
	 * @return
	 */
	public String getPareDec() {
		return pareDec;
	}

	/**
	 * Método que establece la PareDec
	 * @param pareDec
	 */
	public void setPareDec(String pareDec) {
		this.pareDec = pareDec;
	}

	/**
	 * Método que obtiene el Dominio
	 * @return
	 */
	public DominioTO getDominio() {
		if (dominio == null) {
			dominio = new DominioTO();
		}
		return dominio;
	}

	/**
	 * Método que establece el Dominio
	 * @param dominio
	 */
	public void setDominio(DominioTO dominio) {
		this.dominio = dominio;
	}

	/**
	 * Método que obtiene la Constante
	 * @return
	 */
	public ConstanteTO getConstante() {
		if (constante == null) {
			constante = new ConstanteTO();
		}
		return constante;
	}

	/**
	 * Método que establece la Constante
	 * @param constante
	 */
	public void setConstante(ConstanteTO constante) {
		this.constante = constante;
	}

	/* 
	 * Método que devuelve un String con el contenido todos los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComplementoTO [codigo=" + codigo + ", condicion=" + condicion + ", orden=" + orden + ", operador=" + operador + ", pareIzq=" + pareIzq + ", pareDec=" + pareDec
				+ ", dominio=" + dominio + ", constante=" + constante + "]";
	}
}
