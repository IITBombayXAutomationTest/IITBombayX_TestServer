package com.iitbombayX.TS02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS02_TC03 {
	
	private WebDriver wd;
	WebElement byXpath,byXpath1;
	
	
	@Test
	public void faqOf_FaqPage() throws Exception
	{
		String content = null;
		//String content= wd.findElement(By.cssSelector(".ac-large>p")).getText();
		//String content= wd.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p")).getText();
		//.//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p
		wd.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/label")).click();;
		content=wd.findElement(By.xpath("//div[@id='content']/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/section/div/div/section/div[51]/article/p")).getText();		
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
		 wd = new FirefoxDriver();
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wd.get("http://10.129.50.4/faq");
		 
		
	}
	 @AfterMethod
	 public void afterMethod()
	 {
		 wd.quit();
	 }
}
