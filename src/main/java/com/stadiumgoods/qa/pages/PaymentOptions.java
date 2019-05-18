package com.stadiumgoods.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentOptions {

    protected WebDriver driver;

    /* --------------------------Payment via Card-------------------------- */

    @FindBy(css = "div[class='container col1-layout']")
    private WebElement bodyElement;

    //Select Card Radio Button
    @FindBy(css = "input[id$='p_method_vantiv_cc']")
    private WebElement radioButton;

    //Card Number
    @FindBy(id = "vantiv_cc_cc_number")
    private WebElement card;

    //Expiration Month
    @FindBy(id = "vantiv_cc_expiration")
    private WebElement eMonth;

    //Select value from dropdown for Expiration Month
    @FindBy(css = "#vantiv_cc_expiration >option:nth-child(3)")
    private WebElement selectMonth;

    //Expiration Year
    @FindBy(id = "vantiv_cc_expiration_yr")
    private WebElement eYear;

    //Select value from dropdown for Expiration Year
    @FindBy(css = "#vantiv_cc_expiration_yr >option:nth-child(5)")
    private WebElement selectYear;

    //Security
    @FindBy(css = "input[Placeholder^='Security']")
    private WebElement security;

    //Billing Zip
    @FindBy(css = "input[Placeholder*='Billing Zip']")
    private WebElement billingZip;

    //Place My Order
    @FindBy(css = "#review-buttons-container > button")
    private WebElement placeMyOrder;


    /* --------------------------Payment via Paypal-------------------------- */
    //Select Paypal Radio Button
    @FindBy(css = "input[id$='p_method_paypal_express']")
    private WebElement PayPalRadioButton;

    @FindBy(css = "input[id='email']")
    private WebElement emailId;

    @FindBy(css = "input[id='password']")
    private WebElement pwd;

    @FindBy(css = "button[id*='btnLogin']")
    private WebElement login;

    @FindBy(id = "confirmButtonTop")
    private WebElement payPalogin;




    public PaymentOptions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Action Methods
    public void clickRadioBtn() { radioButton.click();}
    public void enterCardNumber(String cardNumber) { card.sendKeys(cardNumber); }
    public void enterExpirationMonth() { eMonth.click(); }
    public void enterExpirationMonthValue() { selectMonth.click(); }
    public void enterExpirationYear() {
        eYear.click();
    }
    public void enterExpirationYearValue() { selectYear.click(); }
    public void enterSecurity(String securityValue) { security.sendKeys(securityValue); }
    public void enterBillingZip(String userBillingZip) { billingZip.sendKeys(userBillingZip); }
    public void enterPlaceMyOrder() { placeMyOrder.click(); }

    public void clickPaypalRadioBtn() { PayPalRadioButton.click();}
    public void enterEmail(String email) { emailId.sendKeys(email);}
    public void enterPwd(String password) { pwd.sendKeys(password);}
    public void clickLogin() { login.click();}
    public void payPal(String email, String password ) {
        emailId.click();
        emailId.clear();
        enterEmail(email);
        enterPwd(password);
    }
    public void payPalLoginClick() { payPalogin.click();}
    //Getters Methods
    public WebElement getPlaceYourOrderPage() {
        return bodyElement;
    }
}
