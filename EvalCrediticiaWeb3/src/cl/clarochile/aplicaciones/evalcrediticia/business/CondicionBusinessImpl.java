package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cl.clarochile.aplicaciones.evalcrediticia.dao.CondicionDAO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CondicionTO;

@Component
public class CondicionBusinessImpl implements CondicionBusiness {

	@Autowired
	CondicionDAO condicionDAO;

	@Override
	public void insertarCondiciones(CondicionTO condicionTO) throws Exception {
		try {
			condicionDAO.insertarCondicion(condicionTO);
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CondicionTO> buscarCondiciones(CondicionTO condicionTO) throws Exception {
		Map<String, Object> mapCondiciones = new HashMap<String, Object>();
		List<CondicionTO> listaCondiciones = null;

		try {
			mapCondiciones.put("condicion", condicionTO.getCodigo());
			mapCondiciones.put("regla.codigo", condicionTO.getRegla().getCodigo());
			mapCondiciones.put("campo.codigoCampo", condicionTO.getCampo().getCodigoCampo());
			mapCondiciones.put("constante.codigo", condicionTO.getConstante().getCodigo());
			mapCondiciones.put("dominio.codigo", condicionTO.getDominio().getCodigo());
			mapCondiciones.put("categoria.codigoCategoria", condicionTO.getCategoria().getCodigoCategoria());
			condicionDAO.listarCondicion(mapCondiciones);
			listaCondiciones = (List<CondicionTO>) mapCondiciones.get("resultados");
		} catch (Exception e) {
			throw e;
		}

		return listaCondiciones;
	}

	@Override
	public void actualizarCondiciones(CondicionTO condicionTO) throws Exception {
		try {
			condicionDAO.actualizarCondicion(condicionTO);
		} catch (Exception e) {
			throw e;
		}
	}
}
