package com.Actitime.Automation;

import com.orangehrm.automation.BlankUser;
import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlankUserFields {
    WebDriver driver;
    @BeforeMethod
    public void setup()throws Exception {

        CommonFunctions commonFunctions = new CommonFunctions();
        driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        //navigate to browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test
            public void blankuser() throws Exception{

        BlankUser blankUser=new BlankUser(driver);

        //locate username element and enter username
        driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(1000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);

        // navigate to user module and click on it
        driver.findElement(By.xpath("//div[@id='container_users']/following::div[1]")).click();
        Thread.sleep(5000);
        //click on New User Button
        blankUser.clickUsermodule();
        Thread.sleep(5000);
        //first name ,last name,emailId
        blankUser.blanksfields("","Matlori","indiramatlori@gmail.com");
        Thread.sleep(5000);
        //locate last name
        //click on save&send Invitation Button
        blankUser.clicksave();
        Thread.sleep(5000);

        String error1=driver.findElement(By.xpath("//span[text()='Please correct all errors in the fields highlighted in red']")).getText();

        blankUser.verifyerrormag(error1);
        //click on cancel button
        blankUser.clickcancel();
        Thread.sleep(2000);
        try {
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
        } catch (Exception e) {
            System.out.println("No alert present");
        };
        Thread.sleep(5000);
        //click on New User Button
        blankUser.clickUsermodule();
        //first name ,last name,emailId
        blankUser.blanksfields("","","indiramatlori@gmail.com");
        Thread.sleep(5000);
        //click on save&send invitation button
        blankUser.clicksave();
        Thread.sleep(5000);

        error1=driver.findElement(By.xpath("//span[text()='Please correct all errors in the fields highlighted in red']")).getText();
        blankUser.verifyerrormag(error1);
        //click on cancel button
        blankUser.clickcancel();
        Thread.sleep(2000);
        try {
            Alert alert2 = driver.switchTo().alert();
            alert2.accept();
        } catch (Exception e) {
            System.out.println("No alert present");
        }
        Thread.sleep(5000);
        //click on New User Button
        blankUser.clickUsermodule();
        //loacte name.last name&email field.
        blankUser.blanksfields("234343","","indiramatlori@gmail.com");
        Thread.sleep(5000);
        //click on save&send invitation button
        blankUser.clicksave();
        Thread.sleep(5000);

        error1=driver.findElement(By.xpath("//span[text()='Please correct all errors in the fields highlighted in red']")).getText();
        blankUser.verifyerrormag(error1);
        //click on cancel button
        blankUser.clickcancel();
        Thread.sleep(2000);
        Alert alert3 = driver.switchTo().alert();
        alert3.accept();
        //click on New User Button
        blankUser.clickUsermodule();
        Thread.sleep(5000);
        //first name ,last name,emailId
        blankUser.blanksfields("Indira","Matlori","indiramatlori");
        Thread.sleep(5000);
        //locate last name
        //click on save&send Invitation Button
        blankUser.clicksave();
        Thread.sleep(5000);

        String error2=driver.findElement(By.id("createUserPanel_emailInvalidError")).getText();
       if (error2.equals("invalid email address")){
            System.out.println("test cases4 passs");
        }
        else {
            throw new Exception("Test cases4 fail");
        }
        blankUser.verifyerrormag(error1);
        //click on cancel button
        blankUser.clickcancel();
        Thread.sleep(2000);
        Alert alert4 = driver.switchTo().alert();
        alert4.accept();


    }
}
