package com.actitime.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Baseclass {
    WebDriver driver;

    public WebDriver launchBrowser(String browserName) {
        switch (browserName){
            case "chrome":
                ChromeOptions options=new ChromeOptions();
                options.setBrowserVersion("stable");
                options.addArguments("--remote-allow-origins=*");
                driver =new ChromeDriver(options);
                break;
            case "edge":
                EdgeOptions edgeOptions=new EdgeOptions();
               edgeOptions.setBrowserVersion("stable");

                driver =new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxoptions=new FirefoxOptions();
                firefoxoptions.setBrowserVersion("stable");
                firefoxoptions.addArguments("--remote-allow-origins=*");
                driver =new FirefoxDriver(firefoxoptions);
                break;
            default:
                ChromeOptions chromeoptions=new ChromeOptions();
                chromeoptions.setBrowserVersion("stable");
                chromeoptions.addArguments("--remote-allow-origins=*");
                driver =new ChromeDriver(chromeoptions);
                break;

        }
     driver.manage().window().maximize();
        return  driver;
    }
}


