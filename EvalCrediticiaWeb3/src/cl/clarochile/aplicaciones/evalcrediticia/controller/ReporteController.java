package cl.clarochile.aplicaciones.evalcrediticia.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cl.clarochile.aplicaciones.evalcrediticia.form.ReporteForm;

@Controller
public class ReporteController {

	String PAGINA_REPORTE_EVAL = "secure/reporte/reporte";

	@RequestMapping(value = "mostrarPaginaReporte.do", method = RequestMethod.GET)
	public ModelAndView mostrarFormReporte(@ModelAttribute ReporteForm formulario, HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		mv = new ModelAndView(PAGINA_REPORTE_EVAL, "model", model);
		formulario.setListaAcreditaciones(null);

		return mv;
	}

}
