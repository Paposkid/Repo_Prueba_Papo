package com.amx.service.business;

import java.util.List;

import com.amx.service.bean.ListaEspecialTO;



public interface ListaEspecialBusiness {

	public void InsertarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception;

	public List<ListaEspecialTO> listarListasEspeciales(ListaEspecialTO listaEspecialTO) throws Exception;

	public ListaEspecialTO obtenerListaEspecialPorCodigo(ListaEspecialTO listaEspecialTO) throws Exception;

	public void ActualizarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception;
}
