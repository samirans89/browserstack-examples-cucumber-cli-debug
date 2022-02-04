package com.company.test.steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutPageSteps extends BaseSteps {

    @Autowired
    private WebDriver webDriver;
    
    @And("I type {string} in Post Code")
    public void iTypeInPostCode(String postCode) {
        webDriver.findElement(By.cssSelector(".dynamic-form-field--postCode #provinceInput")).sendKeys(postCode);
    }

    @And("I click on Checkout Button")
    public void iClickOnCheckoutButton() {
        webDriver.findElement(By.id("checkout-shipping-continue")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-app > div > div > div > div > a > button"))).click();
    }

    @And("I enter shipping details {string}, {string}, {string}, {string} and {string}")
    public void iEnterShippingDetailsAnd(String first, String last, String address, String province, String postCode) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstNameInput"))).sendKeys(first);
        webDriver.findElement(By.id("lastNameInput")).sendKeys(last);
        webDriver.findElement(By.id("addressLine1Input")).sendKeys(address);
        webDriver.findElement(By.id("provinceInput")).sendKeys(province);
        webDriver.findElement(By.id("postCodeInput")).sendKeys(postCode);
    }
}
