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
import org.springframework.web.servlet.ModelAndView;
import cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.DominioForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.validador.DominioValidator;

/**
 * Esta clase controller interactua con las clase Business , para que las
 * pantallas reciban los respectivos datos dependiendo una funcion determinada y
 * realice operaciones en la base de datos, y con la clase validator para
 * validar los campos de los formularios (jsp).
 * 
 * 
 * @author Jeisson Ruiz Cardenas jeisson.ruizcardenas@tcs.com
 * @since 13/03/2013
 * @version 1.0
 */
@Controller
public class DominioController {

	static private Logger logger = Logger.getLogger(DominioController.class);	
	
	@Autowired
	private DominioBusiness business;

	@Autowired
	private DominioValidator validador;

	String PAGINA_DOMINIO_LISTAR = "secure/dominio/listarDominio";
	String PAGINA_DOMINIO_DETALLE = "secure/dominio/detalleDominio";

	/**
	 * La accion mostrarPaginaDominio.do es la que le permite al usuario
	 * dirigirge a el menú de administración de dominios.
	 * 
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "mostrarPaginaDominio.do")
	public ModelAndView mostrarFormDominio(HttpServletRequest request, Model model) {

		DominioForm formulario = new DominioForm();
		
		ModelAndView mv = null;
		model.addAttribute(formulario);
		mv = new ModelAndView(PAGINA_DOMINIO_LISTAR, "model", model);

		try {
			formulario.setResultados((ArrayList<DominioTO>) business.buscarDominioPorCampos(formulario.getDominioTO()));
		} catch (Exception e) {			
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
			logger.error(e.getMessage(), e);
		}
		
		return mv;
	}

	/**
	 * La accion nuevoDominio.do es la que le permite al usuario dirigirge a el
	 * formulario donde se registra un nuevo dominio.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model
	 * @return ModelAndView
	 * @throws Exception
	 */

	@RequestMapping(value = "nuevoDominio.do")
	public ModelAndView mostrarFormNuevoDominio(@ModelAttribute DominioForm formulario, HttpServletRequest request, Model model) {

		model.addAttribute(new DominioForm());
		ModelAndView mv = new ModelAndView(PAGINA_DOMINIO_DETALLE, "model", model);
		mv.addObject(Constantes.HASID, "");

		return mv;
	}

	/**
	 * La accion listarDominios.do es la que le permite listar los dominios en
	 * los formularios (jsp).
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model, DominioForm
	 * @return ModelAndView
	 */
	@RequestMapping(value = "listarDominios.do")
	public ModelAndView mostrarDominios(@ModelAttribute DominioForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_DOMINIO_LISTAR);
		ArrayList<DominioTO> lstDominios = new ArrayList<DominioTO>();

		try {

			lstDominios = (ArrayList<DominioTO>) business.buscarDominioPorCampos(formulario.getDominioTO());

			if (lstDominios.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("general.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(lstDominios);
				if (!(formulario.getDominioDetalleTO().getCodigo()==0)) {
					formulario.getDominioTO().setCodigo(0);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}

		return mv;
	}

	/**
	 * La accion buscarPorCampos.do es la que le permite obtener los dominios
	 * por filtro de campos en los formularios (jsp).
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model, DominioForm
	 * @return ModelAndView
	 */
	@RequestMapping(value = "buscarPorCampos.do")
	public ModelAndView buscarPorCampos(@ModelAttribute DominioForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_DOMINIO_LISTAR);
		ArrayList<DominioTO> lstDominios = new ArrayList<DominioTO>();

		try {
			lstDominios = (ArrayList<DominioTO>) business.buscarDominioPorCampos(formulario.getDominioTO());

			if (lstDominios.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("general.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(lstDominios);
				if (!(formulario.getDominioDetalleTO().getCodigo()==0)) {
					formulario.getDominioTO().setCodigo(0);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);			
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}

		return mv;
	}

	/**
	 * La accion ingresarDominio.do es la que me permite almacenar un registro
	 * dominio en la base de datos.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model, DominioForm, BindingResult
	 * @return ModelAndView
	 */
	@RequestMapping(value = "ingresarDominio.do")
	public ModelAndView ingresarRegistro(@ModelAttribute DominioForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_DOMINIO_DETALLE);

		try {
			validador.validate(formulario, validarForm);

			if (!validarForm.hasErrors()) {
				formulario.getDominioDetalleTO().setUsuarioCreacion("01");
				business.insertarDominio(formulario.getDominioDetalleTO());
				formulario.setDominioTO(new DominioTO());
				formulario.setDominioDetalleTO(new DominioTO());
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String error = e.getCause().getLocalizedMessage();
			mv = new ModelAndView(PAGINA_DOMINIO_DETALLE);

			if (error.contains("ORA-00001")) {
				if (error.contains("PK_EVC_MAE_DOMINIO")) {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
				} else if (error.contains("IDX_EVC_MAE_DOMINIO_1")) {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquenombre", request));
				}
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			}
		}

		return mv;
	}

	/**
	 * La accion editarDominio.do es la que me permite almacenar un registro
	 * dominio en la base de datos.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model, DominioForm
	 * @return ModelAndView
	 */
	@RequestMapping(value = "editarDominio.do")
	public ModelAndView cargarPaginaEditarRegistro(@ModelAttribute DominioForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_DOMINIO_DETALLE);

		try {
			formulario.setDominioDetalleTO(business.obtenerDominioPorCodigo(formulario.getDominioDetalleTO()));
			formulario.setDominioTO(formulario.getDominioDetalleTO());
			model.addAttribute(formulario);
			mv.addObject(Constantes.HASID, formulario.getDominioDetalleTO().getCodigo());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv = new ModelAndView(PAGINA_DOMINIO_LISTAR);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
		}

		return mv;

	}

	/**
	 * La accion modificarDominio.do es la que me permite modificar un registro
	 * dominio en la base de datos.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model, DominioForm, BindingResult
	 * @return ModelAndView
	 */
	@RequestMapping(value = "modificarDominio.do")
	public ModelAndView modificarRegistro(@ModelAttribute DominioForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_DOMINIO_DETALLE);

		try {
			validador.validate(formulario, validarForm);

			if (!validarForm.hasErrors()) {

				formulario.getDominioDetalleTO().setUsuarioModificacion("3");
				business.actualizarDominio(formulario.getDominioDetalleTO());
				formulario.getDominioTO().setCodigo(formulario.getDominioDetalleTO().getCodigo());
				formulario.setDominioTO(business.obtenerDominioPorCodigo(formulario.getDominioDetalleTO()));				
				mv = buscarPorCampos(formulario, request, model);				
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));
			} else {
				mv.addObject(Constantes.HASID, formulario.getDominioDetalleTO().getCodigo());
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv = new ModelAndView(PAGINA_DOMINIO_DETALLE);
			String error = e.getCause().getLocalizedMessage();

			if (error.contains("PK_EVC_MAE_DOMINIO")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			}
		}

		return mv;
	}

	/**
	 * La acción exportarReporte.do s la que permite generar un reporte de los
	 * datos mostrados por pantalla.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @param HttpServletRequest
	 *            , Model, DominioForm, BindingResult
	 * @return
	 */

	@RequestMapping(value = "exportarDomExcel.do")
	public ModelAndView exportarConsulta(@ModelAttribute DominioForm formulario, HttpServletRequest request, HttpServletResponse response, Model model) {

		ModelAndView mv = null;
		try {
			HSSFWorkbook libro = business.generarReporte(formulario);
			if (libro != null) {
				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + "Reporte Dominios" + ".xls\"");
				OutputStream output = response.getOutputStream();
				libro.write(output);
				output.flush();
				output.close();
			} else {
				mv = new ModelAndView(PAGINA_DOMINIO_LISTAR, "model", model);
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.exportar.error", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return mv;
	}
}
