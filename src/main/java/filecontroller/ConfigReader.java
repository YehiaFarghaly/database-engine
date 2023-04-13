package filecontroller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import constants.Constants;

public class ConfigReader {

	public static Properties readProperties() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(Constants.CONFIG_PATH);
		prop.load(inputStream);
		return prop;
	}
}
