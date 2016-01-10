package videoDownloader.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);

	private static Configuration instance;
	private InputStream inputStream = null;
	private Properties prop = new Properties();

	private Configuration(){

	}

	public static Configuration getInstance(){
		if (instance != null)
		{
			return instance;
		}
		return new Configuration();
	}

	private Properties getProperties() throws IOException {
		try {
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}

	public String getPropertyValue(String property) {
		try {
			return getProperties().getProperty(property);
		} catch (IOException e) {
			LOG.error("Property: " + property + "not found", e);
		}
		return property;
	}

}