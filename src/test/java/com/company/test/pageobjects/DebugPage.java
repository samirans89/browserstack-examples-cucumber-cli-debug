package com.company.test.pageobjects;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

public class DebugPage extends BasePage {

    public DebugPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@class='product-cards-wrapper--click--hoverclick']")
    private WebElement liveOption;


    @FindBy(xpath = "//*[@title='Pricing']")
    private WebElement pricing;

    public WebElement getLiveOption() {
        return liveOption;
    }

    public WebElement getPricing() {
        return pricing;
    }
}
