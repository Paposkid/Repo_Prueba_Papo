package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;
import java.util.Date;

public class ReglaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String valor;
	private String descripcion;
	private String tipoRegla;
	private String nombreTipoRegla;
	private String subtipoRegla;
	private String tipoEvaluacion;
	private String fechaVigenciaDesde;
	private String fechaVigenciaHasta;
	private String sinVigencia;
	private String estado;
	private String nombreEstado;
	private Date fechaAlta;
	private String usuarioAlta;
	private Date fechaModificacion;
	private String usuarioModificacion;

	public ReglaTO() {

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoRegla() {
		return tipoRegla;
	}

	public void setTipoRegla(String tipoRegla) {
		this.tipoRegla = tipoRegla;
	}

	public String getSubtipoRegla() {
		return subtipoRegla;
	}

	public void setSubtipoRegla(String subtipoRegla) {
		this.subtipoRegla = subtipoRegla;
	}

	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public String getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(String fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	public String getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(String fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}

	public String getSinVigencia() {
		return sinVigencia;
	}

	public void setSinVigencia(String sinVigencia) {
		this.sinVigencia = sinVigencia;
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
		return "ReglaTO [codigo=" + codigo + ", nombre=" + nombre + ", valor=" + valor + ", descripcion=" + descripcion + ", tipoRegla=" + tipoRegla + ", subtipoRegla=" + subtipoRegla
				+ ", tipoEvaluacion=" + tipoEvaluacion + ", fechaVigenciaDesde=" + fechaVigenciaDesde + ", fechaVigenciaHasta=" + fechaVigenciaHasta + ", sinVigencia=" + sinVigencia + ", estado="
				+ estado + ", fechaAlta=" + fechaAlta + ", usuarioAlta=" + usuarioAlta + ", fechaModificacion=" + fechaModificacion + ", usuarioModificacion=" + usuarioModificacion + "]";
	}
	
	public String getNombreTipoRegla() {
		return nombreTipoRegla;
	}
	
	public void setNombreTipoRegla(String nombreTipoRegla) {
		this.nombreTipoRegla = nombreTipoRegla;
	}
	
	public String getNombreEstado() {
		return nombreEstado;
	}
	
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
}