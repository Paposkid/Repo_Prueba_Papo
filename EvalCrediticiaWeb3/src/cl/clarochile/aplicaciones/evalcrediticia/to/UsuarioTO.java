package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String clave;

	public UsuarioTO() {
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "UsuarioTO [usuario=" + usuario + ", clave=" + clave + "]";
	}
}