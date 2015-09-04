package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import cl.clarochile.aplicaciones.evalcrediticia.to.ReglaTO;

public interface ReglaBusiness {

	public void insertarRegla(ReglaTO reglaTO) throws Exception;

	public List<ReglaTO> buscarRegla(ReglaTO reglaTO) throws Exception;

	public void actualizarRegla(ReglaTO reglaTO) throws Exception;
}
