package com.stadiumgoods.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutMethods {
    protected WebDriver driver;


    // Checkout Section title locator
    @FindBy(className = "page-title")
    private WebElement checkoutTitleSection;

    //Guest Radio button
    @FindBy(css = "input[id*='login:guest']")
    private WebElement guestCheckoutRadioButton;

    //Ankur

    //Create My account Radio button
    @FindBy(css = "input[id*='login:register']")
    private WebElement createMyAccountRadioButton;

    //Continue Button
    @FindBy(css = "#onepage-guest-register-button")
    private WebElement continueButton;

    //--------Registered User LogIn-------------//

    //Email Address
    @FindBy(css = "input[placeholder='Email Address']")
    private WebElement existingEmail;

    @FindBy(css = "input[placeholder='Password'][id='login-password']")
    private WebElement userPwd;

    @FindBy(css = "button[type='submit'][class='button']")
    private WebElement regLogin;


    //--------Login with Amazone----------//

    @FindBy(id = "OffAmazonPaymentsWidgets0")
    private WebElement loginWithAmazone;

    @FindBy(css = "input[id='ap_email']")
    private WebElement aEmail;

    @FindBy(css = "input[id='ap_password']")
    private WebElement aPwd;

    @FindBy(css = "button[type='submit']")
    private WebElement aLogin;




    public CheckoutMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); }



    //Action Methods

    public void getToGuestCheckout() { guestCheckoutRadioButton.click(); }

    public void getToCreateMyAccountCheckout() { createMyAccountRadioButton.click(); }

    public void enterUserEmailId(String emailId) { existingEmail.sendKeys(emailId); }

    public void enterUserPasswordString(String userPassword) { userPwd.sendKeys(userPassword); }

    public void clickLogIn() { regLogin.click(); }

    public void registeredUserCredentials(String emailId, String UserPassword ) {
        enterUserEmailId(emailId);
        enterUserPasswordString(UserPassword);
        clickLogIn();
    }


    public void getToLoginWithAmazone() { loginWithAmazone.click(); }

    public void enterAemailId(String aemailId) { aEmail.sendKeys(aemailId); }

    public void enterApassword(String apassword) { aPwd.sendKeys(apassword); }

    public void clickAlogIn() { aLogin.click(); }

    public void amazone(String aemailId, String apassword ) {
        aEmail.click();
        aEmail.clear();
        enterAemailId(aemailId);
        enterApassword(apassword);
        clickAlogIn(); }

    public void getToShippingInformation() { continueButton.click(); }


    //Getters Methods
    public String getCheckoutSectionTitle() { return checkoutTitleSection.getText().trim(); }

}
