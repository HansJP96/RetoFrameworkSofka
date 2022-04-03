package com.automationpractice.webproject.test.controllers.contactus.validations;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.ContactUsPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class SuccessfulMessage {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String getSuccessMessage() {
        String result = "";
        try{
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            result = webAction.getText(contactUsPage.getSuccessfulMessage(),2,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception) {
            Report.reportFailure("An error ocurred getting the validation message.\n", exception);
        }
        return result;
    }
}
