package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;

import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.TipoReglaTO;

/**
 * CampoForm es una clase que controla los valores y datos referentes a los
 * campos en el formulario
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
public class CampoForm {

	/**
	 * campoTO es un atributo que realiza consulta del CRUD
	 */
	private CampoTO campoTO;

	/**
	 * campoDetalleTO es un atributo que realiza el ingreso del CRUD
	 */
	private CampoTO campoDetalleTO;

	/**
	 * resultados es un atributo que realiza el listado de objetos CampoTO
	 */
	private ArrayList<CampoTO> resultados;

	/**
	 * resultados es un atributo que realiza el listado de objetos para cargar
	 * lista tipo reglas
	 */
	private ArrayList<TipoReglaTO> lista;

	public CampoTO getCampoTO() {
		if (campoTO == null) {
			campoTO = new CampoTO();
		}
		return campoTO;
	}

	public void setCampoTO(CampoTO campoTO) {
		this.campoTO = campoTO;
	}

	public CampoTO getCampoDetalleTO() {
		if (campoDetalleTO == null) {
			campoDetalleTO = new CampoTO();
		}
		return campoDetalleTO;
	}

	public void setCampoDetalleTO(CampoTO campoDetalleTO) {
		this.campoDetalleTO = campoDetalleTO;
	}

	public ArrayList<CampoTO> getResultados() {
		if (resultados == null) {
			resultados = new ArrayList<CampoTO>();
		}
		return resultados;
	}

	public void setResultados(ArrayList<CampoTO> resultados) {
		this.resultados = resultados;
	}

	public ArrayList<TipoReglaTO> getLista() {
		if (lista == null) {
			lista = new ArrayList<TipoReglaTO>();
		}
		return lista;
	}

	public void setLista(ArrayList<TipoReglaTO> lista) {
		this.lista = lista;
	}
}
