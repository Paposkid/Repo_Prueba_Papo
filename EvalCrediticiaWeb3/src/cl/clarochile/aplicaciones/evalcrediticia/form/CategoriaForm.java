package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;

import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioCategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;

/**
 * Clase dónde se encapsula toda la información que esta contenida en el
 * formulario.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */

public class CategoriaForm {

	/**
	 * Atributo que servirá para realizar el crear, modificar.
	 */
	private CategoriaTO categoriaTO;

	/**
	 * Atributo que servirá para filtrar el detalle de todas las categorias
	 */
	private CategoriaTO categoriaDetalleTO;

	/**
	 * Atributo que servirá realizar el crear, modificar, eliminar(lógico)
	 * deacuerdo al dominio
	 */
	private DominioTO dominioTO;

	/**
	 * Atributo que servirá realizar el crear, modificar, eliminar(lógico)
	 * deacuerdo al dominioCategoria
	 */
	private DominioCategoriaTO dominioCategoriaTO;

	/**
	 * Atributo que servirá obtener una lista de las categorias
	 */
	private ArrayList<CategoriaTO> resultados;

	/**
	 * Atributo que servirá obtener una lista de dominios asociados a una
	 * categoria
	 */
	private ArrayList<DominioCategoriaTO> resultadosDomCat;

	private ArrayList<CampoTO> listaComboCampo;

	private ArrayList<DominioTO> listaComboDominio;

	private int cambioPantalla;

	private String tipo;

	ArrayList<String> dominios;

	/**
	 * Método dónde se obtiene la categoria
	 * 
	 * @return categoriaTO.
	 */
	public CategoriaTO getCategoriaTO() {
		if (categoriaTO == null) {
			categoriaTO = new CategoriaTO();
		}
		return categoriaTO;
	}

	/**
	 * Método dónde se establece la categoria
	 * 
	 * @param categoriaTO
	 *            .
	 */
	public void setCategoriaTO(CategoriaTO categoriaTO) {
		this.categoriaTO = categoriaTO;
	}

	/**
	 * Método dónde se obtiene el detalle de la categoria
	 * 
	 * @return categoriaDetalleTO.
	 */
	public CategoriaTO getCategoriaDetalleTO() {
		if (categoriaDetalleTO == null) {
			categoriaDetalleTO = new CategoriaTO();
		}
		return categoriaDetalleTO;
	}

	/**
	 * Método dónde se establece el detalle de la categoria
	 * 
	 * @param categoriaDetalleTO
	 *            .
	 */
	public void setCategoriaDetalleTO(CategoriaTO categoriaDetalleTO) {
		this.categoriaDetalleTO = categoriaDetalleTO;
	}

	/**
	 * Método dónde se obtiene una lista de las categorias
	 * 
	 * @return resultados (lista).
	 */
	public ArrayList<CategoriaTO> getResultados() {
		if (resultados == null) {
			resultados = new ArrayList<CategoriaTO>();
		}
		return resultados;
	}

	/**
	 * Método donde se establece una lista de las categorias
	 * 
	 * @param resultados
	 *            (lista).
	 */
	public void setResultados(ArrayList<CategoriaTO> resultados) {
		this.resultados = resultados;
	}

	/**
	 * Método donde se obtiene el dominio de la categoria
	 * 
	 * @return dominioTO.
	 */
	public DominioTO getDominioTO() {
		if (dominioTO == null) {
			dominioTO = new DominioTO();
		}
		return dominioTO;
	}

	/**
	 * Método donde se establece el dominio de la categoria
	 * 
	 * @param dominioTO
	 *            .
	 */
	public void setDominioTO(DominioTO dominioTO) {
		this.dominioTO = dominioTO;
	}

	/**
	 * Método donde se obtiene la relacion entre dominio y categoria
	 * 
	 * @return dominioCategoriaTO.
	 */
	public DominioCategoriaTO getDominioCategoriaTO() {
		if (dominioCategoriaTO == null) {
			dominioCategoriaTO = new DominioCategoriaTO();
		}
		return dominioCategoriaTO;
	}

	/**
	 * Método donde se establece la relacion entre dominio y categoria
	 * 
	 * @param dominioCategoriaTO
	 *            .
	 */
	public void setDominioCategoriaTO(DominioCategoriaTO dominioCategoriaTO) {
		this.dominioCategoriaTO = dominioCategoriaTO;
	}

	/**
	 * Método donde se obtiene una lista de las dominio respecto a su categoria.
	 * 
	 * @return resultadosDomCat.
	 */
	public ArrayList<DominioCategoriaTO> getResultadosDomCat() {
		if (resultadosDomCat == null) {
			resultadosDomCat = new ArrayList<DominioCategoriaTO>();
		}
		return resultadosDomCat;
	}

	/**
	 * Método donde se establece una lista de las dominio respecto a su
	 * categoria.
	 * 
	 * @param resultadosDomCat
	 *            .
	 */
	public void setResultadosDomCat(ArrayList<DominioCategoriaTO> resultadosDomCat) {
		this.resultadosDomCat = resultadosDomCat;
	}

	public ArrayList<CampoTO> getListaComboCampo() {
		if (listaComboCampo == null) {
			listaComboCampo = new ArrayList<CampoTO>();
		}
		return listaComboCampo;
	}

	public void setListaComboCampo(ArrayList<CampoTO> listaComboCampo) {
		this.listaComboCampo = listaComboCampo;
	}

	public int getCambioPantalla() {
		return cambioPantalla;
	}

	public void setCambioPantalla(int cambioPantalla) {
		this.cambioPantalla = cambioPantalla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<DominioTO> getListaComboDominio() {
		if (listaComboDominio == null) {
			listaComboDominio = new ArrayList<DominioTO>();
		}
		return listaComboDominio;
	}

	public void setListaComboDominio(ArrayList<DominioTO> listaComboDominio) {
		this.listaComboDominio = listaComboDominio;
	}

	public ArrayList<String> getDominios() {

		if (dominios == null) {
			dominios = new ArrayList<String>();
		}

		return dominios;
	}

	public void setDominios(ArrayList<String> dominios) {
		this.dominios = dominios;
	}
}