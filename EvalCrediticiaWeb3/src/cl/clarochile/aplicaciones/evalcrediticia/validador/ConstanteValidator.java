package cl.clarochile.aplicaciones.evalcrediticia.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.clarochile.aplicaciones.evalcrediticia.form.ConstanteForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;
import cl.clarochile.aplicaciones.evalcrediticia.util.Validador;

/**
 * Clase que valida que el form no esté vacio
 * 
 * @author Daniel Ocampo Gutiérrez [daniel.ocampogutierrez@tcs.com]
 * @since 03/15/2013
 * @version 1.0
 */
@Component
public class ConstanteValidator implements Validator {

	@Override
	public boolean supports(Class<?> p) {

		return ConstanteTO.class.isAssignableFrom(p);
	}

	/**
	 * Metodo que valida y notifica los errores
	 * 
	 * @param command
	 * @param errors
	 */
	@Override
	public void validate(Object command, Errors errors) {
		
		
		ConstanteForm formulario = (ConstanteForm)command;
		ConstanteTO constante = new ConstanteTO();
		constante = formulario.getConstanteDetalleTO();
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constanteDetalleTO.nombre", "error.nulo", new Object[] { "Nombre" }, "error");
		//jamj ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constanteDetalleTO.estado", "error.nulo", new Object[] { "Estado" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constanteDetalleTO.tipo", "error.nulo", new Object[] { "Tipo" }, "error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constanteDetalleTO.valor", "error.nulo", new Object[] { "Valor" }, "error");
		
		
		
		if(!Validador.esNuloVacio(constante.getTipo())) {
			if(constante.getTipo().equalsIgnoreCase("N")) {
				if(!Validador.esNumero(constante.getValor())) {
					errors.rejectValue("constanteDetalleTO.valor", "error.numero", new Object [] {"valor"}, "error");
				}
			}
		}
		
	}

}
