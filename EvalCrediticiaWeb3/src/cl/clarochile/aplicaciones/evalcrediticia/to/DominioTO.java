package cl.clarochile.aplicaciones.evalcrediticia.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Data transfer object para la entidad <code> DominioTO </code>
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */
public class DominioTO implements Serializable {

	/**
	 * el codigo representa el serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * El codigo representa el dominio, expresado en numero.
	 */
	private int codigo;

	/**
	 * El nombre del dominio, valor esperado.
	 */
	private String nombre;

	/**
	 * El tipo de caracter determina msi es alguno de los dos valores. Solamente
	 * se admiten los valores:
	 * <UL>
	 * <LI>"Alfanumérico"
	 * <LI>"Numérico"
	 * </UL>
	 */

	private String tipoDato;

	/**
	 * El tipo de dato determina si es alguno de los dos valores. Solamente se
	 * admiten los valores:
	 * <UL>
	 * <LI>"Entrada"
	 * <LI>"Salida"
	 * </UL>
	 */
	private String tipoCampo;

	/**
	 * El valor que toma el dominio, valor esperado.
	 */
	private String valor;

	/**
	 * El estado determina si es alguno de los dos valores. Solamente se admiten
	 * los valores:
	 * <UL>
	 * <LI>"Activo"
	 * <LI>"Inactivo"
	 * </UL>
	 */
	private String estado;

	/**
	 * La fecha de creación, determina la fecha de la primera creacion del
	 * domino
	 */
	private Date fechaCreacion;

	/**
	 * El usuario de creación, determina el usuarioque creo el dominio por
	 * primera vez.
	 */
	private String usuarioCreacion;

	/**
	 * La fecha de modificación, determina la fecha de la modificación mas
	 * actual del domino
	 */
	private Date fechaModificacion;

	/**
	 * El usuario de modificacion, determina el usuario que moficó el dominio
	 * por ultima vez.
	 */
	private String usuarioModificacion;
	private String nombreTipoCaracter;

	
	public DominioTO() {

	}
	
	public DominioTO (int id) {
		this.codigo = id;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipoDato() {
		return tipoDato;
	}


	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}


	public String getTipoCampo() {
		return tipoCampo;
	}


	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}


	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
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


	public String getNombreTipoCaracter() {
		return nombreTipoCaracter;
	}


	public void setNombreTipoCaracter(String nombreTipoCaracter) {
		this.nombreTipoCaracter = nombreTipoCaracter;
	}


	@Override
	public String toString() {
		return "DominioTO [codigo=" + codigo + ", nombre=" + nombre
				+ ", tipoDato=" + tipoDato + ", tipoCampo=" + tipoCampo
				+ ", valor=" + valor + ", estado=" + estado
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion="
				+ usuarioCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", usuarioModificacion=" + usuarioModificacion
				+ ", nombreTipoCaracter=" + nombreTipoCaracter + "]";
	}
	
	
}