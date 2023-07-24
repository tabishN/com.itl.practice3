package admin;

import java.util.ArrayList;
import java.util.Arrays;
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

public class gettingChatDetails {
		public WebDriver driver;
		Reporter r = new Reporter();
		int count= 0;
		ArrayList<String> actualList = new ArrayList<>(Arrays.asList());
		@BeforeClass
		public void beforeTest() {
			System.out.println("Initilizing the Google Chrome Driver");
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		@BeforeMethod
			public void astroOpen() {
			
			driver.get("https://oadmin.anytimeastro.com/account/login");
			String title=driver.getTitle();
			System.out.println("Title of the site is : " + title);
		}
			@Test
			public void login() {
				driver.findElement(By.name("Email")).sendKeys("admin@dashaspeaks.com");
				driver.findElement(By.name("Password")).sendKeys("Test@123!");
				driver.findElement(By.id("login")).click();
				driver.findElement(By.xpath("//span[text()='Chat Report']")).click();
				driver.findElement(By.id("select2-PsychicId-container")).click();
				driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]")).sendKeys("tabish tewwwqwe");
				driver.findElement(By.xpath("//li[@class=\"select2-results__option select2-results__option--highlighted\"]")).click();
				driver.findElement(By.id("chk")).click();
				driver.findElement(By.id("search")).click();
				/*List<WebElement> begintime = driver.findElements(By.xpath("//table[@class=\"table  table-responsive table-hover table-bordered table-striped datatable\"]/tbody/tr/td[2]/p"));
				for(WebElement ele2:begintime) {
		            
		            String x=ele2.getText();
		    		System.out.println(x);
		    		actualList.add(x);
				}
				System.out.println(actualList);
				
				//WebElement endtime = driver.findElement(By.xpath("//tr[1]/td[2]/p[2]"));
				//System.out.println(endtime.getText());*/
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				WebElement startTime =  driver.findElement(By.xpath("//table[@class=\"table  table-responsive table-hover table-bordered table-striped datatable\"]/tbody/tr/td[2]/p"));
				String st = startTime.getText();
				System.out.println(st);
				WebElement endTime =  driver.findElement(By.xpath("//table[@class=\"table  table-responsive table-hover table-bordered table-striped datatable\"]/tbody/tr/td[2]/p[2]"));
				String et = endTime.getText();
				System.out.println(et);
				WebElement minutes = driver.findElement(By.xpath("//table[@class=\"table  table-responsive table-hover table-bordered table-striped datatable\"]/tbody/tr/td[6]"));
				String min = minutes.getText();
				System.out.println(min);
				
		}
			@AfterMethod(enabled = false)
			public void logout() {
				System.out.println("logout started");
			}
			@AfterClass(enabled = false)
			public void closeBrowser() {
				driver.quit();
			}

		

	}
