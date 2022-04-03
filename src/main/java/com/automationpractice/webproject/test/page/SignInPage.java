package com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement emailAddressRegister;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccount;

    @CacheLookup
    @FindBy(id = "email")
    WebElement signInEmail;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement signInPasswrod;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;

    public WebElement getEmailAddressRegister() {
        return emailAddressRegister;
    }

    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }

    public WebElement getSignInEmail() {
        return signInEmail;
    }

    public WebElement getSignInPasswrod() {
        return signInPasswrod;
    }

    public WebElement getSubmitLogin() {
        return submitLogin;
    }
}
