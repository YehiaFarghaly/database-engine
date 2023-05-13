package util.filecontroller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import constants.Constants;
import exceptions.DBAppException;

public class ConfigReader {

	public static Properties readProperties() throws DBAppException {
		Properties prop = new Properties();
		InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(Constants.CONFIG_PATH);
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			throw new DBAppException(e.getMessage());
		}
		return prop;
	}
}
