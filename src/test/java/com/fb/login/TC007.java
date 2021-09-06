package com.fb.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fb.commons.Commons;
import com.fb.commons.Openbrowser;

public class TC003 extends Commons

	{
	public WebDriver driver;
	@Parameters("browsername")
	@BeforeMethod
	public void browsercod(String browsername)
	{
		
		Openbrowser browser=new Openbrowser();
		driver=browser.browsercode(browsername);
	
	}
		@Test
		public void tc003()
		{
			/*try
			{
			driver.get("htt//en-gb.facebook.com/");
			}catch (Exception e) {
				System.out.println("browser url is not working"+ e.getMessage());
				Assert.fail("browser url is not working");
			}*/
			navigateUrl(driver, "http://en-gb.facebook.com/");
			
		}
		
		@AfterMethod
		public void browserclose()
		{
			driver.quit();

		}
	}
