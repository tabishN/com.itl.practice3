package Live;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import repo.WebDriverUtilities;

public class LIVE_details_online_busy_status {
	
	public WebDriver driver;
	public String expertname = "Astro Tabish";
	public WebDriverUtilities wb = new WebDriverUtilities(); 
	String id;
	String se;
	String online;
	String busy;
	int countOnline;
	int countBusy;
	ArrayList<String> onlineInArray = new ArrayList<String>() ;
	ArrayList<String> busyInArray = new ArrayList<String>() ;
	
	@BeforeClass
	public void beforeTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@BeforeMethod
		public void astroOpen() {
		
		driver.get("https://www.anytimeastro.com/");
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
	}
		@Test
		public void login() {
		try 
		{
			wb.waitMTD(driver);
			wb.cleverTapClick(driver);
			driver.findElement(By.xpath("//span[text()='Sign In ']")).click();
			driver.findElement(By.xpath("//a[text()='Login_Via_Email']")).click();
			driver.findElement(By.id("txtLoginEmail")).sendKeys("pia@mailinator.com");
			driver.findElement(By.id("Password")).sendKeys("12345");
			// login to the app
			driver.findElement(By.id("btnLogin")).click();  
			//wb.cleverTapClick(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
			System.out.println("Chat with Expert list selected");
			//wb.cleverTapClick(driver);
			System.out.println("Expert details are :");
			
			// To fetch online astrologers
			//List<WebElement> ne = driver.findElements(By.xpath("//a[text()='"+expertname+"']/ancestor::div"));
			//WebElement newww = driver.findElement(By.xpath("//a[text()='Garima']/following-sibling::span"));
			//System.out.println(newww.getText());
			/*
			 for(WebElement ee : ne) 
			{
				String se = ee.getText();
				System.out.println(se);
			}
			*/
			/*Iterator<WebElement> i = ne.iterator();
			while(i.hasNext())
			{
				id = i.next().getAttribute("data-psychic-id");	
			}
			System.out.println("Expert id is "+id);
			*/
			List<WebElement> onlineExp = driver.findElements(By.xpath("//div[@title=\"Online\"]/parent::li/following-sibling::li/child::a"));
			
			for(WebElement onlineEx : onlineExp) 
			{
				 online = onlineEx.getText();
				 onlineInArray.add(online);
				 countOnline++;
				// System.out.println("online astrologers are : " + online);
			}
			System.out.println("Number of online astrologers are : "+ countOnline);
			System.out.println("online astrologers are : "+onlineInArray);
			// To fetch busy astrologers...........
			List<WebElement> busyExp = driver.findElements(By.xpath("//div[@title=\"Busy\"]/parent::li/following-sibling::li/child::a"));
			
			for(WebElement busyEx : busyExp) {
				 busy = busyEx.getText();
				 busyInArray.add(busy);
				 countBusy++;
				// System.out.println("Busy astrologers are : " + busy);
			}
			System.out.println("busy astrologers are : "+busyInArray);
			System.out.println("Number of Busy astrologers are : "+ countBusy);
			int total = countOnline + countBusy;
			System.out.println("Total astrologers are : "+total);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
			}
		@AfterMethod()
		public void logout() {
			System.out.println("logout started");
			driver.findElement(By.id("dropdownMenuLink")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@onclick=\"funlogout()\"]")).click();
		}
		@AfterClass()
		public void closeBrowser() {
			driver.quit();
		}
}
