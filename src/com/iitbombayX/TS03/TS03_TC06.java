package com.iitbombayX.TS03;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

public class TS03_TC06 {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  WebElement element;
	  
	  @Test
	  public void testResetPassword() throws Exception {
	    //driver.get(baseUrl + "/");
	    
	  
	  driver.findElement(By.linkText("Log in")).click();
	    
	    
	    driver.findElement(By.id("forgot-password-link")).click();
	   driver.findElement(By.id("pwd_reset_email")).clear();
	   driver.findElement(By.id("pwd_reset_email")).sendKeys("raj88.007@gmail.com");
	   driver.findElement(By.id("pwd_reset_button")).click();
	   driver.findElement(By.cssSelector("button.close-modal")).click();
	    
	    driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
	     driver.findElement(By.id("Email")).sendKeys("raj88.007");;
	    driver.findElement(By.id("next")).click();
	     driver.findElement(By.id("Passwd")).sendKeys("design12345");
	    driver.findElement(By.id("signIn")).click();
	    driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
	    //
	    //selenium.mouseDown("xpath=//div [@class='y6']/span[contains(.,'<your original search text>')]");
	    driver.get("http://10.129.50.4/");
	     driver.findElement(By.linkText("Log in")).click();
	      driver.findElement(By.id("email")).clear();
	     driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("design12345");
	    driver.findElement(By.id("remember-yes")).click();
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.linkText("edit")).click();
	    driver.findElement(By.id("new_name_field")).clear();
	    driver.findElement(By.id("new_name_field")).sendKeys("Shivaji");
	    driver.findElement(By.id("name_rationale_field")).clear();
	    driver.findElement(By.id("name_rationale_field")).sendKeys("Real name");
	    driver.findElement(By.cssSelector("fieldset > div.submit > #submit")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
	    
	    
	    
	    } 

    @BeforeMethod
    public void beforeMethod() {
  	  
  	  // Create a new instance of the Firefox driver

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Online Store Website

        driver.get(Constant.URL);

    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 

        String className = this.getClass().getSimpleName();
        String packageName = this.getClass().getName();
        String filename = this.getClass().getName().toString();


        if (testResult.getStatus() == ITestResult.FAILURE) {

            Constant.takeScreenShotOnFailure(testResult,packageName,className,filename,driver);
        }
        driver.quit();
    }
}
