package cl.clarochile.aplicaciones.evalcrediticia.util;



public class Validador {

	
	
	/* Metodo que recibe un String y valida si el valor recibido esta nulo o
	 * se encuentra vacio. Si la validacion es correcta devuelve el valor "true",
	 * en caso contrario devuelve el valor "false"
	 * */
	public static boolean esNuloVacio(String strTexto) {

		boolean retorno = false;

		if(strTexto == null || strTexto.isEmpty()){

			retorno = true;
		}

		return retorno;

	  }
	
	/* Metodo que recibe un String y valida si el valor recibido es numerico. 
	 * si la validacion es correcta devuelve el valor "true",
	 * en caso contrario devuelve el valor "false"
	 * */
	public static boolean esNumero(String string) {
	    boolean blnResultado = true;
	    for (int i = 0; (i < string.length() && blnResultado); i++) {
	      blnResultado = Character.isDigit(string.charAt(i));
	    }
	    return blnResultado;
	  }
	
}
