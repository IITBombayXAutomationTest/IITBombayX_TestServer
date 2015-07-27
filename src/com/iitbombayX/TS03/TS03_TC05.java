package com.iitbombayX.TS03;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.utility.Constant;

import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;



public class TS03_TC05 {
	public WebDriver driver;
	
	
 

  @Test
  public void testLoginPage() {
   
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
