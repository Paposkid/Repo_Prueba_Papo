package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.clarochile.aplicaciones.evalcrediticia.dao.ListaEspecialDAO;
import cl.clarochile.aplicaciones.evalcrediticia.form.ListaEspecialForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ListaEspecialTO;

import cl.clarochile.aplicaciones.evalcrediticia.util.Config;
import cl.clarochile.aplicaciones.evalcrediticia.util.Validador;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

@Service
public class ListaEspecialBusinessImpl implements ListaEspecialBusiness {

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
			throw e;
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
			throw e;
		}
		return miListaEspecialTO;
	}

	@Override
	public void InsertarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception {

		try {

			listaEspecialDao.insertarListaEspecial(listaEspecialTO);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void ActualizarListaEspecial(ListaEspecialTO listaEspecialTO) throws Exception {

		try {

			listaEspecialDao.actualizarListaEspecial(listaEspecialTO);
		} catch (Exception e) {

			throw e;
		}
	}

	@Override
	public HSSFWorkbook generarReporte(ListaEspecialForm listaEspecialForm) throws Exception {
		ArrayList<ListaEspecialTO> resultados = (ArrayList<ListaEspecialTO>) listarListasEspeciales(listaEspecialForm.getListaEspecialTO());
		

		HSSFWorkbook libro = null;

		String reemplazo;
		int posicion = 0;
		int cont = 1;
		if (!resultados.isEmpty()) {

			libro = new HSSFWorkbook();

			// Se crea una hoja dentro del libro
			HSSFSheet hoja = libro.createSheet();
			HSSFFont letraNormal = libro.createFont();
			HSSFFont letraNegrita = libro.createFont();
			HSSFFont letraIntermedia = libro.createFont();

			HSSFCellStyle titulo = libro.createCellStyle();// titulo
			HSSFCellStyle encabezados = libro.createCellStyle();// encabezados
			HSSFCellStyle celdas = libro.createCellStyle(); // Celdas
			HSSFCellStyle celdasOscuras = libro.createCellStyle();

			// Configuración del tipo de letra
			letraNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			letraNormal.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			letraNegrita.setFontHeight((short) 300);
			letraIntermedia.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			letraIntermedia.setFontHeight((short) 200);

			// Configuración de las celdas del reporte
			titulo.setFont(letraNegrita);
			titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// Fila Delegado
			encabezados.setFont(letraNormal);
			encabezados.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			encabezados.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			encabezados.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			// Celdas Oscuras
			celdasOscuras.setFont(letraNormal);
			celdasOscuras.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			celdasOscuras.setFillForegroundColor(HSSFColor.CORAL.index);
			celdasOscuras.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			// Celdas Con borde
			celdas.setFont(letraNormal);
			celdas.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
			celdas.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			HSSFRow fila;
			HSSFCell celda;
			CellRangeAddress region;

			try {

				int nrofila = 0;

				int cantColumns = 5;
				fila = hoja.createRow((short) nrofila);
				fila.setHeight((short) 450);
				region = new CellRangeAddress((short) 0, (short) 0, (short) 0, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				celda = fila.createCell((int) 0);
				celda.setCellStyle(titulo);
				HSSFRichTextString texto = new HSSFRichTextString(Config.getProperty("listaEspecial.tituloReporte"));
				celda.setCellValue(texto);
				nrofila += 3;

				fila = hoja.createRow((short) nrofila);

				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getNombreListaEspecial())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.nombreListaEspecialR") + "= " + listaEspecialForm.getListaEspecialTO().getNombreListaEspecial());
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getValorConcepto())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					if (listaEspecialForm.getListaEspecialTO().getValorConcepto().equals("E")) {
						reemplazo = "VLOR_CONCEPTO1";
					} else {
						reemplazo = "VLOR_CONCEPTO2";
					}
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.valorConceptoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getTipoLista())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					if (listaEspecialForm.getListaEspecialTO().getTipoLista().equals("A")) {
						reemplazo = "TIPO_LISTA1";
					} else {
						reemplazo = "TIPO_LISTA2";
					}
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.tipoListaR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getCampoConsulta())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					if (listaEspecialForm.getListaEspecialTO().getCampoConsulta().equals("A")) {
						reemplazo = "CAMPO_CONSULTA1";
					} else {
						reemplazo = "CAMPO_CONSULTA2";
					}
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.campoConsultaR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getCampoResultado())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					if (listaEspecialForm.getListaEspecialTO().getCampoResultado().equals("A")) {
						reemplazo = "CAMPO_RESULTADO1";
					} else {
						reemplazo = "CAMPO_RESULTADO2";
					}
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.campoResultadoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getValorDefecto())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					if (listaEspecialForm.getListaEspecialTO().getValorDefecto().equals("A")) {
						reemplazo = "VLOR_PORDEFECTO1";
					} else {
						reemplazo = "VLOR_PORDEFECTO2";
					}
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.valorDefectoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(listaEspecialForm.getListaEspecialTO().getStado())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					if (listaEspecialForm.getListaEspecialTO().getStado().equals("A")) {
						reemplazo = "Activo";
					} else {
						reemplazo = "Inactivo";
					}
					texto = new HSSFRichTextString(Config.getProperty("listaEspecial.estadoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}

				if (posicion != 0) {
					fila = hoja.createRow((short) 2);
					fila.setHeight((short) 400);
					region = new CellRangeAddress((short) 2, (short) 2, (short) 0, (short) cantColumns - 1);
					hoja.addMergedRegion(region);
					celda = fila.createCell((int) 0);
					texto = new HSSFRichTextString(Config.getProperty("general.parametrosBusquedat"));
					celda.setCellStyle(titulo);
					celda.setCellValue(texto);
				}
				nrofila += 2;

				fila = hoja.createRow((short) nrofila);

				celda = fila.createCell((int) 0);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.nombreListaEspecialR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 1);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.valorConceptoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 2);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.tipoListaR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 3);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.campoConsultaR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 4);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.campoResultadoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 5);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.valorDefectoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 6);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("listaEspecial.estadoR"));
				celda.setCellValue(texto);

				for (ListaEspecialTO listaEspecialTO : resultados) {
					nrofila += 1;
					fila = hoja.createRow((short) nrofila);
					if (cont % 2 == 1) {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreListaEspecial());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreConcepto());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreLista());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreCampoConsulta());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 4);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreCampoResultado());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 5);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getValorDefecto());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 6);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(listaEspecialTO.getStado());
						celda.setCellValue(texto);
					} else {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreListaEspecial());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreConcepto());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreLista());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreCampoConsulta());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 4);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getNombreCampoResultado());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 5);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getValorDefecto());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 6);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(listaEspecialTO.getStado());
						celda.setCellValue(texto);
					}
					cont++;
				}
				nrofila += 3;
				region = new CellRangeAddress((short) nrofila, (short) nrofila, (short) 1, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				fila = hoja.createRow((short) nrofila);
				celda = fila.createCell((int) 1);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("general.fecha") + new Date());
				celda.setCellValue(texto);

				for (short i = 0; i <= 4; i++) {
					hoja.autoSizeColumn(i);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return libro;
	}
}
