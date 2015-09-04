package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amx.service.bean.ComplementoTO;
import com.amx.service.dao.ComplementoDAO;



@Component
public class ComplementoBusinessImpl implements ComplementoBusiness {

	@Autowired
	ComplementoDAO complementoDAO;
	
	@Override
	public void insertarComplemento(ComplementoTO complementoTO) throws Exception {
		try{
			complementoDAO.insertarComplemento(complementoTO);
		}catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComplementoTO> buscarComplemento(ComplementoTO complementoTO) throws Exception {
		Map<String, Object> mapComplementos = new HashMap<String, Object>();
		List<ComplementoTO> listaComplementos = null;

		try {
			mapComplementos.put("condicion", complementoTO.getCodigo());
			mapComplementos.put("condicion.codigo", complementoTO.getCondicion().getCodigo());
			mapComplementos.put("dominio.codigo", complementoTO.getDominio().getCodigo());
			mapComplementos.put("constante.codigo", complementoTO.getConstante().getCodigo());
			complementoDAO.listarComplemento(mapComplementos);
			listaComplementos = (List<ComplementoTO>) mapComplementos.get("resultados");
		} catch (Exception e) {
			throw e;
		}

		return listaComplementos;
	}

	@Override
	public void actualizarComplemento(ComplementoTO complementoTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
