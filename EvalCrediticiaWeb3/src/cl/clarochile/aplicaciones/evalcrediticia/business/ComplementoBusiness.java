package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import cl.clarochile.aplicaciones.evalcrediticia.to.ComplementoTO;

public interface ComplementoBusiness {

	public void insertarComplemento(ComplementoTO complementoTO) throws Exception;

	public List<ComplementoTO> buscarComplemento(ComplementoTO complementoTO) throws Exception;

	public void actualizarComplemento(ComplementoTO complementoTO) throws Exception;
}
