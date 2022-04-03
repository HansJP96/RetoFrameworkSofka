package com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    // Input fields
    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement submitMessage;

    //For validation
    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    WebElement successfulMessage;

    @FindBy(xpath = "//div[@class=\"alert alert-danger\"]/ol/li")
    WebElement errorBySubjectHeading;

    public WebElement getSubjectHeading() {
        return subjectHeading;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSubmitMessage() {
        return submitMessage;
    }

    public WebElement getSuccessfulMessage() {
        return successfulMessage;
    }

    public WebElement getErrorBySubjectHeading() {
        return errorBySubjectHeading;
    }
}
