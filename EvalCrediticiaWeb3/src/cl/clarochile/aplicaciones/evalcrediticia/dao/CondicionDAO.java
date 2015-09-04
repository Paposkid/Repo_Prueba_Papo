package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;

import cl.clarochile.aplicaciones.evalcrediticia.to.CondicionTO;

public interface CondicionDAO {

	public void listarCondicion(Map<String, Object> condicionTO);

	public void insertarCondicion(CondicionTO condicionTO);

	public void actualizarCondicion(CondicionTO condicionTO);

}
