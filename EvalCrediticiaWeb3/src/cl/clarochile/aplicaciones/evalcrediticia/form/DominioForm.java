package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;

import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;

/**
 * DominioForm es una clase donde se encuentran los diferentes objetos, para
 * realizar la administración de los Dominios, esta clase es usada para setiar
 * los datos que se recuperaron de la base de datos a los formularios (jsp)
 * 
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */
public class DominioForm {

	/**
	 * El objeto DominioTO donde nos ayuda a conectar el bussines con el
	 * controller y devuelve un objeto en particular de la DB
	 */
	private DominioTO dominioTO;

	/**
	 * El objeto dominioDetalleTO donde nos ayuda a conectar el bussines con el
	 * controller y devuelve un objeto en particular de la DB para el ingreso de
	 * un nuevo dominio
	 */
	private DominioTO dominioDetalleTO;

	/**
	 * La lista resultados contiene objetos del tipo DominioTO, donde nos ayuda
	 * a conectar el bussines con el controller y devuelve una lista de este
	 * tipo
	 */
	private ArrayList<DominioTO> resultados;

	public DominioTO getDominioTO() {
		if (dominioTO == null) {
			dominioTO = new DominioTO();
		}
		return dominioTO;
	}

	public void setDominioTO(DominioTO dominioTO) {
		this.dominioTO = dominioTO;
	}

	public DominioTO getDominioDetalleTO() {
		if (dominioDetalleTO == null) {
			dominioDetalleTO = new DominioTO();
		}
		return dominioDetalleTO;
	}

	public void setDominioDetalleTO(DominioTO dominioDetalleTO) {
		this.dominioDetalleTO = dominioDetalleTO;
	}

	public ArrayList<DominioTO> getResultados() {
		if (resultados == null) {
			resultados = new ArrayList<DominioTO>();
		}
		return resultados;
	}

	public void setResultados(ArrayList<DominioTO> resultados) {
		this.resultados = resultados;
	}
}
