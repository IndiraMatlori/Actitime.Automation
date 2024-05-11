package com.Actitime.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateCustomerActi {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        // navigate to browser
                driver.get("https://online.actitime.com/imatlori");
        //wait for browser to launch
        Thread.sleep(5000);

        // locate username element and enter username
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");

        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(5000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);
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
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("25657");
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
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("y45thhgg3gv");
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
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("tnutrfh");
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();

        Thread.sleep(5000);

        //4 click on add new

        driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
        //click on New customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(5000);
        // Enter customer name as only special character
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("@irsy43gv");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(5000);


            }
}
