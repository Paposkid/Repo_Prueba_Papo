package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;

import cl.clarochile.aplicaciones.evalcrediticia.to.ComplementoTO;

public interface ComplementoDAO {

	public void listarComplemento(Map<String, Object> complementoTO);

	public void insertarComplemento(ComplementoTO complementoTO);

	public void actualizarComplemento(ComplementoTO complementoTO);
}
