package com.itl.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class firefix {
	@Test
	public void test0() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\tabish\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Reporter.log("launch firefox browser", true);
		
		driver.manage().window().maximize();
		driver.get("https://www.anytimeastro.com/");
		Reporter.log("launch anytime astro website", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		 System.out.println("Closing the browser ");
		 driver.close();
		 Reporter.log("closing browser...", true);

}
	}
