package com.company.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

//    @Autowired
    protected WebDriver webdriver;

    public BasePage(WebDriver driver) {
        this.webdriver = driver;
        System.out.println("BasePage Webdriver is: " + driver);
        PageFactory.initElements(driver, this);
    }
}
