package com.testinium.methods;

import com.testinium.setup.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class DriverMethods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jExecutor;
    Actions actions;

    public DriverMethods() {
        driver = TestBase.driver;
        wait = new FluentWait<WebDriver>(driver) {{
            withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(30))
            .ignoring(NoSuchElementException.class);
        }};

        jExecutor = (JavascriptExecutor)driver;
        actions = new Actions(driver);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void clickElement(By by) {
        findElement(by).click();
    }

    public void scrollToElementJS(WebElement element) {
        jExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementJS(WebElement element) {
        jExecutor.executeScript("arguments[0].click();", element);
    }

    public void clickElementJS(By by) {
        jExecutor.executeScript("arguments[0].click();", findElement(by));
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void scrollToElement(By by) {
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void sendKeys(By by, String key) {
        findElement(by).sendKeys(key);
    }

    public String getAttribute(By by, String attr) {
        return findElement(by).getAttribute(attr);
    }

    public String getElementText(By by) {
        return findElement(by).getText();
    }

    public WebElement getRandomElement(By by) {
        List<WebElement> eList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return eList.get(getRandomNumber(eList.size())); 
    }

    // starts from 1
    public WebElement getElementAt(By by, int index) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).get(index - 1);
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public Select getSelect(WebElement element) {
        return new Select(element);
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    // takes double argument for fractional time periods (i.e. 4.5 seconds)
    public void waitForSeconds(double seconds) {
        try {
            // from #.### to #### pattern  
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // helper methods
    public int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}