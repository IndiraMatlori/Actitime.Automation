package com.Actitime.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewCustomer {
    WebDriver driver;
    @BeforeClass
    public void setup() throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        // navigate to browser
        driver.get("https://online.actitime.com/imatlori1");
        //wait for browser to launch
        Thread.sleep(1000);

    }
    @Test()
    public void login() throws InterruptedException{
        // login with valid password
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        //clcik on login Button
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div[1]")).click();
        Thread.sleep(50000);
        //navigate to task module
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div")).click();
        Thread.sleep(5000);
        //click on add task button dropdown
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(5000);
        //click on create customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        //Enter the valid details
        driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys("LIC");
        Thread.sleep(5000);
        //click on add customer
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(5000);
        // click on add task dropdown
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(5000);
        //click on new project
        driver.findElement(By.xpath("//div[@class='item createNewProject']")).click();
        Thread.sleep(5000);
        //Enter valid details to create new project
        driver.findElement(By.xpath("(//input[@placeholder='Enter Project Name'])[2]")).sendKeys("insurance ");
        Thread.sleep(5000);
        //click on dropdrown to select customer in we want to create project.
        driver.findElement(By.xpath("//div[text()='Project name cannot be empty']/following::div[@class='dropdownButton']")).click();
        Thread.sleep(5000);
        //click to select the valid customer in which  want to create project
        driver.findElement(By.xpath("//div[text()='-- New Customer --']/following::div[3]")).click();
        //locate the task and enter the taskname1
        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[1]")).sendKeys("Indira");
        Thread.sleep(5000);
        //locate the task and enter the taskname2
        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[2]")).sendKeys("Arjun");
       Thread.sleep(5000);
        //locate the task and enter the taskname3
        //driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[3]")).sendKeys("yukta");
       // Thread.sleep(5000);

        //click on Assigned user button

        driver.findElement(By.xpath("//div[@class='assignedUsers selected']/child::span[1]")).click();
        Thread.sleep(1000);
        //click on Create project button
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();}
      //  driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
        //click on


    }


