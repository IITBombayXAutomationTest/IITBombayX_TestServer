package com.iitbombayX.TS03;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS03_TC01 {
  private WebDriver driver;
  private String baseUrl;
 
  private StringBuffer verificationErrors = new StringBuffer();

  

  @Test
  public void testHeaderLink() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("HOW IT WORKS")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/h1/a/img")).click();
    driver.findElement(By.linkText("Courses")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("Partners")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("Register Now")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("Language")).click();
    new Select(driver.findElement(By.id("settings-language-value"))).selectByVisibleText("हिन�?दी");
    new Select(driver.findElement(By.id("settings-language-value"))).selectByVisibleText("English");
    driver.findElement(By.id("submit-lang")).click();
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
  }
  
  @BeforeMethod
  public void beforemethod() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://10.129.50.4/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void aftermethod() throws Exception {
    driver.quit();
   
  }

  
}