package org.DorDie.selenium.frameworks;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.DorDie.selenium.utilies.Openbrowser;
import org.DorDie.selenium.utilies.commons;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TC002  extends commons{
	
	
	
	Openbrowser openbrowser = new Openbrowser();

	@BeforeSuite
	public void configuration()throws Exception
	{
		report=new ExtentReports(System.getProperty("user.dir")+"//gotomeeting.html");
		report.loadConfig(new File("C:\\Users\\karun\\Documents\\New folder\\DorDie\\extent-config.xml"));
		fis_config =new FileInputStream(System.getProperty("user.dir")+"/resources/config.properties");
		config.load(fis_config);
		fis_org =new FileInputStream(System.getProperty("user.dir")+"/resources/org.properties");
		org.load(fis_org);
	}
	
	
	
	
	 
	@Parameters("browser")
	@BeforeMethod
	public void beforemethod(String browser) throws Exception
	{
		try
		{
			driver = openbrowser.browseropen(driver,browser);
			
		}catch(Exception e)
		{
			System.out.println("Exception occurs in Before Method");
		}
	}
	@Parameters("browser")
	@Test
	public void enterurl(String browser)throws Exception{
		
		try {
			FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/org/DorDie/selenium/data/keyword_data1.xlsx");
			XSSFWorkbook workbook= new XSSFWorkbook(fis);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			System.out.println(sheet.getRow(2).getCell(0).getStringCellValue());
			System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
			for(int i=2;i<=sheet.getLastRowNum();i++)
			{
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC002")&&sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("yes"))
				{

					test=report.startTest("TC-002","clicking on pricing link and click on Start My Free 14-Day Trial and match title"); 
					test.log(LogStatus.PASS, "TC-002 test started");
					test.assignCategory(browser);

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					geturl(driver,test,config.getProperty("SIT_URl"));
					Thread.sleep(3000);
					click(driver,test, org.getProperty("pricing"));
					Thread.sleep(3000);
					click(driver,test, org.getProperty("Start_My_Free_14-Day_Trial"));
					Thread.sleep(2000);
					gettitle(driver,test, org.getProperty("title"));
					
					report.endTest(test);
					report.flush();
				}
				else
				{
					
					throw new SkipException("TC002 kept on skip mode");
				}
				
			}
		}	
		catch (Exception e)
			{
						System.out.println("element is not  clicking");
						
			}
		
		report.endTest(test);
		report.flush();
	
		
		
		
	}
	
	@AfterMethod
	public void aftermethod(){
		try {
			Thread.sleep(2000);
			driver.quit();
			report.flush();
			
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
	}





}
