package com.itl.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Report;

public class Firefoxtest {

	public WebDriver driver; 
	@BeforeTest
	public void beforeTest() {
		System.out.println("Initilizing the Firefox Driver");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\tabish\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		Reporter.log("launch firefox browser", true);
	}
        @Test
 	public void FirefoxTestMethod()
 	{ 

	  //Initialize the chrome driver
	 System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
	 driver.get("https://www.anytimeastro.com"); 
	 Reporter.log("launch anytime astro website", true);
    }
 
     @AfterTest
     public void afterTest() {
	 System.out.println("Closing the browser ");
	 driver.close();
	 Reporter.log("closing browser...", true);
     }
}
