package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;
import java.util.Date;

public class TipoReglaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String estado;
	private Date fechaAlta;
	private String usuarioAlta;
	private Date fechaModificacion;
	private String usuarioModificacion;

	public TipoReglaTO() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	@Override
	public String toString() {
		return "TipoReglaTO [codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", fechaAlta=" + fechaAlta + ", usuarioAlta=" + usuarioAlta + ", fechaModificacion=" + fechaModificacion
				+ ", usuarioModificacion=" + usuarioModificacion + "]";
	}
}
