package com.bootcamp.pt2.bdd.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Bootcamp_DataPropReader {

	public static Properties dataProp;
	public static FileInputStream idp;

	public static Properties initializeDataPropPropertiesFile() throws Exception {
		dataProp = new Properties();
		idp = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\bootcamp_properties_files\\dataProp.properties");
		dataProp.load(idp);

		return dataProp;
	}
}
