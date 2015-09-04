package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import cl.clarochile.aplicaciones.evalcrediticia.form.ListaEspecialForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ListaEspecialTO;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface ListaEspecialBusiness {

	public void InsertarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception;

	public List<ListaEspecialTO> listarListasEspeciales(ListaEspecialTO listaEspecialTO) throws Exception;

	public ListaEspecialTO obtenerListaEspecialPorCodigo(ListaEspecialTO listaEspecialTO) throws Exception;

	public void ActualizarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception;

	public HSSFWorkbook generarReporte(ListaEspecialForm listaEspecialForm) throws Exception;
}
