package cl.clarochile.aplicaciones.evalcrediticia.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

public class Mensajes {

	public static String recuperarMensaje(String keyProperty, HttpServletRequest request) {

		String msj = null;
		WebApplicationContext appCtx = RequestContextUtils.getWebApplicationContext(request);

		msj = appCtx.getMessage(keyProperty, null, RequestContextUtils.getLocale(request));

		return msj;
	}

}