package com.seleniumtest.test.selenium_march;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir") + "\\Config\\config.properties";

		FileInputStream fi = new FileInputStream(filePath); //Scan the file from ur system and then scan data

		Properties prop = new Properties();  //Properties is a class it will read the data from file
		prop.load(fi);

		String os_value = prop.getProperty("os");
		String browser_value = prop.getProperty("browser");
		String urlBlaze_value = prop.getProperty("url_fd");

		System.out.println(os_value);
		System.out.println(browser_value);
		System.out.println(urlBlaze_value);

		fi.close();
	}

}
