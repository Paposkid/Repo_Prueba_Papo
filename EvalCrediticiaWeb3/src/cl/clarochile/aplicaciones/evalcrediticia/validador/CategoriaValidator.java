package cl.clarochile.aplicaciones.evalcrediticia.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;

/**
 * Clase que valida que el form no esté vacio
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
@Component
public class CategoriaValidator implements Validator {

	@Override
	public boolean supports(Class<?> p) {

		return ConstanteTO.class.isAssignableFrom(p);
	}

	/**
	 * Método abstracto validar y notificar los errores
	 * 
	 * @param command
	 * @param errors
	 */
	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaDetalleTO.codigoCategoria", "error.nulo", new Object[] { "Código" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaDetalleTO.nombreCategoria", "error.nulo", new Object[] { "Nombre" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaDetalleTO.tipoCategoria", "error.nulo", new Object[] { "Tipo Dato" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaDetalleTO.codigoCampo", "error.nulo", new Object[] { "Campo" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaDetalleTO.estado", "error.nulo", new Object[] { "Estado" }, "error");

	}

}
