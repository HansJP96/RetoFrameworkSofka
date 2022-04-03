package com.automationpractice.webproject.test.stepdefinition.setup;

import co.com.sofka.test.automationtools.selenium.Browser;
import com.automationpractice.webproject.test.data.objects.TestInfo;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setIncognito(true);
        browserConfiguration.setAutoDriverDownload(true);
        browserConfiguration.setChromeOptions(chomeOptions());

        return browserConfiguration;
    }

    private ChromeOptions chomeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
