package com.Actitime.Automation;

import com.actitime.automation.BaseClass;
import com.actitime.automation.CommonFunction;
import com.orangehrm.automation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUploadTest extends BaseClass {

    WebDriver driver;
    LoginPage loginPage;
    CommonFunction commonFunction;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = launchBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123");
        commonFunction = new CommonFunction(driver);
    }

    @Test
    public void verifyFileUpload() throws IOException, InterruptedException {
        commonFunction.click(By.xpath("//span[text()='My Info']"));
        commonFunction.click(By.xpath("//img[@class='employee-image']"));
        commonFunction.click(By.xpath("//input[@type='file']/following-sibling::div/button"));
        Thread.sleep(1000);
//        Runtime.getRuntime().exec("F:\\upload.exe");
        Runtime.getRuntime().exec("F:\\UploadFile.exe F:\\ProfileImage.PNG");


    }


}
