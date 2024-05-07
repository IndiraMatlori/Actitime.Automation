package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlankUser {
    WebDriver driver;
   public BlankUser(WebDriver driver){this.driver=driver;}
    public void clickUsermodule(){
        driver.findElement(By.xpath("//div[text()='New User']")).click();
    }
    public void blanksfields(String Name,String LastName,String EmailId){
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys(Name);

        //locate last name
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys(LastName);
        //locate Email ID
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys(EmailId);
    }
    public void clicksave(){
        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
    }
    public void clickcancel(){
        driver.findElement(By.xpath("//div[@class='components_button cancelBtn']/child::div[1]")).click();
    }
        public void verifyerrormag(String error1) throws Exception{
            if (error1.equals("Please correct all errors in the fields highlighted in red")){
                System.out.println("test cases passs");
            }
            else {
                throw new Exception("Test cases fail");
            }
        }

    }

