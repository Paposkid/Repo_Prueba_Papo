package cl.clarochile.aplicaciones.evalcrediticia.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cl.clarochile.aplicaciones.evalcrediticia.business.CampoBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.CategoriaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.CondicionBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.ConstanteBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.DominioCategoriaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.ReglaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.business.TipoReglaBusiness;
import cl.clarochile.aplicaciones.evalcrediticia.form.CampoForm;
import cl.clarochile.aplicaciones.evalcrediticia.form.ReglaForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CondicionTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioCategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ReglaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.TipoReglaTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Constantes;
import cl.clarochile.aplicaciones.evalcrediticia.util.Mensajes;
import cl.clarochile.aplicaciones.evalcrediticia.util.StringUtil;

@Controller
public class ReglaController {

	static private Logger logger = Logger.getLogger(ReglaController.class);

	@Autowired
	private TipoReglaBusiness tipoReglaBusiness;

	@Autowired
	private CategoriaBusiness categoriaBusiness;

	@Autowired
	private CampoBusiness campoBusiness;

	@Autowired
	private DominioCategoriaBusiness dominioCategoriaBusiness;

	@Autowired
	private ConstanteBusiness constanteBusinnes;

	@Autowired
	private ReglaBusiness reglaBusiness;

	@Autowired
	private CondicionBusiness condicionBusiness;

	String PAGINA_REGLA_LISTAR = "secure/regla/listarRegla";
	String PAGINA_REGLA_DETALLE = "secure/regla/detalleRegla";
	String PAGINA_CONDICION_REGLA = "secure/regla/condicionRegla";
	String PAGINA_CONDICION_REGLA_LOGICO = "secure/regla/condicionReglaLogico";
	String PAGINA_CONDICION_REGLA_SALIDA = "secure/regla/condicionReglaSalida";
	String PAGINA_CONDICION_RESULTADO_REGLA = "secure/regla/condicionResultado";

	@RequestMapping(value = "mostrarPaginaRegla.do")
	public ModelAndView mostrarFormRegla(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		try {
			mv = new ModelAndView(PAGINA_REGLA_LISTAR, "model", model);

			ArrayList lista = cargarLista();

			if (lista.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, "No hay tipos de reglas configuradas.");
			}

			List<ReglaTO> reglasList = reglaBusiness.buscarRegla(new ReglaTO());

			if (reglasList.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(new ArrayList(reglasList));
			}

			formulario.setListaComboRegla(lista);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			mv.addObject(Constantes.MENSAJE_ERROR, ex.getMessage());
		}

		return mv;
	}

	@RequestMapping(value = "mostrarPaginaDetalleRegla.do")
	public ModelAndView mostrarFormNuevaRegla(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		try {
			mv = new ModelAndView(PAGINA_REGLA_DETALLE, "model", model);

			ArrayList lista = cargarLista();

			if (lista.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, "No hay tipos de reglas configuradas.");
			}

			formulario.setListaComboRegla(lista);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			mv.addObject(Constantes.MENSAJE_ERROR, ex.getMessage());
		}

		return mv;
	}

	@RequestMapping(value = "mostrarPaginaCondicionRegla.do")
	public ModelAndView mostrarFormCondicionRegla(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		formulario.setPaginaEntrada(true);
		formulario.setPaginaSalida(false);
		formulario.setListaComboCampoEntrada(cargarListaCampos_E_S(formulario));
		formulario.setListaComboCategoria(cargarListaCategoria(formulario));
		formulario.setListaComboConstante(cargarListaConstante(formulario));
		mv = new ModelAndView(PAGINA_CONDICION_REGLA, "model", model);

		return mv;
	}

	@RequestMapping(value = "mostrarPaginaCondicionReglaLogico.do")
	public ModelAndView mostrarFormCondicionReglaLogico(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONDICION_REGLA_LOGICO, "model", model);
		formulario.setValorCondiciones(formulario.getCondicionTO().getValor());
		formulario.getCondicionTO().setValor("");
		formulario.setCondicionTO(new CondicionTO());
		for (String str : formulario.getCondiciones()) {
			if (!StringUtil.isEmpty(str)) {
				CondicionTO cond = new CondicionTO();
				cond.setValor(str);
				cond.setCodigo(str);
				formulario.getCargaCondiciones().add(cond);
			}
		}

		return mv;
	}

	@RequestMapping(value = "mostrarPaginaCondicionSalida.do")
	public ModelAndView mostrarFormCondicionSalida(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONDICION_REGLA_SALIDA, "model", model);
		formulario.setValorLogico(formulario.getCondicionLogicoTO().getValor());
		formulario.getCondicionLogicoTO().setValor("");
		formulario.setPaginaEntrada(false);
		formulario.setPaginaSalida(true);
		formulario.setListaComboCampoSalida(cargarListaCampos_E_S(formulario));
		formulario.setListaComboCategoria(cargarListaCategoria(formulario));

		return mv;
	}

	@RequestMapping(value = "mostrarPaginaResultado.do")
	public ModelAndView mostrarFormResultado(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONDICION_RESULTADO_REGLA, "model", model);
		String resultadoF = "";

		for (String str : formulario.getCondicionesSalida()) {
			if (!StringUtil.isEmpty(str)) {
				resultadoF = resultadoF + str + ";\n";
			}
		}

		String resultado = "IF (" + formulario.getValorLogico() + "){\n" + resultadoF + "\n}";
		formulario.setValorResultado(resultado);

		return mv;
	}

	@RequestMapping(value = "guardarRegla.do")
	public ModelAndView mostrarGuardarRegla(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_CONDICION_RESULTADO_REGLA, "model", model);
		try {
			ReglaTO regla = new ReglaTO();
			regla.setDescripcion(formulario.getReglaDetalleTO().getDescripcion());
			regla.setEstado(formulario.getReglaDetalleTO().getEstado());
			regla.setFechaAlta(new Date());
			regla.setFechaVigenciaDesde(formulario.getReglaDetalleTO().getFechaVigenciaDesde());
			regla.setFechaVigenciaHasta(formulario.getReglaDetalleTO().getFechaVigenciaHasta());
			regla.setNombre(formulario.getReglaDetalleTO().getNombre());
			regla.setSinVigencia(formulario.getReglaDetalleTO().getSinVigencia());
			regla.setSubtipoRegla(formulario.getReglaDetalleTO().getSubtipoRegla());
			regla.setTipoEvaluacion(formulario.getReglaDetalleTO().getTipoEvaluacion());
			regla.setUsuarioAlta("1234");
			regla.setValor(formulario.getValorResultado());
			reglaBusiness.insertarRegla(regla);

			CondicionTO condicion = new CondicionTO();
			condicion.setCampo(formulario.getCondicionTO().getCampo());
			condicion.setCategoria(formulario.getCondicionTO().getCategoria());
			condicion.setCodigo(null);
			condicion.setConstante(formulario.getCondicionTO().getConstante());
			condicion.setDominio(formulario.getCondicionTO().getDominio());
			condicion.setOperador(formulario.getCondicionTO().getOperador());
			condicion.setRegla(regla);
			condicionBusiness.insertarCondiciones(condicion);

		} catch (Exception e) {
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.ingresar.error", request));
			logger.error(e.getMessage(), e);
		}

		return mv;
	}

	@RequestMapping(value = "cargarComboDominio.do", method = RequestMethod.GET)
	public ModelAndView mostrarCargarCombo(HttpServletRequest request, HttpServletResponse response, Model model) {

		ArrayList<DominioCategoriaTO> lista = null;
		JSONArray jsonArray = null;
		try {
			DominioCategoriaTO cateDom = new DominioCategoriaTO();
			CategoriaTO cate = new CategoriaTO();
			cate.setCodigoCategoria(request.getParameter("categoria"));
			cateDom.setCategoria(cate);
			lista = (ArrayList<DominioCategoriaTO>) dominioCategoriaBusiness.listarDominioCategorias(cateDom);
			jsonArray = new JSONArray();
			for (DominioCategoriaTO listaF : lista) {
				JSONObject json = new JSONObject();
				json.put("codigo", listaF.getDominioTO().getCodigo());
				json.put("nombre", listaF.getDominioTO().getNombre());
				jsonArray.add(json);
			}
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			lista = new ArrayList<DominioCategoriaTO>();
			logger.error(e.getMessage(), e);
		}
		return null;
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
	@RequestMapping(value = "listarReglas.do")
	public ModelAndView listarReglas(@ModelAttribute ReglaForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_REGLA_LISTAR);

		try {
			List<ReglaTO> reglasList = reglaBusiness.buscarRegla(formulario.getReglaTO());

			if (reglasList.isEmpty()) {
				mv.addObject(Constantes.MENSAJE_ADVERTENCIA, Mensajes.recuperarMensaje("modulo.mensaje.listar.noEncontro", request));
			} else {
				formulario.setResultados(new ArrayList(reglasList));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			mv.addObject(Constantes.MENSAJE_ERROR, Mensajes.recuperarMensaje("general.mensaje.listar.error", request));
		}
		return mv;
	}

	public ArrayList<TipoReglaTO> cargarLista() throws Exception {

		ArrayList<TipoReglaTO> lista = null;
		try {
			lista = (ArrayList<TipoReglaTO>) tipoReglaBusiness.listarTipoReglas(new TipoReglaTO());
		} catch (Exception e) {
			lista = new ArrayList<TipoReglaTO>();
			logger.error(e.getMessage(), e);

		}
		return lista;
	}

	public ArrayList<CampoTO> cargarListaCampos_E_S(ReglaForm formulario) {

		ArrayList<CampoTO> lista = null;
		try {
			CampoTO campo = new CampoTO();
			campo.setCodigoTipoRegla(formulario.getReglaDetalleTO().getTipoRegla());
			if (formulario.isPaginaEntrada()) {
				campo.setTipoCampo("E");
			} else if (formulario.isPaginaSalida()) {
				campo.setTipoCampo("S");
			}
			lista = (ArrayList<CampoTO>) campoBusiness.listarCampos(campo);
		} catch (Exception e) {
			lista = new ArrayList<CampoTO>();
			logger.error(e.getMessage(), e);
		}
		return lista;
	}

	public ArrayList<CategoriaTO> cargarListaCategoria(ReglaForm formulario) {

		ArrayList<CategoriaTO> lista = null;
		try {
			CategoriaTO cate = new CategoriaTO();
			if (formulario.isPaginaEntrada()) {
				cate.setTipoCampo("E");
			} else if (formulario.isPaginaSalida()) {
				cate.setTipoCampo("S");
			}
			lista = (ArrayList<CategoriaTO>) categoriaBusiness.listarCategorias2(cate);
		} catch (Exception e) {
			lista = new ArrayList<CategoriaTO>();
			logger.error(e.getMessage(), e);
		}
		return lista;
	}

	public ArrayList<ConstanteTO> cargarListaConstante(ReglaForm formulario) {

		ArrayList<ConstanteTO> lista = null;
		try {
			ConstanteTO cte = new ConstanteTO();
			lista = (ArrayList<ConstanteTO>) constanteBusinnes.listarConstantes(cte);
		} catch (Exception e) {
			lista = new ArrayList<ConstanteTO>();
			logger.error(e.getMessage(), e);
		}
		return lista;
	}
}