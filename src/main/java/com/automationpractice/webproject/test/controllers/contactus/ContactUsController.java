package com.automationpractice.webproject.test.controllers.contactus;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.HomePage;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class ContactUsController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction){this.webAction = webAction;}

    public void goToContactUsPage(){
        try {
            HomePage homePage = new HomePage(webAction.getDriver());
            webAction.click(homePage.getContactUs(),5,COMMON_SCREEN_SHOT );
        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to the Contact Us page.\n",exception);
        }
    }
}
