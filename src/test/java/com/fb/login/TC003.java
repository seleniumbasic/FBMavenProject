package com.fb.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC003 
{
	public WebDriver driver;
	
	@Parameters("browsername")
	@BeforeMethod
	public void browserOpen(String browsername) throws Exception
	{

		if(browsername.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("ie"))
		{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		}else if(browsername.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		 driver = new FirefoxDriver();
		}else
		{
			System.out.println(browsername + " is invalid");
			throw new Exception(browsername + " is invalid");
		}
	}
	
	@AfterMethod
	public void browserClose()
	{
		driver.quit();
	}
	
	
	@Test
	public void tc001() throws Exception
	{
			
			driver.get("https://en-gb.facebook.com/");
			
			System.out.println(driver.getCurrentUrl());
			Reporter.log(driver.getCurrentUrl() + " is displayed");
			System.out.println(driver.getTitle());
			Reporter.log(driver.getTitle() + " is displayed");
			
			
		
	}

}
