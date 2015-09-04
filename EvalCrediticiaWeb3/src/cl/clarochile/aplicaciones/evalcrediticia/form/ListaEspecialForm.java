package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;

import cl.claro.actualList.ConceptoType;
import cl.claro.actualList.ListasType;
import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ListaEspecialTO;

/**
 * ConfiguracionLineaServicioForm es una clase donde se encuentran los
 * diferentes objetos, para realizar la configuracion línea de servicio, esta
 * clase es usada para setiar los datos que se recuperaron de la base de datos a
 * los formularios (jsp)
 * 
 * @author Christian Camilo Hincapié Monsalve christian.hincapiemonsalve@tcs.com
 * @since 18/03/2013
 * @version 1.0
 */

public class ListaEspecialForm {

	/**
	 * Atributo que servirá para filtrar las listas especiales
	 */
	private ListaEspecialTO listaEspecialTO;

	/**
	 * Atributo que servirá para crear y actualizar listas especial
	 */
	private ListaEspecialTO listaEspecialDetalleTO;

	/**
	 * Atributo que que identifica una lista de las listas especiales
	 */
	private ArrayList<ListaEspecialTO> resultados;
	
	private ArrayList<ConceptoType> comboConcepto;
	
	private ArrayList<ListasType> comboLista;
	
	private ArrayList<CampoTO> comboConsulta;
	
	private ArrayList<CampoTO> comboResultado;

	/**
	 * Método donde se obtiene una lista especial
	 * 
	 * @return listaEspecialTO.
	 */
	public ListaEspecialTO getListaEspecialTO() {

		if (listaEspecialTO == null) {

			listaEspecialTO = new ListaEspecialTO();
		}
		return listaEspecialTO;
	}

	/**
	 * Método donde se establece una lista especial
	 * 
	 * @param listaEspecialTO
	 *            .
	 */
	public void setListaEspecialTO(ListaEspecialTO listaEspecialTO) {
		this.listaEspecialTO = listaEspecialTO;
	}

	/**
	 * Método donde se obtiene el dettalle de una lista especial
	 * 
	 * @return getListaEspecialDetalleTO.
	 */
	public ListaEspecialTO getListaEspecialDetalleTO() {

		if (listaEspecialDetalleTO == null) {

			listaEspecialDetalleTO = new ListaEspecialTO();
		}
		return listaEspecialDetalleTO;
	}

	/**
	 * Método donde se establece el detalle de una lista especial
	 * 
	 * @param getListaEspecialDetalleTO
	 *            .
	 */
	public void setListaEspecialDetalleTO(ListaEspecialTO listaEspecialDetalleTO) {
		this.listaEspecialDetalleTO = listaEspecialDetalleTO;
	}

	/**
	 * Método donde se obtiene una lista de las listas especiales
	 * 
	 * @return resultados (lista)
	 */
	public ArrayList<ListaEspecialTO> getResultados() {
		if (resultados == null) {

			resultados = new ArrayList<ListaEspecialTO>();
		}
		return resultados;
	}

	/**
	 * Método donde se establece una lista de las listas especiales
	 * 
	 * @param resultados
	 */
	public void setResultados(ArrayList<ListaEspecialTO> resultados) {
		this.resultados = resultados;
	}
	
	public ArrayList<ConceptoType> getComboConcepto() {
		if (comboConcepto == null) {
			comboConcepto = new ArrayList<ConceptoType>();
		}
		return comboConcepto;
	}
	
	public void setComboConcepto(ArrayList<ConceptoType> comboConcepto) {
		this.comboConcepto = comboConcepto;
	}
	
	public ArrayList<ListasType> getComboLista() {
		if (comboLista == null) {
			comboLista = new ArrayList<ListasType>();
		}
		return comboLista;
	}
	
	public void setComboLista(ArrayList<ListasType> comboLista) {
		this.comboLista = comboLista;
	}
	
	public ArrayList<CampoTO> getComboConsulta() {
		if (comboConsulta == null) {
			comboConsulta = new ArrayList<CampoTO>();
		}
		return comboConsulta;
	}
	
	public void setComboConsulta(ArrayList<CampoTO> comboConsulta) {
		this.comboConsulta = comboConsulta;
	}
	
	public ArrayList<CampoTO> getComboResultado() {
		if (comboResultado == null) {
			comboResultado = new ArrayList<CampoTO>();
		}
		return comboResultado;
	}
	
	public void setComboResultado(ArrayList<CampoTO> comboResultado) {
		this.comboResultado = comboResultado;
	}

}
