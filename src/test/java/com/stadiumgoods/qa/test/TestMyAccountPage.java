package com.stadiumgoods.qa.test;

import com.stadiumgoods.qa.pages.MyAccountPage;
import com.stadiumgoods.qa.util.ConfigurationManager;
import com.stadiumgoods.qa.util.extentreports.ExtentTestManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.stadiumgoods.qa.pages.LogInPage;
import com.stadiumgoods.qa.pages.GlobalComponents;
import com.relevantcodes.extentreports.LogStatus;

import java.util.concurrent.TimeUnit;

public class TestMyAccountPage extends Base {
	@Test
	public void test_LoginPage_PageLoadsCorrectly() throws InterruptedException {
		ExtentTestManager.startTest("test_LoginPage_PageLoadsCorrectly");
		
		logger.debug("[home page] opening website");
		driver.get(ConfigurationManager.getBaseUrl());
		
		logger.debug("[home page] navigating to login page");
		GlobalComponents global = new GlobalComponents(driver);
		global.redirectToLogin();
		Thread.sleep(5000);

		logger.debug("[login page] identifying page");
		LogInPage page = new LogInPage(driver);
		String title = page.getWelcomeMessage();
		Assert.assertEquals(title.toLowerCase(), "welcome to stadium goods");
		
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_LoginPage_PageLoadsCorrectly) Status is passed");
	}
	
	@Test(dependsOnMethods = {"test_LoginPage_PageLoadsCorrectly"})
	public void test_LoginPage_UserLogsIn() throws InterruptedException {
		ExtentTestManager.startTest("test_LoginPage_UserLogsIn");
		
		logger.debug("[login page] opening login page");
		driver.get(ConfigurationManager.getBaseUrl() + "/customer/account/login/");
		Thread.sleep(5000);
		
		logger.debug("[login page] use login form");
		LogInPage login = new LogInPage(driver);
		login.logInUser("agustin.s@stadiumgoods.com", "Test@123");
		// give the tester 120 seconds to fill the reCaptcha (reCaptcha would need to be disabled for automation test)
		// Thread.sleep(180000);
		
		logger.debug("[my account] identifying page");
		MyAccountPage page = new MyAccountPage(driver);
		String title = page.getDashboardPageTitle();
		Assert.assertEquals(title.toLowerCase(), "my account");
		
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_LoginPage_UserLogsIn) Status is passed");
	}
	
    @Test(dependsOnMethods = {"test_LoginPage_UserLogsIn"})
    public void test_Account_NavigateToAddressBook() {
    	ExtentTestManager.startTest("test_Account_NavigateToAddressBook");
        
        logger.debug("[login page] opening my account dashboard page");
		driver.get(ConfigurationManager.getBaseUrl() + "/customer/account/index/");
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);

        MyAccountPage page = new MyAccountPage(driver);
        logger.debug("[my account dashboard] redirecting to address book");
        page.goToAddressBook();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String title = page.getAddressBookPageTitle();
        logger.debug("[address book] identifying page");
        Assert.assertEquals(title.toLowerCase(), "address book");

        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_Account_NavigateToAddressBook) passed");
    }

}