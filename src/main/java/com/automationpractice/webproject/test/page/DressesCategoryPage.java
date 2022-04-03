package com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesCategoryPage {

    public DressesCategoryPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li[1]/div")
    WebElement productBox1;

    @CacheLookup
    @FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li[1]/div/div[2]/div[@class=\"button-container\"]/a[1]")
    WebElement productAdd1;

    @CacheLookup
    @FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li[5]/div")
    WebElement productBox2;

    @CacheLookup
    @FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li[5]/div/div[2]/div[@class=\"button-container\"]/a[1]")
    WebElement productAdd2;

    @FindBy(id = "layer_cart_product_title")
    WebElement productSelectedName;

    @FindBy(id = "layer_cart_product_attributes")
    WebElement productSelectedInfo;

    @FindBy(id = "layer_cart_product_quantity")
    WebElement productSelectedQuantity;

    @FindBy(id = "layer_cart_product_price")
    WebElement productSelectedPrice;

    @FindBy(xpath = "//div[@id='layer_cart']/div/div[2]/div[4]/span/span")
    WebElement continueShopping;

    //For validations
    @FindBy(xpath = "//div[@class=\"clearfix\"]/div[1]/h2")
    WebElement successfullyAddMessage;

    public WebElement getProductBox1() {
        return productBox1;
    }

    public WebElement getProductAdd1() {
        return productAdd1;
    }

    public WebElement getProductBox2() {
        return productBox2;
    }

    public WebElement getProductAdd2() {
        return productAdd2;
    }


    public WebElement getProductSelectedName() {
        return productSelectedName;
    }

    public WebElement getProductSelectedInfo() {
        return productSelectedInfo;
    }

    public WebElement getProductSelectedQuantity() {
        return productSelectedQuantity;
    }

    public WebElement getProductSelectedPrice() {
        return productSelectedPrice;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getSuccessfullyAddMessage() {
        return successfullyAddMessage;
    }
}
