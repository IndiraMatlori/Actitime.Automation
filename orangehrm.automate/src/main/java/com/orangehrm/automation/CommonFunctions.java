package com.orangehrm.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommonFunctions {
    WebDriver driver;
    public WebDriver lauchBrowser(String Browsername){
        if(Browsername.toLowerCase().equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("121");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }
        return driver;
    }
}
