package com.jp.co.netwisdom.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadUtil {

	public static void main(String[] args) {
		
		System.out.println(getProperty("URL"));
		
	}
	
	public static String getProperty (String key) {
		String value = null;
		Properties properties = new Properties();
		InputStream is = ReadUtil.class.getClassLoader().getResourceAsStream("setting.properties");
		try {
			properties.load(is);
			value = properties.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return value;
	}

}
