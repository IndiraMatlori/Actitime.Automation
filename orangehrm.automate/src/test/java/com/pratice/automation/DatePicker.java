package com.pratice.automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class DatePicker {

      WebDriver driver;
      @Test
      public  void setup()throws InterruptedException {
          //Get the current day of the month
          int dayOfMonth = LocalDateTime.now().getDayOfMonth();
          System.out.println("Day of month is :" + dayOfMonth);

          String currentMonth = LocalDateTime.now().getMonth().name(); //APRIL
          String acutalCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase(); // April

          CommonFunctions commonFunctions = new CommonFunctions();
          driver = commonFunctions.lauchBrowser("chrome");
          driver.get("https://online.actitime.com/imatlori");
          //navigate to browser
          driver.manage().window().maximize();
          Thread.sleep(5000);



        driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(1000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
        // click on task
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(10000);
        //click on project
        driver.findElement(By.xpath("//div[text()='Galaxy Corporation']/following::div[5]")).click();
        Thread.sleep(5000);
        //click on task button
        driver.findElement(By.xpath("//div[@class='rightContainer']")).click();
        Thread.sleep(5000);
        //click on date section
        driver.findElement(By.xpath("//div[@]class='detailsRow']/descendant::div[text()='set up deadline']")).click();
       // String monthXpath="//td[starts-with(@title,'April')]/div";
        String monthXpath="//td[starts-with(@title,'"+acutalCurrentMonth+"')]/div";
        System.out.println(monthXpath);
        List<WebElement> days = driver.findElements(By.xpath(monthXpath));

        for ( WebElement dayElement : days)
        {
            String day =  dayElement.getText();
            System.out.println(day);
            if(day.equals( String.valueOf(dayOfMonth)))
            {
                dayElement.click();
            }
        }





    }
}