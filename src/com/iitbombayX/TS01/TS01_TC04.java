package com.iitbombayX.TS01;

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

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;

import org.openqa.selenium.WebElement;


public class TS01_TC04 {
	
	private WebDriver driver;
	WebElement byId,byId1,byId2,byId3,byId4,byId5,byId6,byId7,byId8,byId9,byId10,byId11;
	
	
	@Test
	public void check_content() throws Exception
	{
		
			// footer navigation content font size check
		
		byId= driver.findElement(By.id("about"));
		byId1= driver.findElement(By.id("news"));
		byId2= driver.findElement(By.id("blog"));
		byId3= driver.findElement(By.id("faq"));
		byId4= driver.findElement(By.id("contact"));
		
		 //header navigation content font check
		
		byId5= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[1]/a")); // how it works
		byId6= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[2]/a")); // courses
		byId7= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[3]/a")); // patener
		byId8= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")); // register now
		byId9= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[5]/a")); // language
		byId10= driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li/a")); //login
		
		byId11 = driver.findElement(By.xpath("html/body/div[1]/div[2]/footer/div[1]/div/p"));
		
		
		footer_nav_content();
		header_nav_content();
		//String fontSize11 = byId10.getCssValue("font-size");
		
		}
				
	
	public void footer_nav_content() throws Exception
	{
		String fontSize= byId.getCssValue("font-size");
		String fontSize1= byId1.getCssValue("font-size");
		String fontSize2= byId2.getCssValue("font-size");
		String fontSize3= byId3.getCssValue("font-size");
		String fontSize4= byId4.getCssValue("font-size");
		String fontSize11 = byId11.getText();
		
		System.out.println("Hellooooooooooo"+fontSize11);
		 
		if(fontSize.equals("16px") )
		{
			System.out.println("About us PASSED");
		}else
		{
		Assert.fail(" About us Font sized not matched");
		}
		if(fontSize1.equals("16px") )
		{
			System.out.println("news PASSED");
		}else
		{
		Assert.fail(" news Font sized not matched");
		}
		if(fontSize2.equals("16px") )
		{
			System.out.println("blog PASSED");
		}else
		{
		Assert.fail("blog Font sized not matched");
		}
		if(fontSize3.equals("16px") )
		{
			System.out.println("faq PASSED");
		}else
		{
		Assert.fail("faq Font sized not matched");
		}
		if(fontSize4.equals("16px") )
		{
			System.out.println("contact us PASSED");
		}else
		{
		Assert.fail("contact us Font sized not matched");
		}
		if(fontSize11.equals("IITBombayX offers interactive online classes and MOOCs. Subjects from multiple disciplines are presently offered, as can be seen in the list of courses. This list will expand later. IITBombayX is a non-profit online platform created with funding from National Mission on Education through Information and Communication Technology (NME-ICT), Ministry of Human Resource Development (MHRD), Government of India (GoI).") )
		{
			System.out.println("footer Paragraph PASSED");
		}else
		{
		Assert.fail("footer Paragraph failed");
		}
		
	System.out.println("PASS FOOTER");
	
	}

	
	public void header_nav_content() throws Exception
	{
		
			
		String fontSize5= byId5.getCssValue("font-size");
		String fontSize6= byId6.getCssValue("font-size");
		String fontSize7= byId7.getCssValue("font-size");
		String fontSize8= byId8.getCssValue("font-size");
		String fontSize9= byId9.getCssValue("font-size");
		String fontSize10= byId10.getCssValue("font-size");
		
		if(fontSize5.equals("14px") )
		{
			System.out.println("How IT WORKS PASSED");
		}else
		{
		Assert.fail("How IT WORKS Font sized not matched");
		}
		if(fontSize6.equals("14px") )
		{
			System.out.println("courses PASSED");
		}else
		{
		Assert.fail("courses Font sized not matched");
		}
		if(fontSize7.equals("14px") )
		{
			System.out.println("Partners PASSED");
		}else
		{
		Assert.fail("Partners Font sized not matched");
		}
		if(fontSize8.equals("14px") )
		{
			System.out.println("Register Now CLEAR3");
		}else
		{
		Assert.fail("Register Font sized not matched");
		}
		if(fontSize9.equals("14px") )
		{
			System.out.println("Language PASSED");
		}else
		{
		Assert.fail("Language Font sized not matched");
		}
		if(fontSize10.equals("16px") )
		{
			System.out.println("Login PASSED");
		}
		else
		{
		Assert.fail("Login Font sized not matched");
		}
	System.out.println("PASS HEADER");
	
	
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
