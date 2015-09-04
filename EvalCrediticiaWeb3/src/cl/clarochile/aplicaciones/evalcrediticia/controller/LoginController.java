package cl.clarochile.aplicaciones.evalcrediticia.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.clarochile.aplicaciones.evalcrediticia.form.LoginForm;

@Controller
public class LoginController {

	static private Logger logger = Logger.getLogger(LoginController.class);	
	
	String INGRESO = "/login";
	String INICIO = "secure/bienvenida";

	@RequestMapping(value = "mostrarPaginaLogin.do")
	public ModelAndView mostrarFormLogin(HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		model.addAttribute(new LoginForm());

		mv = new ModelAndView(INGRESO, "model", model);

		return mv;
	}

	@RequestMapping(value = "mostrarPaginaInicio.do")
	public ModelAndView mostrarFormInicio(HttpServletRequest request, Model model) {

		ModelAndView mv = null;
		model.addAttribute(new ModelAndView());

		mv = new ModelAndView(INICIO, "model", model);

		return mv;
	}

}
