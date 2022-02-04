package com.company.test.steps;

import com.company.test.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageSteps extends BaseSteps {

    @Autowired
    private WebDriver webDriver;
    
    @And("I press Log In Button")
    public void iPressLogin() {
        webDriver.findElement(By.cssSelector(".Button_root__24MxS")).click();
    }

    @Then("I should see {string} as Login Error Message")
    public void iShouldSeeAsLoginErrorMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        try {
            String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".api-error"))).getText();
            Assert.assertEquals(expectedMessage, errorMessage);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Error in logging in");
        }
    }

    @And("I SignIn as {string} with {string} password")
    public void iSignInAsWithPassword(String username, String password) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        webDriver.findElement(By.linkText("Sign In")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username > div > div:nth-child(1)"))).click();
        webDriver.findElement(By.id("react-select-2-input")).sendKeys(username);
        webDriver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
        webDriver.findElement(By.cssSelector("#password > div > div:nth-child(1)")).click();
        webDriver.findElement(By.id("react-select-3-input")).sendKeys(password);
        webDriver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        webDriver.findElement(By.cssSelector(".Button_root__24MxS")).click();
        TestUtils.mockGPS(webDriver);

    }
}
