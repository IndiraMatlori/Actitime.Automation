package com.Actitime.Automation;

import com.orangehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteDepartment {
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
    @Test
            public void deletedepartment() throws Exception{
        //locate username element and enter username
        driver.findElement(By.id("username")).sendKeys("indiramatlori653@gmail.com");
        //locate password element and  entre password
        driver.findElement(By.name("pwd")).sendKeys("indira@1234");
        Thread.sleep(1000);
        //click on loginbutton
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(1000);

        // navigate to user module and click on it
        driver.findElement(By.xpath("//div[@id='container_users']/following::div[1]")).click();
        Thread.sleep(5000);
        //click on New User Button
        driver.findElement(By.xpath("//div[text()='New User']")).click();
        Thread.sleep(5000);
        //locate first name
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys("cyber");
        //locate last name
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys("success");
        //locate Email ID
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys("indiramatlori@gmail.com");
        Thread.sleep(5000);

        //click department not Assigned dropdown
        driver.findElement(By.xpath("(//div[text()='-- department not assigned --']/following::div[1])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='-- new department --']")).click();
         Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@placeholder='New Department Name'])[2]")).sendKeys("Wpiro");
        //selected the department and click on it
       // driver.findElement(By.xpath("//div[text()='-- new department --']/following::div[2]")).click();
        Thread.sleep(5000);
        //click on save&send Invitation Button
        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
        Thread.sleep(5000);
        //click on close text
        //  driver.findElement(By.xpath("//span[text()='Invite one more user']/following::div[1]")).click();
        // Thread.sleep(5000);
        //click on Bluk invitations dropdown
       // driver.findElement(By.xpath("//div[@class='components_button addSeveralUsersButton dropdown']/child::div[1]")).click();
        //click on department button
        driver.findElement(By.xpath("//div[@class='userList_manageButtons_component_groupItem department ']")).click();
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        WebElement element1= driver.findElement(By.xpath("//*[@id='groupManagementLightBox_userGroupNameCell_12']/div/div[1]"));
        actions.moveToElement(element1).build().perform();
        //click on delete symbol
        driver.findElement(By.xpath("//*[@id='groupManagementLightBox_userGroupDeleteLink_12']")).click();
        //click on yes Delete message
        driver.findElement(By.xpath("//*[@id='groupManagementLightBox_confirmDeleteAcceptButton_12']")).click();
    }
}
