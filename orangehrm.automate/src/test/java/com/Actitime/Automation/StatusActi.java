package com.Actitime.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StatusActi {
    public static void main(String[] args)  throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // navigate to browser
        driver.get("https://online.actitime.com/imatlori1");
        driver.manage().window().maximize();
        //wait for browser to launch
        Thread.sleep(1000);

        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div[1]")).click();
        Thread.sleep(50000);
        // click on task module
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div")).click();
        Thread.sleep(50000);
        //click on flight operations project
        driver.findElement(By.xpath("//div[@class='text'][text()='Flight operations']")).click();
        Thread.sleep(1000);
        //click on status dropdown
        driver.findElement(By.xpath("(//div[@class='components-DataFilters-text--V3cbC8fc'])[1]")).click();
        Thread.sleep(1000);
        //click on selected radio button
        driver.findElement(By.xpath("(//input[@class='components-RadioButton-input--v36FTnfk'])[2]")).click();
        Thread.sleep(1000);
        //click on new status
        driver.findElement(By.xpath("//span[text()='Open tasks']/following::span[1]")).click();
       // click on apply button
        driver.findElement(By.xpath("//div[text()='Apply']")).click();
    }
}
