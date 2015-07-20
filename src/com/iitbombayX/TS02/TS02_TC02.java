package com.iitbombayX.TS02;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS02_TC02 {

	 private WebDriver driver;
	 private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	 
	 
	@Test
	  public void testFAQFooter() throws Exception {
	    //driver.get(baseUrl + "/faq");
	    driver.findElement(By.id("about")).click();
	    driver.findElement(By.id("faq")).click();
	    driver.findElement(By.id("news")).click();
	    driver.findElement(By.id("blog")).click();
	    driver.findElement(By.id("contact")).click();
	    driver.findElement(By.id("faq")).click();
	    driver.findElement(By.cssSelector("img[alt=\"edX on Facebook\"]")).click();
	    driver.findElement(By.cssSelector("img[alt=\"edX on Twitter\"]")).click();
	    driver.findElement(By.cssSelector("img[alt=\"Powered by Open edX\"]")).click();
	    
		
		
	  }
	
	
		

	 @BeforeMethod
	  public void beforeMethod() {
		  
		  // Create a new instance of the Firefox driver

	      driver = new FirefoxDriver();
	      driver.manage().window().maximize();
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get("http://10.129.50.4/faq");

	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  driver.quit();
	  }
	
	 private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}
