package com.company.test.utils;

import com.browserstack.junit.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Component
public class SeleniumUtils {

    private WebDriver webDriver;
    JavascriptExecutor js;
    private double retryCount;
    WebDriverWait wait;

    public SeleniumUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
        js = (JavascriptExecutor) webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }

    public boolean safeElementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollIntoView(String xpath) {
        WebElement element = webDriver.findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilVisible(Duration waitDuration, WebElement element) {
        try {
            wait.withTimeout(waitDuration).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ignore) {

        }
    }

    public void waitUntilVisible(Duration waitDuration, List<WebElement> elements) {
        try {
            wait.withTimeout(waitDuration).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception ignore) {

        }
    }

    public void waitSeconds(double seconds) {
        try {
            Thread.sleep(new Double(seconds * 1000).intValue());
        } catch (InterruptedException e) {
        }
    }

    public void generalScroll() {
        for (int i = 0; i < 8; i++) {
            js.executeScript(String.format("window.scrollBy(0,%s)", 300));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void waitUntilListSizeGreatenThanOne(Duration waitDuration, List<WebElement> elements) {
        while (elements.size() < 2 && retryCount < waitDuration.getSeconds()) {
            retryCount++;
            waitSeconds(1);
        }
    }

}
