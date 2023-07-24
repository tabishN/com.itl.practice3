package com.itl.practice;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import repo.WebDriverUtilities;

public class Chat_Session extends BaseClass{
		@Test
		public void chatSession() {
		try 
		{
			driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
			System.out.println("Chat with Expert list selected");
			driver.findElement(By.id("search-box")).sendKeys(expertname);
			driver.findElement(By.xpath("//i[@class=\"fa fa-search\"]")).click();
			driver.findElement(By.xpath("//a[text()='"+expertname+"']")).click();
			driver.findElement(By.xpath("//div[@class=\"my-2 position-relative\"]/descendant::span[3]")).click();
			driver.findElement(By.xpath("//button[text()='Start Chat with "+expertname+"']")).click();
			Thread.sleep(2000);
			// Chat waiting screen open...................
			String CustomerChatTimer = driver.findElement(By.xpath("//span[@id=\"paidTimeCounter\"]")).getText();
			System.out.println(CustomerChatTimer);
			String PleaseWait = driver.findElement(By.xpath("//p[text()='Please wait for Astrologer response']")).getText();
			System.out.println(PleaseWait);
			
			// Chat Screen open........................
			WebElement intakeDetails = driver.findElement(By.xpath("//div[@class=\"clearfix message-content\"]"));
			System.out.println("message box displayed : "+intakeDetails.isDisplayed());
			driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here ...\"]")).sendKeys("Hello !");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector(\"button[id=sendMsg]\").click()");
			System.out.println("For loop started.....");
			WebElement messageField = driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here ...\"]"));
			for(int i=0; i<9; i++) {
				System.out.println("inside for loop....");
				messageField.sendKeys("Hello..");
				Thread.sleep(1000);
				js.executeScript("document.querySelector(\"button[id=sendMsg]\").click()");
				System.out.println("message sent.......");
				Thread.sleep(4000);
			}
			// Ending Chat initiated............
			driver.findElement(By.xpath("//a[text()='End Chat']")).click();
			Thread.sleep(2000);
			WebElement endChatYes = driver.findElement(By.id("btnEndChatPop"));
			System.out.println("Yes End the chat now : "+endChatYes.isDisplayed());
			endChatYes.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String ChatSummary = driver.findElement(By.xpath("//h4[text()='Chat Summary']")).getText();
			System.out.println(ChatSummary);
			//Assert.assertEquals(ChatSummary,"Chat Summary");
			String beginTimeStamp = driver.findElement(By.id("BeginTimestamp")).getText();
			System.out.println(beginTimeStamp);
			String endTimeStamp = driver.findElement(By.id("EndTimestamp")).getText();
			System.out.println(endTimeStamp);
			String paidMin = driver.findElement(By.id("PaidMinutes")).getText();
			System.out.println(paidMin);
			String chargepaid = driver.findElement(By.id("ChargePaid")).getText();
			System.out.println(chargepaid);
			driver.findElement(By.xpath("//button[@onclick=\"closeSummary()\"]")).click();
			//chatScreenopen();	
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
			}
		
}
