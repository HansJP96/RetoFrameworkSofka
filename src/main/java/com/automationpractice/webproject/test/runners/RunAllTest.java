package com.automationpractice.webproject.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactUs.feature",
                "src/main/resources/features/shoppingProcess.feature"},
        glue = {"com.automationpractice.webproject.test.stepdefinition.contactus",
                "com.automationpractice.webproject.test.stepdefinition.shoppingprocess"},
        publish = true
)
public class RunAllTest {
}
