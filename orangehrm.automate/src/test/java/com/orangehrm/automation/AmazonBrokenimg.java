package com.orangehrm.automation;

import io.opentelemetry.api.trace.StatusCode;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class AmazonBrokenimg {
    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("122");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");

       List<WebElement> image = driver.findElements(By.tagName("img"));
        for(WebElement linkimg : image){
            String listoflinks =linkimg.getAttribute("src");
            {
                System.out.println(listoflinks);
            }
          /*  {  // convert string url to url using port
                URL url = new URL(listoflinks);
                URLConnection connection =url.openConnection();
                HttpURLConnection urlConnection =(HttpURLConnection)connection;
                urlConnection.connect();
               int statuscode = urlConnection.getResponseCode();
               if(statuscode !=200){
                   System.out.println("AmazonBrokenimg: " + statuscode + listoflinks );
               }*/

            }

        }

    }


