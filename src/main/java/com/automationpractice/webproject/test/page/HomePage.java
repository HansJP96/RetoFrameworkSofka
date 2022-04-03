package com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @CacheLookup
    @FindBy(linkText = "Contact us")
    WebElement contactUs;

    @CacheLookup
    @FindBy(xpath = "//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li[2]/a")
    WebElement dresses;

    @CacheLookup
    @FindBy(css = ".login")
    WebElement signIn;

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getDresses() {
        return dresses;
    }

    public WebElement getSignIn() {
        return signIn;
    }
}
