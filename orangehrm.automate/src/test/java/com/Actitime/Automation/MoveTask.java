package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MoveTask {
 WebDriver driver;
 public void setup() throws Exception {

        CommonFunctions commonFunctions = new CommonFunctions();
       driver  = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        }
        @Test
        public void movetask() throws Exception{
        driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);
        //click on task button
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        driver.findElement(By.xpath("(//div[text()='Spaceship building'])[1]")).click();
        Thread.sleep(3000);

        //selected checkbox for task
        WebElement element=driver.findElement(By.xpath("(//div[@class='img'])[1]"));
        element.click();
        Thread.sleep(8000);
        //click on move to button
        WebElement moveToButton=driver.findElement(By.xpath("//div[@class='moveTo button'][text()='Move to']"));
        moveToButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='- Select Customer -']")).click();
        Thread.sleep(3000);
        //selected customer from dropdown
        driver.findElement(By.xpath("(//div[text()='Galaxy Corporation'])[2]")).click();
//      select project
        driver.findElement(By.xpath("//div[text()='- Select Project -']")).click();
        //selct project from dropdwon
        driver.findElement(By.xpath("(//div[text()='Android prototyping'])[2]")).click();
        //select move
        driver.findElement(By.xpath("(//div[text()='Move'])[3]")).click();
        String emptytask=driver.findElement(By.xpath("//tr[@class='summary']/descendant::span[1]")).getText();
        String zeroTask="Total for 0 tasks:";
        if(emptytask.equals(zeroTask)){
            System.out.println("Task is successfully moved ");
        }
        else {
            System.out.println("Task move");
        }

    }

}