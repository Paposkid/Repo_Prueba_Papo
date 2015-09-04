package cl.clarochile.aplicaciones.evalcrediticia.util;

import java.util.ResourceBundle;

public final class Config {

	private static java.util.ResourceBundle properties;
	private static final String CONFIG_PATH = "messages";

	public synchronized static String getProperty(String key) {
		if (properties == null) {
			Config.reload();
		}
		String value = properties.getString(key);
		assert value != null : "Propiedad : \"" + key + "\" no encontrada";
		return value;
	}

	/**
	 * recarga la configuracion desde el archivo .properties
	 */
	public synchronized static void reload() {
		try {
			properties = ResourceBundle.getBundle(CONFIG_PATH);
		} catch (Exception ex) {
			properties = null;
			throw new RuntimeException(ex);
		}
	}
}
