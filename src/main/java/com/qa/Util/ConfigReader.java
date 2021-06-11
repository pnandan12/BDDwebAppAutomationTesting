package com.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	public Properties init_Properties() {
		try {
			prop = new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")
					+"/src/test/resources/configFile/config.properties");
					//"C:\\Users\\shyam\\eclipse-workspace\\BddWebAppAutomationTesting\\src\\test\\resources\\come\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
