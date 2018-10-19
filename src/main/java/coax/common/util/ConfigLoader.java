package coax.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigLoader {
	
	static Logger log = LogManager.getLogger(ConfigLoader.class.getName());

	private static Properties properties = new Properties();

	public static String getValue(String key) {
		if ((key == null) || key.isEmpty()) {
			return "Key not matched";
		} else {
			return properties.getProperty(key);

		}
	}

	public static void loadConfig(String fileName) {

		try {

			FileInputStream is = new FileInputStream(fileName);
			properties.load(is);

		} catch (IOException e) {
			log.error(e);
		}

	}
	

}
