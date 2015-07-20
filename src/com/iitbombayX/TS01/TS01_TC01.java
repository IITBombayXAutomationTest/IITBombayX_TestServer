package com.iitbombayX.TS01;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.FileUtils;

public class TS01_TC01 {
  
 private WebDriver driver;
 
 
  
  @Test
  public void testHomePage() {
    
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[1]/a")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[2]/a")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[3]/a")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[5]/a")).click();
    driver.findElement(By.id("submit-lang")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li/a")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
  
   
  }

  
	

  @BeforeMethod
  public void beforeMethod() {
	  
	  // Create a new instance of the Firefox driver

      driver = new FirefoxDriver();
      driver.manage().window().maximize();
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //Launch the Online Store Website

      driver.get("http://10.129.50.4/");
     
      
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }
}

