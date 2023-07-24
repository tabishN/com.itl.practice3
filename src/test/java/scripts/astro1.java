package scripts;

import java.awt.AWTException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;





public class astro1 {
	public WebDriver driver;
	
	@BeforeClass
	public void beforeTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tabish\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@BeforeMethod
		public void astroOpen() {
		
		driver.get("https://otest.anytimeastro.com/");
		driver.findElement(By.xpath("//span[text()='Sign In ']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Login_Via_Email']")).click();
		driver.findElement(By.id("txtLoginEmail")).sendKeys("qa100@mailinator.com");
		driver.findElement(By.id("Password")).sendKeys("1");
		//driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.id("login")).click();
	}
	
		@Test(enabled=false)
		public void chatWithAstrologer() throws InterruptedException, AWTException {
			String title=driver.getTitle();
			System.out.println("Title of the site is : " + title);
			//driver.quit();
			//Assert.assertEquals(title, "Online Astrology Consultation, Ask an Astrologer - Anytime Astr");
			//System.out.println("title verified");
			if(title.equals("Online Astrology Consultation, Ask an Astrologer - Anytime Astro")) {
				System.out.println("Title is verified");
			}
			else {
				System.out.println("Title verification failed");
			}
			try {
			driver.findElement(By.xpath("//a[@class=\"btn btn-chat\"]")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("chat link handled by catch block");
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.id("chatPg")).click();
			}
			driver.findElement(By.id("search-box")).sendKeys("tabish");
			driver.findElement(By.xpath("//button[@class=\"btn btn-link search-btn\"]")).click();
			driver.findElement(By.xpath("//a[@title=\"Tabish Test\"]")).click();
			driver.findElement(By.id("psychic-2182-chat-btn")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[text()='Start Chat with Tabish Test']")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			//isEnabled() check - before sending message
			//display the enable or disable status of "Send" button before sending message
			WebElement sendBtn = driver.findElement(By.xpath("//button[@id='sendMsg']"));
			boolean b1 = sendBtn.isEnabled();  //false
			System.out.println("Send button enable/disable before sending message = "+b1);
			
			driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here ...\"]")).sendKeys("Hello Test, lets start test");
			
			//type message in message box
			WebElement element=driver.findElement(By.xpath("//button[@class=\"btn btn-primary firechat\" and @id=\"sendMsg\"]"));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			//new Actions(driver).moveToElement(element, 1, 1).click().perform();
			
			//getting intake details
			WebElement intakdetails=driver.findElement(By.xpath("//div[@class=\"message message-default  message-self \"]"));
			System.out.println("details " + intakdetails.getText());
			Thread.sleep(2000);
			
			//isEnabled() example - send btn
			//display the enable or disable status of "Send" button after sending msg
			boolean b2 = sendBtn.isEnabled();//true
			System.out.println("Send button enable/disable after sending msg = "+b2);
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary firechat\" and @id=\"sendMsg\"]")).click();
			driver.switchTo().activeElement().click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


			//WebElement ele=driver.findElement(By.id("sendMsg"));
			//ele.click();
			//WebDriverWait wait=new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.elementToBeClickable(ele));
			 
		}
			
			@Test()
			public void payment() {
				driver.findElement(By.id("dropdownMenuLink")).click();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@class=\"dropdown-item d-flex justify-content-between align-items-center pr-2\"]")).click();
				driver.findElement(By.xpath("//a[text()='Add Money']")).click();
				driver.findElement(By.id("pln-d319")).click();
				// to verify coupon apply for this plan
				WebElement coupon= driver.findElement(By.xpath("//span[text()='Coupon Applied']"));
				System.out.println("Succesfully :" + coupon.getText());
				// selecting razorpay upi payment method
				driver.findElement(By.xpath("//input[@data-gateway=\"razorPay\" and @ value=\"upi\"]")).click();
				driver.findElement(By.id("proceedbtn")).click();
				//driver.switchTo().frame(0);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//WebElement paymentText=driver.findElement(By.id("header"));
			//	System.out.println("upi Payment title is :" + paymentText.getText());
				WebElement frameUpi = driver.findElement(By.name("vpa-upi"));
				driver.switchTo().frame(frameUpi);
				driver.findElement(By.name("vpa-upi")).sendKeys("test@ybl");
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				//verifying given plan
				//WebElement plan =driver.findElement(By.xpath("//span[text()='Pay __']"));
				//System.out.println("Plan verified and amount is " + plan.getText());
				driver.findElement(By.id("footer-cta")).click();
				WebElement succesfullPopup=driver.findElement(By.xpath("//div[@class=\"ajs-message ajs-success ajs-visible\"]"));
				
				System.out.println("Displaying : " + succesfullPopup.getText());
				
				
				
				
			}
	@AfterMethod
		public void logout() {
			System.out.println("logout started");
			driver.findElement(By.id("dropdownMenuLink")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@onclick=\"funlogout()\"]")).click();
		}
		@AfterClass
		public void closeBrowser() {
			driver.quit();
		}
	
}


