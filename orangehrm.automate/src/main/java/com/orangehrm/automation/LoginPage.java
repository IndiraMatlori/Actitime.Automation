package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
this.driver = driver;
    }

    public  void login(String username,String password)
    {        // locate the username element
         driver.findElement(By.name("username")).sendKeys(username);
           // locate the password element
         driver.findElement(By.name("password")).sendKeys(password);
         // locate  login button
         driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
    public  void logout()
    {
        //locate dropdown
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();
        // locate logout
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

    }
    public void verifyerrormsg(String errormsg)throws Exception
    {
        if (errormsg.equals("Invalid credentials"))
        {
            System.out.println("test casses pass for invalid credentials");
        }
        else
        {
            throw new Exception("fail: for invalid credentials or error msg is not Displayed");
        }
    }
   /*public void verifyrequiredmsg(String error1)throws Exception
    {
        if(error1.equals("Required") && error1.equals("Required"))
        {
            System.out.println("test cases passed for blank credentails ");
        }
        else
        {
            throw new Exception("test cases failed for blank credentails");
        }
    }*/


    }



