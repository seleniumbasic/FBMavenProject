package com.fb.commons;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Commons 
{
	public void navigateUrl(WebDriver driver,String url)
	{
		try
		{
		driver.get(url);
		}catch (Exception e) {
			System.out.println("browser url is not working" + url + e.getMessage());
			Assert.fail("browser url is not working");
		}
	}
}
