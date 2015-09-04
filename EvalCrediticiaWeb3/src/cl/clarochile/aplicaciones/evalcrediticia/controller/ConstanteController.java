package cl.clarochile.aplicaciones.evalcrediticia.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.clarochile.aplicaciones.evalcrediticia.business.ConstanteBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.ConstanteForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;
import cl.clarochile.aplicaciones.evalcrediticia.validador.ConstanteValidator;

/**
 * Esta es la capa de control donde se realiza la conexión entre la logica del
 * negocio y la interfaz.
 * 
 * @author Daniel Ocampo Gutiérrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */
@Controller
public class ConstanteController {

	static private Logger logger = Logger.getLogger(ConstanteController.class);

	/**
	 * Atributo que inyecta la clase ConstanteController para realizar la logica
	 * del negocio
	 */
	@Autowired
	private ConstanteBusiness constanteBusiness;

	/**
	 * Atributo que inyecta la clase constanteValidator para validar los
	 * atributos ingresados al front
	 */

	@Autowired
	private ConstanteValidator constanteValidator;

	String PAGINA_CONSTANTE_LISTAR = "secure/constante/listarConstante";
	String PAGINA_CONSTANTE_DETALLE = "secure/constante/detalleConstante";

	/**
	 * Método que permite ir a la pantalla donde está ubicado la tabla que
	 * contiene todos los registros de las constantes y el formulario donde se
	 * puede filtrar Para encontrar el registro buscado.
	 * 
	 * @param request
	 * @param model
	 * @return mv
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "mostrarPaginaConstante.do", method = RequestMethod.GET)
	public ModelAndView mostrarFormConstante(HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONSTANTE_LISTAR, "model", model);
		ConstanteForm cf = new ConstanteForm();

		model.addAttribute(cf);
		try {
			cf.setResultados(new ArrayList(constanteBusiness.listarConstantes(new ConstanteTO())));
		} catch (Exception e) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al cargar las constantes.");
			logger.error(e.getMessage(), e);
		}
		return mv;
	}

	@RequestMapping(value = "exportarConstExcel.do")
	public ModelAndView exportarConsulta(@ModelAttribute ConstanteForm formulario, HttpServletRequest request, HttpServletResponse response, Model model) {

		ModelAndView mv = null;
		try {

			HSSFWorkbook libro = constanteBusiness.generarReporte(formulario);
			if (libro != null) {

				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + "Reporte Constantes" + ".xls\"");
				OutputStream output = response.getOutputStream();
				libro.write(output);
				output.flush();
				output.close();
			} else {
				mv = new ModelAndView(PAGINA_CONSTANTE_LISTAR, "model", model);
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			}
		} catch (Exception e) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al exportal a excel");
			logger.error(e.getMessage(), e);
		}
		return mv;
	}

	/**
	 * Cuando se utiliza este método es porque occurio una acción en el
	 * lapíz(imagen), en el momento de realizar esa acción, este método te lleva
	 * a la pantalla "detalleConstante" donde se podra actualizar el registro
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "editarConstante.do")
	public ModelAndView cargarPaginaEditarConstante(

	@ModelAttribute ConstanteForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONSTANTE_DETALLE);
		try {
			
			formulario.setConstanteDetalleTO(constanteBusiness.obtenerConstantePorCodigo(formulario.getConstanteDetalleTO()));
			model.addAttribute(formulario);
			mv.addObject(Constantes.HASID, formulario.getConstanteDetalleTO().getCodigo());
		} catch (Exception e) {
			mv = new ModelAndView(PAGINA_CONSTANTE_LISTAR);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			logger.error(e.getMessage(), e);

		}

		return mv;
	}

	/**
	 * Cuando se utiliza este método es porque occurio una acción con el boton
	 * "Nuevo" y la acción que se realiza es ir la formulario donde se ingresa
	 * el registro de una constante;
	 * 
	 * @param formulario
	 * @param model
	 * @return mv
	 */

	@RequestMapping(value = "nuevaConstante.do")
	public ModelAndView cargarPaginaNuevaConstante(@ModelAttribute ConstanteForm formulario, Model model) {
		model.addAttribute(new ConstanteForm());
		return new ModelAndView(PAGINA_CONSTANTE_DETALLE);
	}

	/**
	 * En el momento de ubicarse en la pagina "listarConstante.do" este método
	 * trae todos los registros de constantes requeridos.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@RequestMapping(value = "listarConstante.do")
	public ModelAndView mostrarConstantes(@ModelAttribute ConstanteForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONSTANTE_LISTAR);
		ArrayList<ConstanteTO> listaConstantes = new ArrayList<ConstanteTO>();

		try {

			listaConstantes = (ArrayList<ConstanteTO>) constanteBusiness.listarConstantes((formulario.getConstanteTO()));

			if (listaConstantes.isEmpty()) {

				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(listaConstantes);
				if (!StringUtil.isEmpty(formulario.getConstanteDetalleTO().getCodigo())) {
					formulario.getConstanteTO().setCodigo("");
				}
			}

		} catch (Exception e) {
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
			logger.error(e.getMessage(), e);
		}

		return mv;
	}

	/**
	 * Cuando se utiliza este método es que se va actualizar un regitro de
	 * constante, al realizar la acción con el boton "Guardar" se valida los
	 * campos que no esten vacios y al no estarlo va al bussines para actualizar
	 * el registro.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return mv
	 */

	@RequestMapping(value = "actualizarConstante.do", method = RequestMethod.POST)
	public ModelAndView actualizarConstante(@ModelAttribute(value = "constanteForm") ConstanteForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CONSTANTE_LISTAR);

		try {

			constanteValidator.validate(formulario, validarForm);
			if (!validarForm.hasErrors()) {
				formulario.getConstanteDetalleTO().setCodUsuarioM(20);
				formulario.getConstanteDetalleTO().setEstado("A");
				constanteBusiness.actualizarConstante(formulario.getConstanteDetalleTO());
				mv = mostrarConstantes(formulario, request, model);
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));
			} else {

				mv = new ModelAndView(PAGINA_CONSTANTE_DETALLE);
				mv.addObject(Constantes.HASID, formulario.getConstanteDetalleTO().getCodigo());
			}
		} catch (Exception e) {

			mv.addObject(Constantes.HASID, formulario.getConstanteDetalleTO().getCodigo());
			mv = new ModelAndView(PAGINA_CONSTANTE_DETALLE);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			logger.error(e.getMessage(), e);
		}

		return mv;

	}

	/**
	 * Cuando se utiliza este método es porque occurio una acción en el boton
	 * "Guardar" y la acción que se realizar es validar si los campos son no
	 * estan vacios y al no estar va al bussines para guardar el registro
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return mv
	 */

	@RequestMapping(value = "ingresarConstante.do")
	public ModelAndView ingresarRegistro(@ModelAttribute(value = "constanteForm") ConstanteForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CONSTANTE_DETALLE);

		try {

			constanteValidator.validate(formulario, validarForm);
			if (!validarForm.hasErrors()) {
				formulario.getConstanteTO().setCodUsuarioA(15);
				formulario.getConstanteDetalleTO().setEstado("A");
				constanteBusiness.insertarConstante(formulario.getConstanteDetalleTO());
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));
				formulario.setConstanteDetalleTO(new ConstanteTO());
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv = new ModelAndView(PAGINA_CONSTANTE_DETALLE);
			String error = e.getCause().getLocalizedMessage();

			if (error.contains("IDX_EVC_MAE_CONSTANTE_1")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquenombre", request));
			} else if (error.contains("PK_EVA_MAE_CONSTANTE")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			}
		}

		return mv;

	}
}