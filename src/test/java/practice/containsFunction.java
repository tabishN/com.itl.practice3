package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class containsFunction {
	public WebDriver driver;
	@Test
	public void containsTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tabish\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://otest.anytimeastro.com/");
		/*driver.findElement(By.xpath("//span[text()='Sign In ']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Login_Via_Email']")).click();
		driver.findElement(By.id("txtLoginEmail")).sendKeys("qa100@mailinator.com");
		driver.findElement(By.id("Password")).sendKeys("1");
		//driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.id("login")).click();
		*/
		driver.findElement(By.xpath("//a[@class=\"btn btn-chat\"]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("search-box")).sendKeys("tabish");
		driver.findElement(By.xpath("//button[@class=\"btn btn-link search-btn\"]")).click();
		driver.findElement(By.xpath("//a[@title=\"Tabish Test\"]")).click();
		driver.findElement(By.id("psychic-2182-chat-btn")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement txtPrint=		driver.findElement(By.xpath("//span[contains(text(),'English, Hin')]"));
		System.out.println("Expert known language is " + txtPrint);
		
		
	}

}
