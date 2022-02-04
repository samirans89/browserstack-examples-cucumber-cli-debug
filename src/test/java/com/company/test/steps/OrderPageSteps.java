package com.company.test.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class OrderPageSteps extends BaseSteps {

    @Autowired
    private WebDriver webDriver;
    
    @Then("I should see elements in list")
    public void iShouldSeeElementsInList() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout")));
        WebElement element;
        try {
            element = webDriver.findElement(By.cssSelector("#__next > main > div > div"));
            List<WebElement> orders = element.findElements(By.tagName("div"));
            Assert.assertNotEquals(0, orders.size());
        } catch (NoSuchElementException e) {
            throw new AssertionError("There are no orders");
        }
    }

}
