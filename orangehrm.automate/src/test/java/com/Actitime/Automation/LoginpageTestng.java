package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginpageTestng {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins");
        driver = new ChromeDriver();

        driver.get("https://online.actitime.com/imatlori1");
        driver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Login with valid credential")
    public void Test1() throws Exception {
        // locate username element and enter username
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(5000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);
        //click on logout
        driver.findElement(By.xpath("(//a[text()='Logout'])[1]")).click();
    }

    @Test(priority = 2, description = "login with invalid credentials")
    public void test() throws InterruptedException {  //find username and enter username
        driver.findElement(By.name("username")).sendKeys("infiramatlroi653@gmail.comd");
        // click on login button
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();

        //verfy the error msg
        String msg = driver.findElement(By.xpath("(//span[@class='errormsg'])[1]")).getText();
        if (msg.equals("Username or Password is invalid. Please try again.")) {
            System.out.println("test case pass");
        } else {
            System.out.println("test cases fail ");
        }
    }
}


