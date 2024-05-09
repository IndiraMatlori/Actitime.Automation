package com.actitime.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class CommonFunction{
    WebDriver driver;
    public CommonFunction(WebDriver driver){this.driver=driver;}
    public  void waitforElementtobepresent(By by){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void fluentWait(By by) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).pollingEvery(Duration.ofSeconds(5)).withTimeout(Duration.ofSeconds(25)).ignoring(Exception.class);
        Function<WebDriver, WebElement> function = (var) -> {
            System.out.println("wait until the element is available..");

             return driver.findElement(by);
        };


    }
}
