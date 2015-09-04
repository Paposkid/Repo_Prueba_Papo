package cl.clarochile.aplicaciones.evalcrediticia.dao;

import java.util.Map;

import cl.clarochile.aplicaciones.evalcrediticia.to.ReglaTO;

public interface ReglaDAO {

	public void listarRegla(Map<String, Object> reglaTO);

	public void insertarRegla(ReglaTO reglaTO);

	public void actualizarRegla(ReglaTO reglaTO);
}
