package com.fb.commons;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Commons 
{
	
	public FileInputStream fis;
	public Properties prop   = new Properties();
	
	
	public void navigateUrl(WebDriver driver,String url)
	{
		try
		{
		driver.get(url);
		driver.manage().window().maximize();
		}catch (Exception e) {
			System.out.println("browser url is not working" + url + e.getMessage());
			Assert.fail("browser url is not working");
		}
	}
	
	
	public void verifyPageTitle(WebDriver driver,String expectedTitle)
	{
		try
		{
				String actualTitle=driver.getTitle();
				System.out.println(actualTitle);
				if(actualTitle.equalsIgnoreCase(expectedTitle))
				{
					System.out.println(actualTitle + " is displayed");
				}else
				{
					System.out.println(actualTitle + "is not displayed");
					Assert.fail(actualTitle + "is not displayed");
					
				}
		}catch(Exception e)
		{
			System.out.println("Verify Page Title is failed " + e.getMessage());
		}
	}
	
	public void verifyText(WebDriver driver,String oxpath, String expectedValue)
	{
		try
		{
				String actualValue=driver.findElement(By.xpath(oxpath)).getText();
				System.out.println(actualValue);
				if(actualValue.equalsIgnoreCase(expectedValue))
				{
					System.out.println(actualValue + " is displayed");
				}else
				{
					System.out.println(actualValue + "is not displayed");
					Assert.fail(actualValue + "is not displayed");
					
				}
		}catch(Exception e)
		{
			System.out.println("Verify Page Title is failed " + e.getMessage());
		}
	}
	
	
	
	public  Properties propertiesLoad(String pathoftheproperties)
	{
		try
		{
			 fis = new FileInputStream(System.getProperty("user.dir")+pathoftheproperties);
			
			prop.load(fis);
			return prop;
		}catch(Exception e)
		{
			System.out.println("Properties Load issue " + e.getMessage());
			return null;
		}
	}
	
	
	
	
	
}
