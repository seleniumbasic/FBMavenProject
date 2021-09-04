package com.fb.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fb.commons.OpenBrowser;

public class TC006 
{
	public WebDriver driver;
	
	@Parameters("browsername")
	@BeforeMethod
	public void browserOpen(String browsername) throws Exception
	{
		OpenBrowser openbrowser = new OpenBrowser();
		driver=openbrowser.browserOpenCode(browsername);		
	}
	
	@AfterMethod
	public void browserClose()
	{
		driver.quit();
	}
	
	
	@Test
	public void tc006() throws Exception
	{
			
			driver.get("https://en-gb.facebook.com/");
			
			List<WebElement> footerLinks = driver.findElements(By.xpath("//ul[contains(@class,'pageFooter')]/li"));
			
			for(WebElement link: footerLinks)
			{
				System.out.println(link.getText());
				Reporter.log(link.getText());
			}
			
			
			
			
		
	}

}
