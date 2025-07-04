package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class KeyReader {
	
	private static Properties prop;
	private static FileInputStream fis;
	
	public static String getKey(String key) {
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//Config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
