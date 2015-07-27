package com.iitbombayX.TS01;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

public class TS01_TC03 {

	private WebDriver driver;
	
	
	@Test
	public void text_onPage() throws Exception 
	{
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		//dString strResult="Fail";
		
			
		
		System.out.println("Text is:"+bodyText);
		Assert.assertTrue("Text not found1!", bodyText.contains("IITBombayX online courses starting soon"));
	//Assert.assertTrue("Text not found!", bodyText.contains("Take great online courses from one of India's best Institutes"));
		//Assert.assertTrue("Text not found!", bodyText.contains("Your Platform Name Here offers interactive online classes and MOOCs. Subjects from multiple disciplines are presently offered, as can be seen in the list of courses. This list will expand later. Your Platform Name Here is a non-profit online platform created with funding from National Mission on Education through Information and Communication Technology (NME-ICT), Ministry of Human Resource Development (MHRD), Government of India (GoI)."));
		Assert.assertTrue("Text not found2!", bodyText.contains("HOW IT WORKS"));
		Assert.assertTrue("Text not found3!", bodyText.contains("COURSES")); 
		Assert.assertTrue("Text not found4!", bodyText.contains("PARTNERS")); 
		Assert.assertTrue("Text not found5!", bodyText.contains("REGISTER NOW")); 
		Assert.assertTrue("Text not found6!", bodyText.contains("LANGUAGE")); 
		Assert.assertTrue("Text not found!", bodyText.contains("Take great online courses from")); 
		Assert.assertTrue("Text not found!", bodyText.contains("one of India's best Institutes")); 
		
		Assert.assertTrue("Text not found7!", bodyText.contains("About")); 
		Assert.assertTrue("Text not found8!", bodyText.contains("News")); 
		Assert.assertTrue("Text not found9!", bodyText.contains("Blog")); 
		Assert.assertTrue("Text not found10!", bodyText.contains("FAQ")); 
		Assert.assertTrue("Text not found11!", bodyText.contains("Contact Us")); 
		Assert.assertTrue("Text not found13!", bodyText.contains("IITBombayX offers interactive online classes and MOOCs. Subjects from multiple disciplines are presently offered, as can be seen in the list of courses. This list will expand later. IITBombayX is a non-profit online platform created with funding from National Mission on Education through Information and Communication Technology (NME-ICT), Ministry of Human Resource Development (MHRD), Government of India (GoI).")); 
		
		
		
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
