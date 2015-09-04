package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.clarochile.aplicaciones.evalcrediticia.dao.DominioDAO;
import cl.clarochile.aplicaciones.evalcrediticia.form.DominioForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Config;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;
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
@Service
public class DominioBusinessImpl implements DominioBusiness {

	@Autowired
	DominioDAO dominioDao;

	/**
	 * Método que permite insertar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 * @see cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness#insertarDominio(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	public void insertarDominio(DominioTO dominioTO) throws Exception {

		try {
			dominioDao.insertarDominio(dominioTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método que permite actualizar un dominio por medio del DAO y guardarlo en
	 * la DB
	 * 
	 * @param DominioTO
	 * @throws Exception
	 * @see cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness#actualizarDominio(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	public void actualizarDominio(DominioTO dominioTO) throws Exception {

		try {
			dominioDao.actualizarDominio(dominioTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método que permite listar un dominio por medio del DAO y guardarlo en la
	 * DB
	 * 
	 * @return List<DominioTO>
	 * @throws Exception
	 * @see cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness#listarDominio()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DominioTO> listarDominio() throws Exception {

		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {
			dominioDao.listarDominio(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

		} catch (Exception e) {
			throw e;
		}

		return lstDominios;
	}

	/**
	 * Método que permite obtener un dominio por codigo por medio del DAO y
	 * guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return DominioTO
	 * @throws Exception
	 * @see cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness#obtenerDominioPorCodigo(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public DominioTO obtenerDominioPorCodigo(DominioTO dominioTO) throws Exception {

		DominioTO dominio = new DominioTO();
		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {

			mapDominioTO.put("codigo", dominioTO.getCodigo());
			dominioDao.obtenerDominioPorCodigo(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

			if (!lstDominios.isEmpty()) {
				dominio = lstDominios.get(0);
			}

		} catch (Exception e) {
			throw e;
		}
		return dominio;
	}

	/**
	 * Método que permite buscar un dominio por varios campos por medio del DAO
	 * y guardarlo en la DB
	 * 
	 * @param DominioTO
	 * @return List<DominioTO>
	 * @throws Exception
	 * @see cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness#buscarDominioPorCampos(cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DominioTO> buscarDominioPorCampos(DominioTO dominioTO) throws Exception {

		List<DominioTO> lstDominios = new ArrayList<DominioTO>();
		Map<String, Object> mapDominioTO = new HashMap<String, Object>();

		try {

			mapDominioTO.put("nombre", (Validador.esNuloVacio(dominioTO.getNombre()) ? dominioTO.getNombre() : dominioTO.getNombre().trim()));
			mapDominioTO.put("tipoDato", dominioTO.getTipoDato());
			mapDominioTO.put("tipoCampo", dominioTO.getTipoCampo());
			mapDominioTO.put("estado", dominioTO.getEstado());
			mapDominioTO.put("valor", (Validador.esNuloVacio(dominioTO.getValor()) ? dominioTO.getValor() : dominioTO.getValor().trim()));

			dominioDao.buscarDominioPorCampos(mapDominioTO);
			lstDominios = (ArrayList<DominioTO>) mapDominioTO.get("resultados");

		} catch (Exception e) {
			throw e;
		}
		return lstDominios;
	}

	/*
	 * Metodo que permite generar un reporte en xls (Excel)
	 * 
	 * @param DominioForm
	 * 
	 * @return HSSFWorkbook
	 * 
	 * @throws Exception
	 * 
	 * @see cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness#
	 * generarReporte
	 * (cl.clarochile.aplicaciones.evalcrediticia.form.DominioForm)
	 */
	@Override
	public HSSFWorkbook generarReporte(DominioForm dominioForm) throws Exception {
		
		// Se crea el libro

		ArrayList<DominioTO> resultados = (ArrayList<DominioTO>) buscarDominioPorCampos(dominioForm.getDominioTO());

		HSSFWorkbook libro = null;

		if (!resultados.isEmpty()) {

			libro = new HSSFWorkbook();

			// Se crea una hoja dentro del libro
			HSSFSheet hoja = libro.createSheet();

			HSSFFont letraNormal = libro.createFont();// Creación de un tipo de
														// letra para el cuerpo
														// del
														// reporte
			HSSFFont letraNegrita = libro.createFont(); // Creación de un tipo
														// de
														// letra para los
														// titulos
														// del reporte
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
				int cantColumns = 6;
				fila = hoja.createRow((short) nrofila);
				fila.setHeight((short) 400);
				region = new CellRangeAddress((short) 0, (short) 0, (short) 0, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				celda = fila.createCell((int) 0);
				celda.setCellStyle(titulo);
				HSSFRichTextString texto = new HSSFRichTextString(Config.getProperty("dominio.tituloReporteDominio"));
				celda.setCellValue(texto);
				nrofila += 3;

				int posicion = 0;
				String cambio = null;
				fila = hoja.createRow((short) nrofila);
				if (!(dominioForm.getDominioTO().getCodigo()==0)) {

					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					texto = new HSSFRichTextString(Config.getProperty("dominio.codigoR") + " = " + dominioForm.getDominioTO().getCodigo());
					celda.setCellValue(texto);
				}
				if (!dominioForm.getDominioTO().getNombre().equals("")) {
					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					texto = new HSSFRichTextString(Config.getProperty("dominio.nombreR") + " = " + dominioForm.getDominioTO().getNombre());
					celda.setCellValue(texto);
				}
				if (!StringUtil.isEmpty(dominioForm.getDominioTO().getTipoDato())) {
					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					if (dominioForm.getDominioTO().getTipoDato().equals("A")) {
						cambio = Config.getProperty("general.tipo.alfanumerico");
					} else {
						cambio = Config.getProperty("general.tipo.numerico");
					}
					texto = new HSSFRichTextString(Config.getProperty("dominio.tipoCaracterR") + " = " + cambio);
					celda.setCellValue(texto);
				}
				if (!dominioForm.getDominioTO().getTipoCampo().equals("")) {
					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					if (dominioForm.getDominioTO().getTipoCampo().equals("E")) {
						cambio = Config.getProperty("general.entrada");
					} else {
						cambio = Config.getProperty("general.salida");
					}
					texto = new HSSFRichTextString(Config.getProperty("dominio.tipoDatoR") + " = " + cambio);
					celda.setCellValue(texto);
				}
				if (!dominioForm.getDominioTO().getEstado().equals("")) {

					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					if (dominioForm.getDominioTO().getEstado().equals("A")) {
						cambio = Config.getProperty("general.estado.activo");
					} else {
						cambio = Config.getProperty("general.estado.inactivo");
					}
					texto = new HSSFRichTextString(Config.getProperty("dominio.estadoR") + " = " + cambio);
					celda.setCellValue(texto);
				}
				if (!dominioForm.getDominioTO().getValor().equals("")) {

					celda = fila.createCell((int) posicion);
					celda.setCellStyle(celdas);
					posicion++;
					texto = new HSSFRichTextString(Config.getProperty("dominio.valorR") + " = " + dominioForm.getDominioTO().getValor());
					celda.setCellValue(texto);
				}
				// nrofila--;
				if (posicion != 0) {
					fila = hoja.createRow((short) 2);
					fila.setHeight((short) 300);
					region = new CellRangeAddress((short) 2, (short) 2, (short) 0, (short) cantColumns - 1);
					hoja.addMergedRegion(region);

					celda = fila.createCell((int) 0);
					celda.setCellStyle(letraIntermedia);
					texto = new HSSFRichTextString(Config.getProperty("general.parametrosBusqueda"));
					celda.setCellValue(texto);
				}

				nrofila += 2;
				fila = hoja.createRow((short) nrofila);

				celda = fila.createCell((int) 0);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("dominio.codigoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 1);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("dominio.nombreR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 2);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("dominio.tipoCaracterR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 3);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("dominio.tipoDatoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 4);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("dominio.estadoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 5);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("dominio.valorR"));
				celda.setCellValue(texto);

				int contador = 1;
				for (DominioTO dominioTO : resultados) {
					nrofila += 1;
					if (contador % 2 == 0) {
						fila = hoja.createRow((short) nrofila);

						celda = fila.createCell((int) 0);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(String.valueOf(dominioTO.getCodigo()));
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(dominioTO.getNombre());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(dominioTO.getTipoDato());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(dominioTO.getTipoCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 4);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(dominioTO.getEstado());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 5);
						celda.setCellStyle(intercalado);
						texto = new HSSFRichTextString(dominioTO.getValor());
						celda.setCellValue(texto);
					} else {
						fila = hoja.createRow((short) nrofila);

						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(String.valueOf(dominioTO.getCodigo()));
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(dominioTO.getNombre());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(dominioTO.getTipoDato());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(dominioTO.getTipoCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 4);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(dominioTO.getEstado());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 5);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(dominioTO.getValor());
						celda.setCellValue(texto);
					}
					contador++;
				}
				nrofila += 3;
				region = new CellRangeAddress((short) nrofila, (short) nrofila, (short) 0, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				fila = hoja.createRow((short) nrofila);
				celda = fila.createCell((int) 0);
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
