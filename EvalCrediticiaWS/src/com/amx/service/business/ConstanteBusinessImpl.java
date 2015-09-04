package com.amx.service.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.ConstanteTO;
import com.amx.service.dao.ConstanteDAO;



/**
 * Clase donde implementa la interfaz ConstanteBusinessImpl y utiliza los
 * métodos para comunicarse con ConstanteDao para la comunicacion de la base de
 * datos.
 * 
 * @author Daniel Ocampo Gutiérrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */
@Service
public class ConstanteBusinessImpl implements ConstanteBusiness {

	@Autowired
	ConstanteDAO constanteDao;

	/**
	 * Método sobre escrito por la interfaz "ConstanteBusiness" donde inserta
	 * los registros de una constante atravez del metodo insertar del DAO.
	 * 
	 * @param constanteTO
	 * @throws Exception
	 */
	@Override
	public void insertarConstante(ConstanteTO constanteTO) throws Exception {

		try {

			constanteDao.insertarConstante(constanteTO);
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Método sobre escrito por la interfaz "ConstanteBusiness" donde actualiza
	 * el registro de una constante.
	 * 
	 * @param constanteTO
	 * @throws Exception
	 */
	@Override
	public void actualizarConstante(ConstanteTO constanteTO) throws Exception {

		try {

			constanteDao.actualizarConstante(constanteTO);
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Método sobre escrito por la interfaz "ConstanteBusiness" donde filtra
	 * todos los registros de una constante,ya sea por el tipo, nombre, valor, o
	 * estado.
	 * 
	 * @param constanteTO
	 * @return lstConstanteTO
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ConstanteTO> listarConstantes(ConstanteTO constanteTO) throws Exception {

		Map<String, Object> mapConstantes = new HashMap<String, Object>();
		List<ConstanteTO> listaConstantes = null;

		try {

			mapConstantes.put("codigo", constanteTO.getCodigo());
			mapConstantes.put("tipo", constanteTO.getTipo());
			mapConstantes.put("nombre", constanteTO.getNombre());
			mapConstantes.put("valor", constanteTO.getValor());
			mapConstantes.put("estado", constanteTO.getEstado());
			constanteDao.listarConstantes(mapConstantes);
			listaConstantes = (List<ConstanteTO>) mapConstantes.get("resultados");
		} catch (Exception e) {

			throw e;
		}

		return listaConstantes;
	}

	/**
	 * Método sobre escrito por la interfaz "ConstanteBusiness" donde se
	 * obtendrá una constante referenciada por el id que representa el registro
	 * 
	 * @param ConstanteTO
	 * @return miConstanteTO
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ConstanteTO obtenerConstantePorCodigo(ConstanteTO constanteTO) throws Exception {

		ConstanteTO miConstanteTO = null;
		List<ConstanteTO> listaConstantes = null;
		Map<String, Object> mapConstantes = new HashMap<String, Object>();

		try {

			mapConstantes.put("codigo", constanteTO.getCodigo());
			constanteDao.buscarConstantePorCodigo(mapConstantes);
			listaConstantes = (List<ConstanteTO>) mapConstantes.get("resultados");
			miConstanteTO = listaConstantes.get(0);

		} catch (Exception e) {

			throw e;
		}

		return miConstanteTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConstanteTO obtenerConstantePorNombre(ConstanteTO constanteTO) throws Exception {
		ConstanteTO miConstanteTO = null;
		List<ConstanteTO> listaConstantes = null;
		Map<String, Object> mapConstantes = new HashMap<String, Object>();

		try {

			mapConstantes.put("nombre", constanteTO.getNombre());
			constanteDao.buscarConstantePorNombre(mapConstantes);
			listaConstantes = (List<ConstanteTO>) mapConstantes.get("resultados");
			miConstanteTO = listaConstantes.get(0);

		} catch (Exception e) {

			throw e;
		}

		return miConstanteTO;
	}
}
