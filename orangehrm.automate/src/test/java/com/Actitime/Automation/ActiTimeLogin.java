package com.Actitime.Automation;

import com.actitime.automation.BaseClass;
import com.actitime.automation.CommonFunction;
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
    CommonFunction commonFunction;

    @BeforeClass
    public void setup() {
        driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        driver.manage().window().maximize();
        commonFunction = new CommonFunction(driver);
        loginPage = PageFactory.initElements(driver, Loginclass.class);
    }

    @BeforeMethod
    public void login() throws InterruptedException {
        loginPage.login("indiramatlori653@gmail.com", "indira@1234");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testmethod() throws InterruptedException {
        commonFunction.click(By.xpath("//div[text()='Tasks']"));

        //
        commonFunction.click(By.xpath("//div[@id='container_tasks']/following::div[1]"));
        Thread.sleep(5000);
        // click on
        commonFunction.click(By.xpath("//div[@class='createdTasksTableContainer']/following::div[3]"));
        Thread.sleep(5000);
        //
        //driver.findElement(By.xpath("//div[@class='changeStatus button']")).click();
        //Thread.sleep(50000);
        //
        commonFunction.click(By.xpath("//div[text()='Change Status']"));
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //
        commonFunction.click(By.xpath("//div[text()='New Status:']/following::div[6]"));
        Thread.sleep(5000);
        //
        commonFunction.click(By.xpath("//div[text()='click to view project settings']/following::div[28]"));
        Thread.sleep(5000);
        //
        commonFunction.click(By.xpath("//span[text()='Apply']"));
        Thread.sleep(5000);
        //
        // String statusChange = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[3]")).getText();
        // System.out.println(statusChange);
        //
        //driver.findElement(By.xpath("div[@text()='New Status']/following::div[7]"))
    }
}