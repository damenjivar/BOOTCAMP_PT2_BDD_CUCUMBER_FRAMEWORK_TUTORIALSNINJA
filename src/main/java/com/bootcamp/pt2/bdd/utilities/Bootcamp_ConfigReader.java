package com.bootcamp.pt2.bdd.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Bootcamp_ConfigReader {

	public static Properties prop;
	public static FileInputStream ip;

	public static Properties initializeConfigPropertiesFile() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\bootcamp_properties_files\\config.properties");
		prop.load(ip);

		return prop;
	}
}
