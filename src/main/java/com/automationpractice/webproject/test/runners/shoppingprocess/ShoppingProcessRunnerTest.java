package com.automationpractice.webproject.test.runners.shoppingprocess;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/shoppingProcess.feature"},
        glue = {"com.automationpractice.webproject.test.stepdefinition.shoppingprocess"},
        publish = true
)
public class ShoppingProcessRunnerTest {
}
