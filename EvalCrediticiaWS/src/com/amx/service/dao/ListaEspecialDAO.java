package com.amx.service.dao;

import java.util.Map;

import com.amx.service.bean.ListaEspecialTO;



public interface ListaEspecialDAO {

	public void insertarListaEspecial(ListaEspecialTO listaEspecialTO);

	public void listarListasEspeciales(Map<String, Object> listaEspecialTO);

	public void actualizarListaEspecial(ListaEspecialTO listaEspecialTO);

	public void obtenerListaEspecialPorCodigo(Map<String, Object> mapListaEspecialTO);
}
