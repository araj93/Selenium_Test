package com.stadiumgoods.qa.util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ConfigurationManager {
	static protected WebDriver driver;
	static public Properties properties;
	
	public ConfigurationManager() {
	}
	
	public static WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		}
		
		Properties props = getProps();
		String browserName = props.getProperty("browser");
		String browserPath = props.getProperty("path");
		
		if (browserName.equals("chrome")) {
			if (browserPath.length() > 0) {
				System.setProperty("webdriver.chrome.driver", browserPath);
			}
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-extensions"); // disabling extensions
	        options.addArguments("--disable-gpu"); // applicable to windows os only
	        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
	        options.addArguments("--no-sandbox"); // Bypass OS security model
			driver = new ChromeDriver(options); 
		} else if(browserName.equals("FF")) {
			if (browserPath.length() > 0) {
				System.setProperty("webdriver.gecko.driver", browserPath);
			}
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	private static Properties getProps() {
		if (properties != null) {
			return properties;
		}
		
		properties = new Properties();
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file = new File(classLoader.getResource("config.properties").getFile());
			FileInputStream ip = new FileInputStream(file);
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
	public static String getBaseUrl() {
		return getProps().getProperty("url");
	}
	
	public static String getHostName() {
		return getProps().getProperty("host");
	}
	
	public static String getEnvironment() {
		return getProps().getProperty("environment");
	}
	
	public static String getUsername() {
		return getProps().getProperty("username");
	}
}
