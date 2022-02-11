package com.company.test.spring;

import com.browserstack.junit.WebDriverRunner;
import com.company.test.pageobjects.DebugPage;
import com.company.test.steps.BaseSteps;
import com.company.test.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


import java.util.concurrent.TimeUnit;

public class ContextConf extends BaseSteps {

    @Bean(name = "webdriver", destroyMethod = "quit")
    @Scope("prototype")
    public WebDriver getWebDriver() {

        return WebDriverRunner.getWebDriver();
    }

    @Bean("wait")
    @Scope("prototype")
    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getWebDriver(), 5);
    }

    @Bean("debugPage")
    @Scope("prototype")
    public DebugPage getDebugPage() {
        return new DebugPage(getWebDriver());
    }

    @Bean("seleniumUtils")
    @Scope("prototype")
    public SeleniumUtils getSeleniumUtils() {
        return new SeleniumUtils(getWebDriver());
    }


}
