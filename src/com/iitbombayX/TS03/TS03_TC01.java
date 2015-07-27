package com.iitbombayX.TS03;

import java.util.regex.Pattern;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

public class TS03_TC01 {
  private WebDriver driver;
  private String baseUrl;
 
  private StringBuffer verificationErrors = new StringBuffer();

  

  @Test
  public void testHeaderLink() throws Exception {
   // driver.get(baseUrl + "/");
    driver.findElement(By.linkText("HOW IT WORKS")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/h1/a/img")).click();
    driver.findElement(By.linkText("COURSES")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("PARTNERS")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("REGISTER NOW")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("LANGUAGE")).click();
    new Select(driver.findElement(By.id("settings-language-value"))).selectByVisibleText("English");
    new Select(driver.findElement(By.id("settings-language-value"))).selectByVisibleText("English");
    driver.findElement(By.id("submit-lang")).click();
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
  }
  
  @BeforeMethod
  public void beforemethod() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    

    driver.get(Constant.URL);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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