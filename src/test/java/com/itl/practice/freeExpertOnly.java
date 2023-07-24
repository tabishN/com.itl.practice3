package com.itl.practice;	//div[@class="psychic-card overflow-hidden 1  expertOnline h-100 offer-applicable "]

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class freeExpertOnly extends BaseClass{

	
	Reporter r = new Reporter();
	int count= 0;
		@Test
		public void freeExpert() {
			driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
			List<WebElement> freeExpetOnly = driver.findElements(By.xpath("//div[@class=\"psychic-card overflow-hidden 1  expertOnline h-100 offer-applicable \"]/descendant::a[@data-toggle=\"tooltip\"]"));
			
			for(WebElement ele2:freeExpetOnly) {
		            
		            String x=ele2.getAttribute("title");
		            count++;
		    		System.out.println(x);
				}
			System.out.println("Total number of free expert are : " + count);
			//System.out.println("Total number of free expert are : " + y.length() );
		//	System.out.println("No expert are online");
	}
		@Test
		public void freeExpertCount() {
		driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
		List<WebElement> xpertList = driver.findElements(By.xpath("//a[@data-toggle=\"tooltip\"]/following::a[@title]"));
		for(WebElement ele1:xpertList) {
            String y=ele1.getAttribute("title");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            System.out.println(y);
		}
		
	}



	

}



