package com.stadiumgoods.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalComponents {
	protected WebDriver driver;

    //Element locators
    @FindBy(css = ".header-tools__item--account a.header-tools__link")
    private WebElement loginButton;
    
    // TODO: should select a random category
    @FindBy(css = "#header-nav > nav > ol > li.level0.nav-1.first.parent > a.level0")
    private WebElement category;
    
    @FindBy(css = ".top-link-cart")
    private WebElement minibagButton;

                                                                                            //Ankur
    @FindBy(css = "#sg-subscribe > div > div.subscribe-close-header > a > svg")
    private WebElement popup;

    @FindBy(css = ".links a.top-link-cart")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[text()='Checkout']")
    private WebElement checkoutButton;

    //Shipping Options
    @FindBy(css = "button[class='button continue']")
    private WebElement saveAndContinueButton;


    public GlobalComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    //Action Methods
    //This will scroll the web page till end.

    public void redirectToLogin() {
        loginButton.click();
    }
    
    public void redirectToCategory() { category.click(); }
    
    public int getProductsCount() {
    	return Integer.parseInt(minibagButton.getText().trim());
    }

    public int getState() {
        return Integer.parseInt(minibagButton.getText().trim());
    }
                                                                                                 //Ankur
    public void cancelpopup() {
        popup.click();
    }
    public void clickToCartIcon() {
        cartIcon.click();
    }
    public void clickCheckout() { checkoutButton.click(); }
    public void clicksaveAndContinueButton() {
        saveAndContinueButton.click();
    }
}
