package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.clarochile.aplicaciones.evalcrediticia.dao.ConstanteDAO;
import cl.clarochile.aplicaciones.evalcrediticia.form.ConstanteForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;
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
				mapConstantes.put("codigo", "");
				mapConstantes.put("tipo", constanteTO.getTipo());
				mapConstantes.put("nombre", Validador.esNuloVacio(constanteTO.getNombre()) ? constanteTO.getNombre() : constanteTO.getNombre().trim());
				mapConstantes.put("valor", Validador.esNuloVacio(constanteTO.getValor()) ? constanteTO.getValor() : constanteTO.getValor().trim());
				//jajm mapConstantes.put("estado", constanteTO.getEstado());
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

	/**
	 * Método que permite generar un reporte en un libro de excel
	 * 
	 * @param constanteForm
	 * @return HSSFWorkbook
	 * @throws Exception
	 */
	@Override
	public HSSFWorkbook generarReporte(ConstanteForm constanteForm) throws Exception {

		// Se crea el libro

		ArrayList<ConstanteTO> resultados = (ArrayList<ConstanteTO>) listarConstantes(constanteForm.getConstanteTO());

		HSSFWorkbook libro = null;
		Date actual = new Date();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");
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

				int cantColumns = 4;
				fila = hoja.createRow((short) nrofila);
				fila.setHeight((short) 450);
				region = new CellRangeAddress((short) 0, (short) 0, (short) 0, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				celda = fila.createCell((int) 0);
				celda.setCellStyle(titulo);
				HSSFRichTextString texto = new HSSFRichTextString(Config.getProperty("constante.tituloReporte"));
				celda.setCellValue(texto);
				nrofila += 3;

				fila = hoja.createRow((short) nrofila);

				if (!Validador.esNuloVacio(constanteForm.getConstanteTO().getCodigo())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("constante.codigoR") + "= " + constanteForm.getConstanteTO().getCodigo());
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(constanteForm.getConstanteTO().getNombre())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("constante.nombreR") + "= " + constanteForm.getConstanteTO().getNombre());
					celda.setCellValue(texto);
				}

				if (!Validador.esNuloVacio(constanteForm.getConstanteTO().getTipo())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (constanteForm.getConstanteTO().getTipo().equals("A")) {
						reemplazo = "Alfanumérico";
					} else {
						reemplazo = "Numérico";
					}
					texto = new HSSFRichTextString(Config.getProperty("constante.tipoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				/*jamj
				if (!Validador.esNuloVacio(constanteForm.getConstanteTO().getEstado())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (constanteForm.getConstanteTO().getEstado().equals("A")) {
						reemplazo = "Activo";
					} else {
						reemplazo = "Inactivo";
					}
					texto = new HSSFRichTextString(Config.getProperty("constante.estadoR") + "= " + constanteForm.getConstanteTO().getEstado());
					celda.setCellValue(texto);
				}*/

				if (!Validador.esNuloVacio(constanteForm.getConstanteTO().getValor())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("constante.valorR") + "= " + constanteForm.getConstanteTO().getValor());
					celda.setCellValue(texto);
				}

				if (posicion != 0) {

					fila = hoja.createRow((short) 2);
					fila.setHeight((short) 400);
					region = new CellRangeAddress((short) 2, (short) 2, (short) 0, (short) cantColumns - 1);
					hoja.addMergedRegion(region);
					celda = fila.createCell((int) 0);
					texto = new HSSFRichTextString(Config.getProperty("general.parametrosBusqueda"));
					celda.setCellStyle(titulo);
					celda.setCellValue(texto);
				}
				nrofila += 2;

				fila = hoja.createRow((short) nrofila);

				celda = fila.createCell((int) 0);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("constante.codigoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 1);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("constante.nombreR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 2);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("constante.tipoR"));
				celda.setCellValue(texto);
				/*
				celda = fila.createCell((int) 3);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("constante.estadoR"));
				celda.setCellValue(texto);*/

				celda = fila.createCell((int) 3);
				celda.setCellStyle(encabezados);
				texto = new HSSFRichTextString(Config.getProperty("constante.valorR"));
				celda.setCellValue(texto);

				for (ConstanteTO constanteTO : resultados) {
					nrofila += 1;
					fila = hoja.createRow((short) nrofila);

					if (cont % 2 == 1) {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(constanteTO.getCodigo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(constanteTO.getNombre());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(constanteTO.getTipo());
						celda.setCellValue(texto);
									/*
						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(constanteTO.getEstado());
						celda.setCellValue(texto); jamj*/

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(constanteTO.getValor());
						celda.setCellValue(texto);
					} else {

						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(constanteTO.getCodigo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(constanteTO.getNombre());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(constanteTO.getTipo());
						celda.setCellValue(texto);
								/*
						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(constanteTO.getEstado());
						celda.setCellValue(texto); jamj*/

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(constanteTO.getValor());
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
				texto = new HSSFRichTextString(Config.getProperty("general.fecha") + fecha.format(actual));
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
