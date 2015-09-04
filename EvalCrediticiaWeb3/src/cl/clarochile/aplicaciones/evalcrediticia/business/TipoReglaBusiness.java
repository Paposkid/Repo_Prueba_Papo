package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import cl.clarochile.aplicaciones.evalcrediticia.to.TipoReglaTO;

public interface TipoReglaBusiness {

	public List<TipoReglaTO> listarTipoReglas(TipoReglaTO tipoRegla) throws Exception;
}
