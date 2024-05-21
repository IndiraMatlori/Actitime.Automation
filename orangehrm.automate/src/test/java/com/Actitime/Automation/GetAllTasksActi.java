package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllTasksActi {
    WebDriver driver;
    @BeforeClass
    public void setup()throws Exception {

        CommonFunctions commonFunctions = new CommonFunctions();
        driver = commonFunctions.lauchBrowser("chrome");
        driver.get("https://online.actitime.com/imatlori");
        //navigate to browser
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }
    @Test()
    public void login() throws Exception{
        // login with valid password
        driver.findElement(By.name("username")).sendKeys("indiramatlori653@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(5000);
        //clcik on login Button
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div[1]")).click();
        Thread.sleep(50000);
        //click on tasks
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        // click on space building
        driver.findElement(By.xpath("//div[text()='Spaceship building']")).click();
        // get all tasks in project
       // List<WebElement> taskname = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
       // Thread.sleep(2000);
        List<WebElement> webElementList = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
        System.out.println("Size of task : " + webElementList.size());
        for (WebElement element : webElementList) {
            if (element.isDisplayed()) {
                System.out.println("task : " + element.getText());
            } else {
                Actions actions = new Actions(driver);
                actions.scrollToElement(element).build().perform();
                System.out.println("task: " + element.getText());
            }
        }




    }
}
