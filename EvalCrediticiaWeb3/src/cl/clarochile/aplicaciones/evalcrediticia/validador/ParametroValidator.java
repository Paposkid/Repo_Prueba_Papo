package cl.clarochile.aplicaciones.evalcrediticia.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.clarochile.aplicaciones.evalcrediticia.to.ParametroTO;

@Component
public class ParametroValidator implements Validator {

	@Override
	public boolean supports(Class<?> p) {

		return ParametroTO.class.isAssignableFrom(p);
	}

	@Override
	public void validate(Object command, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parametroDetalleTO.nombreParametro", "error.nulo", new Object[] { "Nombre" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parametroDetalleTO.tipoParametro", "error.nulo", new Object[] { "Tipo" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parametroDetalleTO.valorParametro", "error.nulo", new Object[] { "Valor" }, "error");
		//jajm ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parametroDetalleTO.estadoParametro", "error.nulo", new Object[] { "Estado" }, "error");
	}
}