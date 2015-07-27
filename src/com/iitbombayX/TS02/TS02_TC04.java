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

public class TS02_TC04 {

	 private WebDriver driver;
	 
	  
	 
	  @Test
	  public void FAQ_content_page() throws Exception {
		  
		  String bodyText = driver.findElement(By.tagName("body")).getText();
			System.out.println("Text is:"+bodyText);
			WebElement byId = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/div/ul/li[1]/a"));
			
			Assert.assertTrue("Text not found1", bodyText.contains("HOW IT WORKS"));
			Assert.assertTrue("Text not found2", bodyText.contains("COURSES")); 
			Assert.assertTrue("Text not found3", bodyText.contains("PARTNERS")); 
			Assert.assertTrue("Text not found4", bodyText.contains("REGISTER NOW")); 
			Assert.assertTrue("Text not found5", bodyText.contains("LANGUAGE")); 
			
			//find test size if about us
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/div/ul/li[1]/a")).getCssValue("14.4");
			Assert.assertTrue("Text not found6", bodyText.contains("ABOUT"));
			
			System.out.println(byId.getCssValue("font-size"));
			
			
			Assert.assertTrue("Text not found7", bodyText.contains("RESEARCH & PEDAGOGY")); 
			Assert.assertTrue("Text not found8", bodyText.contains("BLOG")); 
			Assert.assertTrue("Text not found9", bodyText.contains("NEWS")); 
			Assert.assertTrue("Text not found11", bodyText.contains("CONTACT US")); 
			
			Assert.assertTrue("Text not found12", bodyText.contains("Our goal is to provide you great self-service tools that ensure your success. Still need help after reading these? Please submit a question through our Contact Us page or, if you are a current learner, post your question(s) in your Course Discussion forum.")); 
			Assert.assertTrue("Text not found13", bodyText.contains("Learners' FAQ")); 
		
			
			
			}//end main
			

	  @BeforeMethod
	  public void beforeMethod() {
		  
		  // Create a new instance of the Firefox driver

	      driver = new FirefoxDriver();
	      driver.manage().window().maximize();
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get(Constant.URL +"faq");

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
