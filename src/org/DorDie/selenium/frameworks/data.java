package org.DorDie.selenium.frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class data 
{
	
	
	
	
	@Test(dataProvider = "login")
	public void adbc(String username, String password) throws Exception
	{
		try
		{
			
		System.out.println("Selenium Basics");
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Documents/Grepthor_Selenium/drivers/chromedriver_2.36.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		/*System.setProperty("webdriver.ie.driver", "C:/Users/Lenovo/Documents/Grepthor_Selenium/drivers/IEDriverServer.exe");
		InternetExplorerDriver  driver = new InternetExplorerDriver();
		*/
		
	/*	System.setProperty("webdriver.gecko.driver", "C:/Users/Lenovo/Documents/Grepthor_Selenium/drivers/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
	*/	
		
		driver.manage().window().maximize();
		
		driver.get("https://indiarush.com/careers/");
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
		Thread.sleep(8000);
		jse.executeScript("window.scrollBy(0,250)", "");

		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("(//input[@value='Log In'])[1]")).click();
		
		Thread.sleep(8000);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();

		
		
		
		
		
		
		}catch(Exception e)
		{
			
		}
	}
	
	@DataProvider(name = "login")
	public static Object[][] xyz()
	{
		 return new Object[][] { { "Izaz@gamil.com", "1234567890" }, { "testuser_1","Test@123" }};
		
	}

}
