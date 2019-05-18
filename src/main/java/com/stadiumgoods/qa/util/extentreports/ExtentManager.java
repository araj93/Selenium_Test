package com.stadiumgoods.qa.util.extentreports;
 
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.stadiumgoods.qa.util.ConfigurationManager;
 
public class ExtentManager {
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter() {
        if(extent == null){
        	extent = new ExtentReports(System.getProperty("user.dir") + "/reports/extent.html", true);
    		extent.addSystemInfo("Host Name", ConfigurationManager.getHostName())
    			.addSystemInfo("Environment", ConfigurationManager.getEnvironment())
    			.addSystemInfo("User Name", ConfigurationManager.getUsername());
    		
    		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    		File file = new File(classLoader.getResource("extent-config.xml").getFile());
    		extent.loadConfig(file);
        }

        return extent;
    }
}