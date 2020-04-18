package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;
	
	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		
		try {
			InputStream input = new FileInputStream(file);
			pro = new Properties();
			pro.load(input);
			} catch (Exception e) {
				System.out.println("Exception is "+ e.getMessage());			
			}
		
		}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUser() {
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getFirefoxPath() {
		String path = pro.getProperty("firefoxpath");
		return path;
	}
	public String getChromePath() {
		String path = pro.getProperty("chromepath");
		return path;
	}
}
