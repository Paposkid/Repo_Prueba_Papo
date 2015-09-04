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
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;
import cl.clarochile.aplicaciones.evalcrediticia.business.ParametroBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.ParametroForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ParametroTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.validador.ParametroValidator;

/**
 * Esta interfaz hace parte de la capa de la base de datos, donde estan todo los
 * métodos abstractos para manipular los datos de parametros en la base de
 * datos.
 * 
 * @author Carlos Andres Castrill0n [carlos.castrillonescobar@tcs.com]
 * @since 03/17/2013
 * @version 1.0
 */

@Controller
public class ParametroController {
	
	static private Logger logger = Logger.getLogger(ParametroController.class);		
	
	/**
	 * Atributo que inyecta la clase ParametroController para realizar la logica
	 * del negocio
	 */

	@Autowired
	private ParametroBusiness parametroBusiness;
	/**
	 * Atributo que inyecta la clase ParametroValidator para validar los
	 * atributos ingresados al front
	 */

	@Autowired
	private ParametroValidator parametroValidator;

	String PAGINA_PARAMETRO_LISTAR = "secure/parametro/listarParametro";
	String PAGINA_PARAMETRO_DETALLE = "secure/parametro/detalleParametro";

	/**
	 * Método que permite ir a la pantalla donde está ubicado la tabla que
	 * contiene todos los registros de los parametros y el formulario donde se
	 * puede filtrar Para encontrar el registro buscado.
	 * 
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "mostarPaginaParametro.do")
	public ModelAndView mostrarFormParametro(HttpServletRequest request, Model model) {
		
		ModelAndView mv = null;
		ParametroForm forma = new ParametroForm();
		mv = new ModelAndView(PAGINA_PARAMETRO_LISTAR, "model", model);
		model.addAttribute(forma);

		try {
			forma.setResultados((ArrayList<ParametroTO>) parametroBusiness.listarParametros(forma.getParametroTO()));
		} catch (Exception e) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al listar los parametros");
			logger.error(e.getMessage(), e);
		}

		return mv;
	}

	/**
	 * Cuando se utiliza este método es porque occurio una acción con el boton
	 * "Nuevo" y la acción que se realiza es ir la formulario donde se ingresa
	 * el registro de un parametro;
	 * 
	 * @param formulario
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "nuevoParametro.do")
	public ModelAndView mostrarFormNuevo(HttpServletRequest request, Model model) {
		ModelAndView mv = null;
		model.addAttribute(new ParametroForm());
		mv = new ModelAndView(PAGINA_PARAMETRO_DETALLE, "model", model);
		return mv;
	}

	/**
	 * Cuando se utiliza este método es porque occurio una acción en el boton
	 * "Guardar" y la acción que se realizar es validar si los campos son no
	 * estan vacios y al no estar va al bussines para guardar el registro
	 * vacios.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "insertarParametro.do")
	public ModelAndView mostrarFormInsertar(@ModelAttribute(value = "parametroForm") ParametroForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_PARAMETRO_DETALLE);

		try {
			parametroValidator.validate(formulario, validarForm);
			if (!validarForm.hasErrors()) {
				formulario.getParametroDetalleTO().setCodigoUsuarioAlta(999);
				formulario.getParametroDetalleTO().setEstadoParametro("A");
				parametroBusiness.insertarParametro(formulario.getParametroDetalleTO());
				formulario.setParametroTO(formulario.getParametroDetalleTO());
				formulario.setParametroDetalleTO(new ParametroTO());
				formulario.setParametroTO(new ParametroTO());
				//mv = mostrarFormParametro(formulario, request, model);
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String error = e.getCause().getLocalizedMessage();
			if (error.contains("PK_EVC_MAE_PARAMGLOBAL")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
			} else if (error.contains("IDX_EVC_MAE_PARAMGLOBAL_1")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquenombre", request));
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			}
		}
		return mv;
	}

	/**
	 * En el momento de ubicarse en la pagina "listarParametro.do" este método
	 * trae todos los registros de Parametros requeridos.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "listarParametro.do")
	public ModelAndView mostrarFormParametro(@ModelAttribute ParametroForm formulario, HttpServletRequest request, Model model) {
		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_PARAMETRO_LISTAR);
		ArrayList<ParametroTO> listaParametros = new ArrayList<ParametroTO>();
		try {

			String nombre = formulario.getParametroTO().getNombreParametro();
			String valor = formulario.getParametroTO().getValorParametro();

			if (nombre == null) {
				nombre = "";
			}

			if (valor == null) {
				valor = "";
			}

			formulario.getParametroTO().setNombreParametro(nombre.trim());
			formulario.getParametroTO().setValorParametro(valor.trim());

			listaParametros = (ArrayList<ParametroTO>) parametroBusiness.listarParametros(formulario.getParametroTO());
			if (listaParametros.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(listaParametros);
				if (!StringUtil.isEmpty(formulario.getParametroDetalleTO().getCodigoParametro())) {
					formulario.getParametroTO().setCodigoParametro("");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}
		return mv;
	}

	/**
	 * Cuando se utiliza este método es porque occurio una acción en el
	 * lapíz(imagen), en el momento de realizar esa acción, este método te lleva
	 * a la pantalla "detalleParametro" donde se podra actualizar el registro
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "editarParametro.do")
	public ModelAndView mostrarFormParametroEditar(@ModelAttribute ParametroForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_PARAMETRO_DETALLE);
		try {
			formulario.setParametroDetalleTO(parametroBusiness.buscarParametroPorCodigo(formulario.getParametroDetalleTO()));
			model.addAttribute(formulario);
			mv.addObject(Constantes.HASID, formulario.getParametroDetalleTO().getCodigoParametro());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
		}
		return mv;
	}

	/**
	 * Cuando se utiliza este método es que se va actualizar un regitro de
	 * parametros, al realizar la acción con el boton "Guardar" se valida los
	 * campos que no esten vacios y al no estarlo va al bussines para actualizar
	 * el registro.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "actualizarParametro.do", method = RequestMethod.POST)
	public ModelAndView actualizarParametro(@ModelAttribute(value = "parametroForm") ParametroForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_PARAMETRO_LISTAR);
		try {
			parametroValidator.validate(formulario, validarForm);
			if (!validarForm.hasErrors()) {
				formulario.getParametroDetalleTO().setCodigoUsuario(2222);
				formulario.getParametroDetalleTO().setEstadoParametro("A");
				parametroBusiness.actualizarParametro(formulario.getParametroDetalleTO());
				mv = new ModelAndView(PAGINA_PARAMETRO_LISTAR);
				mv = mostrarFormParametro(formulario, request, model);
				
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));
			} else {
				mv = new ModelAndView(PAGINA_PARAMETRO_DETALLE);
				mv.addObject(Constantes.HASID, formulario.getParametroDetalleTO().getCodigoParametro());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.HASID, formulario.getParametroDetalleTO().getCodigoParametro());
			mv = new ModelAndView(PAGINA_PARAMETRO_DETALLE);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
		}
		return mv;
	}

	/**
	 * Cuando se utiliza este método es que se va exportar a excel el resultado
	 * de la busqueda
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "exportarParExcel.do")
	public ModelAndView exportarConsulta(@ModelAttribute ParametroForm formulario, HttpServletRequest request, HttpServletResponse response, Model model) {

		ModelAndView mv = null;
		try {
			HSSFWorkbook libro = parametroBusiness.generarReporte(formulario);
			if (libro != null) {
				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + "Reporte Parametros" + ".xls\"");
				OutputStream output = response.getOutputStream();
				libro.write(output);
				output.flush();
				output.close();
			} else {
				mv = new ModelAndView(PAGINA_PARAMETRO_LISTAR, "model", model);
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.exportar.error ", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return mv;
	}

}