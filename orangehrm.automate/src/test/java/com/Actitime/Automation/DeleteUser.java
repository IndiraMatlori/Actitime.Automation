package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteUser {
    public static void main(String[] args) throws Exception {
        CommonFunctions commonFunctions = new CommonFunctions();
        WebDriver driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori1");
        //navigate to browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //locate username element and enter username
        driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(1000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
        //navigate to task module and click
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        // navigate to user module and click on it
        driver.findElement(By.xpath("//div[@id='container_users']/following::div[1]")).click();
        Thread.sleep(5000);
        //click on New User Button
        driver.findElement(By.xpath("//div[text()='New User']")).click();
        Thread.sleep(5000);
        //locate first name
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys("cyber");
        //locate last name
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys("success");
        //locate Email ID
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys("indiramatlori@gmail.com");
        Thread.sleep(5000);
        //click department not Assigned dropdown
        driver.findElement(By.xpath("(//div[text()='-- department not assigned --']/following::div[1])[1]")).click();
        Thread.sleep(5000);
        //selected the department and click on it
        driver.findElement(By.xpath("//div[text()='-- new department --']/following::div[2]")).click();
        Thread.sleep(5000);
        //click on save&send Invitation Button
        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
        Thread.sleep(5000);
        //click on close text
      //  driver.findElement(By.xpath("//span[text()='Invite one more user']/following::div[1]")).click();
       // Thread.sleep(5000);
        //select and click  on user u want to delete
        driver.findElement(By.xpath("//span[text()='success, cyber']")).click();
        Thread.sleep(5000);
        //click on delete text/button
        driver.findElement(By.xpath("//div[@class='action'][text()='DELETE']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        }
    }

