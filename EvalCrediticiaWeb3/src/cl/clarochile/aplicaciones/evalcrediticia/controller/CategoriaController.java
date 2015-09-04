package cl.clarochile.aplicaciones.evalcrediticia.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cl.clarochile.aplicaciones.evalcrediticia.business.CampoBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.DominioBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.DominioCategoriaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.CategoriaForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioCategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;
import cl.clarochile.aplicaciones.evalcrediticia.util.Validador;

/**
 * Esta clase CategoriaController interactua con las clase Business , para que
 * las pantallas reciban los respectivos datos dependiendo de cada funcion y
 * realiza las operaciones en la base de datos, ademas con la clase validator
 * que que se usa para validar los campos de los formularios (jsp)
 * DetalleCategoria y ListarCategoria.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
@Controller
public class CategoriaController {

	static private Logger logger = Logger.getLogger(CategoriaController.class);		
	
	@Autowired
	private CategoriaBusiness categoriaBusiness;
	@Autowired
	private DominioCategoriaBusiness dominioCategoriaBusiness;
	@Autowired
	private DominioBusiness dominioBusiness;
	@Autowired
	private CampoBusiness campoBusiness;

	String PAGINA_CATEGORIA_LISTAR = "secure/categoria/listarCategoria";
	String PAGINA_CATEGORIA_DETALLE = "secure/categoria/detalleCategoria";

	/**
	 * La accion mostarPaginaCategoria.do redirige al usuario a el menú de
	 * administración de categoria.
	 * 
	 * @param HttpServletRequest
	 *            , Model
	 * @param request
	 * @param model
	 * @return ModelAndView
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "mostarPaginaCategoria.do")
	public ModelAndView mostrarFormCategoria(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		formulario.setCambioPantalla(0);
		model.addAttribute(formulario);
		try {
			formulario.setResultados(new ArrayList(categoriaBusiness.listarCategorias(formulario.getCategoriaTO())));
			mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR, "model", model);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return mv;

	}

	/**
	 ** La accion nuevoCategoria.do permite al usuario dirigirge a el formulario
	 * donde se registra una nueva categoria.
	 * 
	 * @param HttpServletRequest
	 *            , Model
	 * @return ModelAndView
	 * @throws Exception
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "nuevoCategoria.do")
	public ModelAndView mostrarFormNuevoCategoria(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		formulario.setCambioPantalla(1);
		ModelAndView mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE, "model", model);
		mv.addObject(Constantes.HASID, "");

		return mv;
	}

	/**
	 * La accion insertarCategoria.do permite almacenar un registro en la DB de
	 * una categoria y asociar un dominio en la base de datos.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "insertarCategoria.do")
	public ModelAndView mostrarFormInsertar(@ModelAttribute CategoriaForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);
		mv.addObject(Constantes.HASID, formulario.getCategoriaDetalleTO().getCodigoCategoria());
		mv.addObject("tipo", formulario.getCategoriaDetalleTO().getTipoCampo());

		try {

			if ( formulario.getDominioTO().getTipoDato() != null && !formulario.getDominioTO().getTipoDato().isEmpty()) {

				String[] dominios = formulario.getDominioTO().getTipoDato().split(",");

				for (String string : dominios) {

					if (!formulario.getDominios().contains(string)) {
						formulario.getDominios().add(string);
					} else {
						formulario.getDominios().clear();
						formulario.getDominios().addAll(Arrays.asList(dominios));
						throw new IllegalArgumentException("El dominio " + string + " se encuentra agregado mas de una vez.");
						
					}
				}

			}

			if (formulario.getCategoriaDetalleTO().getTipoCampo().equals("V") || formulario.getCategoriaDetalleTO().getTipoCampo().equals("L")) {
				// if (!(formulario.getDominioTO().getCodigo() == 0)) {
				formulario.getCategoriaDetalleTO().setCodigoUsuarioAlta(1);
				formulario.getCategoriaDetalleTO().setFechaAlta(new Date());
				categoriaBusiness.insertarCategoria(formulario.getCategoriaDetalleTO());

				agregarDominios(formulario);

				mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));

				
			} else {
				if ((!StringUtil.isEmpty(formulario.getCategoriaDetalleTO().getRangoDesde())) && (!StringUtil.isEmpty(formulario.getCategoriaDetalleTO().getRangoHasta()))) {
					formulario.getCategoriaDetalleTO().setCodigoUsuarioAlta(1);
					formulario.getCategoriaDetalleTO().setFechaAlta(new Date());
					categoriaBusiness.insertarCategoria(formulario.getCategoriaDetalleTO());
					// mv = mostrarFormCategoria(formulario, request, model);
					mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));

				} else {
					mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensajeRequerido", request));
				}
			}

			formulario.setCategoriaTO(new CategoriaTO());
			formulario.getDominios().clear();
			formulario.setDominioTO(new DominioTO());
			formulario.setCategoriaDetalleTO(new CategoriaTO());
			formulario.setDominioCategoriaTO(new DominioCategoriaTO());
			formulario.setDominioTO(new DominioTO());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);

			if (e.getCause() != null) {

				String error = e.getCause().getLocalizedMessage();
				if (error.contains("PK_EVC_MAE_CATEGORIA")) {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
				} else if (error.contains("IDX_EVC_MAE_CATEGORIA_1")) {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquenombre", request));
				} else {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
				}
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, e.getMessage());
			}
		}

		cargarForm(formulario, request, model);

		return mv;

	}

	private void agregarDominios(CategoriaForm formulario) throws NumberFormatException, Exception {

		String domin_ = formulario.getDominioTO().getTipoDato();

		if (!domin_.equals("-1") && (formulario.getDominios() == null || formulario.getDominios().isEmpty()) && (domin_ != null && !domin_.isEmpty())) {
			formulario.getDominios().addAll(Arrays.asList(domin_.split(",")));
			}

		if (!formulario.getDominios().isEmpty()) {

			for (String string : formulario.getDominios()) {
				if(string.equals("-1"))
					continue;
				
				string = string.trim();

				DominioCategoriaTO dominioCategoriaTO = new DominioCategoriaTO();
				dominioCategoriaTO.getCategoria().setCodigoCategoria(formulario.getCategoriaDetalleTO().getCodigoCategoria());
				dominioCategoriaTO.getDominioTO().setCodigo(Integer.parseInt(string));
				DominioTO dominio = dominioBusiness.obtenerDominioPorCodigo(new DominioTO(Integer.parseInt(string)));
				dominioCategoriaTO.setEstado(StringUtil.isEmpty(dominio.getEstado()) ? "A" : dominio.getEstado());
				dominioCategoriaTO.setcodUsuarioAlta(1);
				dominioCategoriaTO.setFechaAlta(new Date());
				formulario.getCategoriaDetalleTO().setCodigoCategoria(dominioCategoriaTO.getCategoria().getCodigoCategoria());
				dominioCategoriaBusiness.insertarDominioCategoria(dominioCategoriaTO);

				formulario.setDominioTO(new DominioTO());
				formulario.setDominioCategoriaTO(new DominioCategoriaTO());
			}
		}
	}

	/**
	 * La accion cargarCategoria.do permite cargar los dominios que tiene
	 * asociada una categoria en la base de datos.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "cargarCategoria.do")
	public ModelAndView mostrarFormCargarCategoria(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);
		ArrayList<DominioCategoriaTO> lstDominiosCate = new ArrayList<DominioCategoriaTO>();
		DominioCategoriaTO dominCate = new DominioCategoriaTO();

		try {
			dominCate.getCategoria().setCodigoCategoria(formulario.getCategoriaTO().getCodigoCategoria());
			lstDominiosCate = (ArrayList<DominioCategoriaTO>) dominioCategoriaBusiness.listarDominioCategorias(dominCate);
			if (lstDominiosCate.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultadosDomCat(lstDominiosCate);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}

		return mv;
	}

	/**
	 * La accion listarCategorias.do es la que permite listar las categorias en
	 * los formularios (jsp).
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "listarCategorias.do")
	public ModelAndView mostrarCategorias(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR);
		formulario.setCambioPantalla(0);
		ArrayList<CategoriaTO> lstCategorias = new ArrayList<CategoriaTO>();

		try {
				formulario.getCategoriaTO().setNombreCategoria(formulario.getCategoriaTO().getNombreCategoria().trim());
				

				lstCategorias = (ArrayList<CategoriaTO>) categoriaBusiness.listarCategorias(formulario.getCategoriaTO());
	
				if (lstCategorias.isEmpty()) {
					mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
				} else {
					formulario.setResultados(lstCategorias);
					if (!StringUtil.isEmpty(formulario.getCategoriaDetalleTO().getCodigoCategoria())) {
						formulario.getCategoriaTO().setCodigoCategoria("");
					}
				}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}
		
		cargarForm(formulario, request, model);

		return mv;
	}

	/**
	 * La accion listarDominioCategorias.do permite listar los dominios
	 * asociados a la categoria en los formularios (jsp).
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "listarDominioCategorias.do")
	public ModelAndView mostrarDominioCategorias(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);
		ArrayList<DominioCategoriaTO> lstCategorias = new ArrayList<DominioCategoriaTO>();
		DominioCategoriaTO dominCate = new DominioCategoriaTO();

		try {
			dominCate.getCategoria().setCodigoCategoria(formulario.getCategoriaDetalleTO().getCodigoCategoria());
			lstCategorias = (ArrayList<DominioCategoriaTO>) dominioCategoriaBusiness.listarDominioCategorias(dominCate);

			CampoTO to = new CampoTO();
			to.setCodigoCampo(formulario.getCategoriaDetalleTO().getCodigoCampo());
			to.setNombreCampo(formulario.getCategoriaDetalleTO().getNombreCampo());

			formulario.getListaComboCampo().add(to);

			if (lstCategorias.isEmpty() && formulario.getCategoriaDetalleTO().getTipoCategoria().equals("L")) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultadosDomCat(lstCategorias);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}

		return mv;
	}

	/**
	 * La accion eliminarDominioCategoria.do permite desasociar un dominio a una
	 * categoria en los formularios (jsp) y en DB.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "eliminarDominioCategoria.do")
	public ModelAndView mostrarFormEliminar(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		model.addAttribute(new CategoriaForm());
		mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE, "model", model);
		DominioCategoriaTO dominioCategoria = new DominioCategoriaTO();

		try {
			dominioCategoria.setCategoria(formulario.getCategoriaDetalleTO());
			dominioCategoria.setCodigo(formulario.getDominioCategoriaTO().getCodigo());
			dominioCategoria.setCodUsuario(1);
			dominioCategoriaBusiness.eliminarDominioCategoria(dominioCategoria);
			model.addAttribute(formulario);
			formulario.getCategoriaTO().setCodigoCategoria(formulario.getDominioCategoriaTO().getCategoria().getCodigoCategoria());
			formulario.setCategoriaDetalleTO(categoriaBusiness.obtenerCategoriaPorCodigo(formulario.getCategoriaTO()));
			mv = mostrarDominioCategorias(formulario, request, model);
			mv.addObject(Constantes.HASID, formulario.getCategoriaDetalleTO().getCodigoCategoria());
			mv.addObject("tipo", formulario.getCategoriaDetalleTO().getTipoCampo());
			mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.eliminar.exito", request));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.eliminar.error", request));
		}
		
		cargarForm(formulario, request, model);
		
		return mv;

	}

	/**
	 * La accion editarCategoria.do permite realizar cambios a una categoria
	 * pudiendo modificar un dominio tipo lista o rango en los formularios (jsp)
	 * y en DB.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "editarCategoria.do")
	public ModelAndView cargarPaginaEditarRegistro(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR);
		formulario.setCambioPantalla(0);

		try {

			formulario.setCategoriaDetalleTO(categoriaBusiness.obtenerCategoriaPorCodigo(formulario.getCategoriaDetalleTO()));
			formulario.setDominioTO(formulario.getDominioTO());
			mv = mostrarDominioCategorias(formulario, request, model);
			formulario.getResultadosDomCat();
			model.addAttribute(formulario);
			mv.addObject(Constantes.HASID, formulario.getCategoriaDetalleTO().getCodigoCategoria());
			mv.addObject("tipo", formulario.getCategoriaDetalleTO().getTipoCategoria());
			
			cargarForm(formulario, request, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.editar.error", request));
		}

		return mv;
	}

	/**
	 * La accion modificarCategoria.do permite realizar cambios a una categoria
	 * pudiendo modificar un dominio tipo lista o rango en los formularios (jsp)
	 * y en DB.
	 * 
	 * @param formulario
	 * @param validarForm
	 * @param request
	 * @param model
	 * @returnModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "modificarCategoria.do")
	public ModelAndView modificarRegistro(@ModelAttribute CategoriaForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR);
		mv.addObject(Constantes.HASID, formulario.getCategoriaDetalleTO().getCodigoCategoria());
		mv.addObject("tipo", formulario.getCategoriaDetalleTO().getTipoCategoria());
		DominioCategoriaTO dominioCategoriaTO = new DominioCategoriaTO();
		dominioCategoriaTO.getCategoria().setCodigoCategoria(formulario.getCategoriaDetalleTO().getCodigoCategoria());

		try {
			if (formulario.getCategoriaDetalleTO().getTipoCategoria().equals("V") || formulario.getCategoriaDetalleTO().getTipoCategoria().equals("L")) {

				if (!validarForm.hasErrors()) {
					formulario.getCategoriaDetalleTO().setCodigoUsuario(1);
					categoriaBusiness.actualizarCategoria(formulario.getCategoriaDetalleTO());
					formulario.setResultadosDomCat((ArrayList<DominioCategoriaTO>) dominioCategoriaBusiness.listarDominioCategorias(dominioCategoriaTO));
					agregarDominios(formulario);
					mv = mostrarCategorias(formulario,  request,  model);
					mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));

				} else {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
				}

			} else {
				if (formulario.getCategoriaDetalleTO().getTipoCategoria().equals("R")) {

					if ((!StringUtil.isEmpty(formulario.getCategoriaDetalleTO().getRangoDesde())) && (!StringUtil.isEmpty(formulario.getCategoriaDetalleTO().getRangoHasta()))) {

						categoriaBusiness.actualizarCategoria(formulario.getCategoriaDetalleTO());
						mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));

					} else {
						mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensajeRequerido", request));
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e.getCause() != null) {

				String error = e.getCause().getLocalizedMessage();

				if (error.contains("UK_SNCA_MAE_HORARIOS")) {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.uniquecodigo", request));
				} else {
					if (error.contains("to NULL")) {
						mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensajeRequerido", request));
					} else {
						mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
					}
				}
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, e.getMessage());
			}
		}

		mv.addObject(Constantes.HASID, formulario.getCategoriaDetalleTO().getCodigoCategoria());

		return mv;
	}

	/**
	 * La accion agregarNuevoDominio.do permite asociar un nuevo dominio a una
	 * categoria en los formularios (jsp) y en la DB.
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "agregarNuevoDominio.do")
	public ModelAndView mostrarFormInsertarDominio(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE);
		DominioCategoriaTO dominioCategoriaTO = new DominioCategoriaTO();
		dominioCategoriaTO.getCategoria().setCodigoCategoria(formulario.getCategoriaDetalleTO().getCodigoCategoria());

		try {
			formulario.setResultadosDomCat((ArrayList<DominioCategoriaTO>) dominioCategoriaBusiness.listarDominioCategorias(dominioCategoriaTO));
			mv.addObject(Constantes.HASID, formulario.getCategoriaDetalleTO().getCodigoCategoria());
			mv.addObject("tipo", formulario.getCategoriaDetalleTO().getTipoCampo());
			if (!(formulario.getDominioTO().getCodigo() == 0)) {

				if ((formulario.getCategoriaDetalleTO().getTipoCampo().equals("V") && formulario.getResultadosDomCat().size() < 1) || formulario.getCategoriaDetalleTO().getTipoCampo().equals("L")) {

					dominioCategoriaTO = new DominioCategoriaTO();
					dominioCategoriaTO.getCategoria().setCodigoCategoria(formulario.getCategoriaDetalleTO().getCodigoCategoria());
					dominioCategoriaTO.getDominioTO().setCodigo(formulario.getDominioTO().getCodigo());
					DominioTO dominio = dominioBusiness.obtenerDominioPorCodigo(formulario.getDominioTO());
					dominioCategoriaTO.setEstado(dominio.getEstado());
					dominioCategoriaTO.setcodUsuarioAlta(1);
					dominioCategoriaTO.setFechaAlta(new Date());

					dominioCategoriaTO.getCategoria().setCodigoCategoria(formulario.getCategoriaDetalleTO().getCodigoCategoria());

					dominioCategoriaBusiness.insertarDominioCategoria(dominioCategoriaTO);
					formulario.setResultadosDomCat((ArrayList<DominioCategoriaTO>) dominioCategoriaBusiness.listarDominioCategorias(dominioCategoriaTO));
					mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));

				} else {
					mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("error.dominio.maximo", request));
				}
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensajeRequerido", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String error = e.getCause().getLocalizedMessage();
			if (error.contains("IDX_EVC_REL_DOMINIOCATEG_1")) {
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.error.unique.dominio", request));
			} else {
				mv.addObject(Constantes.MENSAJE_ERROR, "error");
				logger.error(e.getMessage(), e);
			}
		}

		return mv;

	}

	/**
	 * Método que exporta a Excel la tabla de resultados de las categorias
	 * 
	 * @param formulario
	 * @param request
	 * @param response
	 * @param model
	 * @returnModelAndView
	 */
	@RequestMapping(value = "exportarCatExcel.do")
	public ModelAndView exportarConsulta(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, HttpServletResponse response, Model model) {

		ModelAndView mv = null;
		try {
			HSSFWorkbook libro = categoriaBusiness.generarReporte(formulario);
			if (libro != null) {
				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + "Reporte Categoria" + ".xls\"");
				OutputStream output = response.getOutputStream();
				libro.write(output);
				output.flush();
				output.close();
			} else {
				mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR, "model", model);
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
		}
		return mv;
	}

	@RequestMapping(value = "cargar.do")
	public ModelAndView cargarForm(@ModelAttribute CategoriaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		
		formulario.setListaComboCampo(cargarLista(formulario));
		
		formulario.setListaComboDominio(cargarListaDominio(formulario));
		
		if (formulario.getCambioPantalla() == 0) {
			mv = new ModelAndView(PAGINA_CATEGORIA_LISTAR, "model", model);
		} else {
			mv = new ModelAndView(PAGINA_CATEGORIA_DETALLE, "model", model);
		}

		return mv;
	}

	public ArrayList<CampoTO> cargarLista(CategoriaForm formulario) {

		ArrayList<CampoTO> lista = null;
		try {
				CampoTO campo = new CampoTO();
				campo.setTipoCampo(formulario.getTipo());
				lista = (ArrayList<CampoTO>) campoBusiness.listarCampos(campo);
				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			lista = new ArrayList<CampoTO>();
		}
		return lista;
	}
	

	public ArrayList<DominioTO> cargarListaDominio(CategoriaForm formulario) {

		ArrayList<DominioTO> lista = null;
		try {
			DominioTO dominio = new DominioTO();
			
			if (Validador.esNuloVacio(formulario.getTipo())) {
				dominio.setTipoCampo(formulario.getCategoriaDetalleTO().getTipoCampo());
			} else {
				dominio.setTipoCampo(formulario.getTipo());
			}
			lista = (ArrayList<DominioTO>) dominioBusiness.buscarDominioPorCampos(dominio);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			lista = new ArrayList<DominioTO>();
		}
		return lista;
	}

	public ModelAndView mostrarCargarCombo(HttpServletRequest request, HttpServletResponse response, Model model) {

		DominioTO dominio = new DominioTO();
		dominio.setTipoCampo(request.getParameter(""));
		JSONArray jsonArray = null;
		ArrayList<DominioTO> lista = null;
		try {
			lista = (ArrayList<DominioTO>) dominioBusiness.buscarDominioPorCampos(dominio);
			jsonArray = new JSONArray();
			for (DominioTO dom : lista) {
				JSONObject json = new JSONObject();
				json.put("codigo", dom.getCodigo());
				json.put("nombre", dom.getNombre());
				jsonArray.add(json);
			}
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonArray = new JSONArray();
		}
		return null;
	}

	
}