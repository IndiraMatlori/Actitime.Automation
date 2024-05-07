package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteCustomer {
    WebDriver driver;

    @BeforeClass
    public void setup() throws Exception
    {
        CommonFunctions commonFunctions = new CommonFunctions();
         driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori1");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test(priority = 1)
    public void login() throws Exception{

        //login with valid username
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(5000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);



   // @Test(priority = 2)
   // public void dashboard() throws Exception {
        // verify u successfully login Or landed on Dashboard
        String landed = driver.findElement(By.xpath("//div[@id='container_tt']/following::div[1]")).getText();
        if (landed.equals("Time-Track")) {
            System.out.println("successfully landed on Dashboard");
        } else {
            throw new Exception("failed to login");
        }

        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void Task() throws Exception{
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        //click on add new button
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(5000);
        //click on create customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        //Enter the valid details
        driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys("pplSoftware");
        Thread.sleep(5000);
        //click on add customer
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(5000);
        //click on setting logo
        driver.findElement(By.xpath("(//div[@class='collapseButton']/following::div[5])[5]")).click();
        Thread.sleep(5000);
        //click on Action button
        driver.findElement(By.xpath("//div[@class='customerNamePlaceHolder']/following::div[5]")).click();
        Thread.sleep(5000);
        //clcik on Delete button
        driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();
        Thread.sleep(5000);
        //click on Delete permanently logo
        driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();

    }
}