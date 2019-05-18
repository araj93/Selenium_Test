package com.stadiumgoods.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    protected WebDriver driver;

    //Element locators
    @FindBy(css = ".block-title")
    private WebElement dashboardTitleElement;
    
    @FindBy(css = ".page-title")
    private WebElement addressbookTitleElement;
    
    @FindBy(css = ".col-left:first-of-type li:nth-of-type(3) a")
    private WebElement addressBook;
    
    @FindBy(className = "box-head")
    private WebElement addNewAddress;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    //Action Methods
    public void goToAddressBook() { 
    	addressBook.click(); 
    }
    
    public void goToAddNewAddress() {
    	addNewAddress.click();
    }


    //Getters Methods
    public String getDashboardPageTitle() {
    	return dashboardTitleElement.getText().trim();
    }
    
    public String getAddressBookPageTitle() {
    	return addressbookTitleElement.getText().trim();
    }
}
