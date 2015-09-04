package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que expone los valores y datos que hace referencia a la categoria.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public class CategoriaTO implements Serializable {

	/**
	 * El código representa el serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo único que identifica el registro de una categoria
	 */
	private String codigoCategoria;

	/**
	 * Atributo único que identifica el código en la tabla campo
	 */
	private String codigoCampo;

	/**
	 * Atributo que identifica el tipo de la categoria
	 */
	private String tipoCategoria;

	/**
	 * Atributo que identifica el nombre de la categoria
	 */
	private String nombreCategoria;

	/**
	 * Atributo que identifica la fecha de creación de la categoria
	 */
	private Date fechaAlta;

	/**
	 * Atributo único que identifica el código del usuario que crea la categoria
	 */
	private int codigoUsuarioAlta;

	/**
	 * Atributo que identifica la fecha de la modificacion de la categoria
	 */
	private Date fechaModificacion;

	/**
	 * Atributo que identifica el usuario que esta registrado para accerder a la
	 * categoria
	 */
	private int codigoUsuario;

	/**
	 * Atributo que identifica el límite inferior del dominio de la categoria
	 */
	private String rangoDesde;

	private String tipoDominio;

	public String getTipoDominio() {
		return tipoDominio;
	}

	public void setTipoDominio(String tipoDominio) {
		this.tipoDominio = tipoDominio;
	}

	/**
	 * Atributo que identifica el límite supeiror de dominio de la categoria
	 */
	private String rangoHasta;

	private String tipoRegla;

	private String tipoCampo;

	private String nombreCampo;

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	/**
	 * Método que obtiene desde donde vá el rango de dominio de la categoria
	 * 
	 * @return rangoDesde.
	 */
	public String getRangoDesde() {
		return rangoDesde;
	}

	/**
	 * Método que esatablece desde donde vá el rango de dominio de la categoria
	 * 
	 * @param rangoDesde
	 *            .
	 */
	public void setRangoDesde(String rangoDesde) {
		this.rangoDesde = rangoDesde;
	}

	/**
	 * Método que obtiene hasta donde vá el rango de dominio de la categoria
	 * 
	 * @return rangoHasta.
	 */
	public String getRangoHasta() {
		return rangoHasta;
	}

	/**
	 * Método que esatablece hasta donde va el rango de dominio de la categoria
	 * 
	 * @param rangoDesde
	 *            .
	 */
	public void setRangoHasta(String rangoHasta) {
		this.rangoHasta = rangoHasta;
	}

	/**
	 * Método que obtiene el código en la tabla campo
	 * 
	 * @return codigoCampo.
	 */
	public String getCodigoCampo() {
		return codigoCampo;
	}

	/**
	 * Método que oestablece el codigo en la tabla campo
	 * 
	 * @return codigoCampo.
	 */
	public void setCodigoCampo(String codigoCampo) {
		this.codigoCampo = codigoCampo;
	}

	/**
	 * Método que obtiene el código de la categoria
	 * 
	 * @return codigoCategoria.
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	/**
	 * Método que establece el código de la categoria
	 * 
	 * @return codigoCategoria.
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	/**
	 * constructor que inicializa la clase
	 */
	public CategoriaTO() {

	}

	/**
	 * Método que obtiene el tipo de la categoria
	 * 
	 * @return tipoCategoria.
	 */
	public String getTipoCategoria() {
		return tipoCategoria;
	}

	/**
	 * Método que establece el tipo de la categoria
	 * 
	 * @return tipoCategoria.
	 */
	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	/**
	 * Método que obtiene el nombre de la categoria
	 * 
	 * @return nombreCategoria.
	 */
	public String getNombreCategoria() {
		return nombreCategoria;
	}

	/**
	 * Método que establece el nombre de la categoria
	 * 
	 * @return nombreCategoria.
	 */
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	/**
	 * Método que obtiene la fecha de creacion de la categoria
	 * 
	 * @return fechaAlta.
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Método que establece la fecha de creacion de la categoria
	 * 
	 * @return fechaAlta.
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Método que obtiene el código del usuario que crea la categoria
	 * 
	 * @return codigoUsuarioAlta.
	 */
	public int getCodigoUsuarioAlta() {
		return codigoUsuarioAlta;
	}

	/**
	 * Método que establece el código del usuario que crea la categoria
	 * 
	 * @return codigoUsuarioAlta.
	 */
	public void setCodigoUsuarioAlta(int codigoUsuarioAlta) {
		this.codigoUsuarioAlta = codigoUsuarioAlta;
	}

	/**
	 * Método que obtiene la fecha de modificación de la categoria
	 * 
	 * @return fechaModificacion.
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método que establece la fecha de modificación de la categoria
	 * 
	 * @return fechaModificacion.
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método que obtiene el código del usuario que esta registrado para
	 * accerder a la categoria
	 * 
	 * @return codigoUsuario.
	 */
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * Método que establece el código del usuario que esta registrado para
	 * accerder a la categoria
	 * 
	 * @return codigoUsuario.
	 */
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getTipoRegla() {
		return tipoRegla;
	}

	public void setTipoRegla(String tipoRegla) {
		this.tipoRegla = tipoRegla;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	/**
	 * Método que devuelve un String con el contenido todos los atributos
	 */
	@Override
	public String toString() {
		return "CategoriaTO [codigoCategoria=" + codigoCategoria + ", codigoCampo=" + codigoCampo + ", tipoCategoria=" + tipoCategoria + ", nombreCategoria=" + nombreCategoria + ", fechaAlta="
				+ fechaAlta + ", codigoUsuarioAlta=" + codigoUsuarioAlta + ", fechaModificacion=" + fechaModificacion + ", codigoUsuario=" + codigoUsuario + ", rangoDesde=" + rangoDesde
				+ ", rangoHasta=" + rangoHasta + "]";
	}
}