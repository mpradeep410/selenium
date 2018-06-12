package org.DorDie.selenium.utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Openbrowser extends commons
{
	public WebDriver browseropen(WebDriver driver, String browser) throws Exception 
	{
		
		try
		{
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			
			}else 
				if(browser.equalsIgnoreCase("IE"))
				{
					System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				
				}else 
					if(browser.equalsIgnoreCase("FF"))
					{
						System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
						driver = new FirefoxDriver();
					
					}else
					{
						System.out.println("browser value is not matched");
					}
			
			return driver;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		return driver;
		
		
	}
	
	
	
	
	
	


}
