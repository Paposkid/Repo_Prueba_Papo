package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.clarochile.aplicaciones.evalcrediticia.dao.CategoriaDAO;
import cl.clarochile.aplicaciones.evalcrediticia.form.CategoriaForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Config;
import cl.clarochile.aplicaciones.evalcrediticia.util.Validador;

/**
 * CategoriaBusinessImpl es una clase donde se encuentran todos los metodos ya
 * implementados, los cuales se comunicaran con el Dao para obtenber la la
 * informacion del mapeo de la DB.
 * 
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
@Service
public class CategoriaBusinessImpl implements CategoriaBusiness {

	@Autowired
	CategoriaDAO categoriaDao;

	/*
	 * Método que permite insertar una categoria por medio del DAO y guardarlo
	 * en la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness#
	 * insertarCategoria
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	public void insertarCategoria(CategoriaTO categoriaTO) throws Exception {
		try {
			categoriaDao.insertarCategoria(categoriaTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * Método que permite actualizar una categoria por medio del DAO y guardarlo
	 * en la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness#
	 * actualizarCategoria
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	public void actualizarCategoria(CategoriaTO categoriaTO) throws Exception {
		try {
			categoriaDao.actualizarCategoria(categoriaTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Método que permite listar las categorias por medio del DAO, guardados en
	 * la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @return List<CategoriaTO>
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness#
	 * listarCategorias
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaTO> listarCategorias(CategoriaTO categoriaTO)
			throws Exception {

		List<CategoriaTO> lstCategorias = new ArrayList<CategoriaTO>();
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();

		try {
			mapCategoriaTO.put("nombreCategoria", (Validador.esNuloVacio(categoriaTO.getNombreCategoria()) ?  categoriaTO.getNombreCategoria(): categoriaTO.getNombreCategoria().trim()));
			mapCategoriaTO.put("tipoCategoria", categoriaTO.getTipoCategoria());
			mapCategoriaTO.put("tipoCampo", categoriaTO.getCodigoCampo());

			categoriaDao.listarCategorias(mapCategoriaTO);
			lstCategorias = (ArrayList<CategoriaTO>) mapCategoriaTO
					.get("resultados");
		} catch (Exception e) {
			throw e;
		}
		return lstCategorias;
	}

	/*
	 * Método que permite obtener una categoria por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param CategoriaTO
	 * 
	 * @return CategoriaTO
	 * 
	 * @see
	 * cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness#
	 * obtenerCategoriaPorCodigo
	 * (cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public CategoriaTO obtenerCategoriaPorCodigo(CategoriaTO categoriaTO)
			throws Exception {

		CategoriaTO lCategoriaTO = new CategoriaTO();
		List<CategoriaTO> listaCategoria = null;
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();
		try {

			mapCategoriaTO.put("codigoCategoria",
					categoriaTO.getCodigoCategoria());
			categoriaDao.obtenerCategoriaPorCodigo(mapCategoriaTO);
			listaCategoria = (List<CategoriaTO>) mapCategoriaTO
					.get("resultados");

			if (!listaCategoria.isEmpty()) {
				lCategoriaTO = listaCategoria.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return lCategoriaTO;

	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaTO> listarCategorias2(CategoriaTO categoriaTO)
			throws Exception {

		List<CategoriaTO> lstCategorias = new ArrayList<CategoriaTO>();
		Map<String, Object> mapCategoriaTO = new HashMap<String, Object>();

		try {
			mapCategoriaTO.put("nombreCategoria", categoriaTO.getNombreCategoria());
			mapCategoriaTO.put("tipoCategoria", categoriaTO.getTipoCategoria());
			mapCategoriaTO.put("tipoCampo", categoriaTO.getTipoCampo());

			categoriaDao.listarCategorias2(mapCategoriaTO);
			lstCategorias = (ArrayList<CategoriaTO>) mapCategoriaTO.get("resultados");
		} catch (Exception e) {
			throw e;
		}
		return lstCategorias;
	}

	/*
	 * Metodo que permite generar un reporte en xls (Excel)
	 * 
	 * @param CategoriaForm
	 * 
	 * @return HSSFWorkbook
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness#
	 * generarReporte
	 * (cl.clarochile.aplicaciones.evalcrediticia.form.CategoriaForm)
	 */
	@Override
	public HSSFWorkbook generarReporte(CategoriaForm categoriaForm)
			throws Exception {

		// Se crea el libro
		ArrayList<CategoriaTO> resultados = (ArrayList<CategoriaTO>) listarCategorias(categoriaForm
				.getCategoriaTO());

		HSSFWorkbook libro = null;

		if (!resultados.isEmpty()) {

			libro = new HSSFWorkbook();

			// Se crea una hoja dentro del libro
			HSSFSheet hoja = libro.createSheet();

			HSSFFont letraNormal = libro.createFont();
			HSSFFont letraNegrita = libro.createFont();
			HSSFFont letraInt = libro.createFont();

			HSSFCellStyle titulo = libro.createCellStyle();// titulo
			HSSFCellStyle encabezados = libro.createCellStyle();// encabezados
			HSSFCellStyle celdas = libro.createCellStyle(); // Celdas
			HSSFCellStyle intercalado = libro.createCellStyle(); // Celdas
			HSSFCellStyle letraIntermedia = libro.createCellStyle(); // Celdas

			// Configuración del tipo de letra
			letraNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			letraNegrita.setFontHeight((short) 300);
			letraInt.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			letraInt.setFontHeight((short) 260);
			letraNormal.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

			// configuracion para intercalado de la tabla
			intercalado.setFont(letraNormal);
			intercalado.setFillForegroundColor(HSSFColor.CORAL.index);
			intercalado.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			// Configuración de las celdas del reporte
			titulo.setFont(letraNegrita);
			titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// Configuracion letra intermedia
			letraIntermedia.setFont(letraInt);
			letraIntermedia.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// Fila Delegado
			encabezados.setFont(letraNormal);
			encabezados.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			encabezados.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			encabezados.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			// Celdas Con borde
			celdas.setFont(letraNormal);
			celdas.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			HSSFRow fila;
			HSSFCell celda;
			CellRangeAddress region;

			try {
				int nrofila = 0;
				int cantColumns = 4;
				fila = hoja.createRow((short) nrofila);
				fila.setHeight((short) 400);
				region = new CellRangeAddress((short) 0, (short) 0, (short) 0,
						(short) cantColumns - 1);
				hoja.addMergedRegion(region);
				celda = fila.createCell((int) 0);
				celda.setCellStyle(titulo);
				HSSFRichTextString texto = new HSSFRichTextString(
						Config.getProperty("categoria.tituloReporteCategoria"));
				celda.setCellValue(texto);
				nrofila += 3;

				int posicion = 0;
				String cambio = null;
				fila = hoja.createRow((short) nrofila);

				if (!Validador.esNuloVacio(categoriaForm.getCategoriaTO().getNombreCategoria())) {
					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					texto = new HSSFRichTextString(
							Config.getProperty("general.codigoT")
									+ " = "
									+ categoriaForm.getCategoriaTO()
											.getNombreCategoria());
					celda.setCellValue(texto);
				}
				
				celda = fila.createCell((int) posicion);
				celda.setCellStyle(celdas);
				posicion++;
				
				texto = new HSSFRichTextString(
						Config.getProperty("general.campo") + " = "
								+ categoriaForm.getCategoriaTO().getNombreCampo());
				celda.setCellValue(texto);
				
				if (!Validador.esNuloVacio(categoriaForm.getCategoriaTO().getTipoCategoria())) {
					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					if (categoriaForm.getCategoriaTO().getTipoCategoria()
							.equals("V")) {
						cambio = Config.getProperty("categoria.tipo.valor");
					} else if (categoriaForm.getCategoriaTO()
							.getTipoCategoria().equals("L")) {
						cambio = Config.getProperty("categoria.tipo.lista");
					} else {
						cambio = Config.getProperty("categoria.tipo.rango");
					}
					texto = new HSSFRichTextString(
							Config.getProperty("general.tipoDato") + " = "
									+ cambio);
					celda.setCellValue(texto);
				}

				if (posicion != 0) {
					fila = hoja.createRow((short) 2);
					fila.setHeight((short) 300);
					region = new CellRangeAddress((short) 2, (short) 2,
							(short) 0, (short) cantColumns - 1);
					hoja.addMergedRegion(region);

					celda = fila.createCell((int) 0);
					celda.setCellStyle(letraIntermedia);
					texto = new HSSFRichTextString(
							Config.getProperty("general.parametrosBusqueda"));
					celda.setCellValue(texto);
				}

				nrofila += 2;
				fila = hoja.createRow((short) nrofila);

				celda = fila.createCell((int) 0);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(
						Config.getProperty("general.codigo"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 1);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(
						Config.getProperty("general.campo"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 2);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(
						Config.getProperty("general.tipoDato"));
				celda.setCellValue(texto);

				int contador = 1;
				for (CategoriaTO categoriaTO : resultados) {
					nrofila += 1;
					if (contador % 2 == 0) {
						fila = hoja.createRow((short) nrofila);

						celda = fila.createCell((int) 0);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(
								categoriaTO.getNombreCategoria());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(
								categoriaTO.getNombreCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(
								categoriaTO.getTipoCategoria());
						celda.setCellValue(texto);

					} else {
						fila = hoja.createRow((short) nrofila);

						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(
								categoriaTO.getNombreCategoria());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(
								categoriaTO.getNombreCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(
								categoriaTO.getTipoCategoria());
						celda.setCellValue(texto);

					}
					contador++;
				}
				nrofila += 3;
				region = new CellRangeAddress((short) nrofila, (short) nrofila,
						(short) 0, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				fila = hoja.createRow((short) nrofila);
				celda = fila.createCell((int) 0);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(
						Config.getProperty("general.fecha") + new Date());
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
