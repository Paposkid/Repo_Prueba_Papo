package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;

public class ReporteTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nroOrden;
	private String tipoEvaluacion;
	private String fechaDesde;
	private String fechaHasta;
	private String rut;
	private String cliente;
	private String estado;
	private String tipoAcreditacion;
	private String canalVenta;
	private String tipoCliente;
	private String distribuidor;
	private String dicom;
	private String nivelRiesgo;
	private String rangoEdad;

	public ReporteTO() {

	}
	
	public String getNroOrden() {
		return nroOrden;
	}
	
	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}
	
	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	
	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	
	public String getFechaHasta() {
		return fechaHasta;
	}
	
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoAcreditacion() {
		return tipoAcreditacion;
	}

	public void setTipoAcreditacion(String tipoAcreditacion) {
		this.tipoAcreditacion = tipoAcreditacion;
	}

	public String getCanalVenta() {
		return canalVenta;
	}

	public void setCanalVenta(String canalVenta) {
		this.canalVenta = canalVenta;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getDicom() {
		return dicom;
	}

	public void setDicom(String dicom) {
		this.dicom = dicom;
	}

	public String getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(String nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public String getRangoEdad() {
		return rangoEdad;
	}

	public void setRangoEdad(String rangoEdad) {
		this.rangoEdad = rangoEdad;
	}
}