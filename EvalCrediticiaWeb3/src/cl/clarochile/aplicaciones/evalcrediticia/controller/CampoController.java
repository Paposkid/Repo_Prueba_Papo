package cl.clarochile.aplicaciones.evalcrediticia.controller;

import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.clarochile.aplicaciones.evalcrediticia.business.CampoBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.TipoReglaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.CampoForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.TipoReglaTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;
import cl.clarochile.aplicaciones.evalcrediticia.validador.CampoValidator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * CampoController es una clase que permite el control entre el la pantalla del
 * formulario y campoBusiness con la base de datos
 * 
 * 
 * @author Johann Esteban Hernández [johann.hernandezavalo@tcs.com]
 * @since 03/18/2013
 * @version 1.0
 */
@Controller
public class CampoController {

	static private Logger logger = Logger.getLogger(CampoController.class);		
	
	@Autowired
	private CampoBusiness campoBusiness;

	@Autowired
	private CampoValidator campoValidator;

	@Autowired
	private TipoReglaBusiness tipoReglaBusiness;

	String PAGINA_CAMPO_LISTAR = "secure/campo/listarCampo";
	String PAGINA_CAMPO_DETALLE = "secure/campo/detalleCampo";

	/**
	 * mostrarFormCampo es un proceso del mapeo mostrarPaginaCampo.do que
	 * permite mostrar la página de campos
	 * 
	 * @param request
	 * @param model
	 * @return mv
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "mostrarPaginaCampo.do")
	public ModelAndView mostrarFormCampo(@ModelAttribute CampoForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CAMPO_LISTAR, "model", model);
		
		try {
			formulario.setLista(cargarLista());
			formulario.setResultados(new ArrayList(campoBusiness.listarCampos(new CampoTO())));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al consultar los Campos");	
		}
		
		model.addAttribute(formulario);
		
		return mv;
	}

	/**
	 * mostrarCampo es un proceso del mapeo listarCampo.do que permite listar
	 * los campos del filtro
	 * 
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "listarCampo.do")
	public ModelAndView mostrarCampo(@ModelAttribute CampoForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CAMPO_LISTAR);
		ArrayList<CampoTO> listaCampos = new ArrayList<CampoTO>();
		try {
			formulario.setLista(cargarLista());
			listaCampos = (ArrayList<CampoTO>) campoBusiness.listarCampos(formulario.getCampoTO());
			
			if (listaCampos.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(listaCampos);
				if (!StringUtil.isEmpty(formulario.getCampoDetalleTO().getCodigoCampo())) {
					formulario.getCampoTO().setCodigoCampo("");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}
		return mv;
	}

	/**
	 * mostrarFormNuevoCampo es un proceso del mapeo nuevoCampo.do que permite
	 * ingresar los campos de la pantalla del formulario
	 * 
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "nuevoCampo.do")
	public ModelAndView mostrarFormNuevoCampo(@ModelAttribute CampoForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CAMPO_DETALLE, "model", model);
		formulario.setCampoDetalleTO(new CampoTO());
		formulario.setLista(cargarLista());
		mv.addObject(Constantes.HASID, "");
		return mv;
	}

	/**
	 * ingresarCampo es un proceso del mapeo ingresarCampo.do que permite enviar
	 * los ingresos de los campos del formulario al campoBusiness
	 * 
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "ingresarCampo.do", method = RequestMethod.POST)
	public ModelAndView ingresarCampo(@ModelAttribute(value = "campoForm") CampoForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CAMPO_DETALLE);
		try {
			campoValidator.validate(formulario, validarForm);
			formulario.setLista(cargarLista());
			if (!validarForm.hasErrors()) {
				formulario.getCampoDetalleTO().setCodigoUsuarioAlta(111);
				formulario.getCampoDetalleTO().setEstado("A");
				campoBusiness.insertarCampo(formulario.getCampoDetalleTO());
				formulario.getCampoTO().setCodigoCampo(formulario.getCampoDetalleTO().getCodigoCampo());
				mv = mostrarCampo(formulario, request, model);
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String error = e.getCause().getLocalizedMessage();
			mv = new ModelAndView(PAGINA_CAMPO_DETALLE);

			if (error.contains("IDX_EVC_MAE_CAMPO_1")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquenombre", request));
			} else if (error.contains("PK_EVC_MAE_CAMPO")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			}
		}
		return mv;
	}

	/**
	 * EditarFormCampo es un proceso del mapeo editarCampo.do que permite editar
	 * los campos de la pantalla del formulario
	 * 
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "editarCampo.do")
	public ModelAndView EditarFormCampo(@ModelAttribute CampoForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CAMPO_DETALLE);

		try {
			formulario.setLista(cargarLista());
			formulario.setCampoDetalleTO(campoBusiness.obtenerCampoPorCodigo(formulario.getCampoDetalleTO()));
			model.addAttribute(formulario);
			mv.addObject(Constantes.HASID, formulario.getCampoDetalleTO().getCodigoCampo());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv = new ModelAndView(PAGINA_CAMPO_LISTAR);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
		}

		return mv;

	}

	/**
	 * actualizarCampo es un proceso del mapeo actualizarCampo.do que permite
	 * enviar las actualizaciones de los campos del formulario al campoBusiness
	 * 
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "actualizarCampo.do", method = RequestMethod.POST)
	public ModelAndView actualizarCampo(@ModelAttribute(value = "campoForm") CampoForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CAMPO_LISTAR);
		try {
			campoValidator.validate(formulario, validarForm);
			formulario.setLista(cargarLista());
			if (!validarForm.hasErrors()) {
				formulario.getCampoDetalleTO().setCodigoUsuario(222);
				formulario.getCampoDetalleTO().setEstado("A");
				campoBusiness.actualizarCampo(formulario.getCampoDetalleTO());
				formulario.getCampoTO().setCodigoCampo(formulario.getCampoDetalleTO().getCodigoCampo());
				mv = mostrarCampo(formulario, request, model);
				formulario.setCampoTO(new CampoTO());
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));
			} else {
				mv = new ModelAndView(PAGINA_CAMPO_DETALLE);
				mv.addObject(Constantes.HASID, formulario.getCampoDetalleTO().getCodigoCampo());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.HASID, formulario.getCampoDetalleTO().getCodigoCampo());
			mv = new ModelAndView(PAGINA_CAMPO_DETALLE);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
		}

		return mv;

	}

	/**
	 * exportarConsulta es un proceso del mapeo exportarExcel.do que permite
	 * enviar el reporte de los campos del formulario al campoBusiness en excel
	 * 
	 * 
	 * @param formulario
	 * @param response
	 * @param request
	 * @param model
	 * @return mv
	 */
	@RequestMapping(value = "exportarCampExcel.do")
	public ModelAndView exportarConsulta(@ModelAttribute CampoForm formulario, HttpServletRequest request, HttpServletResponse response, Model model) {

		ModelAndView mv = null;
		try {
			HSSFWorkbook libro = campoBusiness.generarReporte(formulario);
			if (libro != null) {
				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + "Reporte Campos" + ".xls\"");
				OutputStream output = response.getOutputStream();
				libro.write(output);
				output.flush();
				output.close();
			} else {
				mv = new ModelAndView(PAGINA_CAMPO_LISTAR, "model", model);
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return mv;
	}

	public ArrayList<TipoReglaTO> cargarLista() {

		ArrayList<TipoReglaTO> lista = null;
		try {
			lista = (ArrayList<TipoReglaTO>) tipoReglaBusiness.listarTipoReglas(new TipoReglaTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			lista = new ArrayList<TipoReglaTO>();
		}
		return lista;
	}
}
