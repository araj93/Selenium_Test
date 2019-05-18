package com.stadiumgoods.qa.test;

import com.relevantcodes.extentreports.LogStatus;
import com.stadiumgoods.qa.pages.*;
import com.stadiumgoods.qa.util.ConfigurationManager;
import com.stadiumgoods.qa.util.extentreports.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCheckoutViaPayPal extends Base {


    @Test
    public void test_checkoutButtonViaPayPal() throws InterruptedException {
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
        Thread.sleep(2000);

        logger.debug("Identify Create Account");
        CheckoutMethods createAcc = new CheckoutMethods(driver);
        createAcc.getToCreateMyAccountCheckout();
        Thread.sleep(2000);

        logger.debug("Identify Continue");
        CheckoutMethods continuebtn = new CheckoutMethods(driver);
        continuebtn.getToShippingInformation();
        Thread.sleep(4000);


        logger.debug("Shipping Information Section");
        ShippingInformationPage emailAdd = new ShippingInformationPage(driver);
        emailAdd.shippingInformation("xyz@hotmail.com","qwerty","qwerty","Ankur","Raj");
        Thread.sleep(3000);

        logger.debug("Shipping Add");
        ShippingInformationPage shippingAdd = new ShippingInformationPage(driver);
        shippingAdd.shipAdd();
        Thread.sleep(1000);

        logger.debug("Phone Number");
        ShippingInformationPage postal = new ShippingInformationPage(driver);
        postal.enterPhone("9608261608");
        Thread.sleep(1000);

        logger.debug("Save and Continue for Shipping Information");
        ShippingInformationPage saveAndcontinuebtn = new ShippingInformationPage(driver);
        saveAndcontinuebtn.clickSaveAndContinueButton();
        Thread.sleep(3000);

        logger.debug("Save and Continue for Shipping Options");
        GlobalComponents saveAndcontinuebutton = new GlobalComponents(driver);
        saveAndcontinuebutton.clicksaveAndContinueButton();
        Thread.sleep(3000);

        logger.debug("PapPal Radio Button Click");
        PaymentOptions radioBtn = new PaymentOptions(driver);
        radioBtn.clickPaypalRadioBtn();
        Thread.sleep(2000);

        //Page scroll to down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        logger.debug("Place My Order");
        PaymentOptions placeOrder = new PaymentOptions(driver);
        placeOrder.enterPlaceMyOrder();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        Thread.sleep(2000);
        logger.debug("PayPal Page");
        PaymentOptions credentials = new PaymentOptions(driver);
        credentials.payPal("xyz@gmail.com","stadiu123");
        Thread.sleep(1000);

        logger.debug("PapPal Radio Button Click");
        PaymentOptions loginToPP = new PaymentOptions(driver);
        loginToPP.clickLogin();
        Thread.sleep(9000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logger.debug("Place My Order");
        PaymentOptions payPalLoginBtn = new PaymentOptions(driver);
        payPalLoginBtn.payPalLoginClick();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        MyAccountPage pageTitel = new MyAccountPage(driver);
        String title = pageTitel.getAddressBookPageTitle();
        logger.debug("[Thank You] identifying page");
        Assert.assertEquals(title.toLowerCase(), "thank you!");

        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_checkoutButton via paypal) Status is passed");
        }


    }

