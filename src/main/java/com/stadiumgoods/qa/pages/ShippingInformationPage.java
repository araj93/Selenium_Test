package com.stadiumgoods.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ShippingInformationPage {
    protected WebDriver driver;

    //Email address Text box click
    @FindBy(id = "shipping:email")
    private WebElement emailAddress;

    //Password Text box click
    @FindBy(id = "shipping:customer_password")
    private WebElement password;

    //Confirm Password Text box click
    @FindBy(id = "shipping:confirm_password")
    private WebElement confirmPassword;

    //First Name Text box click
    @FindBy(id = "shipping:firstname")
    private WebElement firstName;

    //Last Name Text box click
    @FindBy(id = "shipping:lastname")
    private WebElement lastName;

    //Street Address Text box click
    @FindBy(id = "shipping:street1")
    private WebElement streetAddress;

    ////Email address Text box click Text box click
    @FindBy(id = "shipping:city")
    private WebElement city;

    //Click on Region Label
    @FindBy(css = "select[id='shipping:region_id']")
    private WebElement region;

    //Select Region
    @FindBy(css = "#shipping\\:region_id > option:nth-child(3)")
    private WebElement selectRegion;

    //zip Text box click
    @FindBy(css = "input[id='shipping:postcode']")
    private WebElement zip;

    //Phone Text box click
    @FindBy(id = "shipping:telephone")
    private WebElement phone;

    //Save and Continue Button
    @FindBy(css = "button[class='continue button']")
    private WebElement saveAndContinue;


    public ShippingInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Action Methods

    public void enterEmail(String Email) {
        emailAddress.sendKeys(Email);
    }
    public void enterPassword(String Password) {
        password.sendKeys(Password);
    }
    public void enterConfirmPassword(String ConfirmPassword) {
        confirmPassword.sendKeys(ConfirmPassword);
    }
    public void enterFirstName(String FirstName) {
        firstName.sendKeys(FirstName);
    }
    public void enterLastName(String LastName) {
        lastName.sendKeys(LastName);
    }
    public void enterStreetAddress(String StreetAddress) {
        streetAddress.sendKeys(StreetAddress);
    }
    public void enterCity(String City) {
        city.sendKeys(City);
    }
    public void enterZip(String Zip) { zip.sendKeys(Zip); }
    public void enterPhone(String Phone) {phone.sendKeys(Phone);
    }
    public void shippingInformation(String Email, String Password, String ConfirmPassword, String FirstName, String LastName) {
        enterEmail(Email);
        enterPassword(Password);
        enterConfirmPassword(ConfirmPassword);
        enterFirstName(FirstName);
        enterLastName(LastName);
    }
    public void shipAdd() throws InterruptedException {
        streetAddress.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
        streetAddress.sendKeys("d");
       Thread.sleep(2000);
        streetAddress.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
    }
    public void clickRegion() {region.click();}
    public void clickSelectRegion() {selectRegion.click();}

    public void zipAndPhone(String Zip, String Phone){
        enterZip(Zip);
        enterPhone(Phone);
    }

    public void clickSaveAndContinueButton() {
        saveAndContinue.click();
    }

//    public void State() {
//        region.click();
//        selectRegion.click();
//    }


    //Getters Methods

    public WebElement getEmailAddress() { return emailAddress; }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getStreetAddress() {
        return streetAddress;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getZip() {
        return zip;
    }

    public WebElement getPhone() {
        return phone;
    }

}
