package com.amx.service.bean;

import java.io.Serializable;

/**
 *Clase que expone los valores y datos que hace referencia a CondicionRegla.
 * 
 * @author Andres Mendoza andres.mendozavalencia@tcs.com
 * @since 20/04/2013
 * @version 1.0
 */
public class CondicionTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo único que identifica el registro el codigo
	 */
	private String codigo;
	/**
	 * Atributo único que identifica el registro la regla
	 */
	private ReglaTO regla;
	/**
	 * Atributo único que identifica el registro el campo
	 */
	private CampoTO campo;
	/**
	 * Atributo único que identifica el registro constante
	 */
	private ConstanteTO constante;
	/**
	 * Atributo único que identifica el registro dominio
	 */
	private DominioTO dominio;
	/**
	 * Atributo único que identifica el registro categoria
	 */
	private CategoriaTO categoria;
	/**
	 * Atributo único que identifica el registro operador
	 */
	private String operador;
	/**
	 * Atributo único que identifica el registro pareIzq
	 */
	private String pareIzq;

	/**
	 * Constructor que inicializa la clase
	 */
	public CondicionTO() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ReglaTO getRegla() {
		if (regla == null) {
			regla = new ReglaTO();
		}
		return regla;
	}

	public void setRegla(ReglaTO regla) {
		this.regla = regla;
	}

	public CampoTO getCampo() {
		if (campo == null) {
			campo = new CampoTO();
		}
		return campo;
	}

	public void setCampo(CampoTO campo) {
		this.campo = campo;
	}

	public ConstanteTO getConstante() {
		if (constante == null) {
			constante = new ConstanteTO();
		}
		return constante;
	}

	public void setConstante(ConstanteTO constante) {
		this.constante = constante;
	}

	public DominioTO getDominio() {
		if (dominio == null) {
			dominio = new DominioTO();
		}
		return dominio;
	}

	public void setDominio(DominioTO dominio) {
		this.dominio = dominio;
	}

	public CategoriaTO getCategoria() {
		if (categoria == null) {
			categoria = new CategoriaTO();
		}
		return categoria;
	}

	public void setCategoria(CategoriaTO categoria) {
		this.categoria = categoria;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getPareIzq() {
		return pareIzq;
	}

	public void setPareIzq(String pareIzq) {
		this.pareIzq = pareIzq;
	}

	@Override
	public String toString() {
		return "CondicionTO [codigo=" + codigo + ", regla=" + regla + ", campo=" + campo + ", constante=" + constante + ", dominio=" + dominio + ", categoria=" + categoria + ", operador="
				+ operador + ", pareIzq=" + pareIzq + "]";
	}
}
