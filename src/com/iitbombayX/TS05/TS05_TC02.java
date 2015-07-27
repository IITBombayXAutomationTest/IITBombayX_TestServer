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

import com.utility.Constant;

public class TS05_TC02 {
	
	WebDriver driver;
	String baseUrl;
	
	@Test
	public void find_course() throws Exception
	{
		//driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log in")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("design12345");
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.linkText("FIND COURSES")).click();
	    driver.findElement(By.linkText("Introduction to Computer Programming, Part 1")).click();
	    driver.findElement(By.cssSelector("strong")).click();
	    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
	    driver.findElement(By.linkText("FIND COURSES")).click();
	    driver.findElement(By.linkText("BM Workshop for Computer Programming")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/ul/li[2]/a")).click();

	}


	@BeforeMethod
	public void beforeMethod()
	{
		//baseUrl = "http://10.129.50.4/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
