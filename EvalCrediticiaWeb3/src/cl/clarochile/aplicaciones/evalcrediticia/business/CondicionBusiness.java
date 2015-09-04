package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import cl.clarochile.aplicaciones.evalcrediticia.to.CondicionTO;

public interface CondicionBusiness {

	public void insertarCondiciones(CondicionTO condicionTO) throws Exception;

	public List<CondicionTO> buscarCondiciones(CondicionTO condicionTO) throws Exception;

	public void actualizarCondiciones(CondicionTO condicionTO) throws Exception;
}
