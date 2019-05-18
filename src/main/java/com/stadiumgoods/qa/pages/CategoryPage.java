package com.stadiumgoods.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	protected WebDriver driver;
	
    //Element locators
    @FindBy(css = "body.catalog-category-view")
    private WebElement bodyElement;
    
    // TODO: should select a random product
    @FindBy(css = ".products-grid > .item:first-of-type > a")
    private WebElement product;
    
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    //Action Methods
    
    
    //Getters Methods
    public WebElement getCategoryContainer() { return bodyElement; }
    
    public void redirectToProductDetailsPage() {
    	product.click();
    }
}
