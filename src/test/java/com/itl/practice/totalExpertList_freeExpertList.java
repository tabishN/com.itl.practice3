package com.itl.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import repo.WebDriverUtilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;





public class totalExpertList_freeExpertList extends BaseClass {
	int countFreeExpert;
	int countTotalExpert;
		@Test
		public void expertList() throws InterruptedException {
			wb.waitMTD(driver);
			wb.cleverTapClick(driver);
			driver.findElement(By.xpath("//span[text()='Sign In ']")).click();
			driver.findElement(By.xpath("//a[text()='Login_Via_Email']")).click();
			driver.findElement(By.id("txtLoginEmail")).sendKeys("missedjan@mailinator.com");
			driver.findElement(By.id("Password")).sendKeys("12");
			// login to the app...................
			driver.findElement(By.id("btnLogin")).click();  
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
			System.out.println("Chat with Expert list selected");
			// to get total astrologers............
		List<WebElement> xpertList = driver.findElements(By.xpath("//a[@data-toggle=\"tooltip\"]/following::a[@title]"));
		for(WebElement ele1:xpertList) {
            String y=ele1.getAttribute("title");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            System.out.println(y);
            countTotalExpert++;
        }
		System.out.println("Total astrologers are : "+countTotalExpert);
		// to get free astrologers..............
		List<WebElement> freeExpertlist = driver.findElements(By.xpath("//div[@class=\"psychic-card overflow-hidden 1  expertOnline h-100 offer-applicable \"]/child::ul[@class=\"list-unstyled d-flex mb-0\"]/child::li[@class=\"w-100 overflow-hidden\"]"));
		for(WebElement ele2 : freeExpertlist) {
            String y=ele2.getAttribute("title");
            countFreeExpert++;
            System.out.println(y);
        }
		System.out.println("free expert count in the list : "+countFreeExpert);
	}

}


