package utilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	private static Properties properties;
	
	static {
		loadProperties();
	}
	private static void loadProperties()  {
		properties=new Properties();
		try(java.io.InputStream fileInputstream =configReader.class.getClassLoader().getResourceAsStream("loginConfig.properties")){
			
			properties.load(fileInputstream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		
		
		
		
	}
	public static String getProperty(String key) {
		if (properties==null) {
			throw new RuntimeException("properties not loaded. check config file");
		}
		String value=properties.getProperty(key);
		if (value==null) {
			throw new IllegalArgumentException("property '"+key+" not found in config");
			
		}
		return value;
	}
	
	public static String getProperty(String key, String DefaultValue) {
		if (properties==null) {
			return DefaultValue;
		}
		return properties.getProperty(key, DefaultValue);
	}

}
