package com.automationpractice.webproject.test.stepdefinition.contactus;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.webproject.test.controllers.contactus.ContactUsController;
import com.automationpractice.webproject.test.controllers.contactus.NewMessageController;
import com.automationpractice.webproject.test.controllers.contactus.validations.ErrorBySubjectHeading;
import com.automationpractice.webproject.test.controllers.contactus.validations.SuccessfulMessage;
import com.automationpractice.webproject.test.controllers.openwebpage.StartBrowserWebController;
import com.automationpractice.webproject.test.data.objects.TestInfo;
import com.automationpractice.webproject.test.stepdefinition.setup.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.automationpractice.webproject.test.helpers.Dictionary.CONTACT_US_DONE_MESSAGE;
import static com.automationpractice.webproject.test.helpers.Dictionary.CONTACT_US_ERROR_SUBJECT_HEADING;

public class ContactUsStepDefinition extends Setup {

    private WebAction webAction;

    @Before
    public void setUp(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Given("the visitor is already on the Home page")
    public void theVisitorIsAlreadyOnTheHomePage() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.openWebPage();
    }

    @Given("visitor goes to Contact Us page")
    public void visitorGoesToContactUsPage() {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.goToContactUsPage();
    }

    @When("fill the required fields and send the information")
    public void fillTheRequiredFieldsAndSendTheInformation() {
        NewMessageController successMessage = new NewMessageController();
        successMessage.setWebAction(webAction);
        successMessage.fillRequiredContactUsFields();
    }
    @Then("a successful action message appears")
    public void aSuccessfulActionMessageAppears() {
        SuccessfulMessage successfulMessage  = new SuccessfulMessage();
        successfulMessage.setWebAction(webAction);
        String message = successfulMessage.getSuccessMessage();

        Assert.
                Hard
                .thatString(message)
                .isEqualTo(CONTACT_US_DONE_MESSAGE);
    }

    @When("fill the required fields except the subject heading and send the information")
    public void fillTheRequiredFieldsExceptTheSubjectHeadingAndSendTheInformation() {
        NewMessageController failedMessage = new NewMessageController();
        failedMessage.setWebAction(webAction);
        failedMessage.fillRequiredContactUsFieldsExceptSubjectHeading();
    }

    @Then("an error message appears related to subject heading")
    public void anErrorMessageAppearsRelatedToSubjectHeading() {
        ErrorBySubjectHeading error  = new ErrorBySubjectHeading();
        error.setWebAction(webAction);
        String message = error.getMessageErrorBySubjectHeading();

        Assert.
                Hard
                .thatString(message)
                .isEqualTo(CONTACT_US_ERROR_SUBJECT_HEADING);
    }

    @After
    public void closeDriver() {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** TEST HAS FINISHED ******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
