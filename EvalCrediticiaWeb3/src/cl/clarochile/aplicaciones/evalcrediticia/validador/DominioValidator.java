package cl.clarochile.aplicaciones.evalcrediticia.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;

@Component
public class DominioValidator implements Validator {

	@Override
	public boolean supports(Class<?> p) {

		return DominioTO.class.isAssignableFrom(p);
	}

	@Override
	public void validate(Object command, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dominioDetalleTO.codigo", "error.nulo", new Object[] { "Codigo" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dominioDetalleTO.tipoDato", "error.nulo", new Object[] { "Tipo Dato" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dominioDetalleTO.estado", "error.nulo", new Object[] { "Estado" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dominioDetalleTO.valor", "error.nulo", new Object[] { "Valor" }, "error");
	}

	public static boolean isEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

}
