package com.Actitime.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GetAllTasksActi {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // navigate to browser
        driver.get("https://online.actitime.com/imatlori1");
        //wait for browser to launch
        Thread.sleep(10000);

       // Actions action =new Actions(driver);
        // locate username element and enter username
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
        //click on tasks
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        // click on space building
        driver.findElement(By.xpath("//div[text()='Spaceship building']")).click();
        // get all tasks in project
        List<WebElement> taskname = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
        Thread.sleep(2000);
      /*  for(WebElement element: taskname)
        {
            if (element.isDisplayed()){
                System.out.println(element.getText());
            } else
            {
                Actions actions=new Actions(driver);
                actions.scrollToElement(element).build().perform();
                System.out.println(element.getText());
            }
        }*/




    }
}
