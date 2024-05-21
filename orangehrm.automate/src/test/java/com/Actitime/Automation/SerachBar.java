package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SerachBar {
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
   public void serachbar()throws Exception{
        //locate username element and enter username
        driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(1000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(1000);
        //navigate to task module and click
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='searchFieldContainer']/descendant::input")).sendKeys("Big Bang Company");
    }
}
