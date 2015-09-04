package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que expone los valores y datos que hace referencia al Dominio y
 * Categoria
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public class DominioCategoriaTO implements Serializable {

	/**
	 * El c�digo representa el serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo �nico que identifica el c�digo de la relacion dominio categoria
	 */
	private int codigo;
	/**
	 * Atributo �nico que identifica el c�digo de la relacion dominio
	 */
	private DominioTO dominioTO;
	/**
	 * Atributo �nico que identifica el registro de la relacion categoria
	 */
	private CategoriaTO categoria;
	/**
	 * Atributo �nico que identifica el estado de la relaci�n
	 */
	private String estado;
	/**
	 * Atributo �nico que indica la fecha en que fue asociado el dominio a la
	 * categoria
	 */
	private Date fechaAlta;
	/**
	 * Atributo �nico que indica el usuario que realizo la creaci�n de la
	 * asociacion del dominio a una categoria.
	 */
	private int codUsuarioAlta;
	/**
	 * Atributo �nico que indica la fecha en que fue modificado el dominio a la
	 * categoria
	 */
	private Date fechaModificacion;
	/**
	 * Atributo �nico que indica el usuario que realiz� una modificaci�n al
	 * dominio de una categoria
	 */
	private int codUsuario;

	/**
	 * constructor que inicializa la clase
	 */
	public DominioCategoriaTO() {

	}

	/**
	 * M�todo que obtiene el estado del Dominio
	 * 
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * M�todo que establece el estado del Dominio
	 * 
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * M�todo que obtiene el c�digo del Dominio
	 * 
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * M�todo que establece el codigo del Dominio
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo que obtiene el Dominio
	 * 
	 * @return dominio
	 */
	public DominioTO getDominioTO() {
		if (dominioTO == null) {
			dominioTO = new DominioTO();
		}
		return dominioTO;
	}

	/**
	 * M�todo que establece el dominio
	 * 
	 * @param dominio
	 */
	public void setDominioTO(DominioTO dominioTO) {
		this.dominioTO = dominioTO;
	}

	/**
	 * Metodo que obtiene la categoria
	 * 
	 * @return categoria
	 */
	public CategoriaTO getCategoria() {
		if (categoria == null) {
			categoria = new CategoriaTO();
		}
		return categoria;
	}

	/**
	 * M�tdodo que establece la categoria
	 * 
	 * @param categoria
	 */
	public void setCategoria(CategoriaTO categoria) {
		this.categoria = categoria;
	}

	/**
	 * M�tdodo que obtiene el c�digo de usuario de creaci�n
	 * 
	 * @return
	 */
	public int getCodUsuarioAlta() {
		return codUsuarioAlta;
	}

	/**
	 * Metodo que establece el c�digo de creaci�n
	 * 
	 * @param codUsuarioAlta
	 */
	public void setCodUsuarioAlta(int codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}

	/**
	 * M�tdodo que obtiene la fecha de la asociacion del dominio a la categoria
	 * 
	 * @return
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * M�tdodo que establece la fecha de la asociacion del dominio a la
	 * categoria
	 * 
	 * @param fechaAlta
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * M�todo que obtiene el c�digo del usuario que est� registrado para
	 * accerder al mantenedor
	 * 
	 * @return
	 */
	public int getcodUsuarioAlta() {
		return codUsuarioAlta;
	}

	/**
	 * Metodo que establece el c�digo del usuario que est� registrado para
	 * accerder al mantenedor
	 * 
	 * @param codUsuarioAlta
	 */
	public void setcodUsuarioAlta(int codUsuarioAlta) {
		this.codUsuarioAlta = codUsuarioAlta;
	}

	/**
	 * M�todo que obtiene la fecha de modificaion de un dominio respecto a una
	 * cetegoria
	 * 
	 * @return
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * M�todo que establece la fecha de modificaion de un dominio respecto a una
	 * cetegoria
	 * 
	 * @param fechaModificacion
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * M�todo que obtiene el codigo de usuario
	 * 
	 * @return
	 */
	public int getCodUsuario() {
		return codUsuario;
	}

	/**
	 * M�todo que establece el codigo de usuario
	 * 
	 * @param codUsuario
	 */
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	/**
	 * M�todo que devuelve un String con el contenido todos los atributos
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DominioCategoriaTO [codigo=" + codigo + ", dominioTO=" + dominioTO + ", categoria=" + categoria + ", estado=" + estado + ", fechaAlta=" + fechaAlta + ", codUsuarioAlta=" + codUsuarioAlta
				+ ", fechaModificacion=" + fechaModificacion + ", codUsuario=" + codUsuario + "]";
	}
}
