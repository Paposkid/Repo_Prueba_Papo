package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.clarochile.aplicaciones.evalcrediticia.dao.TipoReglaDAO;
import cl.clarochile.aplicaciones.evalcrediticia.to.TipoReglaTO;

@Service
public class TipoReglaBusinessImpl implements TipoReglaBusiness {

	@Autowired
	TipoReglaDAO tipoReglaDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoReglaTO> listarTipoReglas(TipoReglaTO tipoRegla) throws Exception {

		Map<String, Object> mapTipoRegla = new HashMap<String, Object>();
		List<TipoReglaTO> listaTipoReglas = null;

		try {
			mapTipoRegla.put("codigo", tipoRegla.getCodigo());
			mapTipoRegla.put("nombre", tipoRegla.getNombre());
			tipoReglaDAO.listarTiposReglas(mapTipoRegla);
			listaTipoReglas = (List<TipoReglaTO>) mapTipoRegla.get("resultados");
		} catch (Exception e) {
			throw e;
		}

		return listaTipoReglas;
	}
}
