package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        //lauuch browser
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("122");
        options.addArguments("--remote-allows-origins=*");

        driver = new ChromeDriver(options);
        //get URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);

    }

    @DataProvider
    public Object[][] getTextData() {
        Object[][] obj1 = new Object[][]{
                {"Admin", "admin123", "valid"},
                {"kj", "admin123", "invalid"},
                {"ds", "admij3", "invalid"},
                {"Admin", "admin", "invalid"},
                {"", "", "NotValid"},
                {"Admin", "", "blankPwd"},
                {"", "admin123", "blankUN"}
        };
        return obj1;
    }


    @Test(dataProvider = "getTextData")
    public void testlogin(Object username, Object password, Object status) throws Exception {
        LoginPage loginPage = new LoginPage(driver);

        // login with vaild username and password
        loginPage.login(username.toString(), password.toString());// to covert Object into string we have used toString().
        String Testdata = status.toString();
        Thread.sleep(10000);
        if (Testdata.equals("valid")) {

            // locate dashboard and get text
            String dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
            if (dashboard.equals("Dashboard")) {
                System.out.println("landed on dashboard");
            } else {
                throw new Exception("error: not landed of dashboard");
            }
            loginPage.logout();
            Thread.sleep(5000);
        } else if (Testdata.equals("inavlid")) {

            // invaild username & password
            // loginPage.login("indira","123");
            // Thread.sleep(5000);
            String errormsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
            loginPage.verifyerrormsg(errormsg);
            driver.navigate().refresh();
            Thread.sleep(1000);
        } else if (Testdata.equals("invalid")) {


            //  in valid username and valid password
            // loginPage.login("fhdhfh","admin123");
            //  Thread.sleep(5000);
            String errormsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
//      //Print error Message
            loginPage.verifyerrormsg(errormsg);
            driver.navigate().refresh();
            Thread.sleep(5000);
        } else if (Testdata.equals("invalid")) {


            // valid username and invalid password
            //loginPage.login("Admin","53463fgh");
            //Thread.sleep(5000);
            String errormsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
            loginPage.verifyerrormsg(errormsg);
        } else if (Testdata.equals("NotValid")) {

            // blank username and password

            //  loginPage.login("", "");
            //  Thread.sleep(5000);
            String error1 = driver.findElement(By.xpath("//input[@name='username']/following::span[1]")).getText();//fore required text
            String error2 = driver.findElement(By.xpath("//input[@name='username']/following::span[1]")).getText();
            //loginPage.verifyrequiredmsg(error1);
            if (error1.equals("Required") && error2.equals("Required")) {
                System.out.println("test cases passed for blank credentails ");
            } else {
                throw new Exception("test cases failed for blank credentails");
            }
        } else if (Testdata.equals("blankPwd")) {

            // vaild username and blank password

            // loginPage.login("Admin", "");
            //Thread.sleep(5000);
            String error3 = driver.findElement(By.xpath("//input[@name='password']/following::span[1]")).getText();
            if (error3.equals("Required")) {
                System.out.println("test cases passed for blank password");
            } else {
                throw new Exception("test cases fail for blank password");
            }
            // loginPage.verifyerrormsg(error3);
            driver.navigate().refresh();
            Thread.sleep(5000);

        } else if (Testdata.equals("blankUN")) {

            // blank username and valid password

            //loginPage.login("", "admin123");
            //Thread.sleep(5000);
            String error4 = driver.findElement(By.xpath("//input[@name='username']/following::span[1]")).getText();
           if (error4.equals("Required")){
               System.out.println("test cases passed for blank username");
           }
           else {
               throw new  Exception("test case fail for blank username");
           }
           // loginPage.verifyerrormsg(error4);

        }
    }
}








