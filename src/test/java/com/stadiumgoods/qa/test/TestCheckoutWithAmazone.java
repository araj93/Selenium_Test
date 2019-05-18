package com.stadiumgoods.qa.test;

import com.relevantcodes.extentreports.LogStatus;
import com.stadiumgoods.qa.pages.*;
import com.stadiumgoods.qa.util.ConfigurationManager;
import com.stadiumgoods.qa.util.extentreports.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestCheckoutWithAmazone extends Base {


    @Test
    public void test_checkoutButtonViaAmazone() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ExtentTestManager.startTest("test_Checkout");

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
        Thread.sleep(3000);

        logger.debug("popup");
        GlobalComponents alert = new GlobalComponents(driver);
        alert.cancelpopup();
        Thread.sleep(2000);

        logger.debug("Cart Icon");
        GlobalComponents icon = new GlobalComponents(driver);
        icon.clickToCartIcon();
        Thread.sleep(2000);

        logger.debug("Verify Checkout Button");
        GlobalComponents checkoutButton = new GlobalComponents(driver);
        checkoutButton.clickCheckout();
        Thread.sleep(3000);

        logger.debug("Login with Amazone");
        CheckoutMethods clickAmazone = new CheckoutMethods(driver);
        clickAmazone.getToLoginWithAmazone();
        Thread.sleep(1000);

        //--------------------This set of code is used to switch to new window----------//
        String Parent_Window = driver.getWindowHandle();
        Set<String> AllWindows = driver.getWindowHandles();
        for (String Child : AllWindows) {
            if (!Parent_Window.equalsIgnoreCase(Child)) {
                driver.switchTo().window(Child);
            }
        }
        //-----------------------------------------------------------------------------//
        logger.debug("Enter Credentials");
        CheckoutMethods login = new CheckoutMethods(driver);
        login.amazone("autom@gmail.com", "stadium123");
        logger.debug("Logined");
        //driver.close();
        logger.debug("Parent Window");
        Thread.sleep(4000);
        driver.switchTo().window(Parent_Window);
        logger.debug("Amazone window closed");
        Thread.sleep(4000);
        logger.debug("Place Your Order Page");
        PaymentOptions placeOrder = new PaymentOptions(driver);
        Assert.assertEquals(placeOrder.getPlaceYourOrderPage().isDisplayed(), true);
        Thread.sleep(5000);

        //Page scroll to down
        js.executeScript("window.scrollTo(0, 1000)");
        logger.debug("Place My Order");
        PaymentOptions placeOrderWithAmazone = new PaymentOptions(driver);
        placeOrderWithAmazone.enterPlaceMyOrder();
        Thread.sleep(13000);
        MyAccountPage pageTitel = new MyAccountPage(driver);
        String title = pageTitel.getAddressBookPageTitle();
        logger.debug("[Thank You] identifying page");
        Assert.assertEquals(title.toLowerCase(), "thank you!");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_checkoutButtonViaAmazone) passed");
    }
}
