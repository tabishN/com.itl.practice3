package com.itl.practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class getExpertID extends BaseClass {
	
	public static String expertname = "Tabish Tewwwqwe";
	
	@Test
	public  void expertID() {
	
		driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
		System.out.println("Chat with Expert list selected");
		Reporter.log("Expert list fetching started....");
		
		try {
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		}
		catch (Exception e1) {
			e1.printStackTrace();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//List<WebElement> e = driver.findElements(By.xpath("//a[text()='"+expertname+"']/ancestor::ul[@class=\"list-unstyled d-flex mb-0\"]"));
			//WebElement v0 = e.get(0);
			List<WebElement> l = driver.findElements(By.xpath("//div[@id=\"expert-list\"]/div[@data-psychic-id]"));
			for(WebElement x : l) {
				String id = x.getAttribute("data-psychic-id");
				System.out.println(x);
			}
			/*
			 * Iterator<WebElement> i = l.iterator();
			 * 
			 * while(i.hasNext()) { String id = i.next().getAttribute("data-psychic-id");
			 * System.out.println(id);
			 * 
			 * }
			 */
		}
		
		
			
		
		
	}
	}

