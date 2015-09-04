package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase que expone los valores y datos que hace referencia a las listas
 * Especiales
 * 
 * @author Christian Camilo hincapi� Monsalve
 *         [christian.hincapiemonsalve@tcs.com]
 * @since 18/03/2013
 * @version 1.0
 */

public class ListaEspecialTO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Atributo unico que identifica el nombre de una lista especial
	 */
	private String nombreListaEspecial;
	/**
	 * Atributo que identifica el concepto que se consultar�
	 */
	private String valorConcepto;

	
	private String nombreCampoResultado;
	private String nombreCampoConsulta;	
	
	
	/**
	 * Atributo que identifica la lista que se consultar�
	 */
	private String tipoLista;
	/**
	 * Atributo que identifica el �campo� que ser� enviado como par�metro para
	 * la consultas.
	 */
	private String campoConsulta;
	/**
	 * Atributo que identifica el �campo� que recibir� la respuesta de la lista
	 * especial.
	 */
	private String campoResultado;
	/**
	 * Atributo que identifica campo de selecci�n que contiene 3 valores (OK,
	 * NOK, Sin respuesta).
	 */
	private String valorDefecto;
	/**
	 * Atributo que identifica si la consulta se encuentra �Activa� o
	 * �Desactiva�.
	 */
	private String stado;
	/**
	 * Atributo que identifica la fecha que fue creada la lista especial
	 */
	private Date fechaAlta;
	/**
	 * Atributo que identifica al usuiario que creo la lista Especial
	 */
	private Integer codUsuarioAlta;
	/**
	 * Atributo que identifica la fecha a la que la lista especial fue
	 * modificada
	 */
	private Date fechaMod;
	/**
	 * Atributo que identifica al usuario que modifico la lista especial
	 */
	private Integer codUsuarioMod;

	/**
	 * Constructor que inicializa la clase
	 */
	public ListaEspecialTO() {

	}

	/**
	 * M�todo que obtiene el nombre de la lista especial
	 * 
	 * @return nombreListaEspecial.
	 */

	public String getNombreListaEspecial() {
		return nombreListaEspecial;
	}

	/**
	 * M�todo que esatablece el nombre de la lista especial
	 * 
	 * @param nombreListaEspecial
	 *            .
	 */
	public void setNombreListaEspecial(String nombreListaEspecial) {
		this.nombreListaEspecial = nombreListaEspecial;
	}

	/**
	 * M�todo que obtiene el concepto
	 * 
	 * @return valorConcepto.
	 */

	public String getValorConcepto() {
		return valorConcepto;
	}

	/**
	 * M�todo que esatablece el concepto
	 * 
	 * @param tipoLista
	 *            .
	 */
	public void setValorConcepto(String valorConcepto) {
		this.valorConcepto = valorConcepto;
	}

	/**
	 * M�todo que obtiene el tipo de lista
	 * 
	 * @return tipoLista.
	 */
	public String getTipoLista() {
		return tipoLista;
	}

	/**
	 * M�todo que esatablece el tipo de lista
	 * 
	 * @param campoConsulta
	 *            .
	 */
	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}

	/**
	 * M�todo que obtiene el campo de consulta
	 * 
	 * @return campoConsulta.
	 */
	public String getCampoConsulta() {
		return campoConsulta;
	}

	/**
	 * M�todo que esatablece el campo de consulta
	 * 
	 * @param campoResultado
	 *            .
	 */
	public void setCampoConsulta(String campoConsulta) {
		this.campoConsulta = campoConsulta;
	}

	/**
	 * M�todo que obtiene el campo resultado
	 * 
	 * @return campoResultado.
	 */
	public String getCampoResultado() {
		return campoResultado;
	}

	/**
	 * M�todo que esatablece el campo resultado
	 * 
	 * @param campoResultado
	 *            .
	 */
	public void setCampoResultado(String campoResultado) {
		this.campoResultado = campoResultado;
	}

	/**
	 * M�todo que obtiene el valor por defecto
	 * 
	 * @return valorDefecto.
	 */
	public String getValorDefecto() {
		return valorDefecto;
	}

	/**
	 * M�todo que esatablece el valor por defecto
	 * 
	 * @param valorDefecto
	 *            .
	 */
	public void setValorDefecto(String valorDefecto) {
		this.valorDefecto = valorDefecto;
	}

	/**
	 * M�todo que obtiene el estado
	 * 
	 * @return stado.
	 */
	public String getStado() {
		return stado;
	}

	/**
	 * M�todo que esatablece el estado
	 * 
	 * @param stado
	 *            .
	 */
	public void setStado(String stado) {
		this.stado = stado;
	}

	/**
	 * M�todo que obtiene la fecha de creaci�n
	 * 
	 * @return fechaAlta.
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * M�todo que esatablece la fecha de creaci�n
	 * 
	 * @param fechaAlta
	 *            .
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * M�todo que obtiene el codigo del usuario que creo la lista especial
	 * 
	 * @return codUsuarioAlta.
	 */
	public Integer getCodUsuarioAlta() {
		return codUsuarioAlta;
	}

	/**
	 * M�todo que esatablece el codigo del usuario que creo la lista especial
	 * 
	 * @param codUsuarioAlta
	 *            .
	 */
	public void setCodUsuarioAlta(Integer codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}
	
	
	private String nombreLista;
	
	private String nombreConcepto;
	
	private String nombreEstado;

	/**
	 * M�todo que obtiene la fecha de cmodificaci�n
	 * 
	 * @return fechaMod.
	 */
	public Date getFechaMod() {
		return fechaMod;
	}

	/**
	 * M�todo que esatablece la fecha de modificaci�n
	 * 
	 * @param fechaMod
	 *            .
	 */
	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	/**
	 * M�todo que esatablece el codigo del usuario que modifico la lista
	 * especial
	 * 
	 * @return codUsuarioMod.
	 */
	public Integer getCodUsuarioMod() {
		return codUsuarioMod;
	}

	/**
	 * M�todo que esatablece el codigo del usuario que modifico la lista
	 * especial
	 * 
	 * @param codUsuarioMod
	 *            .
	 */
	public void setCodUsuarioMod(Integer codUsuarioMod) {
		this.codUsuarioMod = codUsuarioMod;
	}

	@Override
	public String toString() {
		return "ListaEspecialTO [nombreListaEspecial=" + nombreListaEspecial + ", valorConcepto=" + valorConcepto + ", tipoLista=" + tipoLista + ", campoConsulta=" + campoConsulta
				+ ", campoResultado=" + campoResultado + ", valorDefecto=" + valorDefecto + ", stado=" + stado + ", fechaAlta=" + fechaAlta + ", codUsuarioAlta=" + codUsuarioAlta + ", fechaMod="
				+ fechaMod + ", codUsuarioMod=" + codUsuarioMod + "]";
	}
	
	public String getNombreCampoConsulta() {
		return nombreCampoConsulta;
	}
	
	public void setNombreCampoConsulta(String nombreCampoConsulta) {
		this.nombreCampoConsulta = nombreCampoConsulta;
	}
	
	public String getNombreCampoResultado() {
		return nombreCampoResultado;
	}
	
	public void setNombreCampoResultado(String nombreCampoResultado) {
		this.nombreCampoResultado = nombreCampoResultado;
	}
	
	public String getNombreConcepto() {
		return nombreConcepto;
	}
	
	public void setNombreConcepto(String nombreConcepto) {
		this.nombreConcepto = nombreConcepto;
	}
	
	public String getNombreLista() {
		return nombreLista;
	}
	
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	
	public String getNombreEstado() {
		return nombreEstado;
	}
	
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
}