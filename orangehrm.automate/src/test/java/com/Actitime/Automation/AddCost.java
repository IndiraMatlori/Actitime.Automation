package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AddCost {
WebDriver driver;
    @BeforeClass
    public void setup() {

        CommonFunctions commonFunctions = new CommonFunctions();
        driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        driver.manage().window().maximize();
    }
     @Test
     public void addrate() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js=(JavascriptExecutor)driver;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username"))).sendKeys("indiramatlori653@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='loginButton']/child::div"))).click();

      //  Thread.sleep(1000);

      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='label'][text()='Users']"))).click();

        //Thread.sleep(5000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS);

        driver.findElement(By.xpath("//span[@id='userListTableContainer']/descendant::span[3]")).click();
        driver.findElement(By.xpath("//label[@id='ext-gen515'][text()='Selected users']")).click();
        driver.findElement(By.xpath("//span[@title='Womack, Ashley']")).click();
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Apply'])[2]"))).click();
        Thread.sleep(5000);
        String element = driver.findElement(By.xpath("//span[@class='userNameSpan']")).getText();
        if (element.equals("Womack, Ashley")) {
            System.out.println("tes case pass");
        } else {
            throw new Exception("test case fail");
        }

        driver.findElement(By.xpath("//span[@class='userNameSpan']")).click();
        Thread.sleep(5000);


        Actions actions = new Actions(driver);
       WebElement element1= driver.findElement(By.xpath("//div[@class='edit_user_sliding_panel sliding_panel components_panelContainer']/descendant::span[17]"));
        actions.scrollToElement(element1).build().perform();

        driver.findElement(By.xpath("//div[@class='edit_user_sliding_panel sliding_panel components_panelContainer']/descendant::span[17]")).click();

        actions.scrollToElement(element1).build().perform();
        driver.findElement(By.xpath("//div[@id='editUserPanel']/descendant::input[17]")).sendKeys("500");
        WebElement element2=driver.findElement(By.xpath("(//div[@class='copyLink_panelContainer']/following::div[1])[1]"));
       js.executeScript("arguments[0].click();",element2);



         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='userNameCell first']/following::div[6]"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='userNameCell first']/following::div[6]"))).click();
//          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accountSettingsTab selected']/child::span"))).click;
         //driver.findElement(By.xpath("//div[@class='edit_user_sliding_panel sliding_panel components_panelContainer']/descendant::span[17]")).click();











    }

}