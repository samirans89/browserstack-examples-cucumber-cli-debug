package com.company.test.steps;

import com.browserstack.junit.WebDriverRunner;
import com.company.test.spring.ContextConf;
import com.company.test.utils.SeleniumUtils;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

//    @Autowired
//    protected WebDriver webdriver;

    protected Duration waitDuration = Duration.ofSeconds(4, 0);
    protected Duration longWaitDuration = Duration.ofSeconds(20, 0);

    public String getUrl() {
        return "https://www.browserstack.com";
    }

}
