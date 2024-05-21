package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CreateCustomerActi {

        WebDriver driver;
    public void setup() throws Exception {
        CommonFunctions commonFunctions = new CommonFunctions();
        driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        //navigate to browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test
    public void createcust() throws Exception{
        // locate username element and enter username
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");

        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(5000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(1000);
        //click task module
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div")).click();
        Thread.sleep(5000);
        //1 customer click on add New

        driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
        Thread.sleep(5000);
        //click on New customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        // Enter customer name as numeric values
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("123");
        Thread.sleep(5000);
        //click on add new customer
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(5000);

        //2 click on add new

        driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
        Thread.sleep(5000);
        //click on New customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        // Enter customer name as alpha numeric values
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("ABC123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(5000);

        //3 click on add new

        driver.findElement(By.xpath("//div[@class='plusIcon']/following::div[1]")).click();
        Thread.sleep(5000);
        //click on New customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        // Enter customer name as alphabets
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("ABCEGF");
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();

        Thread.sleep(5000);

        //4 click on add new

        driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
        //click on New customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        // Enter customer name as only special character
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("@#$%!");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(5000);


            }
}
