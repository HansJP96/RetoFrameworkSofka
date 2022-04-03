package com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage {

    public CheckOutPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @CacheLookup
    @FindBy(css = ".standard-checkout > span")
    WebElement summaryCheckOutButton;

    @CacheLookup
    @FindBy(xpath = "//button[@name=\"processAddress\"]")
    WebElement addressCheckOutButton;

    @CacheLookup
    @FindBy(id = "uniform-cgv")
    WebElement agreeTerms;

    @CacheLookup
    @FindBy(xpath = "//button[@name=\"processCarrier\"]")
    WebElement shippingCheckOutButton;

    @CacheLookup
    @FindBy(className = "cheque")
    WebElement payByCheck;

    @CacheLookup
    @FindBy(css = "#cart_navigation span")
    WebElement confirmOrder;

    //For validations
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_summary\"]/tbody/tr")
    List<WebElement> cartQuantity;

    @CacheLookup
    @FindBy(xpath = "//td[@class=\"cart_description\"]/p/a")
    List<WebElement> productName;

    @CacheLookup
    @FindBy(xpath = "//td[@class=\"cart_description\"]/small/a")
    List<WebElement> productInformation;

    @CacheLookup
    @FindBy(xpath = "//td[@class=\"cart_quantity text-center\"]/input[2]")
    List<WebElement> productQuantity;

    @CacheLookup
    @FindBy(xpath = "//td[@class=\"cart_total\"]/span")
    List<WebElement> productPrice;

    @CacheLookup
    @FindBy(xpath = "//div[@id='center_column']/p[@class=\"alert alert-success\"]")
    WebElement finishedMessage;

    @CacheLookup
    @FindBy(xpath = "//span[@class=\"price\"]/strong")
    WebElement paymentAmount;

    public WebElement getSummaryCheckOutButton() {
        return summaryCheckOutButton;
    }

    public WebElement getAddressCheckOutButton() {
        return addressCheckOutButton;
    }

    public WebElement getAgreeTerms() {
        return agreeTerms;
    }

    public WebElement getShippingCheckOutButton() {
        return shippingCheckOutButton;
    }

    public WebElement getPayByCheck() {
        return payByCheck;
    }

    public WebElement getConfirmOrder() {
        return confirmOrder;
    }

    public List<WebElement> getCartQuantity() {
        return cartQuantity;
    }

    public List<WebElement> getProductName() {
        return productName;
    }

    public List<WebElement> getProductInformation() {
        return productInformation;
    }

    public List<WebElement> getProductQuantity() {
        return productQuantity;
    }

    public List<WebElement> getProductPrice() {
        return productPrice;
    }

    public WebElement getFinishedMessage() {
        return finishedMessage;
    }

    public WebElement getPaymentAmount() {
        return paymentAmount;
    }
}
