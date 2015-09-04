package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;

import cl.clarochile.aplicaciones.evalcrediticia.to.ListaEspecialTO;

public interface ListaEspecialDAO {

	public void insertarListaEspecial(ListaEspecialTO listaEspecialTO);

	public void listarListasEspeciales(Map<String, Object> listaEspecialTO);

	public void actualizarListaEspecial(ListaEspecialTO listaEspecialTO);

	public void obtenerListaEspecialPorCodigo(Map<String, Object> mapListaEspecialTO);
}
