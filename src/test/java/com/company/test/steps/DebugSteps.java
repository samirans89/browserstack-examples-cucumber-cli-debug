package com.company.test.steps;

import com.company.test.pageobjects.DebugPage;
import com.company.test.spring.ContextConf;
import com.company.test.utils.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@CucumberContextConfiguration
@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes = ContextConf.class)
public class DebugSteps extends BaseSteps {

    @Autowired
    private WebDriver webdriver;
    @Autowired
    private SeleniumUtils seleniumUtils;
    @Autowired
    private DebugPage debugPage;

    @Given("I go to homepage")
    public void iGoToHomepage() {
        webdriver.get(getUrl());
    }

    @Given("I click on LIVE")
    public void iClickOnLive() {
//        seleniumUtils.generalScroll();
        seleniumUtils.waitUntilVisible(longWaitDuration, debugPage.getLiveOption());
        debugPage.getLiveOption().click();
    }

    @Given("I click on Pricing")
    public void iClickOnPricing() {
//        seleniumUtils.generalScroll();
        seleniumUtils.waitUntilVisible(longWaitDuration, debugPage.getPricing());
        debugPage.getPricing().click();
    }

    @And("I verify current URL contains {string}")
    public void iVerify(String s) {
        System.out.println("iVerify webdriver object is: " + webdriver);
        String currentUrl = webdriver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.contains(s));
    }
}
