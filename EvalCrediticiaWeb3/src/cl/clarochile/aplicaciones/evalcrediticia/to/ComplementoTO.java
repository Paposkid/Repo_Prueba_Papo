package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;

public class ComplementoTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private CondicionTO condicion;
	private String orden;
	private String operador;
	private String pareIzq;
	private String pareDec;
	private DominioTO dominio;
	private ConstanteTO constante;

	public ComplementoTO() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public CondicionTO getCondicion() {
		if (condicion == null) {
			condicion = new CondicionTO();
		}
		return condicion;
	}

	public void setCondicion(CondicionTO condicion) {
		this.condicion = condicion;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
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

	public String getPareDec() {
		return pareDec;
	}

	public void setPareDec(String pareDec) {
		this.pareDec = pareDec;
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

	public ConstanteTO getConstante() {
		if (constante == null) {
			constante = new ConstanteTO();
		}
		return constante;
	}

	public void setConstante(ConstanteTO constante) {
		this.constante = constante;
	}

	@Override
	public String toString() {
		return "ComplementoTO [codigo=" + codigo + ", condicion=" + condicion + ", orden=" + orden + ", operador=" + operador + ", pareIzq=" + pareIzq + ", pareDec=" + pareDec
				+ ", dominio=" + dominio + ", constante=" + constante + "]";
	}
}
