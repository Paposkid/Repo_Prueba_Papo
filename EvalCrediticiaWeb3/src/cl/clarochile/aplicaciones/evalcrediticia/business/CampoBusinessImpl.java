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

import cl.clarochile.aplicaciones.evalcrediticia.dao.CampoDAO;
import cl.clarochile.aplicaciones.evalcrediticia.form.CampoForm;

import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Config;
import cl.clarochile.aplicaciones.evalcrediticia.util.Validador;

/**
 * CampoBusinessImpl es una clase que permite la comunicación con el CampoDao y
 * su base de datos
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
@Service
public class CampoBusinessImpl implements CampoBusiness {

	@Autowired
	CampoDAO campoDAO;

	/**
	 * actualizarCampo es un método que permite actualizar campos por el DAO y
	 * almacenado en la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	@Override
	public void actualizarCampo(CampoTO campoTO) throws Exception {
		try {
			campoDAO.actualizarCampo(campoTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * listarCampos es un método que permite listar campos por el DAO y
	 * mostrarlos desde la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @return listaCampos
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CampoTO> listarCampos(CampoTO campoTO) throws Exception {

		Map<String, Object> mapCampos = new HashMap<String, Object>();
		List<CampoTO> listaCampos = null;
		try {
			mapCampos.put("codigoCampo", campoTO.getCodigoCampo());
			mapCampos.put("nombreCampo", (Validador.esNuloVacio(campoTO.getNombreCampo()) ? campoTO.getNombreCampo() : campoTO.getNombreCampo().trim()));
			mapCampos.put("tipoCampo", campoTO.getTipoCampo());
			mapCampos.put("codigoTipoRegla", campoTO.getCodigoTipoRegla());
			mapCampos.put("subTipo", campoTO.getSubTipo());
			mapCampos.put("tipoDato", campoTO.getTipoDato());
			//jamj mapCampos.put("estado", campoTO.getEstado());

			campoDAO.listarCampo(mapCampos);
			listaCampos = (List<CampoTO>) mapCampos.get("resultados");
		} catch (Exception e) {
			throw e;
		}

		return listaCampos;
	}

	/**
	 * insertarCampo es un método que permite insertar campos por el DAO y
	 * almacenarlos en la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @throws Exception
	 */
	@Override
	public void insertarCampo(CampoTO campoTO) throws Exception {
		try {
			campoDAO.insertarCampo(campoTO);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * obtenerCampoPorCodigo es un método que permite a partir de un codigo de
	 * campo, obtener campos por el DAO y mostrarlos de la base de datos.
	 * 
	 * 
	 * @param campoTO
	 * @return miCampoTO
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public CampoTO obtenerCampoPorCodigo(CampoTO campoTO) throws Exception {

		CampoTO miCampoTO = null;
		List<CampoTO> listaCampos = null;
		Map<String, Object> mapCampos = new HashMap<String, Object>();

		try {
			mapCampos.put("codigoCampo", campoTO.getCodigoCampo());
			campoDAO.buscarCampoPorCodigo(mapCampos);
			listaCampos = (List<CampoTO>) mapCampos.get("resultados");
			miCampoTO = listaCampos.get(0);

		} catch (Exception e) {
			throw e;
		}

		return miCampoTO;
	}

	/**
	 * generarReporte es un método que permite hacer un reporte de los campos en
	 * excel, mostrandolos desde la base de datos.
	 * 
	 * 
	 * @param campoForm
	 * @return libro
	 * @throws Exception
	 */
	@Override
	public HSSFWorkbook generarReporte(CampoForm campoForm) throws Exception {
		ArrayList<CampoTO> resultados = (ArrayList<CampoTO>) listarCampos(campoForm.getCampoTO());
		HSSFWorkbook libro = null;
		String reemplazo;
		int posicion = 0;
		int cont = 1;
		if (!resultados.isEmpty()) {
			libro = new HSSFWorkbook();

			// Se crea una hoja dentro del libro
			HSSFSheet hoja = libro.createSheet();
			// Creación de un tipo de letra para el cuerpo del reporte
			HSSFFont letraNormal = libro.createFont();
			// Creación de un tipo de letra para los titulos del reporte
			HSSFFont letraNegrita = libro.createFont();
			HSSFFont letraIntermedia = libro.createFont();

			HSSFCellStyle titulo = libro.createCellStyle();
			HSSFCellStyle encabezados = libro.createCellStyle();
			HSSFCellStyle celdas = libro.createCellStyle();
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
			encabezados.setFont(letraNegrita);
			encabezados.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			encabezados.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			encabezados.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
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

				int cantColumns = 7;
				fila = hoja.createRow((short) nrofila);
				fila.setHeight((short) 450);
				region = new CellRangeAddress((short) 0, (short) 0, (short) 0, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				celda = fila.createCell((int) 0);
				celda.setCellStyle(titulo);
				HSSFRichTextString texto = new HSSFRichTextString(Config.getProperty("campo.tituloReporte"));
				celda.setCellValue(texto);
				nrofila += 3;

				fila = hoja.createRow((short) nrofila);
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getCodigoCampo())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("campo.codigocampoR") + "= " + campoForm.getCampoTO().getCodigoCampo());
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getNombreCampo())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					texto = new HSSFRichTextString(Config.getProperty("campo.nombrecampoR") + "= " + campoForm.getCampoTO().getNombreCampo());
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getTipoCampo())) {
					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (campoForm.getCampoTO().getTipoCampo().equals("E")) {
						reemplazo = "Entrada";
					} else {
						reemplazo = "Salida";
					}
					texto = new HSSFRichTextString(Config.getProperty("campo.tipocampoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getCodigoTipoRegla())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (campoForm.getCampoTO().getCodigoTipoRegla().equals("F")) {
						reemplazo = "Full Credit Evaluation";
					} else {
						reemplazo = "Ligth Credit Evaluation";
					}
					texto = new HSSFRichTextString(Config.getProperty("campo.codigotiporeglaR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getSubTipo())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (campoForm.getCampoTO().getSubTipo().equals("S")) {
						reemplazo = "Simple";
					} else {
						reemplazo = "Múltiple";
					}
					texto = new HSSFRichTextString(Config.getProperty("campo.subtipoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getTipoDato())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (campoForm.getCampoTO().getTipoDato().equals("N")) {
						reemplazo = "Numérico";
					} else {
						reemplazo = "Alfanumérico";
					}
					texto = new HSSFRichTextString(Config.getProperty("campo.tipodatoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				}
				/*
				if (!Validador.esNuloVacio(campoForm.getCampoTO().getEstado())) {

					celda = fila.createCell((int) posicion);
					posicion++;
					celda.setCellStyle(celdas);
					if (campoForm.getCampoTO().getEstado().equals("A")) {
						reemplazo = "Activo";
					} else {
						reemplazo = "Inactivo";
					}
					texto = new HSSFRichTextString(Config.getProperty("campo.estadoR") + "= " + reemplazo);
					celda.setCellValue(texto);
				} */
				nrofila += 2;
				fila = hoja.createRow((short) nrofila);

				celda = fila.createCell((int) 0);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.codigocampoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 1);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.nombrecampoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 2);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.tipocampoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 3);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.codigotiporeglaR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 4);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.subtipoR"));
				celda.setCellValue(texto);

				celda = fila.createCell((int) 5);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.tipodatoR"));
				celda.setCellValue(texto);
				/*
				celda = fila.createCell((int) 6);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("campo.estadoR"));
				celda.setCellValue(texto);*/

				for (CampoTO campoTO : resultados) {
					nrofila += 1;
					fila = hoja.createRow((short) nrofila);

					if (cont % 2 == 1) {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getCodigoCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getNombreCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getTipoCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getNombreTipoRegla());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 4);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getSubTipo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 5);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getTipoDato());
						celda.setCellValue(texto);
						/*
						celda = fila.createCell((int) 6);
						celda.setCellStyle(celdas);
						texto = new HSSFRichTextString(campoTO.getEstado());
						celda.setCellValue(texto);*/

					} else {
						celda = fila.createCell((int) 0);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getCodigoCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 1);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getNombreCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 2);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getTipoCampo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 3);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getNombreTipoRegla());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 4);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getSubTipo());
						celda.setCellValue(texto);

						celda = fila.createCell((int) 5);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getTipoDato());
						celda.setCellValue(texto);
						/*
						celda = fila.createCell((int) 6);
						celda.setCellStyle(celdasOscuras);
						texto = new HSSFRichTextString(campoTO.getEstado());
						celda.setCellValue(texto); jamj*/

					}
					cont++;
				}
				nrofila += 3;
				region = new CellRangeAddress((short) nrofila, (short) nrofila, (short) 1, (short) cantColumns - 1);
				hoja.addMergedRegion(region);
				fila = hoja.createRow((short) nrofila);
				celda = fila.createCell((int) 1);
				celda.setCellStyle(celdas);
				texto = new HSSFRichTextString(Config.getProperty("general.fecha") + " = " + new Date());
				celda.setCellValue(texto);
				for (short i = 0; i <= 7; i++) {
					hoja.autoSizeColumn(i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return libro;
	}
}