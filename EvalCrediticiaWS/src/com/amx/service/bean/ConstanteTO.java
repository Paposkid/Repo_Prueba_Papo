package com.amx.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que expone los valores y datos que hace referencia a las constantes
 * 
 * @author Daniel Ocampo Gutiérrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */
public class ConstanteTO implements Serializable {

	/**
	 * Atributo que identifica un serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que identifica el registro una constante.
	 */
	private String codigo;

	/**
	 * Atributo que identifica el tipo de una constante. A-->Alfanumerico
	 * N-->Numerico
	 */
	private String tipo;

	/**
	 * Atributo que identifica el nombre de una constante.
	 */
	private String nombre;

	/**
	 * Atributo que identifica el valor de una constante.
	 */
	private String valor;

	/**
	 * Atributo que identifica el estado de una constante. 0-->Inactivo
	 * 1-->Activo .
	 */
	private String estado;

	/**
	 * Atributo que identifica la fecha de creación de una constante.
	 */
	private Date fechaA;

	/**
	 * Atributo que identifica el usuario que creó la constante.
	 */
	private int codUsuarioA;

	/**
	 * Atributo que identifica la fecha de modificación de una constante
	 */
	private Date fechaM;

	/**
	 * Atributo que identifica el codigo de usuario del usuario que relaliza la
	 * ultima modificación de una constante.
	 */
	private int codUsuarioM;

	/**
	 * Constructor vacio
	 */
	public ConstanteTO() {

	}

	/**
	 * Método que obtiene el código de una constante.
	 * 
	 * @return codigo.
	 */
	public String getCodigo() {

		return codigo;
	}

	/**
	 * Método que esatablece el código de una constante.
	 * 
	 * @param codigo
	 *            .
	 */
	public void setCodigo(String codigo) {

		this.codigo = codigo;
	}

	/**
	 * Método que obtiene el tipo de una constante
	 * 
	 * @return tipo.
	 */
	public String getTipo() {

		return tipo;
	}

	/**
	 * Método que esatablece el tipo de una constante.
	 * 
	 * @param tipo
	 *            .
	 */
	public void setTipo(String tipo) {

		this.tipo = tipo;
	}

	/**
	 * Método que obtiene el nombre de una constante.
	 * 
	 * @return nombre.
	 */
	public String getNombre() {

		return nombre;
	}

	/**
	 * Método que esatablece el nombre de una constante
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	/**
	 * Método que obtiene el valor de una constante.
	 * 
	 * @return valor.
	 */
	public String getValor() {

		return valor;
	}

	/**
	 * Método que esatablece el valor de una constante.
	 * 
	 * @param valor
	 */
	public void setValor(String valor) {

		this.valor = valor;
	}

	/**
	 * Método que obtiene el estado de una constante.
	 * 
	 * @return estado.
	 */
	public String getEstado() {

		return estado;
	}

	/**
	 * Método que esatablece el estado de una constante.
	 * 
	 * @param estado
	 */
	public void setEstado(String estado) {

		this.estado = estado;
	}

	/**
	 * Método que obtiene la fecha de creacion de una constante.
	 * 
	 * @return fechaA.
	 */
	public Date getFechaA() {

		return fechaA;
	}

	/**
	 * Método que esatablece la fecha de creacion de una constante.
	 * 
	 * @param fechaA
	 *            .
	 */
	public void setFechaA(Date fechaA) {

		this.fechaA = fechaA;
	}

	/**
	 * Método que obtiene el codigo del usuario que creó una constante.
	 * 
	 * @return codUsuarioA.
	 */
	public int getCodUsuarioA() {

		return codUsuarioA;
	}

	/**
	 * Método que esatablece el codigo del usuario que creó una constante.
	 * 
	 * @param codUsuarioA
	 */
	public void setCodUsuarioA(int codUsuarioA) {

		this.codUsuarioA = codUsuarioA;
	}

	/**
	 * Método que obtiene la fecha de la ultima modificación de una constante.
	 * 
	 * @return fechaM.
	 */
	public Date getFechaM() {

		return fechaM;
	}

	/**
	 * Método que esatablece la fecha de la ultima modificación de una
	 * constante.
	 * 
	 * @param fechaM
	 */
	public void setFechaM(Date fechaM) {

		this.fechaM = fechaM;
	}

	/**
	 * Método que obtiene el codigo del usuario que hace la ultima modificación.
	 * de una constante.
	 * 
	 * @return codUsuarioM.
	 */
	public int getCodUsuarioM() {

		return codUsuarioM;
	}

	/**
	 * Método que esatablece el codigo del usuario que hace la ultima
	 * modificación de una constante
	 * 
	 * @param codUsuarioM
	 */
	public void setCodUsuarioM(int codUsuarioM) {

		this.codUsuarioM = codUsuarioM;
	}

	/**
	 * Método que devuelve un String con el contenido del objeto.
	 */
	@Override
	public String toString() {
		return "ConstanteTO [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", valor=" + valor + ", estado=" + estado + ", fechaA=" + fechaA + ", codUsuarioA=" + codUsuarioA
				+ ", fechaM=" + fechaM + ", codUsuarioM=" + codUsuarioM + "]";
	}
}
