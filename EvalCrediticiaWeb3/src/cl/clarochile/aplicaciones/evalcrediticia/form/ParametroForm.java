package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;

import cl.clarochile.aplicaciones.evalcrediticia.to.ParametroTO;

public class ParametroForm {

	/**
	 * Atributo que servira para filtrar los parametross.
	 */
	private ParametroTO parametroTO;
	/**
	 * Atributo que servira para ingresar y editar los parametross.
	 */
	private ParametroTO parametroDetalleTO;

	/**
	 * Atributo en el cual se almacenan los resultados de las busquedas en la
	 * base de datos.
	 */
	private ArrayList<ParametroTO> resultados;

	/**
	 * Método donde se obtiene el valor para filtrar los parametros.
	 * 
	 * @return parametroDetalleTO.
	 */
	public ParametroTO getParametroTO() {
		if (parametroTO == null) {
			parametroTO = new ParametroTO();
		}
		return parametroTO;
	}

	/**
	 * Método donde se establece el valor para filtrar los parametros.
	 * 
	 * @param parametroDetalleTO
	 *            .
	 */
	public void setParametroTO(ParametroTO parametroTO) {
		this.parametroTO = parametroTO;

	}

	/**
	 * Método donde se obtiene el detalle de un parametro.
	 * 
	 * @return parametroTO.
	 */
	public ParametroTO getParametroDetalleTO() {
		if (parametroDetalleTO == null) {
			parametroDetalleTO = new ParametroTO();
		}
		return parametroDetalleTO;
	}

	/**
	 * Método donde se establece el detalle de un parametro.
	 * 
	 * @param parametroTO
	 *            .
	 */
	public void setParametroDetalleTO(ParametroTO parametroDetalleTO) {
		this.parametroDetalleTO = parametroDetalleTO;
	}

	/**
	 * Método donde se obtiene el valor de la lista de resulados de la busqueda.
	 * 
	 * @return resultados.
	 */
	public ArrayList<ParametroTO> getResultados() {
		if (resultados == null) {
			resultados = new ArrayList<ParametroTO>();
		}
		return resultados;
	}

	/**
	 * Método donde se establece el valor de todos los resultados de la
	 * busqueda.
	 * 
	 */
	public void setResultados(ArrayList<ParametroTO> resultados) {
		this.resultados = resultados;
	}

}
