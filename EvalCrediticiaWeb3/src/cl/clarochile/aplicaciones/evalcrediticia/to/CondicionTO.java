package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;

public class CondicionTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private ReglaTO regla;
	private CampoTO campo;
	private ConstanteTO constante;
	private DominioTO dominio;
	private CategoriaTO categoria;
	private String operador;
	private String pareIzq;
	private String tipo;
	private String valor;

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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "CondicionTO [codigo=" + codigo + ", regla=" + regla + ", campo=" + campo + ", constante=" + constante + ", dominio=" + dominio + ", categoria=" + categoria + ", operador="
				+ operador + ", pareIzq=" + pareIzq + "]";
	}
}
