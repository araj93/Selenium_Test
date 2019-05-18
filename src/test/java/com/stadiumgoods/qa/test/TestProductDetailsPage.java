package com.stadiumgoods.qa.test;

import com.stadiumgoods.qa.util.ConfigurationManager;
import com.stadiumgoods.qa.util.extentreports.ExtentTestManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.stadiumgoods.qa.pages.CategoryPage;
import com.stadiumgoods.qa.pages.GlobalComponents;
import com.stadiumgoods.qa.pages.ProductDetailsPage;
import com.relevantcodes.extentreports.LogStatus;


public class TestProductDetailsPage extends Base {
	@Test
	public void test_ProdutDetailsPage_AddElementToBag() throws InterruptedException {
		ExtentTestManager.startTest("test_ProdutDetailsPage_AddElementToBag");
		
		logger.debug("[home page] opening website");
		driver.get(ConfigurationManager.getBaseUrl());
		Thread.sleep(3000);
		
		logger.debug("[home page] navigating to category page");
		GlobalComponents global = new GlobalComponents(driver);
		global.redirectToCategory();
		Thread.sleep(3000);

		logger.debug("[plp page] identifying page");
		CategoryPage categoryPage = new CategoryPage(driver);
		Assert.assertEquals(true, categoryPage.getCategoryContainer().isDisplayed());
		
		logger.debug("[plp page] navigating to pdp");
		categoryPage.redirectToProductDetailsPage();
		Thread.sleep(3000);
		
		logger.debug("[pdp page] identifying page");
		ProductDetailsPage pdPage = new ProductDetailsPage(driver);
		Assert.assertEquals(pdPage.getProductContainer().isDisplayed(), true);
		
		int productsIntCart = global.getProductsCount();
		pdPage.addProductToCart();
		Thread.sleep(3000);
		Assert.assertEquals(global.getProductsCount(), productsIntCart + 1);
		
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_ProdutDetailsPage_AddElementToBag) Status is passed");
	}
}