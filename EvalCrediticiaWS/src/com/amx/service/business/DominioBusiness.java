package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.DominioTO;



/**
 * DominioBussinessImpl es una clase donde se encuentran los diferentes metodos,
 * para realizar la administracion de los Dominios, con estos metodos nos
 * comunicamos con el dao para recibir informacion de el mapeo que hace a la DB.
 * 
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */
public interface DominioBusiness {

	/**
	 * Método que permite insertar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 */
	public void insertarDominio(DominioTO dominioTO) throws Exception;

	/**
	 * Método que permite actualizar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 */
	public void actualizarDominio(DominioTO dominioTO) throws Exception;

	/**
	 * Método que permite listar un dominio por medio del DAO y guardarlo en la
	 * DB
	 * 
	 * @return List<DominioTO>
	 * @throws Exception
	 */
	public List<DominioTO> listarDominio() throws Exception;

	/**
	 * Método que permite obtener un dominio por codigo por medio del DAO y
	 * guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return DominioTO
	 * @throws Exception
	 */
	public DominioTO obtenerDominioPorCodigo(DominioTO dominioTO) throws Exception;

	/**
	 * Método que permite buscar un dominio por varios campos por medio del DAO
	 * y guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return List<DominioTO>
	 * @throws Exception
	 */
	public List<DominioTO> buscarDominioPorCampos(DominioTO dominioTO) throws Exception;

	/**
	 * Método que permite obtener un dominio por codigo por medio del DAO y
	 * guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return DominioTO
	 * @throws Exception
	 */
	public DominioTO obtenerDominioPorNombre(DominioTO dominioTO) throws Exception;

}
