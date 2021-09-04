package com.fb.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenBrowser 
{
	public WebDriver driver;
	
	/*
	 * public int raj() { int a = 10, b=20; int c = a+b; return c; }
	 * 
	 * public void pradeep() { int d=40; int rsult =raj();
	 * System.out.println(rsult); System.out.println(rsult+d);
	 * 
	 * }
	 * 
	 * 
	 * public static void main(String[] args) {
	 * 
	 * OpenBrowser browse = new OpenBrowser(); browse.pradeep(); }
	 */
	
	
	public WebDriver browserOpenCode(String browsername) throws Exception
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
		
		return driver;
	}
	
}
