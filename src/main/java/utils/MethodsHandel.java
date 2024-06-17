package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodsHandel {
    protected WebDriver driver;
    protected WebDriverWait wait;
    Actions action;

    public MethodsHandel(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    private void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    private void invisibleOf(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOf(webElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)));
    }

    private void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void click(By locator) {
//        invisibilityOf(loader,20);
        explicitWait(locator, 20);
        scrollIntoView(driver, webElement(locator));
        webElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
//        invisibilityOf(loader,20);
        explicitWait(locator, 20);
        scrollIntoView(driver, webElement(locator));
        webElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        explicitWait(locator, 20);
        scrollIntoView(driver, webElement(locator));
        return webElement(locator).getText();
    }

    private void actionMethods(By locator) {
        action = new Actions(driver);
        explicitWait(locator, 20);
    }


    protected void hoverOnElement(By locator) {
        actionMethods(locator);
        action.moveToElement(webElement(locator)).build().perform();
    }

    protected void clickWithAction(By locator) {
        actionMethods(locator);
        action.click(webElement(locator)).build().perform();
    }

}
