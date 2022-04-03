package com.automationpractice.webproject.test.controllers.contactus;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.contactus.ContactUsForm;
import com.automationpractice.webproject.test.page.ContactUsPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.*;
import static com.automationpractice.webproject.test.helpers.contactus.ContactUsHelper.generateRequiredNewMessageInfo;

public class NewMessageController {
    private WebAction webAction;
    private ContactUsForm contactUsForm;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void fillRequiredContactUsFields() {
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            contactUsForm = generateRequiredNewMessageInfo(CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            webAction.selectByValue(contactUsPage.getSubjectHeading(), contactUsForm.getSubjectHeading(), false);
            webAction.sendText(contactUsPage.getEmail(), contactUsForm.getEmail(), COMMON_SCREEN_SHOT);
            webAction.sendText(contactUsPage.getMessage(), contactUsForm.getMessage(), COMMON_SCREEN_SHOT);
            webAction.click(contactUsPage.getSubmitMessage(), 2, COMMON_SCREEN_SHOT);

        } catch (WebActionsException e) {
            Report.reportFailure("An error occurred while writing the new message.\n", e);
        }
    }

    public void fillRequiredContactUsFieldsExceptSubjectHeading() {
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            contactUsForm = generateRequiredNewMessageInfo(CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            webAction.sendText(contactUsPage.getEmail(), contactUsForm.getEmail(), COMMON_SCREEN_SHOT);
            webAction.sendText(contactUsPage.getMessage(), contactUsForm.getMessage(), COMMON_SCREEN_SHOT);
            webAction.click(contactUsPage.getSubmitMessage(), 2, COMMON_SCREEN_SHOT);

        } catch (WebActionsException e) {
            Report.reportFailure("An error occurred while writing the new message.\n", e);
        }
    }
}
