package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mychats {
	public WebDriver driver;
	@Test
	public void myChatCount() {
		try {
		System.out.println("Initilizing the Google Chrome Driver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tabish\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://otest.anytimeastro.com/");
		driver.findElement(By.xpath("//span[text()='Sign In ']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Login_Via_Email']")).click();
		driver.findElement(By.id("txtLoginEmail")).sendKeys("qa100@mailinator.com");
		driver.findElement(By.id("Password")).sendKeys("1");
		//driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("dropdownMenuLink")).click();
		driver.findElement(By.xpath("//span[text()='My Chats']")).click();
		WebElement Mychat=driver.findElement(By.xpath("//div[@class=\"astro-table\"]"));
		System.out.println("List under My chat is :" + Mychat.getText());
		System.out.println("my Chat size is :"+ Mychat.getSize());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
