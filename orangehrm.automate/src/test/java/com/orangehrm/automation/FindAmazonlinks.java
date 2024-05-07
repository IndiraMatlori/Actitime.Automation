package com.orangehrm.automation;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class FindAmazonlinks {
    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("122");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");


       List<WebElement> Elementlinks =  driver.findElements(By.tagName("a"));
       for (WebElement element : Elementlinks)
        {
             String link = element.getAttribute("href");
             if(link != null && !link.equals("javascript: void(0)")) {
                 // converting string url to actual url
                 URL url = new URL(link);
                 // opening the connection for an url using port
                 URLConnection connection =url.openConnection();
                 //cast connection var into httpurlconnection
                 HttpURLConnection urlConnection=(HttpURLConnection) connection;//type cast(upcasting)
                 //hit the url
                 urlConnection.connect();
                 //get the staus code
                 int statuscode = urlConnection.getResponseCode();
                         if (statuscode != 200 ){
                             System.out.println("Broken URl :" +statuscode +"  " + link);
                         }



             }
        }


    }
}
