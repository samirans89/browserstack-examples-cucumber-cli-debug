package com.company.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class BasePage {

//    @Autowired
    protected WebDriver webdriver;

    public BasePage(WebDriver driver) {
        this.webdriver = driver;
        System.out.println("BasePage Webdriver is: " + driver);
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
