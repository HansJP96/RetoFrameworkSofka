package com.automationpractice.webproject.test.controllers.signin;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.HomePage;
import com.automationpractice.webproject.test.page.SignInPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class SignInPageController {
    private WebAction webAction;
    private String email;
    private String password;

    public void setWebAction(WebAction webAction){this.webAction = webAction;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void goToSignInPage(){
        try {
            HomePage homePage = new HomePage(webAction.getDriver());
            webAction.click(homePage.getSignIn(),10,COMMON_SCREEN_SHOT );
        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to the Sign In page.\n",exception);
        }
    }

    public void signInProcess(){
        try {
            SignInPage signInPage = new SignInPage(webAction.getDriver());

            webAction.moveTo(signInPage.getSignInEmail(),10,COMMON_SCREEN_SHOT);
            webAction.sendText(signInPage.getSignInEmail(),email,4,COMMON_SCREEN_SHOT);
            webAction.sendText(signInPage.getSignInPasswrod(),password,4,COMMON_SCREEN_SHOT);

            webAction.click(signInPage.getSubmitLogin(),4,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to the Sign In page.\n",exception);
        }
    }
}
