package com.fb.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fb.commons.Commons;
import com.fb.commons.OpenBrowser;

public class TC008 extends Commons

{
	public WebDriver driver;


	@BeforeSuite
	public  void config() throws Exception
	{
		/*
		 * FileInputStream fis = new
		 * FileInputStream(System.getProperty("user.dir")+"/Config/config.properties");
		 * Properties prop = new Properties(); prop.load(fis);
		 */
		prop = propertiesLoad("//Config//config.properties");
		//expProperties = propertiesLoad("//Config//ExpectedValues.properties");
		
	}
	
	@Parameters("browsername")
	@BeforeMethod
	public void browsercod(String browsername) throws Exception {

		OpenBrowser browser = new OpenBrowser();
		driver = browser.browserOpenCode(browsername);

	}

	@Test
		public void tc003() throws Exception
		{
			
			navigateUrl(driver, prop.getProperty("prod_url"));
			Thread.sleep(8000);
			System.out.println(prop.getProperty("fb_Title"));
			verifyPageTitle(driver, prop.getProperty("fb_Title"));	
			String actualValue=driver.findElement(By.xpath("//h2")).getText();		
			String expectedValue = prop.getProperty("fb_subheader");
			Assert.assertEquals(actualValue, expectedValue);
			verifyText(driver, "//a[contains(text(),'Forgot')]", "Forgotten password?");
			verifyText(driver, "//button[contains(text(),'Log In')]", "Log In");
		}

	@AfterMethod
	public void browserclose() {
		driver.quit();

	}
}
