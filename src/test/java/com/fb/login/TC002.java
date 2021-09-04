package com.fb.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC002 
{
	public WebDriver driver;
	
	@Parameters("browsername")
	@Test
	public void tc002(String browsername) throws Exception
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
			
			driver.get("https://en-gb.facebook.com/");

				List<WebElement> footerLinks = driver.findElements(By.xpath("//ul[contains(@class,'pageFooter')]/li"));
			
				for(WebElement link: footerLinks)
				{
					System.out.println(link.getText());
					Reporter.log(link.getText());
				}
				
				
				
			driver.quit();
			
			
		
	}

}
