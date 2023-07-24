package com.itl.practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import repo.WebDriverUtilities;

public class BaseClass {

	WebDriver driver;
	public String expertname = "Tabish Tewwwqwe";
	public WebDriverUtilities wb = new WebDriverUtilities(); 
	
	@BeforeTest
	public void openBrowser() {
		System.out.println("Initilizing the Google Chrome Driver");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("chrome browser launched ...", true);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		driver.get("https://otest.anytimeastro.com/");
		wb.waitMTD(driver);
		Reporter.log("anytime astro website open", true);	
		
		String title=driver.getTitle();
		System.out.println("Title of the site is : " + title);
		//driver.quit();
		//Assert.assertEquals(title, "Online Astrology Consultation, Ask an Astrologer - Anytime Astr");
		//System.out.println("title verified");
		if(title.equals("Online Astrology Consultation, Ask an Astrologer - Anytime Astro")) 
		{
			System.out.println("Title is verified");
		}
		else 
		{
			System.out.println("Title verification failed");
		}
		
			try 
			{
				wb.cleverTapClick(driver);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("CleverTap popup not found.....");
			}
			
		
		driver.findElement(By.xpath("//span[text()='Sign In ']")).click();
		Reporter.log("signin button hit", true);	
		driver.findElement(By.xpath("//a[text()='Login_Via_Email']")).click();
		Reporter.log("login via email", true);	
		driver.findElement(By.id("txtLoginEmail")).sendKeys("missedjan@mailinator.com");
		Reporter.log("mail id passed", true);	
		driver.findElement(By.id("Password")).sendKeys("12");
		// login to the app
		driver.findElement(By.id("btnLogin")).click();  
		Reporter.log("login button click", true);	
		//wb.cleverTapClick(driver);
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void beforeMTD()
	{
		System.out.println("Before method not required");
		
	}
	
	@AfterMethod()
	public void tearDown() 
	{
		Reporter.log("teardown method executed");
	}
	
	@AfterClass()
	public void afterClass() throws IOException
	{
		TakesScreenshot scr= ((TakesScreenshot)driver);
        File file1= scr.getScreenshotAs(OutputType.FILE);
        
       FileUtils.copyFile(file1, new File("C:\\Users\\tabish\\Desktop\\february\\script_screenshot\\"+wb.getRndNumber()+".PNG"));
	}
	
	@AfterTest
	public void closeBrowser() 
	{
		System.out.println("logout started");
		driver.findElement(By.id("dropdownMenuLink")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@onclick=\"funlogout()\"]")).click();
		Reporter.log("logout button hit", true);	
		driver.quit();
	}
	public void chatScreenopen() throws InterruptedException {
		WebElement intakeDetails = driver.findElement(By.xpath("//div[@class=\"clearfix message-content\"]"));
		System.out.println("message box displayed : "+intakeDetails.isDisplayed());
		driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here ...\"]")).sendKeys("hello");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\"button[id=sendMsg]\").click()");
		System.out.println("For loop started.....");
		for(int i=1; i<=9; i++) {
			System.out.println("inside for loop....");
			driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here ...\"]")).sendKeys("hello");
			Thread.sleep(3000);
			js.executeScript("document.querySelector(\"button[id=sendMsg]\").click()");
			System.out.println("message sent.......");
			//Thread.sleep(3000);
		}
		// Ending Chat initiated............
		driver.findElement(By.xpath("//a[text()='End Chat']")).click();
		Thread.sleep(2000);
		WebElement endChatYes = driver.findElement(By.id("btnEndChatPop"));
		System.out.println("Yes End the chat now : "+endChatYes.isDisplayed());
		endChatYes.click();
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
	}
	
}
