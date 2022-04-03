package com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartView {

    public ShoppingCartView(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
    WebElement shoppingCart;

    @FindBy(xpath = "//div[@class=\"cart-info\"]/div[1]/a")
    WebElement productName;

    @FindBy(className = "quantity")
    WebElement productQuantity;

    @FindBy(xpath = "//div[@class=\"cart-info\"]/div[2]/a")
    WebElement productInfo;

    @FindBy(className = "price")
    WebElement productPrice;

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductQuantity() {
        return productQuantity;
    }

    public WebElement getProductInfo() {
        return productInfo;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }
}
