package cl.clarochile.aplicaciones.evalcrediticia.controller;

import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cl.claro.actualList.ActualListWS;
import cl.claro.actualList.ConceptoType;
import cl.claro.actualList.ListasType;
import cl.claro.actualList.RequestType;
import cl.claro.actualList.ResponseType;
import cl.clarochile.aplicaciones.evalcrediticia.business.CampoBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.ListaEspecialBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.ListaEspecialForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ListaEspecialTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;
import cl.clarochile.aplicaciones.evalcrediticia.validador.ListaEspecialValidator;

/**
 * Esta clase controller interactua con la clase Business , para que las
 * pantallas reciban los respectivos datos dependiendo una funcion determinada,
 * y con la clase validator para validar los campos de los formularios.
 * 
 * @author Christian Camilo Hincapié Monsalve christian.hincapiemonsalve@tcs.com
 * @since 20/03/2013
 * @version 1.0
 */

@Controller
public class ListaEspecialController {

	static private Logger logger = Logger.getLogger(ListaEspecialController.class);

	@Autowired
	public ListaEspecialBusiness listaEspecialBusiness;
	@Autowired
	public ListaEspecialValidator listaEspecialValidator;
	@Autowired
	public CampoBusiness campoBusiness;

	static public Service service;

	String PAGINA_LISTAESPECIAL_LISTAR = "secure/listaEspecial/listarListaEspecial";
	String PAGINA_LISTAESPECIAL_DETALLE = "secure/listaEspecial/detalleListaEspecial";

	public ListaEspecialController() throws MalformedURLException {

	}

	/**
	 * En el momento de ubicarse en la página "Listas Especiales" este metodo
	 * muestra el formulario principal
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "mostrarPaginaListaEspecial.do", method = RequestMethod.GET)
	public ModelAndView mostrarFormListaEspecial(@ModelAttribute ListaEspecialForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_LISTAESPECIAL_LISTAR, "model", model);

		try {

			if (cargarCombo().get("Concepto").isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, "No hay conceptos configurados");
			}

			formulario.setComboConcepto(cargarCombo().get("Concepto"));
		} catch (Exception ex) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al consultar los conceptos");
			logger.error(ex.getMessage(), ex);
		}

		try {
			formulario.setResultados((ArrayList<ListaEspecialTO>) listaEspecialBusiness.listarListasEspeciales((formulario.getListaEspecialTO())));

		} catch (WebServiceException e1) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error en el WS de conceptos " + e1.getMessage());
			logger.error(e1.getMessage(), e1);

		} catch (Exception e1) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al consultar los conceptos");
			logger.error(e1.getMessage(), e1);
		}

		formulario.setComboConsulta(cargarListaConsulta());
		formulario.setComboResultado(cargarListaConsulta());//jamj
		return mv;
	}

	/**
	 * En el momento de ubicarse en la página "Listas Especiales" este método
	 * muestra el formulario para editar una nueva lista Especial
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "editarListaEspecial.do")
	public ModelAndView cargarPaginaEditarListaEspecial(

	@ModelAttribute ListaEspecialForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_LISTAESPECIAL_DETALLE);

		try {

			HashMap<String, ArrayList> combos = cargarCombo();

			formulario.setListaEspecialDetalleTO(listaEspecialBusiness.obtenerListaEspecialPorCodigo(formulario.getListaEspecialDetalleTO()));

			if (combos.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, "No hay conceptos configurados");
			}

			formulario.setComboConcepto(combos.get("Concepto"));
			formulario.setComboConsulta(cargarListaConsulta());
			formulario.setComboResultado(cargarListaConsulta());//jamj

			String code = formulario.getListaEspecialDetalleTO().getValorConcepto();

			formulario.setComboLista((ArrayList<ListasType>) combos.get(code));

			model.addAttribute(formulario);
			mv.addObject(Constantes.HASID, formulario.getListaEspecialDetalleTO().getNombreListaEspecial());
		} catch (Exception e) {
			mv = new ModelAndView(PAGINA_LISTAESPECIAL_LISTAR);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
			logger.error(e.getMessage(), e);

		}

		return mv;
	}

	/**
	 * En el momento de ubicarse en la página "Listas Especiales" este método
	 * muestra el formulario para ingresar una nueva lista Especial
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "nuevaListaEspecial.do")
	public ModelAndView cargarPaginaNuevaListaEspecial(@ModelAttribute ListaEspecialForm formulario, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_LISTAESPECIAL_DETALLE, "model", model);

		try {
			formulario.setComboConcepto(cargarCombo().get("Concepto"));
		} catch (WebServiceException e1) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error en el WS de conceptos " + e1.getMessage());
			logger.error(e1.getMessage(), e1);

		} catch (Exception e1) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al consultar los conceptos");
			logger.error(e1.getMessage(), e1);

		}

		formulario.setListaEspecialDetalleTO(new ListaEspecialTO());
		formulario.setComboConsulta(cargarListaConsulta());
		formulario.setComboResultado(cargarListaConsulta());//jamj
		return mv;
	}

	/**
	 * En el momento de ubicarse en la página "Listas Especiales" lista los
	 * registros de acuerdo a la lista Especial
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listarListasEspeciales.do")
	public ModelAndView mostrarListasEspeciales(@ModelAttribute ListaEspecialForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_LISTAESPECIAL_LISTAR);
		ArrayList<ListaEspecialTO> listListasEspeciales = new ArrayList<ListaEspecialTO>();

		try {
			formulario.setComboConcepto(cargarCombo().get("Concepto"));
		} catch (WebServiceException e1) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error en el WS de conceptos " + e1.getMessage());
			logger.error(e1.getMessage(), e1);

		} catch (Exception e1) {
			mv.addObject(Constantes.MENSAJE_ERROR, "Error al consultar los conceptos");
			logger.error(e1.getMessage(), e1);

		}

		formulario.setComboConsulta(cargarListaConsulta());
		formulario.setComboResultado(cargarListaConsulta());//jamj

		try {

			listListasEspeciales = (ArrayList<ListaEspecialTO>) listaEspecialBusiness.listarListasEspeciales((formulario.getListaEspecialTO()));
			if (listListasEspeciales.isEmpty()) {

				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));

			} else {
				formulario.setResultados(listListasEspeciales);
				if (!StringUtil.isEmpty(formulario.getListaEspecialDetalleTO().getNombreListaEspecial())) {
					formulario.getListaEspecialTO().setNombreListaEspecial("");
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));

		}

		return mv;
	}

	/**
	 * En el momento de ubicarse en la página "Listas Especiales" este método
	 * permite crear un registro de lista Especial
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "ingresarListaEspecial.do", method = RequestMethod.POST)
	public ModelAndView ingresarListaEspecial(@ModelAttribute ListaEspecialForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mw = new ModelAndView(PAGINA_LISTAESPECIAL_DETALLE);
		try {

			listaEspecialValidator.validate(formulario, validarForm);

			if (!validarForm.hasErrors()) {
				formulario.getListaEspecialDetalleTO().setCodUsuarioAlta(22);
				listaEspecialBusiness.InsertarListaEspecial(formulario.getListaEspecialDetalleTO());
				mw.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.ingresar.exito", request));
				formulario.setListaEspecialDetalleTO(new ListaEspecialTO());
			}
		} catch (Exception e) {

			mw = new ModelAndView(PAGINA_LISTAESPECIAL_DETALLE);
			String error = e.getCause().getLocalizedMessage();
			if (error.contains("UK_SNCA_MAE_TIPO_ALERTAS")) {
				mw.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			} else if (error.contains("FK_EVC_MAE_LISTAESPECIALES_1")) {
				mw.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			} else {
				mw.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			}
		}

		try {
			formulario.setComboConcepto(cargarCombo().get("Concepto"));
			formulario.setComboConsulta(cargarListaConsulta());
			formulario.setComboResultado(cargarListaConsulta());//jamj
		} catch (WebServiceException e1) {
			mw.addObject(Constantes.MENSAJE_ERROR, "Error en el WS de conceptos " + e1.getMessage());
			logger.error(e1.getMessage(), e1);

		} catch (Exception e1) {
			mw.addObject(Constantes.MENSAJE_ERROR, "Error al consultar los conceptos");
			logger.error(e1.getMessage(), e1);

		}

		return mw;
	}

	/**
	 * En el momento de ubicarse en la página "Listas Especiales" este método
	 * modificar una listas Especial que ya este registrada
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@RequestMapping(value = "actualizarListaEspecial.do")
	public ModelAndView actualizarListaEspecial(@ModelAttribute(value = "listaEspecialForm") ListaEspecialForm formulario, BindingResult validarForm, HttpServletRequest request, Model model) {

		ModelAndView mv = new ModelAndView(PAGINA_LISTAESPECIAL_LISTAR);

		try {
			listaEspecialValidator.validate(formulario, validarForm);
			if (!validarForm.hasErrors()) {
				formulario.getListaEspecialDetalleTO().setCodUsuarioMod(21);
				listaEspecialBusiness.ActualizarListaEspecial(formulario.getListaEspecialDetalleTO());
				mv = mostrarListasEspeciales(formulario, request, model);
				mv.addObject(Constantes.MENSAJE_EXITO, Mensajes.recuperarMensaje("general.mensaje.actualizar.exito", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			mv = new ModelAndView(PAGINA_LISTAESPECIAL_DETALLE);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.actualizar.error", request));
		}

		return mv;

	}

	/**
	 * En el momento de ubicarse en la página "Lista Especiales" este método nos
	 * ayudara a llevar el resultado de una busqueda que realicemos
	 * 
	 * @param formulario
	 * @param request
	 * @param model
	 * @return mv
	 */

	@RequestMapping(value = "exportarLisExcel.do")
	public ModelAndView exportarConsulta(@ModelAttribute ListaEspecialForm formulario, HttpServletRequest request, HttpServletResponse response, Model model) {

		ModelAndView mv = null;
		try {
			HSSFWorkbook libro = listaEspecialBusiness.generarReporte(formulario);
			if (libro != null) {
				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + "Reporte Listas Especiales" + ".xls\"");
				OutputStream output = response.getOutputStream();
				libro.write(output);
				output.flush();
				output.close();
			} else {
				mv = new ModelAndView(PAGINA_LISTAESPECIAL_LISTAR, "model", model);
				mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.exportar.error", request));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	public HashMap<String, ArrayList> cargarCombo() throws Exception, WebServiceException {

		ResponseType responseType = null;
		RequestType requestType = new RequestType();
		requestType.setIdTransaccion("1");
		HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
		try {

			try {
				responseType = getActualListPort().list(requestType);
			} catch (javax.xml.ws.WebServiceException e) {
				throw new WebServiceException("Error al tratar de conectarse con el servicio, este no está disponible", e);
			}

			ArrayList<ConceptoType> conceptoTypes = (ArrayList<ConceptoType>) responseType.getConcepto();
			ArrayList<ListasType> listaType = null;

			for (ConceptoType conceptoType : conceptoTypes) {
				listaType = new ArrayList<ListasType>();
				for (ListasType list : conceptoType.getListas()) {
					listaType.add(list);
				}
				map.put(String.valueOf(conceptoType.getIdConcepto()), listaType);
			}

			map.put("Concepto", conceptoTypes);
		} catch (WebServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cargarComboTipoLista.do", method = RequestMethod.GET)
	public ModelAndView mostrarCargarCombo(HttpServletRequest request, HttpServletResponse response, Model model) {

		RequestType requestType = new RequestType();
		requestType.setIdTransaccion("1");
		String concepto = request.getParameter("concepto");
		JSONArray jsonArray = null;
		try {
			HashMap<String, ArrayList> mapR = cargarCombo();
			ArrayList<ListasType> listType = (ArrayList<ListasType>) mapR.get(concepto);
			jsonArray = new JSONArray();
			for (ListasType listaF : listType) {
				JSONObject json = new JSONObject();
				json.put("codigo", listaF.getIdLista());
				json.put("nombre", listaF.getNombreLista());
				jsonArray.add(json);
			}
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			jsonArray = new JSONArray();
			logger.error(e.getMessage(), e);

		}
		return null;
	}

	public ArrayList<CampoTO> cargarListaConsulta() {

		ArrayList<CampoTO> lista = null;
		try {
			CampoTO campo = new CampoTO();
			campo.setTipoCampo("E");
			lista = (ArrayList<CampoTO>) campoBusiness.listarCampos(campo);
		} catch (Exception e) {
			lista = new ArrayList<CampoTO>();
			logger.error(e.getMessage(), e);

		}
		return lista;
	}

	public ArrayList<CampoTO> cargarListaResultado() {

		ArrayList<CampoTO> lista = null;
		try {
			CampoTO campo = new CampoTO();
			campo.setTipoCampo("S");
			lista = (ArrayList<CampoTO>) campoBusiness.listarCampos(campo);
		} catch (Exception e) {
			lista = new ArrayList<CampoTO>();
			logger.error(e.getMessage(), e);

		}
		return lista;
	}

	static public ActualListWS getActualListPort() throws MalformedURLException, WebServiceException {

		if (service == null) {
			try {
				URL url_wsdl = new URL("http://10.38.13.9:17011/ActualListWS/ActualList?wsdl");
				service = Service.create(url_wsdl, new QName("http://claro.cl/ActualList", "ActualList"));
			} catch (WebServiceException ex) {
				logger.error(ex.getMessage(), ex);
				throw ex;
			}
		}

		ActualListWS port = service.getPort(ActualListWS.class);

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://10.38.13.9:17011/ActualListWS/ActualList");

		return port;
	}
}