package com.iitbombayX.TS02;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

public class TS02_TC01 {

	 private WebDriver driver;
	
	  
	  @Test
	  public void testHomeToFaqHeadernavLink() throws Exception {
		    //driver.get(baseUrl + "/");
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("LEARNERS FAQ")).click();
		    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("HOW IT WORKS")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("COURSES")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("PARTNERS")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("REGISTER NOW")).click();
		    driver.findElement(By.id("faq")).click();
		    driver.findElement(By.linkText("LANGUAGE")).click();
		    driver.findElement(By.id("submit-lang")).click();
		    
			
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
