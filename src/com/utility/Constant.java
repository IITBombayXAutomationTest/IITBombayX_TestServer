package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Constant {

	public static final String URL = "http://10.129.50.4/";
	public static final String Path_TestData = "E:\\test\\" ;

	public static final String File_TestData ="new.xlsx" ;

	// public static final String Path_ScreenShot = "/home/iitb/Desktop/screenshots"; // Ubuntu
	    
	  public static final String Path_ScreenShot = "E:\\selenium_workspace\\IITBombayX_TestServer\\screenshot\\"; // For Windows

	    
	    public static final void takeScreenShotOnFailure(ITestResult testResult,
	            String packageName, String ClassName, String filename,
	            WebDriver driver) throws IOException {

	        String packageName1 = packageName;
	        String ClassName1 = ClassName;// prints the class name (TS01_TC01)
	        String filename1 = filename;
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
	        Date date = new Date();

	        
	            File scrFile = ((TakesScreenshot) driver)
	                    .getScreenshotAs(OutputType.FILE);

	            FileUtils.copyFile(scrFile,
	                    new File(Path_ScreenShot +"/" + packageName1
	                            + "/" + ClassName1 + "/" + filename1 + "_ "
	                            + dateFormat.format(date) + ".png"));

	        
	    }
	    
	}
	// public static final String Path_TestData = "D://ToolsQA//OnlineStore//src//testData//"
			 
		//      public static final String File_TestData = "TestData.xlsx"
	
	
	

