package com.stadiumgoods.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	protected WebDriver driver;
	
    //Element locators
    @FindBy(css = "body.catalog-product-view")
    private WebElement bodyElement;
    
    @FindBy(css = "#product-options-wrapper > div.product-sizes > div.product-sizes__selected > span")
    private WebElement productSizeSelection;
    
    @FindBy(css = "#product-options-wrapper > div.product-sizes.product-sizes-open > div.product-sizes__options.option-count-overflow > label:nth-child(1)")
    private WebElement sizeOption;
    
    @FindBy(css = "#product_addtocart_form div.add-to-cart-buttons > button")
    private WebElement addToCartButton;
    
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    //Action Methods
    
    
    //Getters Methods
    public WebElement getProductContainer() {
    	return bodyElement;
    }
    
    public void addProductToCart() {
    	// TODO: should select a random (enabled) size
    	productSizeSelection.click();
    	sizeOption.click();
    	addToCartButton.click();
    }
}
