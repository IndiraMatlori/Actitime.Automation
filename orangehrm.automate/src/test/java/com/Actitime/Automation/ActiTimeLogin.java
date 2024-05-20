package com.Actitime.Automation;

import com.actitime.automation.BaseClass;
import com.actitime.automation.Loginclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActiTimeLogin extends BaseClass {
    WebDriver driver;
    Loginclass loginPage;

    @BeforeClass
    public void setup() {
        driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, Loginclass.class);
    }

    @BeforeMethod
    public void login() throws InterruptedException {
        loginPage.login("indiramatlori653@gmail.com", "indira@1234");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testmethod() throws InterruptedException {
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
        String statusChange = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[3]")).getText();
        System.out.println(statusChange);
        //
        //driver.findElement(By.xpath("div[@text()='New Status']/following::div[7]"))
    }
}