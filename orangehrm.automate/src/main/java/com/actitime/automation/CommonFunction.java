package com.actitime.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void waitElementToBeClickable(By by){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void fluentWait(By by) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(5))
                .withTimeout(Duration.ofSeconds(25))
                .ignoring(Exception.class);
        Function<WebDriver, WebElement> function = (driver1) -> {
            System.out.println("wait until the element is available..");
            return fluentWait.until(ExpectedConditions.elementToBeClickable(by));
        };
        fluentWait.until(function);
    }
    public void enterTestwithjs(String text,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='"+text+"';",element);
    }
    public void clickusingJS(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void ScrollBy(int x,int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+");");
    }
  /*public void click(WebElement element) {
       waitElementToBeClickable(element);
       element.click();}*/
    public void click(By by){
        fluentWait(by);
        driver.findElement(by).click();
    }


    }

