package com.automationpractice.webproject.test.controllers.contactus.validations;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.ContactUsPage;

public class ErrorBySubjectHeading {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String getMessageErrorBySubjectHeading() {
        String result = "";
        try{
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            result = webAction.getText(contactUsPage.getErrorBySubjectHeading(),2,false);

        } catch (WebActionsException exception) {
            Report.reportFailure("An error ocurred getting the error message.\n", exception);
        }
        return result;
    }
}
