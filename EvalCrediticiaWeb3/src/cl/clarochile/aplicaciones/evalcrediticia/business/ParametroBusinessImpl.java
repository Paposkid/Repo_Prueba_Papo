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
import cl.clarochile.aplicaciones.evalcrediticia.dao.ParametroDAO;
import cl.clarochile.aplicaciones.evalcrediticia.form.ParametroForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ParametroTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Config;
import cl.clarochile.aplicaciones.evalcrediticia.util.Validador;

/**
 * Clase donde implementa la interfaz ParametroBusiness y utiliza los métodos
 * para comunicarse con ParametroDao para la comunicacion de la base de datos.
 * 
 * @author Carlos Andres Castrill0n [carlos.castrillonescobar@tcs.com]
 * @since 03/17/2013
 * @version 1.0
 */
@Service
public class ParametroBusinessImpl implements ParametroBusiness {

	@Autowired
	ParametroDAO parametroDao;

	/**
	 * Método sobre escrito por la interfaz "ParametroBusiness" donde inserta
	 * los registros de un parametro.
	 */

	@Override
	public void insertarParametro(ParametroTO parametroTO) throws Exception {
		try {
			parametroDao.insertarParametro(parametroTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método sobre escrito por la interfaz "ParametroBusiness" donde actualiza
	 * el registro de un Prametro.
	 */
	@Override
	public void actualizarParametro(ParametroTO parametroTO) throws Exception {
		try {
			parametroDao.actualizarParametro(parametroTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método sobre escrito por la interfaz "ParametroBusiness" donde filtra
	 * todos los registros de un parametro,ya sea por el nombre,tipo,valor, o
	 * estado.
	 * 
	 * @return listaParametros
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ParametroTO> listarParametros(ParametroTO parametroTO) throws Exception {
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		List<ParametroTO> listaParametros = null;
		try {
			mapParametros.put("codigoParametro", parametroTO.getCodigoParametro());
			mapParametros.put("nombreParametro", parametroTO.getNombreParametro());
			mapParametros.put("tipoParametro", parametroTO.getTipoParametro());
			mapParametros.put("valorParametro", parametroTO.getValorParametro());
			//jamj mapParametros.put("estadoParametro", parametroTO.getEstadoParametro());
			parametroDao.listarParametro(mapParametros);
			listaParametros = (List<ParametroTO>) mapParametros.get("resultados");

		} catch (Exception e) {
			throw e;
		}
		return listaParametros;
	}

	/**
	 * Método sobre escrito por la interfaz "ParametroBusiness" donde se
	 * obtendrá un parametro referenciada por el id que representa el registro
	 * 
	 * @return ParametroTO
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ParametroTO buscarParametroPorCodigo(ParametroTO parametroTO) throws Exception {
		ParametroTO miParametroTO = null;
		List<ParametroTO> listaParametros = null;
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		try {
			mapParametros.put("codigoParametro", parametroTO.getCodigoParametro());
			parametroDao.buscarParametroPorCodigo(mapParametros);
			listaParametros = (List<ParametroTO>) mapParametros.get("resultados");
			miParametroTO = listaParametros.get(0);

		} catch (Exception e) {
			throw e;
		}
		return miParametroTO;
	}

	/**
	 * Método sobre escrito por la interfaz "ParametroBusiness" donde se
	 * generara el libro en excel para exportar los registros.
	 * 
	 * @param ParametroForm
	 * @return HSSFWorkbook
	 * @throws Exception
	 */
	@Override
	public HSSFWorkbook generarReporte(ParametroForm parametroForm) throws Exception {
		// TODO Auto-generated method stub
		// Se crea el libro

		ArrayList<ParametroTO> resultados = (ArrayList<ParametroTO>) listarParametros(parametroForm.getParametroTO());

		HSSFWorkbook libro = null;

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
				HSSFRichTextString texto = new HSSFRichTextString(Config.getProperty("parametro.tituloReporte"));
				celda.setCellValue(texto);
				nrofila += 3;

				fila = hoja.createRow((short) nrofila);

				if (!Validador.esNuloVacio(parametroForm.getParametroTO().getNombreParametro())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("parametro.nombreT") + "= " + parametroForm.getParametroTO().getNombreParametro());
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(parametroForm.getParametroTO().getTipoParametro())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					String tipo = parametroForm.getParametroTO().getTipoParametro();
					String valor = "";
					if (tipo.equals("1")) {
						valor = Config.getProperty("parametro.limitesexcepcionadorT");
					}
					if (tipo.equals("2")) {
						valor = Config.getProperty("parametro.tiempoesperaserviciosexternos");
					}
					if (tipo.equals("3")) {
						valor = Config.getProperty("parametro.tiempovugenciaserviciosexternos");
					}
					if (tipo.equals("4")) {
						valor = Config.getProperty("parametro.vigenciaevaluacionT");

					}
					if (tipo.equals("5")) {
						valor = Config.getProperty("parametro.respuestaserviciosexternos");
					}
					texto = new HSSFRichTextString(Config.getProperty("parametro.tipoparametroT") + " = " + valor);
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(parametroForm.getParametroTO().getValorParametro())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("parametro.valorT") + "= " + parametroForm.getParametroTO().getValorParametro());
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(parametroForm.getParametroTO().getEstadoParametro())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					String estado = parametroForm.getParametroTO().getEstadoParametro();
					String valor = "";
					if (estado.equals("I")) {
						valor = "Inactivo";
					} else {
						valor = "Activo";
					}
					texto = new HSSFRichTextString(Config.getProperty("parametro.estadoT") + "= " + valor);
					celda.setCellValue(texto);
				}

				if (posicion != 0) {
					fila = hoja.createRow((short) 2);
					fila.setHeight((short) 400);
					region = new CellRangeAddress((short) 2, (short) 2, (short) 0, (short) cantColumns - 1);
					hoja.addMergedRegion(region);
					celda = fila.createCell((int) 0);
					texto = new HSSFRichTextString(Config.getProperty("parametro.parametros"));
					celda.setCellStyle(titulo);
					celda.setCellValue(texto);
				}
				nrofila += 2;

				fila = hoja.createRow((short) nrofila);

				celda = fila.createCell((int) 0);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("parametro.codigoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 1);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("parametro.nombreR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 2);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("parametro.tipoparametroR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 3);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("parametro.valorR"));
				celda.setCellValue(texto);

				for (ParametroTO parametroTO : resultados) {
					nrofila += 1;
					fila = hoja.createRow((short) nrofila);
					if (cont % 2 == 1) {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(parametroTO.getCodigoParametro());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(parametroTO.getNombreParametro());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(parametroTO.getTipoParametro());
						celda.setCellValue(texto);
						
						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(parametroTO.getValorParametro());
						celda.setCellValue(texto);

					} else {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(parametroTO.getCodigoParametro());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(parametroTO.getNombreParametro());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(parametroTO.getTipoParametro());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(parametroTO.getValorParametro());
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

				for (short i = 0; i <= 3; i++) {
					hoja.autoSizeColumn(i);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return libro;

	}
}
