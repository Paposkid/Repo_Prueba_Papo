package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ListaEspecialTO;
import com.amx.service.dao.ListaEspecialDAO;


//Maestro Lista Especial
@Service
public class ListaEspecialBusinessImpl implements ListaEspecialBusiness {

	private static Logger logger = Logger.getLogger(ListaEspecialBusinessImpl.class);

	@Autowired
	ListaEspecialDAO listaEspecialDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<ListaEspecialTO> listarListasEspeciales(ListaEspecialTO listaEspecialTO) throws Exception {

		Map<String, Object> mapListasEspeciales = new HashMap<String, Object>();
		List<ListaEspecialTO> listListasEpeiales = null;
		
		try {
			mapListasEspeciales.put("nombreListaEspecial", listaEspecialTO.getNombreListaEspecial());
			mapListasEspeciales.put("valorConcepto", listaEspecialTO.getValorConcepto());
			mapListasEspeciales.put("tipoLista", listaEspecialTO.getTipoLista());
			mapListasEspeciales.put("campoConsulta", listaEspecialTO.getCampoConsulta());
			mapListasEspeciales.put("campoResultado", listaEspecialTO.getCampoResultado());
			mapListasEspeciales.put("valorDefecto", listaEspecialTO.getValorDefecto());
			mapListasEspeciales.put("stado", listaEspecialTO.getStado());
			listaEspecialDao.listarListasEspeciales(mapListasEspeciales);
			listListasEpeiales = (List<ListaEspecialTO>) mapListasEspeciales.get("resultados");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listListasEpeiales;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ListaEspecialTO obtenerListaEspecialPorCodigo(ListaEspecialTO listaEspecialTO) throws Exception {

		ListaEspecialTO miListaEspecialTO = null;
		List<ListaEspecialTO> listListasEspeciales = null;
		Map<String, Object> mapListasESpeciales = new HashMap<String, Object>();
		try {

			mapListasESpeciales.put("nombreListaEspecial", listaEspecialTO.getNombreListaEspecial());
			listaEspecialDao.obtenerListaEspecialPorCodigo(mapListasESpeciales);
			listListasEspeciales = (List<ListaEspecialTO>) mapListasESpeciales.get("resultados");
			miListaEspecialTO = listListasEspeciales.get(0);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return miListaEspecialTO;
	}

	@Override
	public void InsertarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception {

		try {

			listaEspecialDao.insertarListaEspecial(listaEspecialTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void ActualizarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception {

		try {

			listaEspecialDao.actualizarListaEspecial(listaEspecialTO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
