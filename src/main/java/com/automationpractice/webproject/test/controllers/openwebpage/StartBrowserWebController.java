package com.automationpractice.webproject.test.controllers.openwebpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.automationpractice.webproject.test.helpers.Dictionary.APP_URL_PROPERTY;
import static com.automationpractice.webproject.test.helpers.createanaccount.CreateAnAccountHelper.getProperty;


public class StartBrowserWebController {
    private WebAction webAction;
    private String featue;
    private Browser browser;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setFeatue(String featue) {
        this.featue = featue;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void openWebPage(){
        try{
            webAction.startWebApp(browser, getProperty(APP_URL_PROPERTY), featue);
        } catch (WebActionsException e){
            Report.reportFailure("An error occurred while opening the web page.\n", e);
        }
    }
}
