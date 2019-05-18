package com.stadiumgoods.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	protected WebDriver driver;
	
    //Element locators
    @FindBy(className = "page-title")
    private WebElement welcomeMessage;
    
    @FindBy(id = "email")
    private WebElement email;
    
    @FindBy(id = "pass")
    private WebElement password;
    
    @FindBy(id = "send2")
    private WebElement logInButton;
    
    @FindBy(linkText = "Create an Account")
    private WebElement createAnAccount;
    
    @FindBy(linkText = "Forgot password?")
    private WebElement forgotPassword;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    //Action Methods
    public void enterUserEmail(String userEmail) {
        email.sendKeys(userEmail);
    }
    
    public void enterUserPassword(String userPassword) {

        password.sendKeys(userPassword);
    }
    
    public void clickLogIn() {
        logInButton.click();
    }
    
    public void clickForgotPassword() {

        forgotPassword.click();
    }
    
    public void clickCreateAnAccount() {
        createAnAccount.click();
    }

    public void logInUser(String userEmail, String userPassword) {
        enterUserEmail(userEmail);
        enterUserPassword(userPassword);
        clickLogIn();
    }

    
    //Getters Methods
    public String getWelcomeMessage() {
    	return welcomeMessage.getText().trim();
    }
    
    public WebElement getEmail() { return email;
    }
    
    public WebElement getPassword() {
        return password;
    }
    
    public WebElement getLogInButton() {
        return logInButton;
    }
    
    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }
    
    public WebElement getForgotPassword() {
        return forgotPassword;
    }
}
