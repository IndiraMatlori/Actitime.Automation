package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteUser {

        WebDriver driver;
        @BeforeClass
        public void setup() throws Exception {
            CommonFunctions commonFunctions = new CommonFunctions();
            driver = commonFunctions.lauchBrowser("chrome");
            driver.get("https://online.actitime.com/imatlori");
            //navigate to browser
            driver.manage().window().maximize();
            Thread.sleep(5000);
        }
        @Test
                public void createuser() throws Exception {
            //locate username element and enter username
            driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
            //locate password element and  entre password
            driver.findElement(By.name("pwd")).sendKeys("indira@1234");
            Thread.sleep(1000);
            //click on loginbutton
            driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
            Thread.sleep(5000);

            // navigate to user module and click on it
            driver.findElement(By.xpath("//div[@id='container_users']/following::div[1]")).click();
            Thread.sleep(1000);
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
            driver.findElement(By.xpath("//*[@id='createUserPanel']/div[2]/div[1]/div[5]/span")).click();
            Thread.sleep(5000);
            System.out.println("user created successfully");
        }
        @Test
                public void deleteuser()throws Exception{
        //select and click  on user u want to delete
        driver.findElement(By.xpath("//span[text()='success, cyber']")).click();
        Thread.sleep(5000);
        //click on delete text/button
        driver.findElement(By.xpath("//div[@class='action'][text()='DELETE']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("user deleted successfully");

        }
    }

