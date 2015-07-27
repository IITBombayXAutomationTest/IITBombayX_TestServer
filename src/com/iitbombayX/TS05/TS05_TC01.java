package com.iitbombayX.TS05;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iitbombayX.TS04.*;
import com.utility.Constant;


public class TS05_TC01 {

	TS04_TC05 obj1 ;
	WebDriver driver;
	
	
	@Test
	public void Login_page() throws Exception{
		
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
	  public void beforeMethod() throws Exception {
		  
		  // Create a new instance of the Firefox driver

	      driver = new FirefoxDriver();
	      driver.manage().window().maximize();
	      
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch the Online Store Website

	      driver.get(Constant.URL);
	     // ExcelUtils.setExcelFile(contant.Path_TestData + contant.File_TestData,"Sheet1");
	     

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

