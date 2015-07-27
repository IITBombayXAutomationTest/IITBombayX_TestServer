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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

public class TS02_TC03 {
	
	private WebDriver driver;
	WebElement byXpath,byXpath1;
	
	
	@Test
	public void faqOf_FaqPage() throws Exception
	{
		String content = null;
		//String content= wd.findElement(By.cssSelector(".ac-large>p")).getText();
		//String content= wd.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p")).getText();
		//.//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/label")).click();;
		content=driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p")).getText();		
		System.out.println("Faq Content is:" +content);

		String actual_result="IITBombayX primarily intends to offer courses from IIT Bombay and teacher training workshops, from IIT Bombay and IIT Kharagpur. Courses from other institutions/universities are expected to be offered soon on the national platform, Swayam. A few such courses will be offered on this IITBombayX platform on a pilot basis, as a part of the commitment to the National Mission on Education using ICT (NMEICT). It may be noted that that the content and running of such courses is entirely the responsiblity of the institutional universities which offer these courses. IITBombayX will not be responsible for the conduct of any of such courses.";
	
				
		/*if(actual_result.equals(content))
		{
			System.out.println("Fail");

		}
*/	
	}
	
	
		


	 @BeforeMethod
	 public void beforeMethod()
	{
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
