package com.actitime.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginclass {
    WebDriver driver;
    CommonFunction commonFunction;

    public Loginclass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(name = "pwd")
    public WebElement password;

    @FindBy(xpath = "//a[@id='loginButton']/child::div")
    public WebElement loginButton;

    public void login(String username, String password) {
        commonFunction = new CommonFunction(driver);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        commonFunction.click(By.xpath("//a[@id='loginButton']/child::div"));
    }
}