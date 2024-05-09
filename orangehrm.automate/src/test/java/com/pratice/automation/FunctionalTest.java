package com.pratice.automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class FunctionalTest {

    public static void main(String[] args) throws Exception {
        // Define the URL, username, and password
        String url = "https://demo.dealsdray.com/";
        String username = "prexo.mis@dealsdray.com";
        String password = "prexo.mis@dealsdray.com";

        // Define the path to the XLSX file
        String xlsxFilePath = "C:\\Users\\Indira\\Downloads\\demo-data (1).xlsx";

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get(url);

        // Login to the application
        driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.manage().window().maximize();

        // Wait for the dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Upload the XLSX file
        WebElement uploadButton = driver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(new File(xlsxFilePath).getAbsolutePath());

        // Wait for the upload to complete
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("upload-status")), "Completed"));

        // Take a screenshot of the final output page
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("screenshot.png"));

        // Close the WebDriver
        driver.quit();
    }
}