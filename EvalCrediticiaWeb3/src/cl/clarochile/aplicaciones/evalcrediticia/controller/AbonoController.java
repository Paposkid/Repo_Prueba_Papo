package cl.clarochile.aplicaciones.evalcrediticia.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.clarochile.aplicaciones.evalcrediticia.form.AbonoForm;

@Controller
public class AbonoController {

	String PAGINA_ABONO = "secure/listarAbono";

	@RequestMapping(value = "mostrarPaginaAbono.do", method = RequestMethod.GET)
	public ModelAndView mostrarFormAbono(HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		model.addAttribute(new AbonoForm());

		mv = new ModelAndView(PAGINA_ABONO, "model", model);

		return mv;
	}
}
