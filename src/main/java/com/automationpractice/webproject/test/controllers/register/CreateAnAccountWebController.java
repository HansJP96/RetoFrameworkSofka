package com.automationpractice.webproject.test.controllers.register;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.Customer;
import com.automationpractice.webproject.test.page.CreateAnAccountPage;
import com.automationpractice.webproject.test.page.SignInPage;


import static com.automationpractice.webproject.test.helpers.Dictionary.*;
import static com.automationpractice.webproject.test.helpers.createanaccount.CreateAnAccountHelper.generateCustomer;

public class CreateAnAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void createNewAccount(){
        try{
            customer = generateCustomer(CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            SignInPage signInPage = new SignInPage(webAction.getDriver());
            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(
                    signInPage.getEmailAddressRegister(),
                    customer.getEmail(),
                    2,
                    COMMON_SCREEN_SHOT
            );
            webAction.click(signInPage.getCreateAnAccount(), 2, COMMON_SCREEN_SHOT);

            webAction.click(createAnAccountPage.getMr(), 10, COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(), COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(), COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(), COMMON_SCREEN_SHOT);
            webAction.selectByPartialText(createAnAccountPage.getDay(), customer.getDayBirth(), COMMON_SCREEN_SHOT);
            webAction.selectByValue(createAnAccountPage.getMonth(), customer.getMonthBirth(), COMMON_SCREEN_SHOT);
            webAction.selectByPartialText(createAnAccountPage.getYear(), customer.getYearBirth(), COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(), COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(), COMMON_SCREEN_SHOT);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(), COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(), COMMON_SCREEN_SHOT);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(), COMMON_SCREEN_SHOT);
            webAction.click(createAnAccountPage.getRegister(), COMMON_SCREEN_SHOT);

        } catch (WebActionsException e) {
            Report.reportFailure("An error ocurred when trying to create an account.\n", e);
        }
    }
}
