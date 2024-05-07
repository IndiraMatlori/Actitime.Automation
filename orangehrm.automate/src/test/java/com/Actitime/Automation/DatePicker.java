package com.Actitime.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) throws InterruptedException {

        //Get the current day of the month
        int dayOfMonth=LocalDateTime.now().getDayOfMonth();
        System.out.println("Day of month is :" +dayOfMonth);

        String currentMonth = LocalDateTime.now().getMonth().name(); //APRIL
        String acutalCurrentMonth=currentMonth.charAt(0) + currentMonth.substring(1,currentMonth.length()).toLowerCase(); // April

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("122");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        // navigate to browser
        driver.get("https://online.actitime.com/cybersuccess7");
        //wait for browser to launch
        Thread.sleep(5000);
        // locate username element and enter username
        driver.findElement(By.name("username")).sendKeys("cybersuccess@yopmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("Test@1234");
        Thread.sleep(5000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);
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