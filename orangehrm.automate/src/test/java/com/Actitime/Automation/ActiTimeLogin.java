package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.Callable;

public class ActiTimeLogin {
    public static void main(String[] arg) throws Exception {
        CommonFunctions commonFunctions = new CommonFunctions();
        WebDriver driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        driver.manage().window().maximize();

       // locate username element and enter username
       driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
       //locate password element and  entre password
        driver.findElement(By.name("password")).sendKeys("indira@1234");
        Thread.sleep(5000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);
        //
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        //
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        // click on
        driver.findElement(By.xpath("//div[@class='createdTasksTableContainer']/following::div[3]")).click();
        Thread.sleep(5000);
        //
       //driver.findElement(By.xpath("//div[@class='changeStatus button']")).click();
       //Thread.sleep(50000);
        //
       driver.findElement(By.xpath("//div[text()='Change Status']")).click();
       driver.manage().window().maximize();
       Thread.sleep(5000);
        //
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[6]")).click();
        Thread.sleep(50000);
        //
        driver.findElement(By.xpath("//div[text()='click to view project settings']/following::div[28]")).click();
        Thread.sleep(50000);
        //
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        Thread.sleep(50000);
        //
        String statusChange= driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[3]")).getText();
                System.out.println(statusChange);
        //
        //driver.findElement(By.xpath("div[@text()='New Status']/following::div[7]"))






       

    }


}
