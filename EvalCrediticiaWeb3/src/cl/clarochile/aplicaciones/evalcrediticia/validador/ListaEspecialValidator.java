package cl.clarochile.aplicaciones.evalcrediticia.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.clarochile.aplicaciones.evalcrediticia.to.ListaEspecialTO;

@Component
public class ListaEspecialValidator implements Validator {

	@Override
	public boolean supports(Class<?> p) {

		return ListaEspecialTO.class.isAssignableFrom(p);
	}

	@Override
	public void validate(Object command, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.nombreListaEspecial", "error.nulo", new Object[] { "Nombre" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.valorConcepto", "error.nulo", new Object[] { "Valor Concepto" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.tipoLista", "error.nulo", new Object[] { "Tipo Lista" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.campoConsulta", "error.nulo", new Object[] { "Campo Consulta" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.campoResultado", "error.nulo", new Object[] { "Campo Resultado" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.valorDefecto", "error.nulo", new Object[] { "Valor por defecto" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listaEspecialDetalleTO.stado", "error.nulo", new Object[] { "Estado" }, "error");
	}
}
