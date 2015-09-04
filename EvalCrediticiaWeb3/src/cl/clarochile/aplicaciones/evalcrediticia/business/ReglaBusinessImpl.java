package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cl.clarochile.aplicaciones.evalcrediticia.dao.ReglaDAO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ReglaTO;

@Component
public class ReglaBusinessImpl implements ReglaBusiness {

	@Autowired
	ReglaDAO reglaDAO;

	@Override
	public void insertarRegla(ReglaTO reglaTO) throws Exception {
		try {
			reglaDAO.insertarRegla(reglaTO);
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReglaTO> buscarRegla(ReglaTO reglaTO) throws Exception {
		Map<String, Object> mapReglas = new HashMap<String, Object>();
		List<ReglaTO> listaReglas = null;

		try {
			mapReglas.put("condicion", reglaTO.getCodigo());
			mapReglas.put("tipoRegla", reglaTO.getTipoRegla());
			mapReglas.put("tipoEvaluacion", reglaTO.getTipoEvaluacion());
			mapReglas.put("estado", reglaTO.getEstado());
			mapReglas.put("fechaVigenciaDesde", reglaTO.getFechaVigenciaDesde());
			mapReglas.put("fechaVigenciaHasta", reglaTO.getFechaVigenciaHasta());
			reglaDAO.listarRegla(mapReglas);
			listaReglas = (List<ReglaTO>) mapReglas.get("resultados");
		} catch (Exception e) {
			throw e;
		}

		return listaReglas;
	}

	@Override
	public void actualizarRegla(ReglaTO reglaTO) throws Exception {
		try {
			reglaDAO.actualizarRegla(reglaTO);
		} catch (Exception e) {
			throw e;
		}
	}

}