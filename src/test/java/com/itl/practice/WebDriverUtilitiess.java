package com.itl.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtilitiess {
	 WebDriver driver;
	WebElement a = driver.findElement(By.xpath("//button[text()='No thanks']"));
	public void cleverTapClick() {
		try {
			a.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
			catch(Exception e) {
				System.out.println("exception are as follows " + e.getMessage());
				driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();
			}
	}
	public void waitMTD() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

}
