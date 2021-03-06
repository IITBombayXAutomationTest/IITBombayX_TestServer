package com.iitbombayX.TS04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

import org.openqa.selenium.WebElement;

public class TS04_TC03 {
	
	private WebDriver driver;
	WebElement byXpath,byXpath1;
	
	
	@Test
	public void RegistrationPageContent () throws Exception
	{
		//driver.findElement(By.linkText("REGISTER NOW")).click();
		driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		byXpath = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/header/h1/span[1]"));
		byXpath1 = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/header/h1/span[2]"));
		
		
	    
		bannerText();
		
	}
	public void bannerText()
	{
		String bannerText = byXpath.getText();
		String bannerText1 = byXpath1.getText();
		System.out.println("Banner Text PASSED1" +bannerText);
		
		
		
		if(bannerText.equals("WELCOME TO IITBOMBAYX!"))
		{
			if(bannerText1.equals("register below to create your iitbombayx account"))
			{
				System.out.println("Banner Text PASSED1");
			}else {
				Assert.fail("Banner Text Failed1");
			}
			
		}else {
			Assert.fail("Banner Text Failed");
		}
		
		
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
