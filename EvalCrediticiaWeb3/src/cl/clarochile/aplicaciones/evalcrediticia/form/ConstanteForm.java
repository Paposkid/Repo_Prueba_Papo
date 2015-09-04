package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;
/**
 * Clase que expone los valores y datos que hace referencia a las constantes
 * @author Daniel Ocampo Gutiérrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */

import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;

public class ConstanteForm {

	/**
	 * Atributo que servirá para realizar el CRUD.
	 */
	private ConstanteTO constanteTO;

	/**
	 * Atributo que servira para filtrar las constantes.
	 */
	private ConstanteTO constanteDetalleTO;

	/**
	 * Atributo en el cual se almacenan los resultados de las busquedas en la
	 * base de datos.
	 */
	private ArrayList<ConstanteTO> resultados;

	/**
	 * Método donde se obtiene el detalle de una constante.
	 * 
	 * @return constanteTO.
	 */
	public ConstanteTO getConstanteTO() {

		if (constanteTO == null) {

			constanteTO = new ConstanteTO();
		}
		return constanteTO;
	}

	/**
	 * Método donde se establece el detalle de las constantes.
	 * 
	 * @param constanteTO
	 *            .
	 */
	public void setConstanteTO(ConstanteTO constanteTO) {

		this.constanteTO = constanteTO;

	}

	/**
	 * Método donde se obtiene el valor para filtrar las constantes.
	 * 
	 * @return constanteDetalleTO.
	 */
	public ConstanteTO getConstanteDetalleTO() {

		if (constanteDetalleTO == null) {

			constanteDetalleTO = new ConstanteTO();
		}

		return constanteDetalleTO;
	}

	/**
	 * Método donde se establece el valor para filtrar las constantes.
	 * 
	 * @param constanteDetalleTO
	 *            .
	 */
	public void setConstanteDetalleTO(ConstanteTO constanteDetalleTO) {

		this.constanteDetalleTO = constanteDetalleTO;
	}

	/**
	 * Método donde se obtiene el valor de todas las constantes
	 * 
	 * @return resultados.
	 */
	public ArrayList<ConstanteTO> getResultados() {

		if (resultados == null) {

			resultados = new ArrayList<ConstanteTO>();
		}
		return resultados;
	}

	/**
	 * Método donde se obtiene el valor de todos las constantes
	 * 
	 * @return resultados.
	 */
	public void setResultados(ArrayList<ConstanteTO> resultados) {

		this.resultados = resultados;
	}

}
