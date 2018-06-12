package org.DorDie.selenium.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class commons {
	
	public static ExtentReports report;
	public ExtentTest  test;
	public WebDriver driver;
	public static Properties config =new Properties();
	public static Properties org =new Properties();
	public static FileInputStream fis_config,fis_org;

	
	
	
	public void geturl(WebDriver driver,ExtentTest test, String url) throws Exception
	{
		try
		{
			driver.get(url);
			driver.manage().window().maximize();
			Reporter.log(url +"url is entered");
			String s=screenshot(driver, "gotomeeting");
			
			test.log(LogStatus.PASS, "url is entered"+test.addScreenCapture(s));
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			test.log(LogStatus.PASS, "url is not entered");
		}
		
			
	}
	public void gettitle(WebDriver driver,ExtentTest test, String Expectedtitle) throws Exception
	{
		try
		{
			String s=driver.getTitle();
			if(s.contains(Expectedtitle))
			{
				System.out.println(s +"is displayed");
				Reporter.log(s +"title is matched");
				test.log(LogStatus.PASS, "title is matched");
			}else
			{
				System.out.println(s +"is not displayed");
				Reporter.log(s +"title is not matched");
				test.log(LogStatus.PASS, "title is not matched");
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			test.log(LogStatus.PASS, "Exceptional error");
		}
			
	}
	public void findelement(WebDriver driver,ExtentTest test, String xpath, String data) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(xpath)).sendKeys(data);;
			
			Reporter.log( data +" is entered");
			String s=screenshot(driver, data);
			
			test.log(LogStatus.PASS, "data is entered"+test.addScreenCapture(s));
			

		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL, "data is  not entered");
		}
		
	
	}
	public void click(WebDriver driver,ExtentTest test,String xpath ) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(xpath)).click();
			
			Reporter.log( "clicked on button");
			test.log(LogStatus.PASS, "clicked on the linkbutton");
			
		}catch(Exception e)
		{
			System.out.println(" link is not clicked");
			
		}
		
	
	}
	
	public String screenshot(WebDriver driver,String TCname)
	{
		try{
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String filename=System.getProperty("user.dir")+"\\Screenshots\\"+TCname+".png";
			FileUtils.copyFile(srcfile, new File(filename));
			return filename;
	    	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	
	
	
	
}
