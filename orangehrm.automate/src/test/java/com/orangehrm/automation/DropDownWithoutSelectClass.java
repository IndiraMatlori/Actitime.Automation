package com.orangehrm.automation;

import com.orangehrm.automation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropDownWithoutSelectClass {
    public static void main(String[] args) throws Exception {
        //
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("122");
        options.addArguments("--remote-allows-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);

        LoginPage loginPage = new LoginPage(driver);

        // login with vaild username and password
        loginPage.login("Admin", "admin123");
        Thread.sleep(10000);
        // click on PIM module
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        // click on dropdown job tilte
        driver.findElement(By.xpath("//div@class='oxd-form-row']/div[6]//i")).click();
        //select Automation Tester from the dropdown
        driver.findElement(By.xpath("//div[@role='Listbox']//div[3]/span")).click();
    }
}
