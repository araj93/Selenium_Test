package com.stadiumgoods.qa.test;

import com.relevantcodes.extentreports.LogStatus;
import com.stadiumgoods.qa.pages.*;
import com.stadiumgoods.qa.util.ConfigurationManager;
import com.stadiumgoods.qa.util.extentreports.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckoutPageViaCard extends Base {


    @Test
    public void test_checkoutButtonViaCard() throws InterruptedException {
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

        logger.debug("Identify Create Account");
        CheckoutMethods createAcc = new CheckoutMethods(driver);
        createAcc.getToCreateMyAccountCheckout();
        Thread.sleep(3000);

        logger.debug("Identify Continue");
        CheckoutMethods continuebtn = new CheckoutMethods(driver);
        continuebtn.getToShippingInformation();
        Thread.sleep(5000);

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

        logger.debug("Card Payment Radio Button Click");
        PaymentOptions radioBtn = new PaymentOptions(driver);
        radioBtn.clickRadioBtn();
        Thread.sleep(2000);

        logger.debug("card Number");
        PaymentOptions cardNo = new PaymentOptions(driver);
        cardNo.enterCardNumber("450047728");
        Thread.sleep(2000);

        logger.debug("Expiration Month");
        PaymentOptions expMonth = new PaymentOptions(driver);
        expMonth.enterExpirationMonth();
        Thread.sleep(2000);

        logger.debug("Select Expiration Month from dropdown");
        PaymentOptions selectExpMonth = new PaymentOptions(driver);
        expMonth.enterExpirationMonthValue();
        Thread.sleep(2000);

        logger.debug("Expiration Year");
        PaymentOptions expYear = new PaymentOptions(driver);
        expYear.enterExpirationYear();
        Thread.sleep(2000);

        logger.debug("Select Expiration Year from dropdown");
        PaymentOptions selectExpYear = new PaymentOptions(driver);
        selectExpYear.enterExpirationYearValue();
        Thread.sleep(2000);

        logger.debug("Security");
        PaymentOptions securityVal = new PaymentOptions(driver);
        securityVal.enterSecurity("5487");
        Thread.sleep(2000);

        //------------Removed From Stage Environment----------------//
//        logger.debug("Billing Zip");
//        PaymentOptions billZip = new PaymentOptions(driver);
//        billZip.enterBillingZip("10036");
//        Thread.sleep(2000);

        //Scroll Page to down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        logger.debug("Place My Order");
        PaymentOptions placeOrder = new PaymentOptions(driver);
        placeOrder.enterPlaceMyOrder();
        Thread.sleep(8000);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case (test_checkoutButton_via_Card) Status is passed");
        }


    }

