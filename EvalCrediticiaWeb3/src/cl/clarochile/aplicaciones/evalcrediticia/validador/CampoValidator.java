package cl.clarochile.aplicaciones.evalcrediticia.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;

@Component
public class CampoValidator implements Validator {

	@Override
	public boolean supports(Class<?> p) {

		return CampoTO.class.isAssignableFrom(p);
	}

	@Override
	public void validate(Object command, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "campoDetalleTO.nombreCampo", "error.nulo", new Object[] { "Nombre" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "campoDetalleTO.tipoCampo", "error.nulo", new Object[] { "Tipo Campo" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "campoDetalleTO.codigoTipoRegla", "error.nulo", new Object[] { "Tipo Evaluación" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "campoDetalleTO.subTipo", "error.nulo", new Object[] { "SubTipo" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "campoDetalleTO.tipoDato", "error.nulo", new Object[] { "Tipo Dato" }, "error");
		//jamj ValidationUtils.rejectIfEmptyOrWhitespace(errors, "campoDetalleTO.estado", "error.nulo", new Object[] { "Estado" }, "error");
	}
}
