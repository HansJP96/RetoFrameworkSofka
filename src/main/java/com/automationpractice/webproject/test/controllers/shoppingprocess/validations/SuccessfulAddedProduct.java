package com.automationpractice.webproject.test.controllers.shoppingprocess.validations;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.DressesCategoryPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class SuccessfulAddedProduct {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String getSuccessAddedProduct() {
        String result = "";
        DressesCategoryPage dressesCategoryPage = new DressesCategoryPage(webAction.getDriver());
        try{
            result = webAction.getText(dressesCategoryPage.getSuccessfullyAddMessage(), 10,COMMON_SCREEN_SHOT);
            webAction.click(dressesCategoryPage.getContinueShopping(), 4,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception) {
            Report.reportFailure("An error ocurred getting the validation message.\n", exception);
        }
        return result;
    }
}
