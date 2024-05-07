package com.pratice.automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExcelHandlingActi {
        WebDriver driver;
        @BeforeClass
        public void setup() {

            CommonFunctions commonFunctions = new CommonFunctions();
            driver = commonFunctions.lauchBrowser("chrome");
            driver.get("https://online.actitime.com/imatlori1");
            driver.manage().window().maximize();
        }
        @Test
        public void getlistoofcustproject() throws Exception {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js=(JavascriptExecutor)driver;

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username"))).sendKeys("indiramatlori653@gmail.com");
            driver.findElement(By.name("pwd")).sendKeys("indira@1234");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='loginButton']/child::div"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]"))).click();
    }
}
