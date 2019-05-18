package com.stadiumgoods.qa.test;

import com.stadiumgoods.qa.util.ConfigurationManager;
import com.stadiumgoods.qa.util.extentreports.ExtentManager;
import com.stadiumgoods.qa.util.extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

abstract public class Base {
	protected WebDriver driver;
	protected Logger logger;

	@BeforeClass
	public void setup() {
		driver = ConfigurationManager.getWebDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		logger = Logger.getLogger("com.stadiumgoods");
	}
	
	@AfterSuite
	public void closeDriver() {
		System.out.println("[Base] Close Driver");
		driver.close();
	}
    
	@AfterClass
	public void tearDown() {
		System.out.println("[Base] Close Driver");
        ExtentManager.getReporter().flush();
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Case Failed with " + result.getThrowable());
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + result.getName() + ".png"));
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		ExtentTestManager.endTest();
	}
}
