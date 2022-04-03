package com.automationpractice.webproject.test.controllers.shoppingprocess.validations;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.CheckOutPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.*;

public class FinishedPurchaseByCheck {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String getOrderConfirmationMessage() {
        String result = "";
        CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
        try {
            result = webAction.getText(checkOutPage.getFinishedMessage(), 2, COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception) {
            Report.reportFailure("An error ocurred getting the validation message.\n", exception);
        }
        return result;
    }

    public float getComparableAmountPayment() {
        float result = 0;
        CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
        try {
            webAction.moveTo(checkOutPage.getPaymentAmount(), 5, COMMON_SCREEN_SHOT);
            result = Float.parseFloat(webAction.getText(checkOutPage.getPaymentAmount(), 2, COMMON_SCREEN_SHOT)
                    .replace(MONEY_SYMBOL,EMPTY_STRING));

        } catch (WebActionsException exception) {
            Report.reportFailure("An error ocurred getting the Payment Amount value.\n", exception);
        }
        return result;
    }
}
