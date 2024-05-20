package com.Actitime.Automation;

import com.actitime.automation.BaseClass;
import com.actitime.automation.CommonFunction;
import com.actitime.automation.Loginclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class
AddUserinActitime extends BaseClass {
    WebDriver driver;
    CommonFunction commonFunction;
    Loginclass loginclass;

    @BeforeClass
    public void setup() throws Exception {
        driver = launchBrowser("chrome");
        loginclass=new Loginclass (driver);
        driver.get("https://online.actitime.com/imatlori");


        commonFunction = new CommonFunction(driver);
        //navigate to browser
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void login(){
        loginclass.login("indiramatlori653@gmail.com","indira@1234");
    }

    @Test
    public void AddUser() throws Exception {
        //navigate to task module and click
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        // navigate to user module and click on it
        driver.findElement(By.xpath("//div[@id='container_users']/following::div[1]")).click();
        Thread.sleep(5000);
        System.out.println("Hello world");
        //click on New User Button
        driver.findElement(By.xpath("//div[text()='New User']")).click();
        Thread.sleep(5000);
        //locate first name
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys("sindu");
        //locate last name
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys("Matlori");
        //locate Email ID
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys("indiramatlori@gmail.com");
        Thread.sleep(5000);
        //click department not Assigned dropdown
        driver.findElement(By.xpath("//div[@class='title'][text()='-- department not assigned --']")).click();
        Thread.sleep(5000);
        //selected the department and click on it
        driver.findElement(By.xpath("//div[text()='-- new department --']/following::div[2]")).click();
        Thread.sleep(5000);
        //click on save&send Invitation Button
        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
        Thread.sleep(5000);
        //click on close text
           /* JavascriptExecutor js=(JavascriptExecutor)driver;
            WebElement close =driver.findElement(By.xpath("//span[text()='Invite one more user']/following::div[1]"));
            js.executeScript("arguments[0].click();",close);*/
        WebElement closeButton = driver.findElement(By.xpath("//span[text()='Invite one more user']/following::div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(closeButton).build().perform();
        closeButton.click();
    }
}


