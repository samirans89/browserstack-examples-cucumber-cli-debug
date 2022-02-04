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
    @Scope("singleton")
//    @Scope("prototype")
    public WebDriver getWebDriver() {
        WebDriver webdriver = WebDriverRunner.getWebDriver();
        System.out.println("getWebDriver webdriver object is: " + webdriver);
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webdriver;
    }

    @Bean("wait")
    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getWebDriver(), 5);
    }

    @Bean("debugPage")
    public DebugPage getDebugPage() {
        return new DebugPage(getWebDriver());
    }

    @Bean("seleniumUtils")
    public SeleniumUtils getSeleniumUtils() {
        return new SeleniumUtils(getWebDriver());
    }


}
